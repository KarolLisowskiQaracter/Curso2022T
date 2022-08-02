package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.rf.tienda.controladores.ControladorCategoria;
import es.rf.tienda.controladores.ControladorUsuario;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DomainException;

public class VistaUsuario implements ActionListener{
	private ControladorUsuario controladorUsuario;
	private static VistaUsuario instancia = null;
	
	Usuario object;
	static JFrame frame;
	JLabel idLabel;
	JLabel nombreLabel;
	JLabel emailLabel;
	JTextField emailText;
	JTextField idText;
	JTextField nombreText;
	JLabel contraseñaLabel;
	JTextField contraseñaText;
	JLabel tipoUsuarioLabel;
	JTextField tipoUsuarioText;
	JLabel dniLabel;
	JTextField dniText;
	JLabel fechaAltaLabel;
	JTextField fechaAltaText;
	JLabel fechaConfirmacionLabel;
	JTextField fechaConfirmacionText;
	JButton aceptarBoton;
	JButton vueltaMenuBoton;
	JTable table;
	
	private VistaUsuario() {
		controladorUsuario = new ControladorUsuario(this);
		listarUsuariosVista();
		view();
	}

	public static VistaUsuario getInstance() {
		if (instancia == null) {
			instancia = new VistaUsuario();
		}
		view();
		return instancia;
	}
	
	
	private static void view() {	
		frame.setVisible(true);	
	}
	
	private void crearUsuarioVista() {
	    frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
			
		Container panel = frame.getContentPane();
			
			idLabel = new JLabel("Id.");
			nombreLabel = new JLabel("Nombre");
			emailLabel = new JLabel("Email");
			idText = new JTextField();
			nombreText = new JTextField();
			emailText = new JTextField();
			
			contraseñaLabel = new JLabel("Contraseña");
			contraseñaText = new JTextField();
			tipoUsuarioLabel = new JLabel("Tipo Usuario");
			tipoUsuarioText = new JTextField();
			dniLabel = new JLabel("DNI");
			dniText = new JTextField();
			fechaAltaLabel = new JLabel("Fecha Alta");
			fechaAltaText = new JTextField();
			fechaConfirmacionLabel = new JLabel("Fecha Confirmacion");
			fechaConfirmacionText = new JTextField();
			
			aceptarBoton = new JButton("Aceptar");
			aceptarBoton.setActionCommand("CrearUsuario");
			aceptarBoton.addActionListener(this);
			vueltaMenuBoton = new JButton("Volver al menu");
			vueltaMenuBoton.setActionCommand("VolverMenuUsuarios");
			vueltaMenuBoton.addActionListener(this);
			
			
			GridLayout grid = new GridLayout(9,2);
			panel.setLayout(grid);
			panel.add(idLabel);
			panel.add(idText);
			panel.add(nombreLabel);
			panel.add(nombreText);
			panel.add(emailLabel);
			panel.add(emailText);
			panel.add(contraseñaLabel);
			panel.add(contraseñaText);
			panel.add(tipoUsuarioLabel);
			panel.add(tipoUsuarioText);
			panel.add(dniLabel);
			panel.add(dniText);
			panel.add(fechaAltaLabel);
			panel.add(fechaAltaText);
			panel.add(fechaConfirmacionLabel);
			panel.add(fechaConfirmacionText);
			panel.add(aceptarBoton);
			panel.add(vueltaMenuBoton);

	    }
	
