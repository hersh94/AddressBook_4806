package Boot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

public class PersistBuddyInfo {
    public static void performJPA() {
        // Creating objects representing some BuddyInfos
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

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

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

       System.out.println("List of BuddyInfos\n----------------");

        for (BuddyInfo b : results) {

            System.out.println(b.getName() + " (id=" + b.getPhoneNumber() + ")");
        }

        for(AddressBook a: aResults){
            System.out.println("Id: "+ addressBook.getId() + " " + addressBook.toString());
        }

        // Closing connection
        em.close();

        emf.close();
    }

}