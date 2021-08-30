import Model.User;
import ObjectManager.UserManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager uManager;

    public UserManagerTest(){
        uManager = new UserManager();
    }

    public User getUser(String first, String last, String user, String pass){
        return new User(first,last, user, pass);
    }

    //***ADDITION***//
    @Test
    @DisplayName("Testing Add Function")
    public void testingAddFunction(){
        assertTrue(uManager.add(getUser("Osaretin", "Omofonmwan", "Oso", "Oso")));
        assertEquals(1, uManager.getUserSize());
        uManager.showAll();
    }

    @Test
    @DisplayName("Testing Multiple Additions")
    public void testingMultipleAdditions(){
        assertTrue(uManager.add(getUser("Osaretin", "Omofonmwan", "Oso", "Oso")));
        assertTrue(uManager.add(getUser("Omoruyi", "Omofonmwan", "Uyi", "Oso")));
        assertEquals(2, uManager.getUserSize());
        uManager.showAll();
    }

    @Test
    @DisplayName("Testing Adding, Deleting And Then Adding Again")
    public void testAddAndDeleteAndTest(){
        assertTrue(uManager.add(getUser("Osaretin", "Omofonmwan", "Oso", "Oso")));
        assertTrue(uManager.add(getUser("Omoruyi", "Omofonmwan", "Uyi", "Oso")));
        assertTrue(uManager.remove("Uyi"));
        assertTrue(uManager.add(getUser("Boye", "Uwensuyi", "Boye", "Oso")));
        assertEquals(2, uManager.getUserSize());
        uManager.showAll();
    }

    //***REMOVE***//
    @Test
    @DisplayName("Removing Single Element")
    public void removeSingle(){
        assertTrue(uManager.add(getUser("Adedayo", "Uwensuyi", "Ade", "Oso")));
        assertTrue(uManager.remove("Ade"));
    }

    @Test
    @DisplayName("Removing Multiple Elements")
    public void removeMultiple(){
        assertTrue(uManager.add(getUser("Osaretin", "Omofonmwan", "Oso", "Oso")));
        assertTrue(uManager.add(getUser("Omoruyi", "Omofonmwan", "Uyi", "Oso")));
        assertTrue(uManager.add(getUser("Adedayo", "Uwensuyi", "Ade", "Oso")));
        assertTrue(uManager.remove("Ade"));
        assertTrue(uManager.remove("Oso"));
        assertEquals(1, uManager.getUserSize());
        uManager.showAll();
    }


    //***SEARCH***//
    @Test
    @DisplayName("Testing Search Function")
    public void searchTest(){
        assertTrue(uManager.add(getUser("Adedayo", "Uwensuyi", "Ade", "Oso")));
        assertTrue(uManager.add(getUser("Boye", "Uwensuyi", "Boye", "Oso")));
        assertNotNull(uManager.search("Boye"));
        assertNotNull(uManager.search("Ade"));
        uManager.remove("Boye");
        assertNull(uManager.search("Boye"));
    }
}
