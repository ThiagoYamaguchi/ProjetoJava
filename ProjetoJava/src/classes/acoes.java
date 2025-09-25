package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class acoes {
	
	private int id;
	private String nomecompleto;
	private String cpf;
	private String email;
	private String cargo;
	private String login;
	private String senha;
	
	public acoes(int id_p) {
		
		this.id = id_p;
		
	}
	
	public acoes(String nom, String cp, String ema, String car, String lo, String se) {
		
		this.nomecompleto = nom;
		this.cpf = cp;
		this.email = ema;
		this.cargo = car;
		this.login = lo;
		this.senha = se;
		
	}
	
	public acoes(int id_p, String nom, String cp, String ema, String car, String lo, String se) {
		
		this.id = id_p;
		this.nomecompleto = nom;
		this.cpf = cp;
		this.email = ema;
		this.cargo = car;
		this.login = lo;
		this.senha = se;
		
	}
	
	public void salvar() {
		try {
			Connection con = Conexao.faz_conexao(); // Criando objetivo tipo con para fazer a conexao com o método dela faz_conexao
			
			String sql = "insert into dados_senhas(nomecompleto, cpf, email, cargo, login, senha) value(?, ?, ?, ?, ?, ?)"; // Fazendo o sql para inserir na base
			
			PreparedStatement stmt = con.prepareStatement(sql); // Preparando o sql
			
			stmt.setString(1, nomecompleto);
			stmt.setString(2, cpf);
			stmt.setString(3, email);
			stmt.setString(4, cargo);      // Preparando as informações para envio
			stmt.setString(5, login);
			stmt.setString(6, senha);
			
			stmt.execute();  // Executa
			
			stmt.close();
			con.close();;  // fechando conexão para o banco não ficar preso
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!"); // Mensagem para cadastro caso tenha dado sucesso
			
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void atualizar() {
		try {
			Connection con = Conexao.faz_conexao();
			
			String sql = "update dados_senhas set nomecompleto=?, cpf=?, email=?, cargo=?, login=?, senha=? where id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nomecompleto);
			stmt.setString(2, cpf);
			stmt.setString(3, email);
			stmt.setString(4, cargo);
			stmt.setString(5, login);
			stmt.setString(6, senha);
			stmt.setInt(7, id);
			
			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
