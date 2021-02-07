package com.careerit.cbook.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.domain.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	private ContactDao contactDao;

	@Autowired
	public ContactServiceImpl(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public Contact addContact(Contact contact) {
		Assert.notNull(contact, "Contact can't be null or empty");
		Assert.notNull(contact.getName(), "Contact name can't be null or empty");
		Assert.notNull(contact.getMobile(), "Contact Mobile can't be null or empty");
		Contact savedContact = contactDao.insertContact(contact);
		logger.info("Contact is added and return with id:{}", savedContact.getCid());
		return savedContact;
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> list = contactDao.selectContacts();
		logger.info("Returned Contacts with size {}  ", list.size());
		return list;
	}

	@Override
	public Contact getContact(int cid) {
		Assert.notNull(cid, "Contact can't be null or empty");
		return contactDao.selectContact(cid);
		
	}

	@Override
	public Contact updateContact(Contact contact) {
		Assert.notNull(contact, "Contact can't be null or empty");
		Assert.notNull(contact.getName(), "Contact name can't be null or empty");
		Assert.notNull(contact.getMobile(), "Contact Mobile can't be null or empty");
		return contactDao.updateContact(contact);
	}

	@Override
	public boolean removeContact(int cid) {
		Assert.notNull(cid, "Contact can't be null or empty");
		return contactDao.deleteContact(cid);
	}

	@Override
	public List<Contact> search(String str) {
		Assert.notNull(str, "Contact can't be null or empty");
		logger.info("User search data {} is requested",str);
		return contactDao.search(str);
	
	}

}
