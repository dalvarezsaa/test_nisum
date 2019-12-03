package com.test.nisum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.nisum.entity.PhoneEntity;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, Integer> {

}
