package com.devtiro.databaseSQL;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseSqlApplication implements CommandLineRunner {

	private final DataSource datasource;

	public DatabaseSqlApplication(final DataSource dataSource) {
		this.datasource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Datasource: " + datasource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(datasource);
		restTemplate.execute("select 1");

	}
}