package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import application.Fromage;
import application.Panier;

import java.awt.GridLayout;

public class Fen_description {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Fromage cheese, Panier panier) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_description window = new Fen_description(cheese, panier);
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
	public Fen_description(Fromage cheese, Panier panier) {
		initialize(cheese, panier);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Fromage cheese, Panier panier) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		for (int i = 0; i< cheese.getArticles().size(); i++) {
			comboBox.insertItemAt(cheese.getArticles().get(i).getClé() + " : " + cheese.getArticles().get(i).getPrixTTC() +"€", i);
		}
		comboBox.setSelectedIndex(0);
		SpinnerModel value = new SpinnerNumberModel(0, 0, cheese.getArticles().get(comboBox.getSelectedIndex()).getQuantitéEnStock(), 1);
		JSpinner spinner = new JSpinner(value);
		
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setText("prix : "+ cheese.getArticles().get(comboBox.getSelectedIndex()).getPrixTTC() * spinner.getValue().hashCode()  + "€");
				SpinnerModel value = new SpinnerNumberModel(0, 0, cheese.getArticles().get(comboBox.getSelectedIndex()).getQuantitéEnStock(), 1);
				spinner.setModel(value);
			}
		});
		panel_1.add(comboBox);
		spinner.addChangeListener(new ChangeListener() {
			@Override public void stateChanged(ChangeEvent changeEvent) {
				textPane_1.setText("prix : "+ cheese.getArticles().get(comboBox.getSelectedIndex()).getPrixTTC() * spinner.getValue().hashCode()  + "€");
				} 
			});
		panel_1.add(spinner);
		
		textPane_1.setText("prix : "+ cheese.getArticles().get(comboBox.getSelectedIndex()).getPrixTTC() * spinner.getValue().hashCode()  + "€");
		panel_1.add(textPane_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setEnabled(false);
		panel.add(splitPane, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ajouter au panier");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panier.ajoutArticlePanier(cheese.getArticles().get(comboBox.getSelectedIndex()), spinner.getValue().hashCode());
				frame.dispose();
			}
		});
		splitPane.setLeftComponent(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		splitPane.setRightComponent(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(cheese.getDescription());
		scrollPane.setViewportView(textPane);
	}

	public void setValue(int truc, int valeur) {
		truc = valeur;
	}
}
