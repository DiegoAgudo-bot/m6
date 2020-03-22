package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class CrearPropietari extends JFrame {

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
	public CrearPropietari(long index) {
		//Creem tot el formulari
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][424px]", "[14px][][][][][][][][][][][][]"));

		JLabel lblCreaciDeVehicles = new JLabel("Creaci\u00F3 de propietaris");
		contentPane.add(lblCreaciDeVehicles, "cell 0 0");

		JLabel lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1, "cell 0 1");

		JLabel lblModel = new JLabel("Edad:");
		contentPane.add(lblModel, "cell 0 2");

		textField = new JTextField();
		contentPane.add(textField, "cell 0 3,growx");
		textField.setColumns(10);

		JLabel lblMarca = new JLabel("Nom:");
		contentPane.add(lblMarca, "cell 0 4");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 0 5,growx");
		textField_1.setColumns(10);

		JLabel lblAireAcondicionat = new JLabel("Ha pagat?");
		contentPane.add(lblAireAcondicionat, "cell 0 8");

		JRadioButton rdbtnSi = new JRadioButton("Si");
		contentPane.add(rdbtnSi, "cell 0 9");

		JRadioButton rdbtnNo = new JRadioButton("No");

		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnSi);
		bG.add(rdbtnNo);

		contentPane.add(rdbtnNo, "cell 0 10");

		//Crear o modificar, depenent de l'index
		JButton btnCrear = new JButton("Crear/Modificar");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals("")) {
					try {
						if (Integer.parseInt(textField.getText()) > 0) {
							Main propietari = new Main();
							//Després de les comprovacions, creem el propietari
							if (rdbtnSi.isSelected()) {
								propietari.creaPropietari(index, Integer.parseInt(textField.getText()), textField_1.getText(), true);
							} else {
								propietari.creaPropietari(index, Integer.parseInt(textField.getText()), textField_1.getText(), false);
							}
							
							//I tornem al menú
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
							lblNewLabel_1.setText("Introdueix edad vàlida.");
						}
					} catch (Exception ex) {
						lblNewLabel_1.setText("Introdueix edad vàlida.");
					}

				} else {
					lblNewLabel_1.setText("Introdueix dades vàlides.");
				}
			}
		});
		contentPane.add(btnCrear, "cell 0 12");
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
		contentPane.add(btnSortir, "cell 0 12");
	}

}
