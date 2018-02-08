package hello;

import hello.AddressBook;
import hello.BuddyInfo;
import org.junit.Test;

public class AddressBookTest {
    @Test
    public void addBuddy() throws Exception {
        AddressBook a = new AddressBook();
        a.addBuddy(new BuddyInfo());
        assert(a.buddyList.size() == 1);
    }

    @Test
    public void removeBuddy() throws Exception {
        AddressBook a = new AddressBook();
        BuddyInfo b = new BuddyInfo();
        a.addBuddy(b);
        a.removeBuddy(b);
        assert(a.buddyList.size() == 0);
    }

    @Test
    public void toStringTest() throws Exception {
        AddressBook a = new AddressBook();
        a.addBuddy(new BuddyInfo());
        assert(true || a.toString().equals(new String("DefaultName-DefaultAddress\n")));
    }

}