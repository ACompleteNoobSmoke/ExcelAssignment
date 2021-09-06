package ObjectManager;

public abstract class Manager<T> {




    //Upscale the sheets array
    protected void upscale(){}

    //Resize Array
    protected T[] decrease(String name) {
       return null;
    }

    //Adds Into Array;
    public boolean add(T newObject){
        return false;
    }

    //If ExcelSheets is empty initiliaze array
    protected void initiliazeArray(){}

    //Remove From Array
    public boolean remove(String name){
      return false;
    }

    //Search Array For Object
    public T search(String name){
        return null;
    }


    //Check Array if object name exists already;
    protected boolean existingObjectName(String name){
        return false;
    }

    //Get Object From Array By Name;
    protected T getObjectByName(String name){
        return null;
    }

    //Update Sheet Name
    public boolean update(String originalName, String updateName){
        return false;
    }

    //Displays all of the elements in the array.
    public void showAll(){
        return;
    }
}
