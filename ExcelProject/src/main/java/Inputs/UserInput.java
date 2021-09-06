package Inputs;

import ObjectManager.UserManager;

import java.util.function.BiFunction;

public class UserInput extends ScannerInput{

    //User inputs the first name
    public String setUserFirstName(){
        String firstName = "";
        while(firstName.isBlank()) {
            System.out.print("Please Enter First Name: ");
            firstName = supplyString.get();
        }
        return firstName.trim();
    }

    //User inputs the last name
    public String setUserLastName(){
        String lastName = "";
        while(lastName.isBlank()) {
            System.out.print("Please Enter Last Name: ");
            lastName = supplyString.get();
        }
        return lastName.trim();
    }

    //User inputs the user name
    public String setUserName(){
        String userName = "";
        while(userName.isBlank()) {
            System.out.print("Please Enter UserName: ");
            userName = supplyString.get();
        }
        return userName.trim();
    }

    //Helper method to see if the username exists.
    public BiFunction<String, UserManager, Boolean> setUserNameAndValidate = (n, u) -> u.getObjectByName(n) != null;

    //User inputs the user name and checks if the user name already exists
    public String setUserName2(UserManager uManager){
        boolean exists = true;
        String userName = "";
        while(exists) {
            userName = setUserName();
            exists = setUserNameAndValidate.apply(userName, uManager);
            userNameErrorMessage(exists, userName);
        }
        return userName;
    }

    //If user name already exists it prints out a warning message
    private void userNameErrorMessage(boolean exists, String userName){
        if(exists){
            System.out.println("\nUserName: " + userName + " Already Exists In Database!\n");
        }
    }

    //User inputs the password
    public String setPassword(){
        String passWord = "";
        while(passWord.isBlank()) {
            System.out.print("Please Enter PassWord: ");
            passWord = supplyString.get();
        }
        return passWord.trim();
    }
}
