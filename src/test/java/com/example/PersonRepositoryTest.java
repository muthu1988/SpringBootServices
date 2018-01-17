package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.astro.domain.Person;
import com.astro.repo.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository repository;
	
	@Test
	public void asdasd(){
		Person person = new Person();
		person.setName("Muthu");
		person.setSign("Aries");
		this.entityManager.persist(person);
		Person fromDb = repository.findById(person.getId());
		assertThat(fromDb.getName()).isEqualTo("Muthu");
	}

}
