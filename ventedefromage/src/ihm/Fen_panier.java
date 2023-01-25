package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import application.Panier;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
public class Fen_panier {
	private JFrame frame;
	private double frais;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Panier panierFromage) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_panier window = new Fen_panier(panierFromage);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void updateTable() {
		
	}
	/**
	 * Create the application.
	 */
	public Fen_panier(Panier panierFromage) {
		initialize(panierFromage);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Panier panierFromage) {
		frais = 9.9;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Votre Panier");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Valider le panier");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Fen_client.main(null, panierFromage, frais);
			}
		});
		panel.add(btnNewButton);
		
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Vider le panier");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panierFromage.validerPanier(false);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Continuer les achats");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		DefaultTableModel model = creationModel(panierFromage);;
		JTable table = new JTable(model);
		panel_1.add(table, BorderLayout.CENTER);
	
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(4, 1, 0, 0));
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Colissimo en point Relais 4.9€");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Colissimo à domicile 4.9€");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chronopost 9.9€");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setValueAt("4.9€", model.getRowCount()-2, 3);
				model.setValueAt(4.9 + panierFromage.getPrixTotal()+ "€", model.getRowCount()-1, 3);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
				frais = 4.9;
			}
		});
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.add(rdbtnNewRadioButton_2);
		
		
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setValueAt("4.9€", model.getRowCount()-2, 3);
				model.setValueAt(4.9 + panierFromage.getPrixTotal() + "€", model.getRowCount()-1, 3);
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				frais = 4.9;
			}
		});
		panel_3.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setValueAt("9.9€", model.getRowCount()-2, 3);
				model.setValueAt(9.9 + panierFromage.getPrixTotal()+ "€", model.getRowCount()-1, 3);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				frais = 9.9;
			}
		});
		panel_3.add(rdbtnNewRadioButton);
		
	}
	
	public DefaultTableModel creationModel(Panier panierFromage) {
		String[] s = {"produit", "prix", "quantité", "total"};
	    DefaultTableModel model = new DefaultTableModel(s, 0);
	    
	    model.addRow(s);
	    for (int i = 0; i < panierFromage.getPanier().size(); i++) {
			model.addRow(new Object[] {
					panierFromage.getPanier().get(i).getFromage().getDésignation(),
					panierFromage.getPanier().get(i).getPrixTTC(),
					panierFromage.getQuantité().get(i),
					panierFromage.getPanier().get(i).getPrixTTC() * panierFromage.getQuantité().get(i)
			});
		}
	    model.addRow(new Object[] {
				"",
				"",
				"SOUS TOTAL TTC",
				panierFromage.getPrixTotal()
		});
	    
	    model.addRow(new Object[] {
	    		"",
				"",
				"FRAIS DE PORT",
				"9.9€"
				
		});
	    
	    model.addRow(new Object[] {
	    		"",
				"",
				"TOTAL TTC",
				9.9 + panierFromage.getPrixTotal()
		});
	    
	    return model;
	}
}