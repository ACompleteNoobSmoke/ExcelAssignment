import ExcelObjects.ExcelFile;
import ObjectManager.ExcelManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExcelManagerTest {

    private ExcelManager eManager;

    public ExcelManagerTest(){
        eManager = new ExcelManager();
    }

    public ExcelFile getFile(int number){return new ExcelFile("ExcelFile" + number, number);}

    //***ADDITION***//
    @Test
    @DisplayName("Testing Add Function")
    public void testingAddFunction(){
        assertTrue(eManager.add(getFile(1)));
        assertEquals(1, eManager.getfileSize());
        eManager.showAll();
    }

    @Test
    @DisplayName("Testing Multiple Additions")
    public void testingMultipleAdditions(){
        assertTrue(eManager.add(getFile(1)));
        assertTrue(eManager.add(getFile(2)));
        assertEquals(2, eManager.getfileSize());
        eManager.showAll();
    }

    @Test
    @DisplayName("Testing Adding, Deleting And Then Adding Again")
    public void testAddAndDeleteAndTest(){
        assertTrue(eManager.add(getFile(1)));
        assertTrue(eManager.add(getFile(2)));
        assertTrue(eManager.remove("ExcelFile1"));
        assertTrue(eManager.add(getFile(4)));
        assertEquals(2, eManager.getfileSize());
        eManager.showAll();
    }

    //***REMOVE***//
    @Test
    @DisplayName("Removing Single Element")
    public void removeSingle(){
        eManager.add(getFile(1));
        assertTrue(eManager.remove("ExcelFile1"));
    }

    @Test
    @DisplayName("Removing Multiple Elements")
    public void removeMultiple(){
        eManager.add(getFile(1));
        eManager.add(getFile(2));
        eManager.add(getFile(3));
        assertTrue(eManager.remove("ExcelFile1"));
        assertTrue(eManager.remove("ExcelFile3"));
        assertTrue(eManager.remove("ExcelFile2"));
        assertEquals(0, eManager.getfileSize());
        eManager.showAll();
    }


    //***SEARCH && UPDATE***//
    @Test
    @DisplayName("Testing Search Function")
    public void searchTest(){
        eManager.add(getFile(1));
        eManager.add(getFile(2));
        assertNotNull(eManager.search("ExcelFile1"));
        assertNotNull(eManager.search("ExcelFile2"));
        eManager.remove("ExcelFile2");
        assertNull(eManager.search("ExcelFile3"));
        assertNull(eManager.search("ExcelFile2"));
    }

    @Test
    @DisplayName("Testing The Update")
    public void updateTest(){
        eManager.add(getFile(1));
        eManager.add(getFile(2));
        eManager.add(getFile(3));
        System.out.println("*** Before Updating ***");
        eManager.showAll();
        assertTrue(eManager.update("ExcelFile1", "TestingUpdate"));
        System.out.println("*** After Updating ***");
        eManager.showAll();
    }
}
