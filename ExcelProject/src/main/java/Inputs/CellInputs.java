package Inputs;

public class CellInputs extends ScannerInput {

    //Set the column for a cell, returns a character
    public char setColumn(){
        char col = '0';
        while(col == '0'){
            System.out.print("Please Enter Column: ");
            col = supplyChar.get();
        }
        return col;
    }

    //Set the row for a cell, returns an integer
    public int setRow(){
        int row = 0;
        while(row == 0){
            System.out.print("Please Enter Row: ");
            row = supplyInt.get();
        }
        return row;
    }

    //Set the content for a cell, returns a string
    public String setContent(){
        String content = "";
        while(content.isBlank()){
            System.out.print("Please Enter Content: ");
            content = supplyString.get();
        }
        return content.trim();
    }
}
