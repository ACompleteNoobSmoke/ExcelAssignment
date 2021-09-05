package Inputs;

import ObjectManager.ExcelManager;

public class ExcelInputs extends AbstractInputs{


    public String setName(){
        String fileName = "";
        while(fileName.isBlank()) {
            System.out.print("Please Enter File Name: ");
            fileName = supplyString.get();
        }
        return fileName.trim();
    }

    public int setNumber(){
        int number = 0;
        while(number == 0){
            System.out.print("Please Enter File Number: ");
            number = supplyInt.get();
        }
        return number;
    }

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

    private void errorMessage(boolean exists, String fileName){
        if(exists)
            System.out.println("File Name: " + fileName + " Already Exists.");
    }

    public String setUpdatedName(){
        String updatedName = "";
        while(updatedName.isBlank()){
            System.out.print("Please Enter Updated File Name: ");
            updatedName = supplyString.get();
        }
        return updatedName.trim();
    }
}
