package Inputs;

import ExcelObjects.ExcelFile;
import LinkedLists.Sheet;
import ObjectManager.ExcelManager;

public class SheetInputs extends AbstractInputs{

    public String setName(){
        String sheetName = "";
        while(sheetName.isBlank()) {
            System.out.print("Please Enter Sheet Name: ");
            sheetName = supplyString.get();
        }
        return sheetName.trim();
    }

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

    private void errorMessage(boolean exists, String fileName){
        if(exists)
            System.out.println("File Name: " + fileName + " Already Exists.");
    }

    public int setNumber(){
        int number = 0;
        while(number == 0){
            System.out.print("Please Enter Sheet Number: ");
            number = supplyInt.get();
        }
        return number;
    }

    public String setUpdatedName(){
        String updatedName = "";
        while(updatedName.isBlank()){
            System.out.print("Please Enter Updated Sheet Name: ");
            updatedName = supplyString.get();
        }
        return updatedName.trim();
    }
}
