package com.skn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.skn.Repository.ContactRepo;
import com.skn.entity.Contact;

@Service
public class ContactServiceImp implements ContactService{

	@Autowired
	private ContactRepo repo;
	@Override
	public Boolean saveContact(Contact c) {
		
		if(c!=null) {
			repo.save(c);
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getContact(String name ,Long mob ) {
		Contact c=new Contact();
		if(!"".equals(name)) {
			c.setName(name);
		}
		if(!"".equals(mob)) {
			c.setMobNo(mob);
		}
		Example<Contact> ex=Example.of(c);
		List<Contact> con =repo.findAll(ex);
		return con;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> con=repo.findAll();
		return con;
	}

	@Override
	public Contact fetchForUpdate(Integer id) {
		Optional<Contact>data=repo.findById(id);
       Contact con = data.orElse(new Contact());
		return con;
	}

	@Override
	public Boolean updateContact(Contact c) {
		
		if(c!=null) {
			repo.save(c);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteContact(Integer id) {
		if(repo.existsById(id)) {
		repo.deleteById(id);
		return true;
		}
		else
		return false;
	}

}
