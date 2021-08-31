package ObjectManager;

import Model.User;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class UserManager extends Manager<User> {

    private User[] userProfiles;

    private static int userSize;

    public UserManager(){
        this.userSize = 0;
    }


    //Check if the File Size is equivalent to the array length
    private Predicate<Integer> isFull = size -> size == userProfiles.length;
    //Check if the userSize is zero
    private Predicate<Integer> isEmpty = size -> size.equals(0);
    //Check if the names are the same
    private BiPredicate<String, User> sameName = (n, e) -> e.getUserName().equals(n);
    //Check if the names are the same
    private BiPredicate<String,  User> samePassword = (n, e) -> e.getPassWord().equals(n);
    //Supply File size
    public int getUserSize(){ return userSize;}

    @Override
    //Upscale the ExceluserProfiles array
    protected void upscale(){
        if(isFull.test(userSize)){
            User newuserProfiles[] = new User[userSize + 1];
            for(int i = 0; i < userSize; i++){
                newuserProfiles[i] = userProfiles[i];
            }
            userProfiles = newuserProfiles;
        }
    }

    @Override
    //Adds A New User Into Array;
    public boolean add(User newUser) {
        if(!existingObjectName(newUser.getUserName())){
            initiliazeArray();
            upscale();
            userProfiles[userSize++] = newUser;
            return true;
        }
        return false;
    }

    @Override
    //Resize Array -- Passed
    protected User[] decrease(String UserName) {
        User []lessUser = new User[userSize-1];
        int j = 0;
        for (int i = 0; i < userSize; i++) {
            if (sameName.test(UserName, userProfiles[i])) { continue;}
            lessUser[j++] = userProfiles[i];
        }
        return lessUser;
    }

    @Override
    //If userProfiles is empty initiliaze array
    protected void initiliazeArray(){
        if(isEmpty.test(userSize))
            userProfiles = new User[3];
    }

    @Override
    //Remove User From Array
    public boolean remove(String UserName){
        if(existingObjectName(UserName)){
            userProfiles = decrease(UserName);
            userSize--;
            return true;
        }
        return false;
    }

    @Override
    //Search Array For User
    public User search(String UserName){
        if(!isEmpty.test(userSize)){
            return getObjectByName(UserName);
        }
        return null;
    }


    @Override
    //Check Array if User name exists already;
    protected boolean existingObjectName(String UserName){
        if(!isEmpty.test(userSize)){
            for(int i = 0;  i < userSize; i++){
                if(sameName.test(UserName, userProfiles[i])) return true;
            }
        }
        return false;
    }

    @Override
    //Get User From Array By Name;
    public User getObjectByName(String UserName){
        for(int i = 0; i < userSize; i++){
            if(sameName.test(UserName, userProfiles[i])) return userProfiles[i];
        }
        return null;
    }

    //Get User from array by username & password.
    public User getObjectByNameAndPassword(String UserName, String PassWord){
        for(int i = 0; i < userSize; i++){
            if(sameName.test(UserName, userProfiles[i]) &&
                    samePassword.test(PassWord, userProfiles[i]))
                return userProfiles[i];
        }
        return null;
    }



    @Override
    //Displays all of the elements in the array.
    public void showAll(){
        if(!isEmpty.test(userSize)){
            for(int i = 0; i < userSize; i++){
                System.out.println(userProfiles[i].getUserName());
            }
        }
    }
}
