package Inputs;

public class SheetInputs extends AbstractInputs{

    public String setName(){
        String sheetName = "";
        while(sheetName.isBlank()) {
            System.out.print("Please Enter Sheet Name: ");
            sheetName = supplyString.get();
        }
        return sheetName;
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
        return updatedName;
    }
}
