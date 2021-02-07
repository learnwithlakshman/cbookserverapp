package com.careerit.cbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/all")
	public List<Contact> getAllContacts() {
		return contactService.getContacts();
	}
	@PostMapping("/add")
	public Contact addContact(@RequestBody Contact contact) {
		return contactService.addContact(contact);
	}
	@PutMapping("/update")
	public Contact updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}
	@DeleteMapping("/remove/{cid}")
	public boolean deleteContact(@PathVariable int cid) {
		return contactService.removeContact(cid);
	}
	
	@GetMapping("/search/{str}")
	public List<Contact> search(@PathVariable String str) {
		return contactService.search(str);
	}
}
