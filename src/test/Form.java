package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
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
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 566, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el nombre:");
		lblNewLabel.setBounds(50, 64, 136, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(171, 61, 274, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese la edad:");
		lblNewLabel_1.setBounds(50, 108, 105, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(171, 108, 274, 20);
		frame.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		JRadioButton radHombre = new JRadioButton("Hombre");
		JRadioButton radMujer = new JRadioButton("Mujer");
		radHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radMujer.setSelected(false);
			}
		});
		radHombre.setSelected(true);
		radHombre.setBounds(171, 146, 109, 23);
		frame.getContentPane().add(radHombre);
		
		radMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radHombre.setSelected(false);
			}
		});
		radMujer.setBounds(282, 146, 109, 23);
		frame.getContentPane().add(radMujer);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione el sexo:");
		lblNewLabel_2.setBounds(50, 150, 115, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ingrese el peso:");
		lblNewLabel_3.setBounds(50, 202, 115, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ingrese la altura:");
		lblNewLabel_4.setBounds(50, 255, 105, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(171, 199, 274, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(171, 252, 274, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular IMC");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre = txtNombre.getText();
				int edad = Integer.parseInt(txtEdad.getText());
				boolean checkHombre = radHombre.isSelected();
				boolean checkMujer = radMujer.isSelected();
				double peso = Double.parseDouble(txtPeso.getText());
				double altura = Double.parseDouble(txtAltura.getText());
				Sexo sexo = null;
				
				
				Persona persona = new Persona();
				
				if(checkHombre)
					sexo = Sexo.HOMBRE;
				else if(checkMujer) {
					sexo = Sexo.MUJER;
				}
				
				
				int response = persona.calcularIMC(peso, altura, sexo);
				
				
				if(response == Response.PORDEBAJO.getResponse()) {
					JOptionPane.showMessageDialog(null, "La persona " + nombre + " esta por debajo de su peso ideal.");
				}else if(response == Response.PESOIDEAL.getResponse()) {
					JOptionPane.showMessageDialog(null, "La persona " + nombre + " esta en su peso ideal.");
				}else if( response == Response.SOBREPESO.getResponse()) {
					JOptionPane.showMessageDialog(null, "La persona " + nombre + " tiene sobrepeso.");
				}
				
				if(persona.esMayorDeEdad(edad)) {
					JOptionPane.showMessageDialog(null, "La persona " + nombre + " Es mayor de edad");
				}
				
				JOptionPane.showMessageDialog(null, persona.toString(nombre, edad, sexo, peso, altura));
				
					
			}
		});
		btnCalcular.setBounds(80, 364, 156, 40);
		frame.getContentPane().add(btnCalcular);
		
		JButton btnNewButton = new JButton("Resetear");
		btnNewButton.setBounds(322, 364, 166, 40);
		frame.getContentPane().add(btnNewButton);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
