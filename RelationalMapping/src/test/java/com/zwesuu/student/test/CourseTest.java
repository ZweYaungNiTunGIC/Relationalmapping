package com.zwesuu.student.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zwesuu.student.entity.Account;
import com.zwesuu.student.entity.Account.Role;
import com.zwesuu.student.entity.Address;

public class CourseTest {
	
	static EntityManagerFactory emf;
	@BeforeAll
	static void init() {
		emf= Persistence.createEntityManagerFactory("RelationalMapping");
	}
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	@Test
	void test() {
		var em= emf.createEntityManager();
		em.getTransaction().begin();
		
		var account = new Account();
		account.setLoginId("apple");
		account.setPassword("12345");
		account.setRole(Role.Admin);
		account.setName("Apple");
		
		em.persist(account);
		
		var address = new Address();
		address.setAccount(account);
		address.setAddress("Mandalay");
		address.setEmail("apple@gmail.com");
		address.setPhone("0923445678");
		
		em.persist(address);
		
		em.getTransaction().commit();
		
		
	}

}
