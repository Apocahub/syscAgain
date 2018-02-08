package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository, BuddyInfoRepository buddyRep) {
        return args -> {
            AddressBook addressBook1 = new AddressBook();
            AddressBook addressBook2 = new AddressBook();

            BuddyInfo b1 = new BuddyInfo();
            b1.setAddress("earth");
            b1.setName("aliens");

            BuddyInfo b2 = new BuddyInfo();
            b2.setAddress("mars");
            b2.setName("water");

            BuddyInfo b3 = new BuddyInfo();
            b3.setAddress("venus");
            b3.setName("lava");

            addressBook1.addBuddy(b1);
            addressBook1.addBuddy(b2);

            //addressBook2.addBuddy(b3);

            repository.save(addressBook1);

            //repository.save(addressBook2);

            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addressBookRet1 : repository.findAll()) {
                log.info(addressBookRet1.toString());
            }

            // fetch an individual customer by ID
            AddressBook addressBookRet2 = repository.findOne(1L);
            log.info("AddressBook found with findOne(1L):");
            log.info("--------------------------------");
            log.info(addressBookRet2.toString());
            log.info("");

        };
    }

}
