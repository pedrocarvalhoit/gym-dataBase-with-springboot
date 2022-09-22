package com.blackBeltGym.blackBeltGym.repository;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {


}
