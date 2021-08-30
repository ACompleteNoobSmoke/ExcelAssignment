import ExcelObjects.ExcelFile;
import LinkedLists.Sheet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.Arguments;


import java.util.stream.Stream;

public class ExcelObjectTest {

    ExcelFile newFile;

   public ExcelObjectTest(){
       newFile = new ExcelFile("ExcelFile1", 1);
   }

    public static Sheet getNewSheet(int sheetNumber){
        return new Sheet("SheetFile" + sheetNumber, sheetNumber);
    }


    @Test
    @DisplayName("Testing Insert Function")
    public void insertAssertions(){
        Sheet newSheet = getNewSheet(1);
        newFile.add(newSheet);
        assertEquals(1, newFile.getSheetSize());
        newFile.showAll();
    }

    @Test
    @DisplayName("Testing Multiple Inserts")
    //@MethodSource("getSheets")
    public void multipleInsertsAssertion(){
       Sheet newSheet = getNewSheet(1);
       Sheet newSheet2 = getNewSheet(2);
       Sheet newSheet3 = getNewSheet(3);
       Sheet newSheet4 = getNewSheet(4);
       newFile.add(newSheet);
       newFile.add(newSheet2);
       newFile.add(newSheet3);
       newFile.add(newSheet4);
       assertEquals(4, newFile.getSheetSize());
       System.out.println("\nMultiple Inserts Assertion Test");
       newFile.showAll();

    }

    public static Stream<Arguments> getSheets(){
       return Stream.of(
               Arguments.of(getNewSheet(1), getNewSheet(2), getNewSheet(3), getNewSheet(4))
               //Arguments.of(getNewSheet(4), getNewSheet(5), getNewSheet(6))
       );
    }

    @Test
    @DisplayName("Testing Deletion")
    public void deleteAssertions(){
       newFile.add(getNewSheet(1));
       newFile.add(getNewSheet(2));
       System.out.println("\nBefore Deletion");
       newFile.showAll();
       assertTrue(newFile.remove("SheetFile1"));
       System.out.println("\nAfter Deletion");
       newFile.showAll();
       System.out.println(newFile.getSheetSize());
    }

    @Test
    @DisplayName("Add Delete Add")
    public void addDeleteAdd(){
       newFile.add(getNewSheet(1));
       newFile.add(getNewSheet(2));
       assertTrue(newFile.remove("SheetFile1"));
       assertTrue(newFile.add(getNewSheet(3)));
       newFile.showAll();
    }

    @Test
    @DisplayName("Testing Deletion With Single Object")
    public void deleteAssertionsSingle(){
        newFile.add(getNewSheet(1));
        System.out.println("\nBefore Deletion");
        newFile.showAll();
        assertTrue(newFile.remove("SheetFile1"));
        assertFalse(newFile.remove("SheetFile2"));
        System.out.println("\nAfter Deletion");
        assertTrue(newFile.add(getNewSheet(4)));
        newFile.showAll();
        System.out.println(newFile.getSheetSize());
    }

    @Test
    @DisplayName("Testing Deletion Inserting Then Deleting")
    public void deleteInsertThenDelete(){
        newFile.add(getNewSheet(1));
        System.out.println("\nBefore Deletion");
        newFile.showAll();
        newFile.remove("SheetFile1");
        System.out.println("\nAfter Deletion");
        assertTrue(newFile.add(getNewSheet(4)));
        assertTrue(newFile.remove("SheetFile4"));
        newFile.showAll();
        System.out.println(newFile.getSheetSize());
    }

    @Test
    @DisplayName("Testing Searching")
    public void searchingTest(){
       newFile.add(getNewSheet(1));
       assertNotNull(newFile.search("SheetFile1"), "Should not be null");
       assertNull(newFile.search("Sheet2"), "Should be null");
    }

    @Test
    @DisplayName("Testing Searching After Deleting")
    public void searchingAfterDeletingTest(){
        newFile.add(getNewSheet(1));
        assertNotNull(newFile.search("SheetFile1"), "Should not be null");
        newFile.remove("SheetFile1");
        assertNull(newFile.search("SheetFile1"), "Should be null");
    }

    @Test
    @DisplayName("Update Method Test")
    public void updateTest(){
       newFile.add(getNewSheet(1));
       newFile.add(getNewSheet(2));
       newFile.showAll();
       System.out.println("\nAfter Updating");
       assertTrue(newFile.update("SheetFile2", "New Sheet"));
       assertFalse(newFile.update("SheetFile2", "Should Not Update"));
       newFile.showAll();
    }
}
