package tutorial;

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

public class VeureVehicles extends JFrame {

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
	public VeureVehicles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Main vehicles = new Main();
		List<Vehicle> llistaVehicle = vehicles.retornarVehicles();
		contentPane.setLayout(new MigLayout("", "[424px]", "[251px][]"));

		JList list = new JList(llistaVehicle.toArray());
		contentPane.add(new JScrollPane(list), "cell 0 0,grow");

		// Botó per tornar al menú
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
		contentPane.add(btnSortir, "flowx,cell 0 1");

		// Mentres tinguis seleccionada un registre, el modificaras
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index != -1) {
					long id = llistaVehicle.get(index).getId();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								CrearVehicle frame = new CrearVehicle(id);
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

		// Borres el registre seleccionat
		JButton btnEsborrar = new JButton("Esborrar");
		btnEsborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if (index != -1) {
					long id = llistaVehicle.get(index).getId();

					Main esborrar = new Main();
					esborrar.esborrarRegistre(id, "v");

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
			}
		});
		contentPane.add(btnEsborrar, "cell 0 1");

	}

}
