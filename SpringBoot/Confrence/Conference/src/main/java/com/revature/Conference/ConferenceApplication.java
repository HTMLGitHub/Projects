package com.revature.Conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@SpringBootApplication
public class ConferenceApplication
{
	@Autowired
	protected static DataSource dataSource;

	public static void main(String[] args)
	{
		SpringApplication.run(ConferenceApplication.class, args);
	}
}
