package ExcelObjects;

import LinkedLists.Sheet;
import ObjectManager.Manager;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ExcelFile extends Manager<Sheet> {
    private String fileName;
    private int fileNumber;
    private Sheet []excelSheets;
    private static int sheetSize;

    public ExcelFile(String fileName, int fileNumber){
        this.fileName = fileName;
        this.fileNumber = fileNumber;
        this.sheetSize = 0;
    }

    public String getFileName(){ return fileName; }
    public void setFileName(String fileName){ this.fileName = fileName; }
    public void setFileNumber(int fileNumber){ this.fileNumber = fileNumber; }

    //Check if the sheetsize is equivalent to the array length
    private Predicate<Integer> isFull = size -> size == excelSheets.length;
    //Check if the sheetsize is zero
    private Predicate<Integer> isEmpty = size -> size.equals(0);
    //Check if the names are the same
    private BiPredicate<String, Sheet> sameName = (n, s) -> s.getSheetName().equalsIgnoreCase(n);
    //Supply sheet size
    public int getSheetSize(){ return sheetSize;}

    @Override
    //Upscale the sheets array
    protected void upscale(){
        if(isFull.test(sheetSize)){
            Sheet newSheets[] = new Sheet[sheetSize + 1];
            for(int i = 0; i < sheetSize; i++){
                newSheets[i] = excelSheets[i];
            }
            excelSheets = newSheets;
        }
    }

    @Override
    //Adds A New Sheet Into Array;
    public boolean add(Sheet newSheet) {
        if(!existingObjectName(newSheet.getSheetName())){
            initiliazeArray();
            newSheet.setSheetNumber(sheetSize + 1);
            upscale();
            excelSheets[sheetSize++] = newSheet;
            return true;
        }
        return false;
    }

    @Override
    //Resize Array -- Passed
    protected Sheet[] decrease(String sheetName) {
        Sheet []lessSheet = new Sheet[sheetSize-1];
        int j = 0;
        for (int i = 0; i < sheetSize; i++) {
            if (sameName.test(sheetName, excelSheets[i])) { continue;}
            lessSheet[j++] = excelSheets[i];
        }
        return lessSheet;
    }

    @Override
    //If ExcelSheets is empty initiliaze array
    protected void initiliazeArray(){
        if(isEmpty.test(sheetSize))
            excelSheets = new Sheet[3];
    }

    @Override
    //Remove Sheet From Array
    public boolean remove(String sheetName){
        if(existingObjectName(sheetName)){
             excelSheets = decrease(sheetName);
             sheetSize--;
             return true;
        }
        return false;
    }

    @Override
    //Search Array For Sheet
    public Sheet search(String sheetName){
        if(!isEmpty.test(sheetSize)){
            return getObjectByName(sheetName);
        }
        return null;
    }


    @Override
    //Check Array if sheet name exists already;
    protected boolean existingObjectName(String sheetName){
        if(!isEmpty.test(sheetSize)){
            for(int i = 0;  i < sheetSize; i++){
                if(sameName.test(sheetName, excelSheets[i])) return true;
            }
        }
        return false;
    }

    @Override
    //Get Sheet From Array By Name;
    public Sheet getObjectByName(String sheetName){
        for(int i = 0; i < sheetSize; i++){
            if(sameName.test(sheetName, excelSheets[i])) return excelSheets[i];
        }
        return null;
    }

    @Override
    //Update Sheet Name
    public boolean update(String originalName, String updateName){
        if(existingObjectName(originalName)){
            getObjectByName(originalName).setSheetName(updateName);
            return true;
        }
        return false;
    }

    @Override
    //Displays all of the elements in the array.
    public void showAll(){
        if(!isEmpty.test(sheetSize)){
            for(int i = 0; i < sheetSize; i++){
                System.out.println(excelSheets[i].getSheetName());
            }
        }
    }
}
