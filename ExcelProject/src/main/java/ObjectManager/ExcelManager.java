package ObjectManager;

import ExcelObjects.ExcelFile;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ExcelManager extends Manager<ExcelFile> {
    private ExcelFile []files;
    private static int fileSize;

    public ExcelManager(){
      this.fileSize = 0;
    }


    //Check if the File Size is equivalent to the array length
    private Predicate<Integer> isFull = size -> size == files.length;
    //Check if the FileSize is zero
    private Predicate<Integer> isEmpty = size -> size.equals(0);
    //Check if the names are the same
    private BiPredicate<String, ExcelFile> sameName = (n, e) -> e.getFileName().equalsIgnoreCase(n);
    //Supply File size
    public int getfileSize(){ return fileSize;}

    @Override
    //Upscale the ExcelFiles array
    protected void upscale(){
        if(isFull.test(fileSize)){
            ExcelFile newFiles[] = new ExcelFile[fileSize + 1];
            for(int i = 0; i < fileSize; i++){
                newFiles[i] = files[i];
                newFiles[i].setFileNumber(i+1);
            }
            files = newFiles;
        }
    }

    @Override
    //Adds A New ExcelFile Into Array;
    public boolean add(ExcelFile newExcelFile) {
        if(!existingObjectName(newExcelFile.getFileName())){
            initiliazeArray();
            newExcelFile.setFileNumber(fileSize + 1);
            upscale();
            files[fileSize++] = newExcelFile;
            return true;
        }
        return false;
    }

    @Override
    //Resize Array -- Passed
    protected ExcelFile[] decrease(String ExcelFileName) {
        ExcelFile []lessExcelFile = new ExcelFile[fileSize-1];
        int j = 0;
        for (int i = 0; i < fileSize; i++) {
            if (sameName.test(ExcelFileName, files[i])) { continue;}
            lessExcelFile[j++] = files[i];
        }
        return lessExcelFile;
    }

    @Override
    //If files is empty initiliaze array
    protected void initiliazeArray(){
        if(isEmpty.test(fileSize))
            files = new ExcelFile[3];
    }

    @Override
    //Remove ExcelFile From Array
    public boolean remove(String ExcelFileName){
        if(existingObjectName(ExcelFileName)){
            files = decrease(ExcelFileName);
            fileSize--;
            return true;
        }
        return false;
    }

    @Override
    //Search Array For ExcelFile
    public ExcelFile search(String ExcelFileName){
        if(!isEmpty.test(fileSize)){
            return getObjectByName(ExcelFileName);
        }
        return null;
    }


    @Override
    //Check Array if ExcelFile name exists already;
    public boolean existingObjectName(String ExcelFileName){
        if(!isEmpty.test(fileSize)){
            for(int i = 0;  i < fileSize; i++){
                if(sameName.test(ExcelFileName, files[i])) return true;
            }
        }
        return false;
    }

    @Override
    //Get ExcelFile From Array By Name;
    public ExcelFile getObjectByName(String ExcelFileName){
        for(int i = 0; i < fileSize; i++){
            if(sameName.test(ExcelFileName, files[i])) return files[i];
        }
        return null;
    }

    @Override
    //Update ExcelFile Name
    public boolean update(String originalName, String updateName){
        if(existingObjectName(originalName)){
            getObjectByName(originalName).setFileName(updateName);
            return true;
        }
        return false;
    }

    @Override
    //Displays all of the elements in the array.
    public void showAll(){
        if(!isEmpty.test(fileSize)){
            for(int i = 0; i < fileSize; i++){
                System.out.println(files[i].getFileName());
            }
        }
    }
}
