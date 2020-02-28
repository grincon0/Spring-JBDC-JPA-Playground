package com.georgerincon.jdbc.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.georgerincon.jdbc.databasedemo.entity.Person;
import com.georgerincon.jdbc.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDAO dao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//logs results from executed method
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting 10031 -> No. of row deleted - {}", dao.deleteById(10031));
		logger.info("inserting 10041 -> {}", dao.insert(new Person(10041, "Water", "London", new Date() )));
		logger.info("updating 10021 -> {}", dao.update(new Person(10021, "Fire", "Kansas", new Date() )));
	}

}
