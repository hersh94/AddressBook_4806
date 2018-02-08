import Boot.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo buddy1;
    @Before
    public void setUp() throws Exception {
        this.buddy1 = new BuddyInfo("Melissa", "613 316 0110");
    }

    @Test
    public void getName() throws Exception {
        assertEquals(buddy1.getName(),"Melissa");
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals(buddy1.getPhoneNumber(), "613 316 0110");
    }

    @Test
    public void setName() throws Exception {
        buddy1.setName("Blah");
        assertEquals(buddy1.getName(), "Blah");
    }

    @Test
    public void setPhoneNumber() throws Exception {
        buddy1.setPhoneNumber("123 456 7890");
        assertEquals(buddy1.getPhoneNumber(), "123 456 7890");
    }


    @Test
    public void equals() throws Exception {
        BuddyInfo b = new BuddyInfo("Melissa", "613 316 0110");
        assertTrue(buddy1.equals(b));
    }

}