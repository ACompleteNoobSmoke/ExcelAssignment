package Methods;

import Inputs.CellInputs;
import LinkedLists.Sheet;
import Model.Cell;


public class CellMethods extends CellInputs {

    public boolean enterNewCell(Sheet currentSheet){
        System.out.println("*** Create New Cell ***");
        char col = setColumn();
        int row = setRow();
        if(checkIfExists(currentSheet, col, row)) return false;
        String content = setContent();
        return currentSheet.insertToList(new Cell(col, row, content));
    }

    private boolean checkIfExists(Sheet cur, char col, int row){
        if(cur.cellExists(col, row)){
            System.out.println("Cell Exists");
            return true;
        }
        return false;
    }

    private Cell getCell(Sheet cur){
        char col = setColumn();
        int row = setRow();
        return cur.searchSheet(col, row);
    }

    public boolean updateCell(Sheet currentSheet){
        System.out.println("*** Update Cell ***");
        char col = setColumn();
        int row = setRow();
        String content = setContent();
        return currentSheet.updateCell(new Cell(col, row, content));
    }

    public Cell searchCell(Sheet currentSheet){
        System.out.println("*** Search Cell ***");
        return getCell(currentSheet);
    }

    public void deleteCell(Sheet currentSheet){
        System.out.println("*** Delete Cell ***");
        Cell deleteThis = getCell(currentSheet);
        if(deleteThis == null){
            System.out.println("Cell Does Not Exist");
            return;
        }
        currentSheet.removeToList(deleteThis.getColumn(),
                deleteThis.getRow());
    }

    public void viewAllCells(Sheet currentSheet){
        System.out.println("*** View All Cells ***");
        if(currentSheet.getCellSize() != 0){
            currentSheet.viewAllCells();
            return;
        }
        System.out.println("Sheet Is Currently Empty!\n");
    }
}
