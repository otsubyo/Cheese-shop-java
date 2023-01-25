package ihm;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import application.Client;
import application.Panier;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fen_facture {

	private JFrame frmFacture;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Panier panierFromage, Client client, double frais) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_facture window = new Fen_facture(panierFromage, client, frais);
					window.frmFacture.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fen_facture(Panier panierFromage, Client client, double frais) {
		initialize(panierFromage,client, frais);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Panier panierFromage, Client client, double frais) {
		String varDate = new String("Jeudi");
		String varHeure = new String("16h");
		String varLieu = new String("toulouse");
		String Nom = client.getNom();
		String Prenom = client.getPrenom();
		String varAdresse =client.getAdresse();
		String varAdresse2 =client.getAdresse2();
		String varCodePostal = client.getC_postal();
		String varVille = client.getVille();
		String varNTel = client.getTelephone();
		String varMail = client.getMail();
		String prixTransports = "TRANSPORTS :  " + Double.toString(frais);
		if (panierFromage.getPrixTotal() >= 150) {
			prixTransports = "TRANSPORTS OFFERTS";
		}
		
		frmFacture = new JFrame();
		frmFacture.setTitle("Facture");
		frmFacture.setBounds(100, 100, 749, 535);
		frmFacture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFacture.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmFacture.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frmFacture.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Toulouse, le "+varDate+" à "+varHeure +" "+ varLieu);
		lblNewLabel_1.setBounds(10, 37, 365, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Fromagerie Dauré pour vous servir et vous resservir en fromages");
		lblNewLabel.setBounds(67, 10, 300, 13);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("INFORMATIONS CLIENT:");
		lblNewLabel_2.setBounds(20, 61, 136, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setText(Prenom +" "+ Nom);
		lblNewLabel_3.setBounds(223, 61, 221, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setText(varAdresse);
		lblNewLabel_3_1.setBounds(223, 73, 200, 13);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setText(varCodePostal+" "+ varVille);
		lblNewLabel_3_2.setBounds(223, 111, 200, 13);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setText(varNTel);
		lblNewLabel_3_3.setBounds(223, 97, 200, 13);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel();
		lblNewLabel_3_4.setText(varMail);
		lblNewLabel_3_4.setBounds(223, 121, 200, 13);
		panel_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_4 = new JLabel("RECAP. COMMANDE :");
		lblNewLabel_4.setBounds(20, 157, 136, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fromagerie Dauré pour vous servir et vous resservir en fromages");
		lblNewLabel_5.setBounds(82, 428, 441, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL TTC COMMANDE : "+panierFromage.getPrixTotal()+"€");
		lblNewLabel_6.setBounds(82, 351, 254, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PRIX TOTAL TTC : "+panierFromage.getPrixTotal()+"€");
		lblNewLabel_7.setBounds(82, 376, 254, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(prixTransports);
		lblNewLabel_8.setBounds(82, 362, 113, 14);
		panel_1.add(lblNewLabel_8);
		
		String[] s = {"n°", "désignation","coupe", "prix TTC unité", "quantité", "prix TTC"};
	    DefaultTableModel model = new DefaultTableModel(s, 0);
		model.addRow(s);
	    for (int i = 0; i < panierFromage.getPanier().size(); i++) {
			model.addRow(new Object[] {
					i,
					panierFromage.getPanier().get(i).getFromage().getDésignation(),
					panierFromage.getPanier().get(i).getClé(),
					panierFromage.getPanier().get(i).getPrixTTC(),
					panierFromage.getQuantité().get(i),
					panierFromage.getPanier().get(i).getPrixTTC() * panierFromage.getQuantité().get(i)
			});
		}
		table_1 = new JTable(model);
		table_1.setBounds(20, 182, 703, 104);
		panel_1.add(table_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel();
		lblNewLabel_3_1_1.setText(varAdresse2);
		lblNewLabel_3_1_1.setBounds(223, 87, 200, 13);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("TRANSPORT :");
		lblNewLabel_6_1.setBounds(82, 362, 254, 14);
		panel_1.add(lblNewLabel_6_1);
		
		JPanel panel_2 = new JPanel();
		frmFacture.getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		frmFacture.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panierFromage.validerPanier(false);
				frmFacture.dispose();
			}
		});
		panel_3.add(btnNewButton);
		
		
	}
}