	private void listarUsuariosVista() {
	    frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLocationRelativeTo(null);

			table = new JTable();
			BorderLayout border = new BorderLayout();			
			
			List<Usuario> usuarios = controladorUsuario.listAll();
			String[][] data = new String[usuarios.size()][3];
			for(int i = 0; i < usuarios.size(); i++) {
				data[i][0] = Integer.toString(usuarios.get(i).getId_usuario());
				data[i][1] = usuarios.get(i).getUser_nombre();
				data[i][2] = usuarios.get(i).getUser_email();
			}
		
		        // Column Names
		        String[] columnNames = { "ID", "Nombre", "Email" };
		 
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
			
			JButton jButtonCrearUsuario = new JButton("Nuevo usuario");
			jButtonCrearUsuario.setSize(150, 90);
			jButtonCrearUsuario.setActionCommand("CrearUsuarioPantalla");
			jButtonCrearUsuario.addActionListener(this);
			
			JButton jButtonActualizarUsuario = new JButton("Actualizar");
			jButtonActualizarUsuario.setSize(150, 90);
			jButtonActualizarUsuario.setActionCommand("ActualizarDatosUsuario");
			jButtonActualizarUsuario.addActionListener(this);
			
			JButton jButtonBorrarUsuario = new JButton("Borrar");
			jButtonBorrarUsuario.setSize(150, 90);
			jButtonBorrarUsuario.setActionCommand("BorrarUsuario");
			jButtonBorrarUsuario.addActionListener(this);
			
			JButton  jButtonVolverMenuPrincipal = new JButton("Menu");
			jButtonVolverMenuPrincipal.setSize(150, 90);
			jButtonVolverMenuPrincipal.setActionCommand("VolverMenuPrincipal");
			jButtonVolverMenuPrincipal.addActionListener(this);
			
			JPanel panel3 = new JPanel();
			panel3.setBounds(0, 300, 500, 300);
			Container c2 = new Container();
			c2.setSize(500, 300);
			
			
			c2.add(jButtonCrearUsuario);
			c2.add(jButtonActualizarUsuario);
			c2.add(jButtonBorrarUsuario);
			c2.add(jButtonVolverMenuPrincipal);
			
			Color green = Color.green;
			c2.setBackground(green);
			c2.setMaximumSize(new Dimension(500, 300));
			GridLayout grid2 = new GridLayout(0,4);
			c2.setLayout(grid2);
			c2.setVisible(true);
			panel3.add(c2);
			panel3.setVisible(true);
			frame.getContentPane().add(c2,BorderLayout.SOUTH);
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("CrearUsuarioPantalla")) {
			frame.hide();
			crearUsuarioVista();
			view();
			
		}else if(comando.equals("ListarUnUsuario")){
			Usuario dummy = new Usuario(97,"Manuel" , "manuelgarcia@hotmail.com");
			Usuario cat = controladorUsuario.listOne(dummy);
			System.out.println(cat.getId_usuario());
			System.out.println(cat.getUser_nombre());
			System.out.println(cat.getUser_email());
			
		}else if(comando.equals("ActualizarDatosUsuario")){
			if(!table.getSelectionModel().isSelectionEmpty() && table.getSelectionModel().getSelectedItemsCount() == 1) {
				int selectedRow = table.getSelectionModel().getSelectedIndices()[0];
				Usuario usuario = new Usuario();		
					usuario.setId_usuario(Integer.parseInt(table.getValueAt(selectedRow, 0).toString()));
					usuario.setUser_nombre(table.getValueAt(selectedRow, 1).toString());
					usuario.setUser_email(table.getValueAt(selectedRow, 2).toString());
					frame.hide();
					crearUsuarioVista();
					idText.setText(Integer.toString(usuario.getId_usuario()));
					idText.disable();
					nombreText.setText(usuario.getUser_nombre());
					emailText.setText(usuario.getUser_email());
					aceptarBoton.setText("Modificar");
					aceptarBoton.setActionCommand("ActualizarUsuario");
					vueltaMenuBoton.setActionCommand("VolverMenuUsuarios");
					view();							
			}			
		}else if(comando.equals("ActualizarUsuario")){	
			if(!idText.getText().equals("") && !nombreText.getText().equals("") && !emailText.getText().equals("")
					&& !contraseñaText.getText().equals("") && !tipoUsuarioText.getText().equals("") && !dniText.getText().equals("")) {
				Usuario usuario = new Usuario(Integer.parseInt(idText.getText()),nombreText.getText(),emailText.getText(),
						contraseñaText.getText(),Integer.parseInt(tipoUsuarioText.getText()),dniText.getText());
				controladorUsuario.actualizar(usuario);
			}
		}else if(comando.equals("BorrarUsuario")){	
			if(!table.getSelectionModel().isSelectionEmpty() && table.getSelectionModel().getSelectedItemsCount() == 1) {
				int selectedRow = table.getSelectionModel().getSelectedIndices()[0];
				Usuario usuario = new Usuario();		
					usuario.setId_usuario(Integer.parseInt(table.getValueAt(selectedRow, 0).toString()));
					usuario.setUser_nombre(table.getValueAt(selectedRow, 1).toString());
					usuario.setUser_email(table.getValueAt(selectedRow, 2).toString());
					controladorUsuario.borrar(usuario);
					frame.hide();
					listarUsuariosVista();
					view();		
			}
		}else if(comando.equals("VolverMenuUsuarios")){	
			frame.hide();
			listarUsuariosVista();
			view();
		}else if(comando.equals("CrearUsuario")){	
			Integer.parseInt(idText.getText());
			if(!idText.getText().equals("") && !nombreText.getText().equals("") && !emailText.getText().equals("")
					&& !contraseñaText.getText().equals("") && !tipoUsuarioText.getText().equals("") && !dniText.getText().equals("")) {
				Usuario usuario = new Usuario(Integer.parseInt(idText.getText()),nombreText.getText(),emailText.getText(),
						contraseñaText.getText(),Integer.parseInt(tipoUsuarioText.getText()),dniText.getText());
				controladorUsuario.crear(usuario);
				frame.hide();
				listarUsuariosVista();
				view();
			}
		}else if(comando.equals("VolverMenuPrincipal")){	
			frame.hide();
			VistaMenu.getInstance().crearVistaMenu();		
		}	
	}
}
