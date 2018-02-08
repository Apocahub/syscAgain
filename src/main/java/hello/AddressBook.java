package hello;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class AddressBook implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<BuddyInfo> buddyList;

    @Id
    @GeneratedValue
    private long id;

    public AddressBook()
    {
        buddyList = new LinkedList<BuddyInfo>();
    }

    public AddressBook(LinkedList<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }

    public void addBuddy(BuddyInfo bud)
    {
        buddyList.add(bud);
    }

    public void removeBuddy(BuddyInfo bud)
    {
        buddyList.remove(bud);
    }

    @Override
    public String toString()
    {
        String ret = Long.toString(this.id) + "\n";
        for(BuddyInfo b : buddyList) {
            ret += b.toString() + "\n";
        }
        return ret;
    }

    public Collection<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public void setBuddyList(Collection<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }

    public boolean equals(AddressBook ad) {

        return this.buddyList.equals(ad.buddyList);

    }

}
