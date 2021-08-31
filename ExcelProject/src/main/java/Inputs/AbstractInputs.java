package Inputs;

public abstract class AbstractInputs extends ScannerInput {

    public String setName(){
        String fileName = "";
        while(fileName.isBlank()) {
            System.out.print("Please Enter File Name: ");
            fileName = supplyString.get();
        }
        return fileName;
    }

    public int setNumber(){
        int number = 0;
        while(number == 0){
            System.out.print("Please Enter File Number: ");
            number = supplyInt.get();
        }
        return number;
    }

    public String setUpdatedName(){
        String updatedName = "";
        while(updatedName.isBlank()){
            System.out.print("Please Enter Updated File Name: ");
            updatedName = supplyString.get();
        }
        return updatedName;
    }

}
