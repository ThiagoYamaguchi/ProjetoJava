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

public class Cadastro_equipes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNomeeqp;
	private JTextField tfdesceqp;
	private JTextField tfMembros;
	private JTextField tfBusca;
	private JTextField tfBuscaMembro;
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_equipes frame = new Cadastro_equipes();
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
	public Cadastro_equipes() {
		setResizable(false);
		setTitle("Cadastro de equipes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDaEquipe = new JLabel("Nome da equipe");
		lblNomeDaEquipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDaEquipe.setBounds(278, 26, 115, 14);
		contentPane.add(lblNomeDaEquipe);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(29, 86, 171, 14);
		contentPane.add(lblDescricao);
		
		JLabel lblMembros = new JLabel("Membros");
		lblMembros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMembros.setBounds(278, 86, 115, 14);
		contentPane.add(lblMembros);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setBounds(29, 49, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNomeeqp = new JTextField();
		tfNomeeqp.setBounds(278, 51, 242, 20);
		contentPane.add(tfNomeeqp);
		tfNomeeqp.setColumns(10);
		
		tfdesceqp = new JTextField();
		tfdesceqp.setBounds(29, 110, 217, 20);
		contentPane.add(tfdesceqp);
		tfdesceqp.setColumns(10);
		
		tfMembros = new JTextField();
		tfMembros.setBounds(278, 110, 242, 20);
		contentPane.add(tfMembros);
		tfMembros.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(13, 325, 507, 65);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(tfNomeeqp.getText().equals("") || tfdesceqp.getText().equals("") || tfMembros.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existe campos em branco!");
				} else {
				
					try {
						Connection con = Conexao.faz_conexao(); // Criando objetivo tipo con para fazer a conexao com o método dela faz_conexao
						
						String sql = "insert into dados_equipes(nomeeqp, descricaoeqp, membros) value(?, ?, ?)"; // Fazendo o sql para inserir na base
						
						PreparedStatement stmt = con.prepareStatement(sql); // Preparando o sql
						
						stmt.setString(1, tfNomeeqp.getText());
						stmt.setString(2, tfdesceqp.getText());
						stmt.setString(3, tfMembros.getText());

						stmt.execute();  // Executa
						
						stmt.close();
						con.close();;  // fechando conexão para o banco não ficar preso
						
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!"); // Mensagem para cadastro caso tenha dado sucesso
						
						tfNomeeqp.setText("");
						tfdesceqp.setText("");
						tfMembros.setText("");
						tfBuscaMembro.setText("");

					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(26, 31, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {
				
					try {
						Connection con = Conexao.faz_conexao();
						
						String sql="delete from dados_equipes where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfId.getText());
						
						stmt.execute();
						
						stmt.close();
						con.close();
						
						JOptionPane.showMessageDialog(null, "Excluído!");
						
						tfId.setText("");
						tfNomeeqp.setText("");
						tfdesceqp.setText("");
						tfMembros.setText("");
						tfBuscaMembro.setText("");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_4.setBounds(125, 31, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Voltar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu exibir = new Menu();
				exibir.setVisible(true);
				
				setVisible(false);
				
			}
		});
		btnNewButton_5.setBounds(224, 31, 89, 23);
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Abrir dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBounds(13, 414, 508, 55);
		contentPane.add(panel_1);
		
		tfBusca = new JTextField();
		tfBusca.setColumns(10);
		tfBusca.setBounds(127, 24, 86, 20);
		panel_1.add(tfBusca);
		
		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfBusca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {
										
					try {
						Connection con = Conexao.faz_conexao();
						
						String sql = "select * from dados_equipes where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfBusca.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						while (rs.next()) {
							tfId.setText(rs.getString("id"));
							tfNomeeqp.setText(rs.getString("nomeeqp"));
							tfdesceqp.setText(rs.getString("descricaoeqp"));
							tfMembros.setText(rs.getString("membros"));
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
					
					String sql = "Select * from dados_equipes";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					modelo.setNumRows(0);
					
					while (rs.next()) {
						
						modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nomeeqp"), rs.getString("descricaoeqp"), rs.getString("membros")});
						
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
		
		JButton btnNewButton_1_1 = new JButton("Buscar usuário");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfBuscaMembro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID");
				} else {
										
					try {
						Connection con = Conexao.faz_conexao();
						
						String sql = "select * from dados_senhas where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfBuscaMembro.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						while (rs.next()) {

							tfMembros.setText(rs.getString("nomecompleto"));
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
		btnNewButton_1_1.setBounds(374, 141, 146, 23);
		contentPane.add(btnNewButton_1_1);
		
		tfBuscaMembro = new JTextField();
		tfBuscaMembro.setColumns(10);
		tfBuscaMembro.setBounds(278, 142, 86, 20);
		contentPane.add(tfBuscaMembro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 188, 507, 128);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome da equipe", "Descri\u00E7\u00E3o equipe", "Membros"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDados.getColumnModel().getColumn(1).setPreferredWidth(118);
		tbDados.getColumnModel().getColumn(2).setPreferredWidth(101);
		scrollPane.setViewportView(tbDados);

	}
}
