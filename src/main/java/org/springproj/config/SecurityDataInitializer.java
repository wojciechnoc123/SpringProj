package org.springproj.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;

public class SecurityDataInitializer implements ApplicationRunner {

    private final JdbcTemplate jdbcTemplate;

    public SecurityDataInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) {
        this.jdbcTemplate.execute("""
                CREATE TABLE IF NOT EXISTS `user` (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(255) NOT NULL UNIQUE,
                    password VARCHAR(255) NOT NULL
                )
                """);
        this.jdbcTemplate.execute("""
                CREATE TABLE IF NOT EXISTS `role` (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(255) NOT NULL,
                    role VARCHAR(255) NOT NULL
                )
                """);

        insertUserIfMissing("dbuser1", "dbuser1");
        insertUserIfMissing("dbuser2", "dbuser2");
        insertUserIfMissing("dbuser3", "dbuser3");

        insertRoleIfMissing("dbuser1", "ROLE_ADMIN");
        insertRoleIfMissing("dbuser2", "ROLE_USER");
        insertRoleIfMissing("dbuser3", "ROLE_USER");
        insertRoleIfMissing("dbuser3", "ROLE_ADMIN");
    }

    private void insertUserIfMissing(String username, String password) {
        Integer count = this.jdbcTemplate.queryForObject(
                "select count(*) from `user` where username = ?",
                Integer.class,
                username
        );
        if (count != null && count == 0) {
            this.jdbcTemplate.update(
                    "insert into `user`(username, password) values (?, ?)",
                    username,
                    password
            );
        }
    }

    private void insertRoleIfMissing(String username, String role) {
        Integer count = this.jdbcTemplate.queryForObject(
                "select count(*) from `role` where username = ? and role = ?",
                Integer.class,
                username,
                role
        );
        if (count != null && count == 0) {
            this.jdbcTemplate.update(
                    "insert into `role`(username, role) values (?, ?)",
                    username,
                    role
            );
        }
    }
}
