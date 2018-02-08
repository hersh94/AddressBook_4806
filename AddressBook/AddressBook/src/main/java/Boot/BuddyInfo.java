package Boot;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    private String name;
    @Id
    private String phoneNumber;
    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public BuddyInfo(){}

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Phone Number: " + phoneNumber;
    }
    @Override
    public boolean equals(Object b){
        if(!(b instanceof BuddyInfo)) {
            return false;
        }
        BuddyInfo buddy = (BuddyInfo) b;
        return getName().equals(buddy.getName()) && this.getPhoneNumber().equals(buddy.getPhoneNumber());


    }
}
