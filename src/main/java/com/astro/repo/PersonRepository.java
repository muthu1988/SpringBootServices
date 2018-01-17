package com.astro.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.astro.domain.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String>{
	
	Integer countBySign(String sign);
	
	Person findByName(String name);
	
	Person findById(Integer name);

}
