package LinkedLists;

import Model.Cell;
import Node.CellNode;

import java.util.function.Consumer;

public class Sheet {
    private String sheetName;
    private int sheetNumber;
    private CellNode Head;
    private int cellSize;
    private int Max = 500;

    public Sheet(){

    }

    public Sheet(String name){
        this.sheetName = name;
        this.sheetNumber = 0;
        this.cellSize = 0;
        this.Head = null;
    }

    public Sheet(String name, int number){
        this.sheetName = name;
        this.sheetNumber = number;
        this.cellSize = 0;
        this.Head = null;
    }

    public String getSheetName(){
        return sheetName;
    }

    public void setSheetName(String name){
        this.sheetName = name;
    }

    public int getSheetNumber(){
        return sheetNumber;
    }

    public void setSheetNumber(int number){
        this.sheetNumber = number;
    }

    public int getCellSize(){
        return cellSize;
    }

    private boolean isMax(){
        return cellSize == Max;
    }

    private boolean isEmpty(){
        return cellSize == 0;
    }

    public boolean cellExists(char col, int row){
        return searchSheet(col, row) != null ? true : false;
    }



    //Public method for inserting Model.Cell into the Linked List
    public boolean insertToList(Cell newCell){
        char col = newCell.getColumn(); int row = newCell.getRow();
        if(!isMax() && !cellExists(col, row)){
            return insertTail(newCell);
        }
        return false;
    }

    //Public method for removing Model.Cell from Linked List
    public boolean removeToList(char column, int row){
        if(!isEmpty() && cellExists(column, row)){
            return removeTail(column, row);
        }
        return false;
    }

    //Public method for updating cell in Linked List
    public boolean updateCell(Cell updateThis){
        char cellColumn = updateThis.getColumn();
        int cellRow = updateThis.getRow();
        String cellContent = updateThis.getContent();
        if(cellExists(cellColumn, cellRow)) return insertToList(updateThis);
        return updated(cellColumn, cellRow, cellContent);
    }


    //Insert In Front
    private boolean insertHead(Cell newCell){
        CellNode celly = null;
        if(isEmpty()){
            celly = new CellNode(newCell);
        }else{
            celly = new CellNode(null, newCell, Head);
        }
        Head = celly;
        cellSize++;
        return true;
    }

    //Insert In Back
    private boolean insertTail(Cell newCell){
        CellNode newCelly = null;
        if(isEmpty()){
            return insertHead(newCell);
        }else if(cellSize == 1){
            newCelly = new CellNode(Head, newCell, null);
            Head.setNext(newCelly);
        }else{
            CellNode current = Head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            newCelly = new CellNode(current, newCell, null);
            current.setNext(newCelly);
        }
        cellSize++;
        return true;
    }

    private boolean removeHead(){
        if(cellSize == 1){
            Head = null;
        }else{
            Head = Head.getNext();
        }
        cellSize--;
        return true;
    }

    private boolean removeTail(char column, int row){
        if(checkColRow(Head, column, row) != null){
            return removeHead();
        }
        CellNode current = Head;
        while(current != null){
            Cell remove = checkColRow(current, column, row);
            if(remove != null){ break; }
            current = current.getNext();
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        cellSize--;
        return true;
    }

    //Searches the cells linked list.
    public Cell searchSheet(char col, int row){
        if(!isEmpty()){
            CellNode current = Head;
            while(current != null){
                Cell found = checkColRow(current, col, row);
                if(found != null) return found;
                current = current.getNext();
            }
        }
        return null;
    }

    //Check the cell equals the column & row.
    private Cell checkColRow(CellNode node, char col, int row){
        char nodeCol = node.getCell().getColumn();
        int nodeRow = node.getCell().getRow();
        if(nodeCol == col && nodeRow == row){
            return node.getCell();
        }
        return null;
    }

    //View Search Model.Cell
    public Consumer<Cell> viewSearchCell = System.out::println;

    //View All Cells
    public void viewAllCells(){
        if(!isEmpty()){
            if(cellSize == 1){ System.out.println(Head.getCell()); return; }
            CellNode current = Head;
            while(current != null){
                System.out.println(current.getCell().toString() + "\n");
                current = current.getNext();
            }
        }
    }

    private boolean updated(char col, int row, String content){
        CellNode current = Head;
        while(current != null){
            if(checkColRow(current, col, row) != null){break;}
            current = current.getNext();
        }
        current.getCell().setContent(content);
        return true;
    }

}
