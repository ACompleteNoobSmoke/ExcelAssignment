import Methods.AppMethods;
import Model.User;

public class App {
    public static void main(String[] args) {
        AppMethods methods = new AppMethods();
        while(true) {
            User newUser = methods.mainMenuMethod();
            if(newUser != null){
                methods.optionMenu(newUser);
            }
        }
    }
}
