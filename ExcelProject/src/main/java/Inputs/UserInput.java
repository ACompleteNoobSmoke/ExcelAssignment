package Inputs;

public class UserInput extends ScannerInput{

    public String setUserFirstName(){
        String firstName = "";
        while(firstName.isBlank()) {
            System.out.print("Please Enter First Name: ");
            firstName = supplyString.get();
        }
        return firstName;
    }

    public String setUserLastName(){
        String lastName = "";
        while(lastName.isBlank()) {
            System.out.print("Please Enter Last Name: ");
            lastName = supplyString.get();
        }
        return lastName;
    }

    public String setUserName(){
        String userName = "";
        while(userName.isBlank()) {
            System.out.print("Please Enter UserName: ");
            userName = supplyString.get();
        }
        return userName;
    }

    public String setPassword(){
        String passWord = "";
        while(passWord.isBlank()) {
            System.out.print("Please Enter PassWord: ");
            passWord = supplyString.get();
        }
        return passWord;
    }
}
