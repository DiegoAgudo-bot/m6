package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VeurePropietaris extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public void tancarPestanya() {
		this.dispose();
	}
	/**
	 * Create the frame.
	 */
	public VeurePropietaris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Main propietaris = new Main();
		List<Propietaris> llistaPropietaris = propietaris.retornarPropietaris();
		contentPane.setLayout(new MigLayout("", "[424px]", "[251px][]"));
		
		//Mostra tots els propietaris
		JList list = new JList(llistaPropietaris.toArray());
		contentPane.add(new JScrollPane(list), "cell 0 0,grow");
		
		//Tornar al menú
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MenuPrincipal frame = new MenuPrincipal();
							frame.setVisible(true);
							tancarPestanya();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnSortir, "cell 0 1");
		
		//Modificar registre seleccionat
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index != -1) {
				long id = llistaPropietaris.get(index).getId();
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CrearPropietari frame = new CrearPropietari(id);
							frame.setVisible(true);
							tancarPestanya();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			}
		});
		contentPane.add(btnModificar, "cell 0 1");

		//Borrar registre seleccionat
		JButton btnEsborrar = new JButton("Esborrar");
		btnEsborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if (index != -1) {
				long id = llistaPropietaris.get(index).getId();
				
				Main esborrar = new Main();
				esborrar.esborrarRegistre(id, "p");
				
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
			}
		});
		contentPane.add(btnEsborrar, "cell 0 1");
	}

}
