package Methods;

import Inputs.CellInputs;
import LinkedLists.Sheet;
import Model.Cell;


public class CellMethods extends CellInputs {

    //Enter the new cell into sheet
    private boolean enterNewCell(Sheet currentSheet){
        System.out.println("*** Create New Cell ***");
        char col = setColumn();
        int row = setRow();
        if(checkIfExists(currentSheet, col, row)) return false;
        String content = setContent();
        return currentSheet.insertToList(new Cell(col, row, content));
    }

    //Check the sheet if the cell exists already
    private boolean checkIfExists(Sheet cur, char col, int row){
        if(cur.cellExists(col, row)){
            System.out.println("Cell Exists");
            return true;
        }
        return false;
    }

    //Returns cell based on the column and row
    private Cell getCell(Sheet cur){
        char col = setColumn();
        int row = setRow();
        return cur.searchSheet(col, row);
    }

    //Updates the cell if it exists in the sheet
    // or it will be inserted into the sheet if it is not
    private boolean updateCell(Sheet currentSheet){
        System.out.println("*** Update Cell ***");
        char col = setColumn();
        int row = setRow();
        String content = setContent();
        return currentSheet.updateCell(new Cell(col, row, content));
    }

    //Searches the sheet for a particular cell
    private void searchCell(Sheet currentSheet){
        System.out.println("*** Search Cell ***");
        Cell foundCell = getCell(currentSheet);
        if(foundCell == null){
            System.out.println(currentSheet.getSheetName() +
                    " Does Not Contain Cell");
            return;
        }
        System.out.println(foundCell);
    }

    //Searches and deletes a cell if it exists in the sheet
    private void deleteCell(Sheet currentSheet){
        System.out.println("*** Delete Cell ***");
        Cell deleteThis = getCell(currentSheet);
        if(deleteThis == null){
            System.out.println("Cell Does Not Exist");
            return;
        }
        char col = deleteThis.getColumn();
        int row = deleteThis.getRow();
        currentSheet.removeToList(col, row);
    }

    //Prints all the cells that exists in the sheet
    private void viewAllCells(Sheet currentSheet){
        System.out.println("*** View All Cells ***");
        if(currentSheet.getCellSize() != 0){
            currentSheet.viewAllCells();
            return;
        }
        System.out.println("Sheet Is Currently Empty!\n");
    }

    //Performs a cell method based on the user input choice
    public void cellMethodVoidOptions(int input, Sheet currentSheet){
        switch (input){
            case 1: enterNewCell(currentSheet); break;
            case 2: updateCell(currentSheet); break;
            case 3: searchCell(currentSheet); break;
            case 4: deleteCell(currentSheet); break;
            case 5: viewAllCells(currentSheet); break;
        }
    }
}
