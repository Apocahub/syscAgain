package hello;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name = "DefaultName";

    private String address = "DefaultAddress";
    public BuddyInfo() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString()
    {
        return name + "-" + address;
    }

    public static BuddyInfo fromString(String[] info)
    {
        BuddyInfo toret = new BuddyInfo();
        toret.setName(info[0]);
        toret.setAddress(info[1]);
        return toret;
    }

    public boolean equals(Object b) {
        if (!b.getClass().equals(BuddyInfo.class) ){
            return false;
        }
        if (this.name.equals(((BuddyInfo)b).getName()) && this.address.equals(((BuddyInfo)b).getAddress())) {
            return true;
        }
        return false;
    }

}
