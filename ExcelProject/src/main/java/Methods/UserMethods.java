package Methods;

import Inputs.UserInput;
import Model.User;
import ObjectManager.UserManager;

public class UserMethods extends UserInput {

    //Use for registration and save into UserManager
    private User enterNewUser(UserManager users){
        System.out.println("*** New User ***");
        String firstName = setUserFirstName();
        String lastName = setUserLastName();
        String userName = setUserName2(users);
        String passWord = setPassword();
        users.add(new User(firstName, lastName, userName, passWord));
        return users.getObjectByName(userName);
    }

    //Use for login to get user from user manager
    private User returningUser(UserManager users){
        System.out.println("*** Returning User ***");
        String userName = setUserName();
        String passWord = setPassword();
        return users.getObjectByNameAndPassword(userName, passWord);
    }

    //Use to search for user in the user manager
    private User searchUser(UserManager users){
        System.out.println("*** Search User ***");
        String searchUserName = setUserName();
        return users.getObjectByName(searchUserName);
    }

    //Gets user based on the option the user picks
    public User getUserByOption(int userOption, UserManager uManager){
        return userOption == 1 ? enterNewUser(uManager) : returningUser(uManager);
    }
}
