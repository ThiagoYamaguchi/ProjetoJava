package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();  
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
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadUser = new JButton("Cadastro de usuários");
		btnCadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_usuarios exibir = new Cadastro_usuarios();
				exibir.setVisible(true);
				
				setVisible(false);
			}
		});
		btnCadUser.setBounds(101, 46, 232, 31);
		contentPane.add(btnCadUser);
		
		JButton btnNewButton = new JButton("Cadastro de Projetos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_projetos exibir = new Cadastro_projetos();
				exibir.setVisible(true);
				
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(101, 118, 232, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastro de equipes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_equipes exibir = new Cadastro_equipes();
				exibir.setVisible(true);
				
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(101, 184, 232, 31);
		contentPane.add(btnNewButton_1);

	}

}
