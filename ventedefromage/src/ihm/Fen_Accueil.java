package ihm;

import java.awt.EventQueue;
import application.*;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.swing.JSplitPane;

import application.Articles;
import application.GenerationFromages;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.util.LinkedList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Fen_Accueil {
	private Articles mesArticles = GenerationFromages.générationBaseFromages();
	List<Fromage> Liste_fromage = mesArticles.getLesFromages();
	List<Fromage> Liste_fromage_Vache = mesArticles.fromageAuLaitDe(TypeLait.VACHE);
	List<Fromage> Liste_fromage_Brebis = mesArticles.fromageAuLaitDe(TypeLait.BREBIS);
	List<Fromage> Liste_fromage_Chevre = mesArticles.fromageAuLaitDe(TypeLait.CHEVRE);
	
	private List<String> tout_fromage = new LinkedList<String>();
	private List<String> fromage_Vache = new LinkedList<String>();
	private List<String> fromage_Brebis = new LinkedList<String>();
	private List<String> fromage_Chevre = new LinkedList<String>();
	
	private DefaultListModel<String> modTout = new DefaultListModel<String>();
	private DefaultListModel<String> modVache = new DefaultListModel<String>();
	private DefaultListModel<String> modBrebis = new DefaultListModel<String>();
	private DefaultListModel<String> modChevre = new DefaultListModel<String>();
	
	private Panier panier = new Panier();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_Accueil window = new Fen_Accueil();
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
	public Fen_Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		fillModel();
		JList<String> list = new JList<String>(modTout);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pos  = list.getSelectedIndex();
				Fromage cheese = Liste_fromage.get(pos);
				Fen_description.main(null, cheese, panier);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("CHEVRE");
		btnNewButton.setIcon(new ImageIcon(Fen_Accueil.class.getResource("/image/sheep_Custom.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<String> list = new JList<String>(modChevre);
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int pos  = list.getSelectedIndex();
						Fromage cheese = Liste_fromage_Chevre.get(pos);
						System.out.println(cheese.getDésignation());
						Fen_description.main(null, cheese, panier);
					}
				});
				scrollPane.setViewportView(list);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VACHE");
		btnNewButton_1.setIcon(new ImageIcon(Fen_Accueil.class.getResource("/image/cow_Custom.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<String> list = new JList<String>(modVache);
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int pos  = list.getSelectedIndex();
						Fromage cheese = Liste_fromage_Vache.get(pos);
						System.out.println(cheese.getDésignation());
						Fen_description.main(null, cheese, panier);
					}
				});
				scrollPane.setViewportView(list);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BREBI");
		btnNewButton_2.setIcon(new ImageIcon(Fen_Accueil.class.getResource("/image/goat_Custom.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<String> list = new JList<String>(modBrebis);
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int pos  = list.getSelectedIndex();
						Fromage cheese = Liste_fromage_Brebis.get(pos);
						System.out.println(cheese.getDésignation());
						Fen_description.main(null, cheese, panier);
					}
				});
				scrollPane.setViewportView(list);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("TOUS");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<String> list = new JList<String>(modTout);
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int pos  = list.getSelectedIndex();
						Fromage cheese = Liste_fromage.get(pos);
						Fen_description.main(null, cheese, panier);
					}
				});
				scrollPane.setViewportView(list);
			}
		});
		panel.add(btnNewButton_3);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		frame.getContentPane().add(splitPane, BorderLayout.NORTH);
		JLabel Titre = new JLabel("Liste de tout les fromages :");
		Titre.setIcon(new ImageIcon(Fen_Accueil.class.getResource("/image/cheese_Custom_1.png")));
		splitPane.setLeftComponent(Titre);
		
		JButton buttonPanier = new JButton("Panier");
		buttonPanier.setIcon(new ImageIcon(Fen_Accueil.class.getResource("/image/chariot_Custom (Personnalis\u00E9).png")));
		buttonPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fen_panier.main(null, panier);
			}
		});
		splitPane.setRightComponent(buttonPanier);
		
		
	}
	
	private void fillList() {
		for (Fromage f : Liste_fromage) {
			tout_fromage.add(f.getDésignation());
			
			if (f.getTypeFromage() == TypeLait.BREBIS) {
				fromage_Brebis.add(f.getDésignation());
			}
			
			if (f.getTypeFromage() == TypeLait.VACHE) {
				fromage_Vache.add(f.getDésignation());
			}
			
			if (f.getTypeFromage() == TypeLait.CHEVRE) {
				fromage_Chevre.add(f.getDésignation());
			}
		}
	}
	
	private void fillModel() {
		fillList();
		for (int i = 0, n = tout_fromage.size(); i < n; i++) {
			modTout.addElement(tout_fromage.get(i));
		}
		for (int i = 0, n = fromage_Brebis.size(); i < n; i++) {
			modVache.addElement(fromage_Brebis.get(i));
		}
		for (int i = 0, n = fromage_Vache.size(); i < n; i++) {
			modBrebis.addElement(fromage_Vache.get(i));
		}
		for (int i = 0, n = fromage_Chevre.size(); i < n; i++) {
			modChevre.addElement(fromage_Chevre.get(i));
		}
	}

}
