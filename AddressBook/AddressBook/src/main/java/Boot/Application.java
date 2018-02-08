package Boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "738 872 8765"));
            repository.save(new BuddyInfo("Chloe", "517 927 0875"));
            repository.save(new BuddyInfo("Kim", "864 997 5435"));
            repository.save(new BuddyInfo("David", "878 729 7548"));
            repository.save(new BuddyInfo("Michelle", "780 721 7272"));

            // fetch all customers
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo buddy = repository.findOne("878 729 7548");
            log.info("Buddy found with findOne():878 729 7548");
            log.info("--------------------------------");
            log.info(buddy.toString());
            log.info("");

            // fetch customers by last name
            log.info("Buddies found with findByPhoneNumber('864 997 5435'):");
            log.info("--------------------------------------------");
            for (BuddyInfo buddy1 : repository.findByPhoneNumber("864 997 5435")) {
                log.info(buddy1.toString());
            }
            log.info("");
        };
    }

}