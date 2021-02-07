package com.careerit.cbook.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.careerit.cbook.domain.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private ContactRepo contactRepo;

	private Logger logger = LoggerFactory.getLogger(ContactDaoImpl.class);

	@Autowired
	public ContactDaoImpl() {

	}

	@Override
	public Contact insertContact(Contact contact) {
		Contact savedContact = contactRepo.save(contact);
		logger.info("Contact is added with new id:{}", savedContact.getCid());
		return contact;
	}

	@Override
	public List<Contact> selectContacts() {
		List<Contact> list = contactRepo.findAll();
		logger.info("Total contact found in db:{}", list.size());
		return list;
	}

	@Override
	public Contact selectContact(int cid) {
		Optional<Contact> optContact = contactRepo.findById(cid);
		if (optContact.isPresent()) {
			logger.info("Contact is is found for the given id: {}", cid);
			return optContact.get();
		}
		return null;
	}

	@Override
	public Contact updateContact(Contact contact) {
		Contact updateContact = contactRepo.save(contact);
		logger.info("Contact with id {} is updated successfully", updateContact.getCid());
		return updateContact;
	}

	@Override
	public boolean deleteContact(int cid) {
		Optional<Contact> optContact = contactRepo.findById(cid);
		if (optContact.isPresent()) {
			logger.info("Contact is is found for the given id: {}", cid);
			contactRepo.deleteById(cid);
			return true;
		}
		logger.info("Contact is not found for the given id:{}", cid);
		return false;
	}

	@Override
	public List<Contact> search(String str) {
		List<Contact> list = contactRepo.findByNameContainingIgnoreCase(str);
		logger.info("Total contact found in db:{} for search string", list.size(), str);
		return list;
	}

}
