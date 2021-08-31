package Inputs;

public class CellInputs extends ScannerInput {

    public char setColumn(){
        char col = '0';
        while(col == '0'){
            System.out.print("Please Enter Column: ");
            col = supplyChar.get();
        }
        return col;
    }

    public int setRow(){
        int row = 0;
        while(row == 0){
            System.out.print("Please Enter Row: ");
            row = supplyInt.get();
        }
        return row;
    }
}
