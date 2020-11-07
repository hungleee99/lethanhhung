package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.autoconfigure.domain.EntityScanner;

import com.vti.entity.Department;



public class hibernateUtils {
	private static hibernateUtils instance;
	private Configuration configuration;
	private SessionFactory factory;
	private hibernateUtils(){
		config();
	}
	public Session openSession(){
		buildSessionFactory();
		return factory.openSession();
	}
	private SessionFactory buildSessionFactory() {
		if(factory== null || factory.isClosed()){
			ServiceRegistry registry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(registry);
		}
		return factory;
	}
	public void closeFactory(){
		if(factory!=null && factory.isOpen()){
			factory.close();
		}
	}
	private void config() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Department.class);
		
	}
	public static hibernateUtils getInstance(){
		if(instance== null){
			instance =  new hibernateUtils();
		}
		return instance;		
	}
	
}
