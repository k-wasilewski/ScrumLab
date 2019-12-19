package pl.coderslab.model;

public class SuperAdmin extends Admin {

    /*public SuperAdmin(String firstName, String lastName, String email, String password) {
//        if (super.superadmin == 1) {
        super(firstName, lastName, email, password);
//        }
    }*/

    public static void setEnable(Admin admin, byte enable) {
        if (enable == 1) {
            admin.enable = 1;
        }
        if (enable == 0) {
            admin.enable = 0;
        }
    }

    public SuperAdmin setSuperAdmin(Admin admin, byte enable) {
        if (enable == 1) {
            admin.superadmin = 1;
            SuperAdmin superAdmin = (SuperAdmin) admin;
            return superAdmin;
        }
        if (enable == 0) {
            admin.superadmin = 0;
        }
        return null;

    }
}