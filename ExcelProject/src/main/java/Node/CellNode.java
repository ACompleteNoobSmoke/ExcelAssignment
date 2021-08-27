package Node;

import Model.Cell;

public class CellNode {

    private Cell cell;
    private CellNode prev;
    private CellNode next;

    public CellNode(){

    }

    public CellNode(Cell newCell){
        this.cell = newCell;
        this.prev = null;
        this.next = null;
    }

    public CellNode(CellNode prev, Cell newCell, CellNode next){
        this.prev = prev;
        this.cell = newCell;
        this.next = next;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public CellNode getPrev() {
        return prev;
    }

    public void setPrev(CellNode prev) {
        this.prev = prev;
    }

    public CellNode getNext() {
        return next;
    }

    public void setNext(CellNode next) {
        this.next = next;
    }

    public String toString(){
        return getCell().toString();
    }
}
