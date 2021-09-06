import FrontEnd.UserMenu;
import Methods.AppMethods;
import Model.User;

public class App {

    public static void main(String[] args) {
        AppMethods methods = new AppMethods();
        UserMenu menu = new UserMenu();
        while(true) {
            User newUser = methods.mainMenuMethod(menu);
            if(newUser != null){
                methods.optionMenu(newUser, menu);
            }
        }
    }
}
