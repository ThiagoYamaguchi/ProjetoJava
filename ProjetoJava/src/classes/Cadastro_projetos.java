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
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cadastro_projetos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNomepj;
	private JTextField tfDescpj;
	private JTextField tdDatTerm;
	private JTextField tfDatIni;
	private JTextField tfBusca;
	private JTextField tfSta;
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_projetos frame = new Cadastro_projetos();
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
	public Cadastro_projetos() {
		setTitle("Cadastro de projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 28, 106, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDoProjeto = new JLabel("Nome do projeto");
		lblNomeDoProjeto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoProjeto.setBounds(281, 33, 162, 20);
		contentPane.add(lblNomeDoProjeto);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(35, 87, 162, 20);
		contentPane.add(lblDescrio);
		
		JLabel lblDataDeIncio = new JLabel("Data de início");
		lblDataDeIncio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeIncio.setBounds(281, 87, 162, 20);
		contentPane.add(lblDataDeIncio);
		
		JLabel lblDataDeTrmino = new JLabel("Data de término prevista");
		lblDataDeTrmino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeTrmino.setBounds(35, 150, 162, 20);
		contentPane.add(lblDataDeTrmino);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(281, 150, 162, 20);
		contentPane.add(lblStatus);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(35, 59, 122, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNomepj = new JTextField();
		tfNomepj.setBounds(281, 56, 246, 20);
		contentPane.add(tfNomepj);
		tfNomepj.setColumns(10);
		
		tfDescpj = new JTextField();
		tfDescpj.setBounds(35, 119, 232, 20);
		contentPane.add(tfDescpj);
		tfDescpj.setColumns(10);
		
		tdDatTerm = new JTextField();
		tdDatTerm.setBounds(35, 182, 162, 20);
		contentPane.add(tdDatTerm);
		tdDatTerm.setColumns(10);
		
		tfDatIni = new JTextField();
		tfDatIni.setColumns(10);
		tfDatIni.setBounds(281, 119, 162, 20);
		contentPane.add(tfDatIni);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(19, 378, 507, 65);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(tfNomepj.getText().equals("") || tfDescpj.getText().equals("") || tdDatTerm.getText().equals("") || tfDatIni.getText().equals("") || tfSta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existe campos em branco!");
				} else {
				
					try {
						Connection con = Conexao.faz_conexao(); // Criando objetivo tipo con para fazer a conexao com o método dela faz_conexao
						
						String sql = "insert into dados_projetos(nomepj, descricaopj, datainicio, datatermino, status) value(?, ?, ?, ?, ?)"; // Fazendo o sql para inserir na base
						
						PreparedStatement stmt = con.prepareStatement(sql); // Preparando o sql
						
						stmt.setString(1, tfNomepj.getText());
						stmt.setString(2, tfDescpj.getText());
						stmt.setString(3, tfDatIni.getText());
						stmt.setString(4, tdDatTerm.getText());
						stmt.setString(5, tfSta.getText());

						stmt.execute();  // Executa
						
						stmt.close();
						con.close();;  // fechando conexão para o banco não ficar preso
						
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!"); // Mensagem para cadastro caso tenha dado sucesso
						
						tfNomepj.setText("");
						tfDescpj.setText("");
						tfDatIni.setText("");
						tdDatTerm.setText("");
						tfSta.setText("");						

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
						
						String sql="delete from dados_projetos where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfId.getText());
						
						stmt.execute();
						
						stmt.close();
						con.close();
						
						JOptionPane.showMessageDialog(null, "Excluído!");
						
						tfId.setText("");
						tfNomepj.setText("");
						tfDescpj.setText("");
						tfDatIni.setText("");
						tdDatTerm.setText("");
						tfSta.setText("");	
						
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
		panel_1.setBounds(19, 459, 508, 55);
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
						
						String sql = "select * from dados_projetos where id=?";
						
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, tfBusca.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						while (rs.next()) {
							tfId.setText(rs.getString("id"));
							tfNomepj.setText(rs.getString("nomepj"));
							tfDescpj.setText(rs.getString("descricaopj"));
							tfDatIni.setText(rs.getString("datainicio"));
							tdDatTerm.setText(rs.getString("datatermino"));
							tfSta.setText(rs.getString("status"));
							
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
					
					String sql = "Select * from dados_projetos";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					modelo.setNumRows(0);
					
					while (rs.next()) {
						
						modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nomepj"), rs.getString("descricaopj"), rs.getString("datainicio"), rs.getString("datatermino"), rs.getString("status")});
						
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
		
		tfSta = new JTextField();
		tfSta.setColumns(10);
		tfSta.setBounds(281, 181, 232, 20);
		contentPane.add(tfSta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 221, 508, 146);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome do projeto", "Descri\u00E7\u00E3o", "Data de in\u00EDcio", "Data de t\u00E9rmino prevista", "Status"
			}
		));
		tbDados.getColumnModel().getColumn(4).setPreferredWidth(144);
		scrollPane.setViewportView(tbDados);

	}
}
