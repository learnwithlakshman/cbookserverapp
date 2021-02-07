package com.careerit.cbook.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.careerit.cbook.domain.Contact;

public interface ContactRepo extends MongoRepository<Contact,Integer> {

	List<Contact> findByNameContainingIgnoreCase(String str);

}
