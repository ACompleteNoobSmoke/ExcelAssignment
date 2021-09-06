package Model;

public class Cell {
    private char column;
    private int row;
    private String content = " ";
    private boolean isFilled;

    public Cell(){}

    public Cell(char column, int row){
        this.column = column;
        this.row = row;
        this.isFilled = false;
    }

    public Cell(char column, int row, String content){
        this.column = column;
        this.row = row;
        this.content = content;
        this.isFilled = filled(content);
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getContent() {
        return content;
    }

    public String getContent(char column, int row){
        if(column == getColumn() && row == getRow()){
            return content;
        }
        return "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public boolean filled(String content){
        return content.isBlank() ? false : true;
    }

    public String toString(){
        return "Column: " + column + "\n" +
                "Row: " + row + "\n" +
                "Content: " + content;
    }
}
