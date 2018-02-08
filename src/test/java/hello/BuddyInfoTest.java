package hello;

import hello.BuddyInfo;
import org.junit.Test;

public class BuddyInfoTest {
    @Test
    public void getName() throws Exception {
        BuddyInfo b = new BuddyInfo();
        assert (b.getName().equals(new String("DefaultName")));
    }

    @Test
    public void setName() throws Exception {
        BuddyInfo b = new BuddyInfo();
        b.setName("owowo");
        assert (b.getName().equals(new String("owowo")));
    }

    @Test
    public void getAddress() throws Exception {
        BuddyInfo b = new BuddyInfo();
        assert (b.getAddress().equals(new String("DefaultAddress")));
    }

    @Test
    public void setAddress() throws Exception {
        BuddyInfo b = new BuddyInfo();
        b.setAddress("hello");
        assert (b.getAddress().equals(new String("hello")));
    }

    @Test
    public void toStringTest() throws Exception {
        BuddyInfo b = new BuddyInfo();
        assert (b.toString().equals(new String("DefaultName-DefaultAddress")));
    }

}