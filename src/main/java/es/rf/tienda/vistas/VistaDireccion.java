package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import es.rf.tienda.dominio.Categoria;

public class VistaDireccion {
	Categoria object;
	JFrame frame;
	JLabel idLabel;
	JLabel nombreLabel;
	JLabel descripcionLabel;
	JTextField idText;
	JTextField nombreText;
	JTextField descripcionText;
	JButton aceptarBoton;
	JButton cancelarBoton;
	
	public VistaDireccion() {
	}
	
	public void view() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500,120);
		frame.setLocationRelativeTo(null);
		
		Container panel = frame.getContentPane();
		
		idLabel = new JLabel("Id.");
		nombreLabel = new JLabel("Nombre");
		descripcionLabel = new JLabel("Descripcion");
		idText = new JTextField();
		nombreText = new JTextField();
		descripcionText = new JTextField();
		aceptarBoton = new JButton("Aceptar");
		aceptarBoton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!idText.getText().equals("") && !idText.getText().equals("") && !idText.getText().equals("")) {
					sendData(idText.getText(), nombreText.getText(), descripcionText.getText());
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
		
		frame.setVisible(true);
		
	}
	
	    public void sendData(String s1, String s2, String s3) {
	        
	        Map<String, Object> data = new HashMap<String, Object>();
	        data.put("id", s1);
	        data.put("nombre", s2);
	        data.put("descripcion", s3);
	        
	        // generate the event
	       // setChanged();
	       // notifyObservers(data);
	    }
	
}
