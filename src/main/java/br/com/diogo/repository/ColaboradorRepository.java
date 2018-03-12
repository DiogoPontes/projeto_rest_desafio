package br.com.diogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.diogo.model.Colaborador;

@Transactional
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	
	@Query("select u.id, u.nome, u.email, s.descricao from Colaborador u, Setor s  "
			+ "where s.id = u.setor "
			+ "group by u.id, u.setor order by u.setor, u.id")
	List<Colaborador> findGroupBySetor();
 
}
