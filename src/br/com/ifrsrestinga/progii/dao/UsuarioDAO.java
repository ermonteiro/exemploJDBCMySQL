package br.com.ifrsrestinga.progii.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.com.ifrsrestinga.progii.entidades.Usuario;
import br.com.ifrsrestinga.progii.jdbc.Conexao;

public class UsuarioDAO {
	
	private Connection con = Conexao.getConnection();
	
		public void salvar (Usuario usuario){
			//montando o sql
			String sql = "INSERT INTO USUARIO (nome, login, senha) values (?,?,?)";
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				String nome = usuario.getNome();
				String login = usuario.getLogin();
				String senha = usuario.getSenha();
				
				prepara.setString(1,nome); //inserindo nome no primeiro '?' (nome) 
				prepara.setString(2,login); //inserindo nome no segundo '?' (login) 
				prepara.setString(3,senha); //inserindo nome no terceiro '?' (senha) 
				
				//executando no banco de dados o comando sql
				prepara.execute();   //execute retorna um booleano
				prepara.close();

				System.out.println("Registro Usuario -salvo- com sucesso");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		
		public void atualizar (Usuario usuario){
			//montando o sql
			String sql = "UPDATE usuario SET nome=?, login=?, senha=? WHERE id=?";
			
			//String sql = "UPDATE paciente SET rg=?, nome=?, datanascimento=? "+ "WHERE id=?";
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				
				String nome = usuario.getNome();
				String login = usuario.getLogin();
				String senha = usuario.getSenha();
				int id = usuario.getId();
				
				prepara.setString(1,nome); 
				prepara.setString(2,login); 
				prepara.setString(3,senha); 
				prepara.setInt(4,id); //atualizando pelo id que eh inteiro
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Registro Usuario -alterado- com sucesso");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		
		public void deletar (Usuario usuario){
			//montando o sql
			String sql = "DELETE FROM usuario WHERE id=?";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				int id = usuario.getId();
				prepara.setInt(1,id); //deletando pelo id que eh inteiro
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Registro Usuario -Deletado- com sucesso");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		
		public List<Usuario> listarTodos(){ //procurar todos nao tem parametro
			
			List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
			
			//montando o sql
			String sql = "SELECT * FROM usuario";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				//executando ---CONSULTA--- no banco de dados o comando sql
				ResultSet resultado = prepara.executeQuery(); //retorna resultado da consulta da query -> tipo ResultSet
				
				while(resultado.next()){ //buscando valor das colunas, registro por registro
					
					Usuario usu  = new Usuario();

					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String login = resultado.getString("login");
					String senha = resultado.getString("senha");

					usu.setId(id);
					usu.setNome(nome);
					usu.setLogin(login);
					usu.setSenha(senha);

					listaDeUsuarios.add(usu);
				}
				prepara.close();

				System.out.println("Listando Todos os Registros");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
			
			return listaDeUsuarios;
		}
		
		//metodos auxiliares de CRUD
		public Usuario procurarPorId(Integer id){ //procurar pelo id

			//montando o sql
			String sql = "SELECT * FROM usuario WHERE id = ?";
			
			Usuario usuario = null;

			try{
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1,id); //informando o id que deve ser buscado

				ResultSet resultado = prepara.executeQuery(); 
				
				if (resultado.next()){ 
					
					usuario = new Usuario();
					
					 //colocando id buscado (resultante) para objeto usuario
					id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String login = resultado.getString("login");
					String senha = resultado.getString("senha");

					usuario.setId(id); 
					usuario.setNome(nome);
					usuario.setLogin(login);
					usuario.setSenha(senha);
				}
				prepara.close();
				System.out.println("Listando Registro do ID: " + id);

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
			
			return usuario;
		}
		
		public Usuario procurarPorNome(String nome){ //procurar pelo id

			//montando o sql
			String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
			
			Usuario usuario = null;

			try{
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setString(1,nome); //informando o id que deve ser buscado

				ResultSet resultado = prepara.executeQuery(); 
				
				if (resultado.next()){ 
					
					usuario = new Usuario();
					
					 //colocando id buscado (resultante) para objeto usuario
					nome = resultado.getString("nome");
					int id = resultado.getInt("id");
					String login = resultado.getString("login");
					String senha = resultado.getString("senha");

					usuario.setId(id); 
					usuario.setNome(nome);
					usuario.setLogin(login);
					usuario.setSenha(senha);
				}
				prepara.close();
				System.out.println("Listando Registro do Nome: " + nome);

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
			
			return usuario;
		}
		
		public Usuario procurarPorLogin(String login){ //procurar pelo id

			//montando o sql
			String sql = "SELECT * FROM usuario WHERE login=?";
			
			Usuario usuario = null;

			try{
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setString(1,login); //informando o id que deve ser buscado

				ResultSet resultado = prepara.executeQuery(); 
				
				if (resultado.next()){ 
					
					usuario = new Usuario();
					
					 //colocando id buscado (resultante) para objeto usuario
					login = resultado.getString("login");
					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String senha = resultado.getString("senha");

					usuario.setId(id); 
					usuario.setNome(nome);
					usuario.setLogin(login);
					usuario.setSenha(senha);
				}
				prepara.close();
				System.out.println("Listando Registro do Login:" + login);

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
			
			return usuario;
		}
}
