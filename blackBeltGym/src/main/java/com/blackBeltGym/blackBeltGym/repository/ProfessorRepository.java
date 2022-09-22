package com.blackBeltGym.blackBeltGym.repository;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.orm.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {




}
