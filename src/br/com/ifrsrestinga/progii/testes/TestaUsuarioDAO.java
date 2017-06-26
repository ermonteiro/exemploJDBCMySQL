package br.com.ifrsrestinga.progii.testes;

import java.util.List;

import br.com.ifrsrestinga.progii.entidades.Usuario;
import br.com.ifrsrestinga.progii.dao.UsuarioDAO;

public class TestaUsuarioDAO {

	public static void main(String[] args) {
		testeSalvar();
		//testeAtualizar();
		//testeDeletar();
		//testeListarTodos();
		//testeProcurarPorId();
		//testeProcurarPorNome();
		//testeProcurarPorLogin();
	}

	
	private static void testeSalvar() {
		Usuario usu  = new Usuario();
		usu.setNome("TestaDAO");
		usu.setLogin("testeDao.t");
		usu.setSenha("testandoDao45");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usu);
	}
	
	private static void testeAtualizar() {
		Usuario usu  = new Usuario();
		usu.setId(6);
		usu.setNome("Juca Silva");
		usu.setLogin("jujuca");
		usu.setSenha("jujuca123");	
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.atualizar(usu);
	}
	
	private static void testeDeletar() {
		Usuario usu  = new Usuario();
		usu.setId(22);
				
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.deletar(usu);
	}

	
	private static void testeListarTodos() {
		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> listaDeUsuarios =  usuDao.listarTodos();
		
		for (Usuario u : listaDeUsuarios){
			System.out.println(u.getId() + " | " +  u.getNome() + " | " + u.getLogin() + " | " + u.getSenha());
		}
	}
	
	private static void testeProcurarPorId() {
		UsuarioDAO usuDao = new UsuarioDAO();
		//System.out.println(usuDao.procurarPorId(4));

		Usuario retorno_usu = usuDao.procurarPorId(4);
		
		if (retorno_usu != null)
			System.out.println("Nome: " + retorno_usu.getNome() + " | Login:" + retorno_usu.getLogin() + " | Senha:" + retorno_usu.getSenha());
		else
			System.out.println("ID nao localizado");
	}
	
	private static void testeProcurarPorNome() {
		UsuarioDAO usuDao = new UsuarioDAO();

		Usuario retorno_usu = usuDao.procurarPorNome("Teste DAO");
		
		if (retorno_usu != null)
			System.out.println("ID:" + retorno_usu.getId() + " | Nome:" + retorno_usu.getNome() + " | Login:" + retorno_usu.getLogin() + " | Senha:" + retorno_usu.getSenha());
		else
			System.out.println("Nome nao localizado");
	}
	
	private static void testeProcurarPorLogin() {
		UsuarioDAO usuDao = new UsuarioDAO();

		Usuario retorno_usu = usuDao.procurarPorLogin("maria.tal");
		
		if (retorno_usu != null)
			System.out.println("ID:" + retorno_usu.getId() + " | Nome:" + retorno_usu.getNome() + " | Login:" + retorno_usu.getLogin() + " | Senha:" + retorno_usu.getSenha());
		else
			System.out.println("Login nao localizado");
	}
}

	

	


