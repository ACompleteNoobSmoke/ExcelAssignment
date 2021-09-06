package Inputs;

import ObjectManager.ExcelManager;

public class ExcelInputs extends AbstractInputs{


    //Overridden method to set file name
    public String setName(){
        String fileName = "";
        while(fileName.isBlank()) {
            System.out.print("Please Enter File Name: ");
            fileName = supplyString.get();
        }
        return fileName.trim();
    }

    //Used to check if the file name already exists.
    public String setName2(ExcelManager excelManage){
        boolean exists = true;
        String fileName = "";
        while(exists){
            fileName = setName();
            exists = excelManage.existingObjectName(fileName);
            errorMessage(exists, fileName);
        }
        return fileName;
    }

    //checks if the file name exists. If it does it prints a warning.
    private void errorMessage(boolean exists, String fileName){
        if(exists)
            System.out.println("File Name: " + fileName + " Already Exists.");
    }

    //Overridden method to set file number
    public int setNumber(){
        int number = 0;
        while(number == 0){
            System.out.print("Please Enter File Number: ");
            number = supplyInt.get();
        }
        return number;
    }

    //Overridden method to set updated excel file name
    public String setUpdatedName(){
        String updatedName = "";
        while(updatedName.isBlank()){
            System.out.print("Please Enter Updated File Name: ");
            updatedName = supplyString.get();
        }
        return updatedName.trim();
    }
}
