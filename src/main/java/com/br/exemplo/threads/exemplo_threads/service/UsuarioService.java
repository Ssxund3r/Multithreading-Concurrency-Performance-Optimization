package com.br.exemplo.threads.exemplo_threads.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.br.exemplo.threads.exemplo_threads.model.Usuario;
import com.br.exemplo.threads.exemplo_threads.repository.UsuarioRepository;
@Stateless
public class UsuarioService {
	
	@EJB
	private UsuarioRepository usuarioRepository;

	public void criarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
