package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class CrearVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public void tancarPestanya() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public CrearVehicle(long index2) {
		//Creem tot el formulari
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][424px]", "[14px][][][][][][][][][][][][][]"));

		JLabel lblCreaciDeVehicles = new JLabel("Creaci\u00F3 de vehicles");
		contentPane.add(lblCreaciDeVehicles, "cell 0 0");

		JLabel lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1, "cell 0 1");

		JLabel lblModel = new JLabel("Model:");
		contentPane.add(lblModel, "cell 0 2");

		textField = new JTextField();
		contentPane.add(textField, "cell 0 3,growx");
		textField.setColumns(10);

		JLabel lblMarca = new JLabel("Marca:");
		contentPane.add(lblMarca, "cell 0 4");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 0 5,growx");
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Kilometres:");
		contentPane.add(lblNewLabel, "cell 0 6");

		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 0 7,growx");
		textField_2.setColumns(10);

		JLabel lblAireAcondicionat = new JLabel("Aire acondicionat:");
		contentPane.add(lblAireAcondicionat, "cell 0 8");

		JRadioButton rdbtnSi = new JRadioButton("Si");
		contentPane.add(rdbtnSi, "cell 0 9");

		JRadioButton rdbtnNo = new JRadioButton("No");

		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnSi);
		bG.add(rdbtnNo);

		contentPane.add(rdbtnNo, "cell 0 10");

		Main propietaris = new Main();
		List<Propietaris> llistaPropietaris = propietaris.retornarPropietaris();

		JLabel lblPropietari = new JLabel("Propietari:");
		contentPane.add(lblPropietari, "flowx,cell 0 11");

		//Fem una comboBox per que mostri tots els propietaris
		JComboBox comboBox = new JComboBox(llistaPropietaris.toArray());
		contentPane.add(comboBox, "cell 0 11");
		
		//Botó per modificar
		JButton btnCrear = new JButton("Crear/Modificar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("") && !textField_1.getText().equals("")) {
					try {
						if (Integer.parseInt(textField_2.getText()) > 0) {
							Main vehicle = new Main();
							boolean aire;
							//Després de totes les comprovacions, creem el vehicle
							int index = comboBox.getSelectedIndex();
							long id = llistaPropietaris.get(index).getId();
							
							if (rdbtnSi.isSelected()) {
								aire = true;
							} else {
								aire = false;
								
							}
							vehicle.crearVehicle(index2, id, Integer.parseInt(textField_2.getText()), textField_1.getText(), textField.getText(), aire);
							
							//I tornem al menú principal
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
						} else {
							lblNewLabel_1.setText("Introdueix kilòmetres vàlids.");
						}
					} catch (Exception ex) {
						System.out.println(ex);
						lblNewLabel_1.setText("Introdueix kilòmetres vàlids.");
					}

				} else {
					lblNewLabel_1.setText("Introdueix dades vàlides.");
				}
			}
		});
		contentPane.add(btnCrear, "flowx,cell 0 13");
		
		//Tornar al menú
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		contentPane.add(btnSortir, "cell 0 13");

	}
}
