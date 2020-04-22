package com.libraryportal.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryportal.portal.models.User;

public interface UserRepository extends JpaRepository<User, Number>{

}
