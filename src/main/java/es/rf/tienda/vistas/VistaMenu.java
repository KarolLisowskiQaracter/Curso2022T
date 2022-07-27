package es.rf.tienda.vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VistaMenu implements ActionListener{
	JFrame ventana;
	
	public void crearVistaMenu(){
		ventana = new JFrame("Colores");
		ventana.setSize(400, 400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		Container panel = ventana.getContentPane();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JButton jb1 = new JButton("Categorias");
		
		jb1.addActionListener(this);
		jb1.setActionCommand("PanelCategorias");
		
		JButton jb2 = new JButton("Productos");
		
		jb2.addActionListener(e -> ventana.getContentPane().setBackground(Color.GREEN));

		JButton jb3 = new JButton("Usuarios");
		
		jb3.addActionListener(e -> ventana.getContentPane().setBackground(Color.BLUE));

		JButton jb4 = new JButton("Direcciones");
		
		jb4.addActionListener(e -> ventana.getContentPane().setBackground(Color.WHITE));
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jb1,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(jb2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(jb3,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(jb4,gbc);
		
		
		ventana.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equals("PanelCategorias")) {
			ventana.hide();
			VistaCategoria vistaCat = new VistaCategoria();
			vistaCat.listarCategoriasVista();
			vistaCat.view();
		}
	}

}
