package com.springexample.vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Helps connect to MYSQL using Vault
 *
 * @author Suranjana Basu
 */
@SpringBootApplication
public class VaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

    @Autowired
    DataSource dataSource;



    @PostConstruct
    private void postConstruct() throws Exception {

        System.out.println("##########################");

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT USER();");
            resultSet.next();

            System.out.println("Connection works with User: " + resultSet.getString(1));

            resultSet.close();
        }

        System.out.println("##########################");
    }

}
