package com.codewithanmol.fullstackbackend.repository;

import com.codewithanmol.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
