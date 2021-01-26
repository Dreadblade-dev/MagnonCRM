package com.dreadblade.magnoncrm.repository;

import com.dreadblade.magnoncrm.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
