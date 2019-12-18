package pl.coderslab.dao;
import pl.coderslab.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class RecipePlanDao {
    private static final String ADD_RECIPE_TO_PLAN_QUERY = "INSERT INTO recipe_plan(recipe_id, meal_name, display_order, day_name_id, plan_id) VALUES (?, ?, ?, ?, ?);";
    public void addRecipeToPlan(int recipeId, String mealName, int displayOrder, int dayNameId, int planId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(ADD_RECIPE_TO_PLAN_QUERY)) {
            insertStm.setInt(1, recipeId);
            insertStm.setString(2, mealName);
            insertStm.setInt(3, displayOrder);
            insertStm.setInt(4, dayNameId);
            insertStm.setInt(5, planId);
            insertStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}