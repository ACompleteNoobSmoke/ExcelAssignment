package Inputs;

import ExcelObjects.ExcelFile;


public class SheetInputs extends AbstractInputs{

    //Overridden method to set sheet name
    public String setName(){
        String sheetName = "";
        while(sheetName.isBlank()) {
            System.out.print("Please Enter Sheet Name: ");
            sheetName = supplyString.get();
        }
        return sheetName.trim();
    }

    //Used to check if the sheet name already exists
    public String setName2(ExcelFile file){
        boolean exists = true;
        String fileName = "";
        while(exists){
            fileName = setName();
            exists = file.existingObjectName(fileName);
            errorMessage(exists, fileName);
        }
        return fileName;
    }

    //Used to print a warning if sheet name already exists
    private void errorMessage(boolean exists, String fileName){
        if(exists)
            System.out.println("File Name: " + fileName + " Already Exists.");
    }

    //Overridden method to set sheet number
    public int setNumber(){
        int number = 0;
        while(number == 0){
            System.out.print("Please Enter Sheet Number: ");
            number = supplyInt.get();
        }
        return number;
    }

    //Overridden method to set updated sheet name
    public String setUpdatedName(){
        String updatedName = "";
        while(updatedName.isBlank()){
            System.out.print("Please Enter Updated Sheet Name: ");
            updatedName = supplyString.get();
        }
        return updatedName.trim();
    }
}
