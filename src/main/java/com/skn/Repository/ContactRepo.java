package com.skn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skn.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer>{

}
