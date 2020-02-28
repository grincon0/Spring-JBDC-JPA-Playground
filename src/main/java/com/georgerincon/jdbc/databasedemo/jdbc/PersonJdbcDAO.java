package com.georgerincon.jdbc.databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.georgerincon.jdbc.databasedemo.entity.Person;

// talks to the DB and gets values from there
@Repository
public class PersonJdbcDAO {
	// select * from person
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll(){
		// BeanPropertyRowMapper maps entry received from the query to a bean ( like map is in javascript)
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id){
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person){
		return jdbcTemplate.update("insert into person (id, name, location, birth_date)" 
				+ "values(?, ?, ?, ?)", new Object[] { person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person){
		return jdbcTemplate.update(
				"update person" 
				+ " set name = ?, location = ?, birth_date = ? "
				+ " where id = ?"
				, new Object[] {  person.getName(), person.getLocation(), person.getBirthDate(), person.getId() });
	}
	
}
