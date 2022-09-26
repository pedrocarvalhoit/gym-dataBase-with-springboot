package com.blackBeltGym.blackBeltGym.repository;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.orm.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Integer> {

    public List<Professor> findByDadosPessoaisLastName(String lastName);


}
