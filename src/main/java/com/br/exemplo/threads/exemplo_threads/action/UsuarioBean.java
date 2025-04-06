package com.br.exemplo.threads.exemplo_threads.action;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.br.exemplo.threads.exemplo_threads.model.Usuario;
import com.br.exemplo.threads.exemplo_threads.service.UsuarioService;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioService usuarioService;

	private Usuario usuario;

	public String SalvarNomeUsuario() {
		usuario.setNome("Gabriel");
		usuarioService.criarUsuario(usuario);
		return "";
	}
}
