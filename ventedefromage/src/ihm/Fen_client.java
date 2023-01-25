package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import application.Client;
import application.Panier;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Fen_client {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Panier panierFromage, double frais) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_client window = new Fen_client(panierFromage,frais);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fen_client(Panier panierFromage,double frais) {
		initialize(panierFromage,frais);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Panier panierFromage, double frais) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 300, 0};
		gbl_panel.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Nom");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.fill = GridBagConstraints.BOTH;
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 0;
		gbc_lblPrnom.gridy = 1;
		panel.add(lblPrnom, gbc_lblPrnom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		
		JLabel lblAdresse = new JLabel("Adresse 1");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.fill = GridBagConstraints.BOTH;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 2;
		panel.add(lblAdresse, gbc_lblAdresse);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		
		JLabel lblAdresse_1 = new JLabel("Adresse 2");
		GridBagConstraints gbc_lblAdresse_1 = new GridBagConstraints();
		gbc_lblAdresse_1.fill = GridBagConstraints.BOTH;
		gbc_lblAdresse_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse_1.gridx = 0;
		gbc_lblAdresse_1.gridy = 3;
		panel.add(lblAdresse_1, gbc_lblAdresse_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel.add(textField_3, gbc_textField_3);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.fill = GridBagConstraints.BOTH;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 0;
		gbc_lblCodePostal.gridy = 4;
		panel.add(lblCodePostal, gbc_lblCodePostal);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panel.add(textField_4, gbc_textField_4);
		
		JLabel lblVille = new JLabel("Ville");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.fill = GridBagConstraints.BOTH;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 0;
		gbc_lblVille.gridy = 5;
		panel.add(lblVille, gbc_lblVille);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		panel.add(textField_5, gbc_textField_5);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone");
		GridBagConstraints gbc_lblTlphone = new GridBagConstraints();
		gbc_lblTlphone.fill = GridBagConstraints.BOTH;
		gbc_lblTlphone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlphone.gridx = 0;
		gbc_lblTlphone.gridy = 6;
		panel.add(lblTlphone, gbc_lblTlphone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 6;
		panel.add(textField_6, gbc_textField_6);
		
		JLabel lblMail = new JLabel("Mail");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.fill = GridBagConstraints.BOTH;
		gbc_lblMail.insets = new Insets(0, 0, 0, 5);
		gbc_lblMail.gridx = 0;
		gbc_lblMail.gridy = 7;
		panel.add(lblMail, gbc_lblMail);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 7;
		panel.add(textField_7, gbc_textField_7);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fen_facture.main(null, panierFromage, new Client(textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(), textField_5.getText(), 
						textField_6.getText(), textField_7.getText()),frais);
				frame.dispose();
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		panel_1.add(btnNewButton);
	}

}
