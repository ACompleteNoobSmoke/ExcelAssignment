package Methods;

import Inputs.UserInput;
import Model.User;
import ObjectManager.UserManager;

public class UserMethods extends UserInput {

    //Use for registration and save into UserManager
    public User enterNewUser(UserManager users){
        System.out.println("*** New User ***");
        String firstName = setUserFirstName();
        String lastName = setUserLastName();
        String userName = setUserName2(users);
        String passWord = setPassword();
        users.add(new User(firstName, lastName, userName, passWord));
        return users.getObjectByName(userName);
    }

    //Use for login to get user from user manager
    public User returningUser(UserManager users){
        System.out.println("*** Returning User ***");
        String userName = setUserName();
        String passWord = setPassword();
        return users.getObjectByNameAndPassword(userName, passWord);
    }

    //Use to search for user in the user manager
    private User searchUser(UserManager users){
        String searchUserName = setUserName();
        return users.getObjectByName(searchUserName);
    }
}
