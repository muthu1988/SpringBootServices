package com.astro.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.astro.domain.Sunsign;

@Repository
public interface SunsignRepositiry extends PagingAndSortingRepository<Sunsign, String> {
	
	Page<Sunsign> findAll(Pageable pageable);
	
	List<Sunsign> findBySign(String sign);
	
	List<Sunsign> findBySignIn(Collection<String> signs);

}
