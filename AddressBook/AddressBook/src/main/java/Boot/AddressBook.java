package Boot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class AddressBook {

    private int id;
    private List<BuddyInfo> addressBook;

    public AddressBook(){
        this.addressBook = new ArrayList<BuddyInfo>();
    }

   //public Boot.AddressBook(){};

    public void addBuddy(BuddyInfo b){
        addressBook.add(b);
    }

    public void removeBuddy(BuddyInfo b){
        addressBook.remove(b);
    }

    @Id
    @GeneratedValue
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id of this Team to the specified value.
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        String str = "";
        for( BuddyInfo b: addressBook){
            str = str + b.toString();
        }
        return str;
    }
    @OneToMany(cascade = CascadeType.PERSIST)
    public List<BuddyInfo> getAddressBook(){
        return addressBook;
    }

    public void setAddressBook(List<BuddyInfo>aBook){ this.addressBook=aBook;}
    public boolean containsBuddy(BuddyInfo buddy){
        return addressBook.contains(buddy);
    }

    @Override
    public boolean equals(Object aBook){
        if(!(aBook instanceof AddressBook)){ return false;}
        AddressBook a = (AddressBook) aBook;
        return addressBook.equals(a.addressBook);
    }

    public static void main(String[] args){
        AddressBook aBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Melissa", "613 316 0110");
        BuddyInfo buddy2 = new BuddyInfo("Blah", "736 927 9272");
        BuddyInfo buddy3 = new BuddyInfo("Sjndjsnd","737 983 8766");
        aBook.addBuddy(buddy1);
        aBook.addBuddy(buddy2);
        aBook.addBuddy(buddy3);
        System.out.println(aBook.toString());
        PersistBuddyInfo.performJPA();
    }
}
