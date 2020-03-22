package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	static MenuPrincipal frame;

	
	public void tancarPestanya() {
		this.dispose();
	}
	
	/**
	 * Launch the application.
	 */
	//Menu principal
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenuPrincipal();
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
	
	//Afegim tots els botons amb els seus listeners
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][]", "[][][][][][][][][][]"));
		
		JButton btnAfegirNouVehicle = new JButton("Afegir nou vehicle");
		btnAfegirNouVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CrearVehicle frame = new CrearVehicle(0);
							frame.setVisible(true);
							tancarPestanya();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel lblBenvingutATallers = new JLabel("Benvingut a Tallers Agudo!");
		contentPane.add(lblBenvingutATallers, "cell 3 0");
		
		JButton btnVeureVehicles = new JButton("Veure vehicles");
		btnVeureVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VeureVehicles frame = new VeureVehicles();
							frame.setVisible(true);
							tancarPestanya();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnVeureVehicles, "cell 3 3");
		
		JButton btnVeurePropietaris = new JButton("Veure propietaris");
		btnVeurePropietaris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VeurePropietaris frame = new VeurePropietaris();
							frame.setVisible(true);
							tancarPestanya();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnVeurePropietaris, "cell 5 3");
		contentPane.add(btnAfegirNouVehicle, "cell 3 4");
		
		JButton btnCrearPropietari = new JButton("Crear propietari");
		btnCrearPropietari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								CrearPropietari frame = new CrearPropietari(0);
								frame.setVisible(true);
								tancarPestanya();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			}
		});
		contentPane.add(btnCrearPropietari, "cell 5 4");
		
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSortir, "cell 3 7");
	}

}
