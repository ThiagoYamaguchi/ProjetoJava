package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Cadastro_usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNomeCompleto;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfCargo;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private JTextField tfBusca;
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_usuarios frame = new Cadastro_usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro_usuarios() {
		setResizable(false);
		setTitle("Cadastro de usuários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 680);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ações");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNomeCompleto.getText().equals("") || tfCpf.getText().equals("") || tfEmail.getText().equals("") || tfCargo.getText().equals("") || tfLogin.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existe campos em branco!");
				} else {
					
					acoes ac = new acoes(tfNomeCompleto.getText(), tfCpf.getText(), tfEmail.getText(), tfCargo.getText(),  tfLogin.getText(), tfSenha.getText());
					ac.salvar();		
					
					tfNomeCompleto.setText("");
					tfCpf.setText("");
					tfEmail.setText("");
					tfCargo.setText("");
					tfLogin.setText("");
					tfSenha.setText("");
				}
				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Atualizar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {	
					
					acoes ac = new acoes(Integer.parseInt(tfId.getText()), tfNomeCompleto.getText(), tfCpf.getText(), tfEmail.getText(), tfCargo.getText(), tfLogin.getText(), tfSenha.getText());
					ac.atualizar();
					
				}
				
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(286, 22, 114, 14);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(34, 82, 114, 25);
		contentPane.add(lblCpf);
		
		JLabel lblNomeCompleto_1_1 = new JLabel("E-mail");
		lblNomeCompleto_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto_1_1.setBounds(286, 84, 114, 14);
		contentPane.add(lblNomeCompleto_1_1);
		
		JLabel lblNomeCompleto_1 = new JLabel("Cargo");
		lblNomeCompleto_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto_1.setBounds(34, 135, 114, 25);
		contentPane.add(lblNomeCompleto_1);
		
		JLabel lblNomeCompleto_1_2 = new JLabel("Login");
		lblNomeCompleto_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto_1_2.setBounds(286, 137, 114, 23);
		contentPane.add(lblNomeCompleto_1_2);
		
		JLabel lblNomeCompleto_1_3 = new JLabel("Senha");
		lblNomeCompleto_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto_1_3.setBounds(34, 191, 114, 14);
		contentPane.add(lblNomeCompleto_1_3);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(34, 51, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNomeCompleto = new JTextField();
		tfNomeCompleto.setColumns(10);
		tfNomeCompleto.setBounds(286, 47, 256, 20);
		contentPane.add(tfNomeCompleto);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(34, 109, 220, 20);
		contentPane.add(tfCpf);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(286, 109, 256, 20);
		contentPane.add(tfEmail);
		
		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		tfCargo.setBounds(34, 160, 220, 20);
		contentPane.add(tfCargo);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(286, 160, 256, 20);
		contentPane.add(tfLogin);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(34, 216, 220, 20);
		contentPane.add(tfSenha);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(34, 469, 507, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNomeCompleto.getText().equals("") || tfCpf.getText().equals("") || tfEmail.getText().equals("") || tfCargo.getText().equals("") || tfLogin.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existe campos em branco!");
				} else {
				
					try {
						Connection con = Conexao.faz_conexao(); // Criando objetivo tipo con para fazer a conexao com o método dela faz_conexao
						
						String sql = "insert into dados_senhas(nomecompleto, cpf, email, cargo, login, senha) value(?, ?, ?, ?, ?, ?)"; // Fazendo o sql para inserir na base
						
						PreparedStatement stmt = con.prepareStatement(sql); // Preparando o sql
						
						stmt.setString(1, tfNomeCompleto.getText());
						stmt.setString(2, tfCpf.getText());
						stmt.setString(3, tfEmail.getText());
						stmt.setString(4, tfCargo.getText());      // Preparando as informações para envio
						stmt.setString(5, tfLogin.getText());
						stmt.setString(6, tfSenha.getText());
						
						stmt.execute();  // Executa
						
						stmt.close();
						con.close();;  // fechando conexão para o banco não ficar preso
						
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!"); // Mensagem para cadastro caso tenha dado sucesso
						
						tfNomeCompleto.setText("");
						tfCpf.setText("");
						tfEmail.setText("");
						tfCargo.setText("");   // Limpando campos
						tfLogin.setText("");
						tfSenha.setText("");
						
					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				
				}
				
			}
		});
		btnNewButton.setBounds(26, 31, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {	
					
					try {
						Connection con = Conexao.faz_conexao();
						
						String sql = "update dados_senhas set nomecompleto=?, cpf=?, email=?, cargo=?, login=?, senha=? where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfNomeCompleto.getText());
						stmt.setString(2, tfCpf.getText());
						stmt.setString(3, tfEmail.getText());
						stmt.setString(4, tfCargo.getText());
						stmt.setString(5, tfLogin.getText());
						stmt.setString(6, tfSenha.getText());
						stmt.setString(7, tfId.getText());
						
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
		});
		btnNewButton_3.setBounds(125, 31, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {
				
					try {
						Connection con = Conexao.faz_conexao();
						
						String sql="delete from dados_senhas where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfId.getText());
						
						stmt.execute();
						
						stmt.close();
						con.close();
						
						JOptionPane.showMessageDialog(null, "Excluído!");
						
						tfId.setText("");
						tfNomeCompleto.setText("");
						tfCpf.setText("");
						tfEmail.setText("");
						tfCargo.setText("");   // Limpando campos
						tfLogin.setText("");
						tfSenha.setText("");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_4.setBounds(224, 31, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Voltar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu exibir = new Menu();
				exibir.setVisible(true);
				
				setVisible(false);
				
			}
		});
		btnNewButton_5.setBounds(323, 31, 89, 23);
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Abrir dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBounds(34, 555, 508, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tfBusca = new JTextField();
		tfBusca.setBounds(127, 24, 86, 20);
		panel_1.add(tfBusca);
		tfBusca.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfBusca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {
										
					try {
						Connection con = Conexao.faz_conexao();
						
						String sql = "select * from dados_senhas where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfBusca.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						while (rs.next()) {
							tfId.setText(rs.getString("id"));
							tfNomeCompleto.setText(rs.getString("nomecompleto"));
							tfCpf.setText(rs.getString("cpf"));
							tfEmail.setText(rs.getString("email"));
							tfCargo.setText(rs.getString("cargo")); 
							tfLogin.setText(rs.getString("login"));
							tfSenha.setText(rs.getString("senha"));
							
						}
						
						rs.close();
						con.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				
				}
				
			}
		});
		btnNewButton_1.setBounds(28, 23, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar Dados");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "Select * from dados_senhas";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					modelo.setNumRows(0);
					
					while (rs.next()) {
						
						modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nomecompleto"), rs.getString("cpf"), rs.getString("email"), rs.getString("cargo"), rs.getString("login"), rs.getString("senha")});
						
					}
					
					rs.close();
					con.close();
					
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(369, 23, 129, 23);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 264, 567, 181);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Completo", "Cpf", "E-mail", "Cargo", "Login", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDados.getColumnModel().getColumn(1).setPreferredWidth(101);
		scrollPane.setViewportView(tbDados);

	}
}
