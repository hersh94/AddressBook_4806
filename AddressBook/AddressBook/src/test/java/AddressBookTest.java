import Boot.AddressBook;
import Boot.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {
    AddressBook aBook;
    BuddyInfo buddy1;

    @Before
    public void setUp() throws Exception {
        this.aBook = new AddressBook();
        this.buddy1 = new BuddyInfo("Melissa", "613 316 0110");
    }

    @org.junit.Test
    public void addBuddy() throws Exception {
        assertEquals(aBook.getAddressBook().size(), 0);
        aBook.addBuddy(buddy1);
        assertEquals(aBook.getAddressBook().size(), 1);
        assertTrue(aBook.getAddressBook().contains(buddy1));
    }

    @org.junit.Test
    public void removeBuddy() throws Exception {
        assertEquals(aBook.getAddressBook().size(), 0);
        aBook.addBuddy(buddy1);
        aBook.removeBuddy(buddy1);
        assertEquals(aBook.getAddressBook().size(), 0);
        assertFalse(aBook.getAddressBook().contains(buddy1));
    }



    @Test
    public void equals() throws Exception {
        aBook.addBuddy(buddy1);
        AddressBook a = new AddressBook();
        BuddyInfo b = new BuddyInfo("Melissa", "613 316 0110");
        a.addBuddy(b);
        assertEquals(b, buddy1);
        assertTrue(aBook.equals(a));
    }
}