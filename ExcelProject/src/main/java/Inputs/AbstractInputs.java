package Inputs;

public abstract class AbstractInputs extends ScannerInput {

    //Used to set the name of excel file or sheet name
    public String setName(){
        String fileName = "";
        while(fileName.isBlank()) {
            System.out.print("Please Enter File Name: ");
            fileName = supplyString.get();
        }
        return fileName;
    }

    //Used to set the number for excel file or sheet number
    public int setNumber(){
        int number = 0;
        while(number == 0){
            System.out.print("Please Enter File Number: ");
            number = supplyInt.get();
        }
        return number;
    }

    //Used to set the updated name for excel file or sheet name
    public String setUpdatedName(){
        String updatedName = "";
        while(updatedName.isBlank()){
            System.out.print("Please Enter Updated File Name: ");
            updatedName = supplyString.get();
        }
        return updatedName;
    }

}
