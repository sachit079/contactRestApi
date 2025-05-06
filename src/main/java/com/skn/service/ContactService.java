package com.skn.service;

import java.util.List;

import com.skn.entity.Contact;

public interface ContactService {

	public Boolean saveContact(Contact c);
	public List<Contact> getContact(String name,Long mob);
	public List<Contact> getAllContact();
	public Contact fetchForUpdate(Integer id);
	public Boolean updateContact(Contact c);
	public Boolean deleteContact(Integer id);
}
