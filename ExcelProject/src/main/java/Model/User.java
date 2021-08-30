package Model;

import ObjectManager.ExcelManager;

public class User {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String passWord;
    private final ExcelManager excelManager;

    public User(String firstName, String lastName, String userName, String passWord){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.excelManager = new ExcelManager();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public ExcelManager getExcelManager() {
        return excelManager;
    }
}
