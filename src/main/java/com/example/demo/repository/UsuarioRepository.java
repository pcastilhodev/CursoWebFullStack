package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query(value = "select * from USUARIO where LOGIN = ?1", nativeQuery = true)
	Optional<Usuario> findUserByLogin(String login);
	
	@Query(value = "select * from USUARIO where id = ?1 or login = ?2", nativeQuery = true)
	Usuario findUserByPessoa(Long id, String email);

	@Query(
			value = "select constraint_name from information_schema.constraint_column_usage \r\n"
			+ "where table_name = 'usuarios_acessos' \r\n"
			+ "and column_name = 'acesso_id'\r\n"
			+ "and constraint_name <> 'uni_acesso_usuario';", nativeQuery = true
	)
	String consultaConstraintAcesso();

	@Transactional
	@Modifying
	@Query(value = "insert into USUARIOS_ACESSOS(usuario_id, acesso_id) values (?1, (select ID from ACESSOS where DESCRICAO = 'ROLE_USER'))", nativeQuery = true)
	void insereAcessoUsuarioPessoaJuridica(Long id);
}