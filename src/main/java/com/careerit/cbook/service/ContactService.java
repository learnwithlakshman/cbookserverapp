package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactService {

	Contact addContact(Contact contact);

	List<Contact> getContacts();

	Contact getContact(int cid);

	Contact updateContact(Contact contact);

	boolean removeContact(int cid);

	List<Contact> search(String str);
}
