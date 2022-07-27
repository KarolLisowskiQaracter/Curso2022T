package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.rf.tienda.controladores.ControladorCategoria;
import es.rf.tienda.dominio.Categoria;

public class VistaCategoria implements ActionListener{
	private ControladorCategoria controladorCat;
	
	Categoria object;
	JFrame frame;
	JLabel idLabel;
	JLabel nombreLabel;
	JLabel descripcionLabel;
	JTextField idText;
	JTextField nombreText;
	JTextArea descripcionText;
	JButton aceptarBoton;
	JButton cancelarBoton;
	
	public VistaCategoria() {
		controladorCat = new ControladorCategoria(this);
	/*	JFrame vista = new JFrame();
		vista.setTitle("Gestion de categorias");
		vista.setSize(600,400);
		vista.setLocationRelativeTo(null);
		
		JPanel jpanel = new JPanel();*/
	}
	
	
	
	public void view() {	
		frame.setVisible(true);	
	}
	

	public void crearCategoriaVista() {
	    frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500,200);
		frame.setLocationRelativeTo(null);
			
		Container panel = frame.getContentPane();
			
			idLabel = new JLabel("Id.");
			nombreLabel = new JLabel("Nombre");
			descripcionLabel = new JLabel("Descripcion");
			idText = new JTextField();
			nombreText = new JTextField();
			descripcionText = new JTextArea();
			aceptarBoton = new JButton("Aceptar");
			aceptarBoton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						Integer.parseInt(idText.getText());
						if(!idText.getText().equals("") && !nombreText.getText().equals("") && !descripcionText.getText().equals("")) {
							Categoria cat = new Categoria(Integer.parseInt(idText.getText()),nombreText.getText(),descripcionText.getText());
							controladorCat.crear(cat);
						}
					}catch(Exception exception){
						System.out.println("¡El id debe ser un valor numerico!");
					}
				}
			});
			cancelarBoton = new JButton("Cancelar");
			cancelarBoton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					idText.setText("");
					nombreText.setText("");
					descripcionText.setText("");
				}
			});
			
			GridLayout grid = new GridLayout(4,2);
			panel.setLayout(grid);
			panel.add(idLabel);
			panel.add(idText);
			panel.add(nombreLabel);
			panel.add(nombreText);
			panel.add(descripcionLabel);	
			panel.add(descripcionText);
			panel.add(aceptarBoton);
			panel.add(cancelarBoton);

	    }

	public void listarCategoriasVista() {
	    frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLocationRelativeTo(null);
			//panel.setSize(480, 300);
			//Color c = Color.blue;
		//	panel.setBackground(c);
		//	panel.show();
			JTable table = new JTable();
			BorderLayout border = new BorderLayout();
			
		/*	idLabel = new JLabel("Id.");
			nombreLabel = new JLabel("Nombre");
			descripcionLabel = new JLabel("Descripcion");
			idText = new JTextField();
			nombreText = new JTextField();
			descripcionText = new JTextArea();
			aceptarBoton = new JButton("Aceptar");
			aceptarBoton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						Integer.parseInt(idText.getText());
						if(!idText.getText().equals("") && !idText.getText().equals("") && !idText.getText().equals("")) {
							Categoria cat = new Categoria(Integer.parseInt(idText.getText()),nombreText.getText(),descripcionText.getText());
							controladorCat.crear(cat);
						}
					}catch(Exception exception){
						System.out.println("¡El id debe ser un valor numerico!");
					}
				}
			});
			cancelarBoton = new JButton("Cancelar");
			cancelarBoton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					idText.setText("");
					nombreText.setText("");
					descripcionText.setText("");
				}
			});
			
			GridLayout grid = new GridLayout(4,2); 
			panel.setLayout(grid);
			panel.add(idLabel);
			panel.add(idText);
			panel.add(nombreLabel);
			panel.add(nombreText);
			panel.add(descripcionLabel);	
			panel.add(descripcionText);
			panel.add(aceptarBoton);
			panel.add(cancelarBoton); */
			
			String[][] data = {
		            { "Manuel", "4031", "CSE" },
		            { "Camila", "6014", "IT" },
		            { "Jesus", "4031", "CSE" },
		            { "Maria", "6014", "IT" },
		            { "Marta", "4031", "CSE" },
		            { "Juan", "6014", "IT" },
		            { "Ruben", "4031", "CSE" },
		            { "Marisa", "6014", "IT" },
		            { "Miguel", "4031", "CSE" },
		            { "Victor", "6014", "IT" }
		        };
		 
		        // Column Names
		        String[] columnNames = { "Name", "Roll Number", "Department" };
		 
		        table = new JTable(data, columnNames);
		        table.setBounds(0, 0, 500, 200);
		 
		       
			Color c1 = Color.yellow;
			table.setBackground(c1);
			JPanel panel1 = new JPanel();
			panel1.setBounds(0, 0, 500, 300);
			panel1.setMaximumSize(new Dimension(500, 200));
			
			panel1.setLayout(new BorderLayout());
			Container c = new Container();
			c.setBounds(00, 00, 500, 200);
			c.setLayout(border);
			table.setName("JTable Example");
		        // Frame Size
		        table.setVisible(true);
		        c.add(table);
		        c.setVisible(true);
		        c.setBackground(c1);
		        panel1.add(c);
		        frame.getContentPane().add(panel1,BorderLayout.NORTH);
			//frame.add(c);
			
			JButton jButtonCrearCat = new JButton("Nueva categoria");
			jButtonCrearCat.setSize(150, 90);
			jButtonCrearCat.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {				
						System.out.println("hola");
						//frame.removeAll();
						frame.hide();
						crearCategoriaVista();
						view();
					}catch(Exception exception){
						System.out.println("¡El id debe ser un valor numerico!");
					}
				}
			});
			
			JButton jButtonActualizarCat = new JButton("Actualizar");
			jButtonActualizarCat.setSize(150, 90);
			JButton  jButtonBorrarCat = new JButton("Borrar");
			jButtonBorrarCat.setSize(150, 90);
			JPanel panel3 = new JPanel();
			panel3.setBounds(0, 300, 500, 300);
			Container c2 = new Container();
			c2.setSize(500, 300);
			
			
			c2.add(jButtonCrearCat);
			c2.add(jButtonActualizarCat);
			c2.add(jButtonBorrarCat);
			Color green = Color.green;
			c2.setBackground(green);
			c2.setMaximumSize(new Dimension(500, 300));
			GridLayout grid2 = new GridLayout(0,3);
			c2.setLayout(grid2);
			c2.setVisible(true);
			panel3.add(c2);
			panel3.setVisible(true);
			frame.getContentPane().add(c2,BorderLayout.SOUTH);
	    }
	
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if(comando.equals("")) {
				
			}
			
		}
	
}
