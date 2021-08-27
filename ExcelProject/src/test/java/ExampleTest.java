
import Model.Cell;
import LinkedLists.Sheet;
import org.junit.jupiter.api.*;

public class ExampleTest {
    //@Test
    @org.junit.jupiter.api.Test
    public void insertIntoSheetLinkedListAssertions() {
        Sheet newSheet = new Sheet("Sheet1", 1);
        Cell newCell = new Cell('A', 1, "This is A1");
        Cell newCell2 = new Cell('B', 1, "This is B1");
        Cell newCell3 = new Cell('A', 1, "This shouldn't work");
        Cell newCell4 = new Cell('B', 1, "Let see if this shows up");
        Assertions.assertTrue(newSheet.insertToList(newCell), "Should Work");
        Assertions.assertTrue(newSheet.insertToList(newCell2), "Should Work");
        Assertions.assertFalse(newSheet.insertToList(newCell3), "Should Not Work");
        Assertions.assertFalse(newSheet.insertToList(newCell4), "Should Not Work");
        Assertions.assertEquals(2, newSheet.getCellSize());
        newSheet.viewAllCells();
    }

    @Test
    @Disabled
    public void deletedFromLinkedListAssertions(){
        Sheet newSheet = new Sheet("Sheet1", 1);
        Cell newCell = new Cell('A', 1, "This is A1");
        Cell newCell2 = new Cell('B', 1, "This is B1");
        Assertions.assertTrue(newSheet.insertToList(newCell), "Should Work");
        Assertions.assertTrue(newSheet.insertToList(newCell2), "Should Work");
        //newSheet.viewAllCells();
        Assertions.assertTrue(newSheet.removeToList('A', 1), "Should Remove");
        Assertions.assertEquals(1, newSheet.getCellSize());
        Assertions.assertFalse(newSheet.removeToList('A', 2), "Should Not Be Anything To Remove");
        //newSheet.viewAllCells();
        Assertions.assertTrue(newSheet.removeToList('B', 1), "Should Remove");
        Assertions.assertEquals(0, newSheet.getCellSize());
        newSheet.viewAllCells();
    }

    @Test
    @DisplayName("Updating Test")
    public void updateCellAssertions(){
        Sheet newSheet = new Sheet("Sheet1", 1);
        Cell newCell = new Cell('A', 1, "This is A1");
        Cell newCell2 = new Cell('B', 1, "This is B1");
        Assertions.assertTrue(newSheet.updateCell(newCell), "Should Insert");
        Assertions.assertTrue(newSheet.updateCell(newCell2), "Should Insert");
        newSheet.viewAllCells();
        Cell newCell3 = new Cell('A', 1, "A1 was updated");
        Cell newCell4 = new Cell('B', 1, "B1 was updated");
        Assertions.assertTrue(newSheet.updateCell(newCell3), "Updated");
        Assertions.assertTrue(newSheet.updateCell(newCell4), "Updated");
        newSheet.viewAllCells();
    }
}
