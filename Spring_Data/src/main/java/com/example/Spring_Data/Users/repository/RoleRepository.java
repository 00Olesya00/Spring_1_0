package com.example.Spring_Data.Users.repository;


import com.example.Spring_Data.Users.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Authority, Long> {
}