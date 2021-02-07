package com.careerit.cbook.dao;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactDao {

	Contact insertContact(Contact contact);

	List<Contact> selectContacts();

	Contact selectContact(int cid);

	Contact updateContact(Contact contact);

	boolean deleteContact(int cid);

	List<Contact> search(String str);
}
