import Boot.AddressBook;
import Boot.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

public class PersistBuddyInfoTest {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    @Before
    public void setUp() throws Exception {
        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        this.emf= Persistence.createEntityManagerFactory("jpa-test");

        this.em= emf.createEntityManager();

        // Creating a new transaction
        this.tx = em.getTransaction();

    }

    @Test
    public void performJPATest(){
        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setName("Melissa");
        buddy1.setPhoneNumber("6133160110");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Blah");
        buddy2.setPhoneNumber("1234567890");

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.setId(1);



        tx.begin();

        // Persisting the product entity objects
//        em.persist(buddy1);
//        em.persist(buddy2);
        em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        Query q1 = em.createQuery("SELECT a FROM AddressBook a");
        //@SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();
        List<AddressBook>aResults = q1.getResultList();
        assertTrue(aResults.contains(addressBook));
        assertTrue(results.contains(buddy1));
        assertTrue(results.contains(buddy2));


    }



    @After
    public void tearDown(){
    // Closing connection
        em.close();

        emf.close();
    }

}