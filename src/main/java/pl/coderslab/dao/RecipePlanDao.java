package pl.coderslab.dao;

import pl.coderslab.model.RecipePlan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecipePlanDao {
    private static final String PLAN_DETAILS_QUERY = "SELECT day_name.name as day_name, meal_name, recipe.name as recipe_name\n" +
            "FROM `recipe_plan`\n" +
            "JOIN day_name on day_name.id=day_name_id\n" +
            "JOIN recipe on recipe.id=recipe_id WHERE plan_id = ?\n" +
            "ORDER by day_name.display_order, recipe_plan.display_order;";
    private static final String DELETE_RECIPE_FROM_PLAN_QUERY = "DELETE from recipe_plan WHERE plan_id = ? AND " +
            "recipe_id = ?;";

    public void deleteRecipeFromPlan(int planId, int recipeId){
        try (Connection connection = DbUtil.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RECIPE_FROM_PLAN_QUERY);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Nie znaleziono bazy");
        }
    }
    public RecipePlan details(int planId) {
        RecipePlan recipePlan = new RecipePlan();
        Map<String, List<String[]>> planDetails = new HashMap<>();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PLAN_DETAILS_QUERY);
            preparedStatement.setInt(1, planId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String[] meal = {resultSet.getString(2),
                        resultSet.getString(3)};
                List<String[]> meals = new LinkedList<>();

                if (planDetails.get(resultSet.getString(1)) != null) {
                    meals = planDetails.get(resultSet.getString(1));
                    meals.add(meal);
                } else {
                    meals.add(meal);
                }
                planDetails.put(resultSet.getString(1), meals);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono bazy");
        }
        recipePlan.setPlanDetails(planDetails);
        return recipePlan;
    }
}
