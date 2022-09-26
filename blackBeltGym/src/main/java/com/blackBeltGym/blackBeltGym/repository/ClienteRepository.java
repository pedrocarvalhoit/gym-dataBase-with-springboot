package com.blackBeltGym.blackBeltGym.repository;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.orm.ClienteProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>,
        JpaSpecificationExecutor<Cliente> {

    //Busca o nome dos Dados Pessoais
    public List<Cliente> findByDadosPessoaisFirstName(String firstName);

    public List<Cliente> findByModalidadeDescricao(String descricao);

    @Query(
            value = "SELECT c.id , c.cpf, c.nivel_de_atividade FROM tb_clientes c; ",
            nativeQuery = true)
    List<ClienteProjecao> findClienteIdComModalidade();
}
