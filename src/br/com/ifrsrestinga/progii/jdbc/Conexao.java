package br.com.ifrsrestinga.progii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	public static Connection getConnection(){
		Connection con = null;
		
		String host = "localhost";
		String port = "3306";
		String bd = "teste?characterEncoding=UTF-8&useSSL=false";
		// inseri o encoding para eliminar o warning, caso contrario, String bd = "teste";
		String url = "jdbc:mysql://"+host+":"+port+"/"+bd;
		String usuario = "root";
		String senha = "root";

    try {
	    System.out.println("Conectando...");
   		Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection(url, usuario, senha);
	    System.out.println("Conectado com sucesso!");
	    } catch (ClassNotFoundException ex) {
	    	System.err.println("Erro de Sistema - Classe do Driver Nao Encontrada!");
	    	throw new BDException(ex);
	    	} catch (SQLException ex) {
	    		System.err.println("Erro de Sistema - Problema na conexao do banco de dados");
	    		throw new BDException(ex);
	    		}
	    return(con);
	}

}
