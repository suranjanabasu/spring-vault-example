package com.springexample.vaultkv;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;


/**
 * This will help in injecting all the values that are specific to the application from vault.
 * They can also be changed based on profile.
 *
 * The service will use profile to determine which set of values to retrieve
 * @author Suranjana Basu
 */
@SpringBootApplication
@EnableConfigurationProperties(MyKeyValues.class)
public class VaultKvApplication implements CommandLineRunner {

    private final MyKeyValues myKeyValues;

    public VaultKvApplication(MyKeyValues myKeyValues) {
        this.myKeyValues = myKeyValues;
    }


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(VaultKvApplication.class);
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setActiveProfiles("prod");
        application.setEnvironment(environment);
        application.run(args);
    }


    @Override
    public void run(String... args) {

        Logger logger = LoggerFactory.getLogger(VaultKvApplication.class);

        logger.info("-----------------------------------");
        logger.info("Key Values retrieved");
        logger.info("        example.username is {}", myKeyValues.getUsername());
        logger.info("        example.role is {}", myKeyValues.getRole());
        logger.info("------------------------------------");
    }

}

