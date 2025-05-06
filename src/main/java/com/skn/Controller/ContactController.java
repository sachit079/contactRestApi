package com.skn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skn.entity.Contact;
import com.skn.service.ContactServiceImp;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceImp service;

	@PostMapping(value="/save",
			consumes= {"application/json"},
			produces= {"application/json"})
	public ResponseEntity<String> saveContact(@RequestBody Contact c) {
		service.saveContact(c);
		return new ResponseEntity<String>("contact saved...",HttpStatus.OK);
	}
	
	@GetMapping(value="/get")
	 
	public ResponseEntity<String> getContact(@RequestParam(required=false) String name, @RequestParam(required=false) Long mob){
		
		List<Contact> res =service.getContact(name ,mob);
		return new ResponseEntity<String>("data="+res,HttpStatus.CREATED);

	}
	@GetMapping(value="/")
	 
	public ResponseEntity<String> getAllContact(){
		
		List<Contact> res =service.getAllContact();
		return new ResponseEntity<String>("data="+res,HttpStatus.OK);

	}
	@GetMapping(value="/{id}")
	 
	public ResponseEntity<String> fetchIdUpdate(@PathVariable("id") Integer id){
		Contact res =service.fetchForUpdate(id);
		return new ResponseEntity<String>("data="+res,HttpStatus.OK);
	}
	@PostMapping(value="/update",
			consumes= {"application/json"},
			produces= {"application/json"})
	public ResponseEntity<String> updateSavedContact(@RequestBody Contact c) {
		service.updateContact(c);
		return new ResponseEntity<String>("contact Updated...",HttpStatus.OK);
	}
	@GetMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") Integer id){
		if(service.deleteContact(id))
		return new ResponseEntity<String>("Contact deleted...",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Contact not deleted...",HttpStatus.BAD_REQUEST);

	}
}
