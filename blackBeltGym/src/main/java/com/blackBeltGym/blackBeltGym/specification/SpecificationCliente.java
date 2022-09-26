package com.blackBeltGym.blackBeltGym.specification;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationCliente {

    public static Specification<Cliente> nivelDeAtividade(String nivel){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nivelDeAtividade"), nivel));
    }

}
