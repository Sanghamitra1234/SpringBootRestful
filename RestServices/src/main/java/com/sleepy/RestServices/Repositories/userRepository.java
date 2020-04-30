package com.sleepy.RestServices.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sleepy.RestServices.entities.User;

@Repository
public  interface userRepository extends JpaRepository<User, Long>{
	User findByName(String name);
}
