package com.br.exemplo.threads.exemplo_threads.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.br.exemplo.threads.exemplo_threads.model.Usuario;

@Stateless
public class UsuarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Usuario usuario) {
		em.persist(usuario);
	}
	
}
