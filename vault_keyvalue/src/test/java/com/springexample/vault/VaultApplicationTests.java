/*Need vault and mysql connectivity for this test to run**/

//package com.springexample.vault;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class VaultApplicationTests {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Test
//    public void shouldConnectToMySql() throws Exception {
//
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement()) {
//            {
//                try (ResultSet resultSet = statement
//                        .executeQuery("SELECT USER();")) {
//
//                    assertThat(resultSet.next()).isTrue();
//                }
//            }
//        }
//    }
//
//}
