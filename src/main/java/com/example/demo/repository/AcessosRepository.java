package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.acesso;

@Repository
@Transactional
public interface AcessosRepository extends JpaRepository<acesso, Long> {
	@Query(value = "select * from acessos a where upper(trim(a.DESCRICAO)) like %?1%", nativeQuery = true)
	List<acesso> buscarAcessoDescricao(String descricao);

}