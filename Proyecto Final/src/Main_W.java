import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Random;
import javax.swing.JTextArea;
import javax.swing.JTable;
public class Main_W extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id_textField;
    private JTextField psw_textField;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table;
    private JTextField iddeleteu_textField;
    private JTextField serial_textField;
    private JTextField package_textField;
    private JTextField weight_textField;
    private JTextField date_textField;
    private JTextField deletei_textField;
    private JTable table_1;
    private JTextField serialei_textField;
    private JTextField packageei_textField;
    private JTextField weightei_textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main_W frame = new Main_W();
                    frame.setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


    public Main_W() {
    	crearDB();   // crea almacen.db
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,686,413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
                

        JPanel admin_panel = new JPanel();
        admin_panel.setBounds(5, 5, 657, 253);
        contentPane.add(admin_panel);
        admin_panel.setVisible(false);
        admin_panel.setLayout(null);
        
        JPanel editi_panel = new JPanel();
        editi_panel.setBounds(181, 49, 361, 163);
        admin_panel.add(editi_panel);
        editi_panel.setLayout(null);
        editi_panel.setVisible(false);
        
        JLabel serialei_lbl = new JLabel("Serial:");
        serialei_lbl.setBounds(10, 10, 45, 13);
        editi_panel.add(serialei_lbl);
        
        serialei_textField = new JTextField();
        serialei_textField.setBounds(107, 7, 96, 18);
        editi_panel.add(serialei_textField);
        serialei_textField.setColumns(10);
        
        JButton searchei_btn = new JButton("Search");
        searchei_btn.setBounds(213, 6, 84, 20);
        editi_panel.add(searchei_btn);
        
        JLabel confirmacionei_lbl = new JLabel("");
        confirmacionei_lbl.setBounds(307, 10, 96, 12);
        editi_panel.add(confirmacionei_lbl);
        
        packageei_textField = new JTextField();
        packageei_textField.setBounds(107, 35, 96, 18);
        editi_panel.add(packageei_textField);
        packageei_textField.setColumns(10);
        packageei_textField.setVisible(false);
        
        JLabel packageei_lbl = new JLabel("Package: ");
        packageei_lbl.setBounds(11, 38, 84, 12);
        editi_panel.add(packageei_lbl);
        packageei_lbl.setVisible(false);
        
        JLabel weightei_lbl = new JLabel("Weight:");
        weightei_lbl.setBounds(10, 66, 85, 12);
        editi_panel.add(weightei_lbl);
        weightei_lbl.setVisible(false);
        
        weightei_textField = new JTextField();
        weightei_textField.setBounds(107, 63, 96, 18);
        editi_panel.add(weightei_textField);
        weightei_textField.setColumns(10);
        weightei_textField.setVisible(false);
        
        JComboBox itemei_comboBox = new JComboBox();
        itemei_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Transmision", "Volante", "Piston", "Marcha", "Boton"}));
        itemei_comboBox.setBounds(107, 91, 96, 20);
        editi_panel.add(itemei_comboBox);
        itemei_comboBox.setVisible(false);
        
        JLabel itemei_lbl = new JLabel("Item: ");
        itemei_lbl.setBounds(10, 95, 85, 12);
        editi_panel.add(itemei_lbl);
        itemei_lbl.setVisible(false);
        
        JButton editei_btn = new JButton("Edit");
        editei_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        if (serialei_textField.getText().trim().isEmpty()) {
        		        	confirmacionei_lbl.setText("Ingresa un serial.");
        		            return;
        		        }
        		        String checkSql = "SELECT COUNT(*) FROM items WHERE serial = ?";
        		        String updateSql = "UPDATE items SET item = ?, package = ?, weight = ? WHERE serial = ?";

        		        try (Connection con = ConexionDB.conectar();
        		             PreparedStatement check = con.prepareStatement(checkSql)) {

        		            // Verificar si existe el serial
        		            check.setString(1, serialei_textField.getText().trim());

        		            ResultSet rs = check.executeQuery();

        		            if (rs.next() && rs.getInt(1) == 0) {
        		            	confirmacionei_lbl.setText("Serial no encontrado.");
        		                return;
        		            }

        		            try (PreparedStatement update = con.prepareStatement(updateSql)) {

        		                update.setString(1, itemei_comboBox.getSelectedItem().toString());
        		                update.setString(2, packageei_textField.getText().trim());
        		                update.setString(3, weightei_textField.getText().trim());
        		                update.setString(4, serialei_textField.getText().trim());

        		                int filas = update.executeUpdate();

        		                if (filas > 0) {
        		                	confirmacionei_lbl.setText("Registro actualizado.");
        		                    System.out.println("Serial "
        		                            + serialei_textField.getText().trim()
        		                            + " actualizado.");
        		                } else {
        		                	confirmacionei_lbl.setText("No se pudo actualizar.");
        		                }
        		            }

        		        } catch (SQLException e1) {
        		            e1.printStackTrace();
        		            confirmacionei_lbl.setText("Error al actualizar.");
        		        }
        		    }
        		});
        editei_btn.setBounds(213, 120, 84, 20);
        editi_panel.add(editei_btn);
        editei_btn.setVisible(false);
        
        JPanel deletei_panel = new JPanel();
        deletei_panel.setBounds(181, 49, 332, 163);
        admin_panel.add(deletei_panel);
        deletei_panel.setLayout(null);
        deletei_panel.setVisible(false);
        
        JLabel deletei_lbl = new JLabel("Serial");
        deletei_lbl.setBounds(32, 9, 26, 13);
        deletei_panel.add(deletei_lbl);
        
        deletei_textField = new JTextField();
        deletei_textField.setBounds(63, 6, 96, 19);
        deletei_panel.add(deletei_textField);
        deletei_textField.setColumns(10);
        
        JButton deletei_btn = new JButton("Delete item");
        deletei_btn.setBounds(164, 5, 85, 21);
        deletei_panel.add(deletei_btn);
        
        JLabel confirmaciondi_lbl = new JLabel("");
        confirmaciondi_lbl.setBounds(73, 35, 86, 13);
        deletei_panel.add(confirmaciondi_lbl);
        deletei_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (deletei_textField.getText() == null || deletei_textField.getText().trim().isEmpty()) {
    	        	confirmaciondi_lbl.setText("Ingresa un numero serial.");
    	        	return;
    			}
    	        	String checkSql = "SELECT COUNT(*) FROM items WHERE serial = ?";
    	            String deleteSql = "DELETE FROM items WHERE serial = ?";

    	            try (Connection con = ConexionDB.conectar();
    	                 PreparedStatement check = con.prepareStatement(checkSql)) {

    	                check.setString(1, deletei_textField.getText() .trim());
    	                ResultSet rs = check.executeQuery();

    	                if (rs.getInt(1) == 0) {
    	                	confirmaciondi_lbl.setText("Serial no encontrado.");
    	                    return;
    	                }

    	                try (PreparedStatement delete = con.prepareStatement(deleteSql)) {
    	                    delete.setString(1, deletei_textField.getText() .trim());
    	                    delete.executeUpdate();
    	                    confirmaciondi_lbl.setText("Item eliminado.");
    	                    System.out.println("Item " + deletei_textField.getText()  + " eliminado.");
    	                }

    	            } catch (SQLException e1) {
    	                e1.printStackTrace();
    	                deletei_textField.setText("Error al eliminar.");
    	            }
        	}
        });
        
        JPanel searchi_panel = new JPanel();
        searchi_panel.setBounds(181, 49, 466, 163);
        admin_panel.add(searchi_panel);
        
        table_1 = new JTable();
        searchi_panel.add(table_1);
        
        JPanel search_panel = new JPanel();
        search_panel.setBounds(181, 49, 466, 163);
        admin_panel.add(search_panel);
        search_panel.setVisible(false);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 8));
        search_panel.add(table);
        
        JLabel title_lbl2 = new JLabel("ADMIN");
        title_lbl2.setBounds(38, 0, 426, 25);
        title_lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        title_lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        admin_panel.add(title_lbl2);
        
        JComboBox comboBox = new JComboBox();
        
        comboBox.setBounds(0, 144, 171, 25);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Delete user", "Add user", "Search user", "Add Item", "Delete Item", "Search Item", "Edit Item"}));
        comboBox.setToolTipText("");
        admin_panel.add(comboBox);
        comboBox.setVisible(false);
        
        JComboBox comboBox_3 = new JComboBox();
        
       
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Edit Item", "Delete Item", "Add Item", "Search Item"}));
        comboBox_3.setBounds(0, 179, 171, 20);
        admin_panel.add(comboBox_3);
        comboBox_3.setVisible(false);
                        
        JLabel id_lbl = new JLabel("ID: ");
        id_lbl.setBounds(0, 109, 180, 25);
        admin_panel.add(id_lbl);
        
        JLabel welcome_lbl = new JLabel("Welcome: ");
        welcome_lbl.setHorizontalAlignment(SwingConstants.LEFT);
        welcome_lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
        welcome_lbl.setVerticalAlignment(SwingConstants.TOP);
        welcome_lbl.setBounds(0, 49, 180, 31);
        admin_panel.add(welcome_lbl);
        
        JButton logout_btn = new JButton("Log Out");
        logout_btn.setBounds(274, 222, 142, 21);
        admin_panel.add(logout_btn);
        
        JPanel addu_panel = new JPanel();
        addu_panel.setBounds(181, 49, 235, 162);
        admin_panel.add(addu_panel);
        addu_panel.setVisible(false);
        addu_panel.setLayout(null);
        
        JLabel id_lblNewLabel_1 = new JLabel("ID: ");
        id_lblNewLabel_1.setBounds(0, 10, 45, 13);
        addu_panel.add(id_lblNewLabel_1);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(55, 7, 96, 18);
        addu_panel.add(textField);
        textField.setColumns(10);

        
        JLabel id_lblNewLabel_1_1 = new JLabel("Name: ");
        id_lblNewLabel_1_1.setBounds(0, 44, 45, 13);
        addu_panel.add(id_lblNewLabel_1_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(55, 41, 96, 18);
        addu_panel.add(textField_1);
        
        JLabel id_lblNewLabel_1_1_1 = new JLabel("Password: ");
        id_lblNewLabel_1_1_1.setBounds(0, 74, 51, 13);
        addu_panel.add(id_lblNewLabel_1_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(55, 71, 96, 18);
        addu_panel.add(textField_2);
        
        JLabel id_lblNewLabel_1_1_1_1 = new JLabel("Rol: ");
        id_lblNewLabel_1_1_1_1.setBounds(0, 106, 45, 13);
        addu_panel.add(id_lblNewLabel_1_1_1_1);
        
        JButton btnNewButton_1 = new JButton("Generate");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Random random = new Random();
                int numero = 100000 + random.nextInt(900000);
                textField.setText(String.valueOf(numero));
        	}
        });
        btnNewButton_1.setBounds(151, 6, 84, 20);
        addu_panel.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("Generate");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        	    Random random = new Random();

        	    StringBuilder codigo = new StringBuilder();

        	    for (int i = 0; i < 9; i++) {
        	        int indice = random.nextInt(caracteres.length());
        	        codigo.append(caracteres.charAt(indice));
        	    }

        	    textField_2.setText(codigo.toString());
        	}
        });
        btnNewButton_1_1.setBounds(151, 70, 84, 20);
        addu_panel.add(btnNewButton_1_1);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ADMIN", "WORKER"}));
        comboBox_2.setBounds(55, 102, 96, 20);
        addu_panel.add(comboBox_2);
        
        JButton btnNewButton_2 = new JButton("Add user");
        btnNewButton_2.setBounds(0, 132, 235, 20);
        addu_panel.add(btnNewButton_2);
        
        JPanel deleteu_panel = new JPanel();
        deleteu_panel.setBounds(181, 49, 235, 163);
        admin_panel.add(deleteu_panel);
        deleteu_panel.setVisible(false);
        
        iddeleteu_textField = new JTextField();
        deleteu_panel.add(iddeleteu_textField);
        iddeleteu_textField.setColumns(10);
        
        JButton deleteu_btn = new JButton("Delete");
        deleteu_panel.add(deleteu_btn);
        
        JLabel lbl_confirmacion = new JLabel("");
        deleteu_panel.add(lbl_confirmacion);
        
        JPanel addi_panel = new JPanel();
        addi_panel.setBounds(181, 49, 332, 163);
        admin_panel.add(addi_panel);
        addi_panel.setLayout(null);
        addi_panel.setVisible(false);
        
        JLabel serial_lbl = new JLabel("Num. Serial: ");
        serial_lbl.setBounds(31, 9, 77, 13);
        addi_panel.add(serial_lbl);
        
        serial_textField = new JTextField();
        serial_textField.setBounds(98, 6, 96, 19);
        addi_panel.add(serial_textField);
        serial_textField.setColumns(10);
        
        JButton generateSerial_btn = new JButton("Generate");
        generateSerial_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Random random = new Random();
                int numero = 100000 + random.nextInt(900000);
                serial_textField.setText(String.valueOf(numero));
        	}
        });
        generateSerial_btn.setBounds(204, 5, 85, 21);
        addi_panel.add(generateSerial_btn);
        
        JComboBox item_comboBox = new JComboBox();
        item_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Transmision", "Volante", "Piston", "Marcha", "Boton"}));
        item_comboBox.setBounds(81, 32, 169, 21);
        addi_panel.add(item_comboBox);
        
        JLabel lblNewLabel_2 = new JLabel("Date: ");
        lblNewLabel_2.setBounds(31, 63, 44, 12);
        addi_panel.add(lblNewLabel_2);
        
        package_textField = new JTextField();
        package_textField.setBounds(81, 85, 96, 18);
        addi_panel.add(package_textField);
        package_textField.setColumns(10);
        
        JLabel package_lbl = new JLabel("Package:");
        package_lbl.setBounds(31, 88, 44, 12);
        addi_panel.add(package_lbl);
        
        JLabel weight_lbl = new JLabel("Weight:");
        weight_lbl.setBounds(31, 115, 44, 12);
        addi_panel.add(weight_lbl);
        
        weight_textField = new JTextField();
        weight_textField.setBounds(81, 112, 96, 18);
        addi_panel.add(weight_textField);
        weight_textField.setColumns(10);
        
        JButton addi_btn = new JButton("Add item");
        addi_btn.setBounds(183, 133, 84, 20);
        addi_panel.add(addi_btn);
        
        JLabel item_lbl = new JLabel("Item");
        item_lbl.setBounds(31, 36, 44, 12);
        addi_panel.add(item_lbl);
        
        date_textField = new JTextField();
        date_textField.setBounds(81, 60, 96, 18);
        addi_panel.add(date_textField);
        date_textField.setColumns(10);
        addi_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    if (!serial_textField.getText().isEmpty() && !weight_textField.getText().isEmpty() && !package_textField.getText().isEmpty()) {
        	    	Connection con;
					try {
						con = ConexionDB.conectar();
						
					additem(serial_textField.getText(), item_comboBox.getSelectedItem().toString(),LocalDate.now().toString(),package_textField.getText(),weight_textField.getText());
        	        addi_panel.setVisible(false);
        	        textField.setText(null);
        	        textField_1.setText(null);
        	        textField_2.setText(null);
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	    }
        		else{
        			System.out.println("Los campos deben ser llenados correctamente");
        		}
        	}
        });
        deleteu_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			if (iddeleteu_textField.getText() == null || iddeleteu_textField.getText().trim().isEmpty()) {
        	        	lbl_confirmacion.setText("Ingresa un ID.");
        			}
        	        	String checkSql = "SELECT COUNT(*) FROM usuarios WHERE id = ?";
        	            String deleteSql = "DELETE FROM usuarios WHERE id = ?";

        	            try (Connection con = ConexionDB.conectar();
        	                 PreparedStatement check = con.prepareStatement(checkSql)) {

        	                check.setString(1, iddeleteu_textField.getText() .trim());
        	                ResultSet rs = check.executeQuery();

        	                if (rs.getInt(1) == 0) {
        	                	lbl_confirmacion.setText("ID no encontrado.");
        	                    return;
        	                }

        	                try (PreparedStatement delete = con.prepareStatement(deleteSql)) {
        	                    delete.setString(1, iddeleteu_textField.getText() .trim());
        	                    delete.executeUpdate();
        	                    lbl_confirmacion.setText("Usuario eliminado.");
        	                    System.out.println("Usuario " + iddeleteu_textField.getText()  + " eliminado.");
        	                }

        	            } catch (SQLException e1) {
        	                e1.printStackTrace();
        	                lbl_confirmacion.setText("Error al eliminar.");
        	            }
        	    }
        });
        
                
        JPanel worker_panel = new JPanel();
        worker_panel.setBounds(0, 0, 662, 252);
        contentPane.add(worker_panel);
        worker_panel.setVisible(false);
        worker_panel.setLayout(null);
        
        
        JLabel title_lbl2_1_1 = new JLabel("Worker");
        title_lbl2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        title_lbl2_1_1.setBounds(164, 10, 67, 37);
        worker_panel.add(title_lbl2_1_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Edit Item", "Delete Item", "Add Item", "Search Item"}));
        comboBox_1.setBounds(10, 138, 106, 21);
        comboBox_1.setToolTipText("");
        worker_panel.add(comboBox_1);
        
        JLabel id_lbl_1 = new JLabel("ID: ");
        id_lbl_1.setBounds(10, 99, 234, 24);
        worker_panel.add(id_lbl_1);
        
        JLabel welcome_lbl_1 = new JLabel("Welcome: ");
        welcome_lbl_1.setBounds(10, 60, 234, 24);
        worker_panel.add(welcome_lbl_1);
        
        JButton logout_btn_2 = new JButton("Log Out");
        logout_btn_2.setBounds(347, 231, 67, 21);
        worker_panel.add(logout_btn_2);
        
        
        //PANELES
        JPanel acces_panel = new JPanel();
        acces_panel.setBounds(5, 5, 426, 253);
        contentPane.add(acces_panel);
        acces_panel.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        acces_panel.add(panel, BorderLayout.NORTH);
        JPanel panel_1 = new JPanel();
        acces_panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);

        
        JLabel lblNewLabel = new JLabel("BIENVENIDO");
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        
        
        JLabel title_lbl = new JLabel("Expediente:");
        title_lbl.setBounds(119, 45, 94, 24);
        title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(title_lbl);
        
        id_textField = new JTextField();
        id_textField.setBounds(213, 45, 107, 24);
        panel_1.add(id_textField);
        id_textField.setColumns(10);
        
        JLabel title_lbl_1 = new JLabel("Contraseña:");
        title_lbl_1.setBounds(119, 69, 94, 24);
        title_lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(title_lbl_1);
        
        psw_textField = new JTextField();
        psw_textField.setBounds(213, 69, 107, 24);
        psw_textField.setColumns(10);
        panel_1.add(psw_textField);
        
        JButton btnNewButton = new JButton("Log in");
        btnNewButton.setBounds(213, 95, 105, 24);
        panel_1.add(btnNewButton);
        
    	
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {	
        		boolean f1 = false;
        		Sesion usuario = new Sesion();
        		f1 = usuario.inicioSesion(id_textField.getText(), psw_textField.getText());
                if (f1) {
            		switch (usuario.rolDB) {
                	case "ADMIN":{
                		acces_panel.setVisible(false);
                		admin_panel.setVisible(true);
                		welcome_lbl.setText("Welcome: " +usuario.nameDB);
                		id_lbl.setText("ID: " +usuario.idDB);
                		comboBox.setVisible(true);
                		title_lbl2.setText("ADMIN");
                		
                	} 
                	break;
                	case "WORKER":{
                		acces_panel.setVisible(false);
                		admin_panel.setVisible(true);
                		welcome_lbl.setText("Welcome: " +usuario.nameDB);
                		id_lbl.setText("ID: " +usuario.idDB);
                		comboBox_3.setVisible(true);
                		title_lbl2.setText("WORKER");
                	} 
                	break;
                }
                }
        	}
        });
        logout_btn_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	acces_panel.setVisible(true);
        		admin_panel.setVisible(false);
        		worker_panel.setVisible(false);
        		id_textField.setText(null);
        		psw_textField.setText(null);
        	}
        });
        logout_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	acces_panel.setVisible(true);
        		admin_panel.setVisible(false);
        		worker_panel.setVisible(false);
        		id_textField.setText(null);
        		psw_textField.setText(null);
        		addu_panel.setVisible(false);
        		search_panel.setVisible(false);
        		deleteu_panel.setVisible(false);
        		addi_panel.setVisible(false);
                deletei_panel.setVisible(false);
                searchi_panel.setVisible(false);
                editi_panel.setVisible(false);
            	packageei_lbl.setVisible(false);
            	packageei_textField.setVisible(false);
            	weightei_lbl.setVisible(false);
            	weightei_textField.setVisible(false);
            	itemei_comboBox.setVisible(false);
            	itemei_lbl.setVisible(false);
            	editei_btn.setVisible(false);
        	}
        });
        comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Delete user
        		//Add user
        		//Search user
        		//Add Item
        		//Delete Item
        		//Search Item
        		//Edit Item
        		addu_panel.setVisible(false);
        		search_panel.setVisible(false);
        		deleteu_panel.setVisible(false);
        		addi_panel.setVisible(false);
                deletei_panel.setVisible(false);
                searchi_panel.setVisible(false);
                editi_panel.setVisible(false);
            	packageei_lbl.setVisible(false);
            	packageei_textField.setVisible(false);
            	weightei_lbl.setVisible(false);
            	weightei_textField.setVisible(false);
            	itemei_comboBox.setVisible(false);
            	itemei_lbl.setVisible(false);
            	editei_btn.setVisible(false);
                
        		switch (comboBox.getSelectedIndex()) {
            	case 0 :{
            		deleteu_panel.setVisible(true);
            	} 
            	break;
            	case 1 :{
            		addu_panel.setVisible(true);
            	} 
            	break;
            	case 2 :{
            		search_panel.setVisible(true);
            		cargarUsuarios();
            	} 
            	break;
            	case 3 :{
            		date_textField.setText(LocalDate.now().toString());
            		addi_panel.setVisible(true);
            	} 
            	break;
            	case 4 :{
            		confirmaciondi_lbl.setText("");
            		deletei_textField.setText("");
                    deletei_panel.setVisible(true);
            	} 
            	break;
            	case 5 :{
            		searchi_panel.setVisible(true);
            		cargarItems();
            	} 
            	break;
            	case 6 :{
                	editi_panel.setVisible(true);
            	} 
            	break;
            } 
        	}
        });
        comboBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Delete user
        		//Add user
        		//Search user
        		//Add Item
        		//Delete Item
        		//Search Item
        		//Edit Item
        		addu_panel.setVisible(false);
        		search_panel.setVisible(false);
        		deleteu_panel.setVisible(false);
        		addi_panel.setVisible(false);
                deletei_panel.setVisible(false);
                searchi_panel.setVisible(false);
                editi_panel.setVisible(false);
            	packageei_lbl.setVisible(false);
            	packageei_textField.setVisible(false);
            	weightei_lbl.setVisible(false);
            	weightei_textField.setVisible(false);
            	itemei_comboBox.setVisible(false);
            	itemei_lbl.setVisible(false);
            	editei_btn.setVisible(false);
                
        		switch (comboBox_1.getSelectedIndex()) {
            	case 0 :{
            		editi_panel.setVisible(true);
            	} 
            	break;
            	case 1 :{
            		confirmaciondi_lbl.setText("");
            		deletei_textField.setText("");
                    deletei_panel.setVisible(true);
            	} 
            	break;
            	case 2 :{
            		date_textField.setText(LocalDate.now().toString());
            		addi_panel.setVisible(true);
            	} 
            	break;
            	case 3 :{
            		searchi_panel.setVisible(true);
            		cargarItems();
            	} 
            	break;
            } 
        	}
        });
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String r= null;
        	    if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && textField_2.getText().length() > 8) {
        	    	Connection con;
					try {
						con = ConexionDB.conectar();
						switch (comboBox_2.getSelectedIndex()) {
	                		case 0 :{
	                			r = Rol.ADMIN.name();                	        
	                            PreparedStatement insertar = con.prepareStatement("""
	                                    INSERT INTO usuarios
	                                    (id, name, psw, rol)
	                                    VALUES(?,?,?,?)
	                                    """);
	
	                            insertar.setString(1,textField.getText());
	                            insertar.setString(2,textField_1.getText());
	                            insertar.setString(3,textField_2.getText());
	                            insertar.setString(4,r);
	                		} 
	                		break;
		                	case 1 :{
	                			r = Rol.WORKER.name();
	                            PreparedStatement insertar = con.prepareStatement("""
	                                    INSERT INTO usuarios
	                                    (id, name, psw, rol)
	                                    VALUES(?,?,?,?)
	                                    """);
	
	                            insertar.setString(1,textField.getText());
	                            insertar.setString(2,textField_1.getText());
	                            insertar.setString(3,textField_2.getText());
	                            insertar.setString(4,r);
		                	} 
		                	break;
						} 
            		adduser(textField.getText(),textField_1.getText(),textField_2.getText(),r);
        	        addu_panel.setVisible(false);
        	        textField.setText(null);
        	        textField_1.setText(null);
        	        textField_2.setText(null);
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	    }
        		else{
        			System.out.println("Los campos deben ser llenados correctamente");
        		}
        	}
        });
        searchei_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (serialei_textField.getText() == null || serialei_textField.getText().trim().isEmpty()) {
    	        	confirmacionei_lbl.setText("Ingresa un serial.");
    			}
    	        	String checkSql = "SELECT COUNT(*) FROM items WHERE serial = ?";
    	            try (Connection con = ConexionDB.conectar();
    	                 PreparedStatement check = con.prepareStatement(checkSql)) {

    	                check.setString(1, serialei_textField.getText() .trim());
    	                ResultSet rs = check.executeQuery();
    	                if (rs.getInt(1) == 0) {
    	                	confirmacionei_lbl.setText("Serial no encontrado.");
    	                    return;
    	                }
    	                else {
    	                	packageei_lbl.setVisible(true);
    	                	packageei_textField.setVisible(true);
    	                	weightei_lbl.setVisible(true);
    	                	weightei_textField.setVisible(true);
    	                	itemei_comboBox.setVisible(true);
    	                	itemei_lbl.setVisible(true);
    	                	editei_btn.setVisible(true);
    	                }
    	            } catch (SQLException e1) {
    	                e1.printStackTrace();
    	                confirmacionei_lbl.setText("Error al buscar.");
    	            }
    	    }
        });
        comboBox_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Delete user
        		//Add user
        		//Search user
        		//Add Item
        		//Delete Item
        		//Search Item
        		//Edit Item
        		addu_panel.setVisible(false);
        		search_panel.setVisible(false);
        		deleteu_panel.setVisible(false);
        		addi_panel.setVisible(false);
                deletei_panel.setVisible(false);
                searchi_panel.setVisible(false);
                editi_panel.setVisible(false);
            	packageei_lbl.setVisible(false);
            	packageei_textField.setVisible(false);
            	weightei_lbl.setVisible(false);
            	weightei_textField.setVisible(false);
            	itemei_comboBox.setVisible(false);
            	itemei_lbl.setVisible(false);
            	editei_btn.setVisible(false);
                
        		switch (comboBox_3.getSelectedIndex()) {
            	case 0 :{
            		editi_panel.setVisible(true);
            	} 
            	break;
            	case 1 :{
            		confirmaciondi_lbl.setText("");
            		deletei_textField.setText("");
                    deletei_panel.setVisible(true);
            	} 
            	break;
            	case 2 :{
            		date_textField.setText(LocalDate.now().toString());
            		addi_panel.setVisible(true);
            	} 
            	break;
            	case 3 :{
            		searchi_panel.setVisible(true);
            		cargarItems();
            	} 
            	break;
            } 	
        		
        	}
        });
       
    }
    
    
    public void crearDB() {

        try(Connection con = ConexionDB.conectar()){
            Statement st = con.createStatement();
            // Crear tabla usuarios
            st.execute("""
                CREATE TABLE IF NOT EXISTS usuarios(
                    num INTEGER PRIMARY KEY AUTOINCREMENT,
            		id TEXT UNIQUE,
                    name Text,
                    psw TEXT,
                    rol TEXT
                )
            """);
            System.out.println("DB done");
            // Revisar si existe admin
            PreparedStatement check =
                    con.prepareStatement(
                    "SELECT COUNT(*) FROM usuarios WHERE rol='ADMIN'");

            ResultSet rs = check.executeQuery();

            int cantidad = rs.getInt(1);

            if(cantidad == 0){            	
                PreparedStatement insertar = con.prepareStatement("""
                        INSERT INTO usuarios
                        (id, name, psw, rol)
                        VALUES(?,?,?,?)
                        """);

                insertar.setString(1,"000000");
                insertar.setString(2,"Christofer Lopez");
                insertar.setString(3,"L0cosleonla-");
                insertar.setString(4,Rol.ADMIN.name());

                insertar.executeUpdate();

                System.out.println("Admin ready");
            }
            else {
                System.out.println("Admin already done");
            }
            
         // Crear tabla items
            st.execute("""
                CREATE TABLE IF NOT EXISTS items(
                    num INTEGER PRIMARY KEY AUTOINCREMENT,
                    serial TEXT UNIQUE,
                    item TEXT,
                    date TEXT,
                    package  TEXT,
                    weight  TEXT
                )
            """);
            System.out.println("DB items done");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void adduser(String i,String n,String p,String r) {
    	try(Connection con = ConexionDB.conectar()){
    		 PreparedStatement insertar = con.prepareStatement("""
                     INSERT INTO usuarios
                     (id, name, psw, rol)
                     VALUES(?,?,?,?)
                     """);

             insertar.setString(1,i);
             insertar.setString(2,n);
             insertar.setString(3,p);
             insertar.setString(4,r);

             insertar.executeUpdate();

             System.out.println("Admin ready");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void additem(String serial,String item,String date,String packagee, String weight) {
    	try(Connection con = ConexionDB.conectar()){
    		 PreparedStatement insertar = con.prepareStatement("""
                     INSERT INTO items
                     (serial, item, date, package, weight)
                     VALUES(?,?,?,?,?)
                     """);

             insertar.setString(1,serial);
             insertar.setString(2,item);
             insertar.setString(3,date);
             insertar.setString(4,packagee);
             insertar.setString(5,weight);
             
             insertar.executeUpdate();

             System.out.println("Item addded");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void cargarUsuarios() {

        String[] columnas = {"ID", "Expediente", "Contraseña", "Rol"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(columnas, 0);

        String sql = "SELECT * FROM usuarios";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[] {
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("psw"),
                    rs.getString("rol")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setModel(modelo);
    }
    public void cargarItems() {

        String[] columnas = {"Serial", "Item", "Date", "Package", "Weight"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(columnas, 0);

        String sql = "SELECT * FROM items";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[] {
                    rs.getString("serial"),
                    rs.getString("item"),
                    rs.getString("date"),
                    rs.getString("package"),
                    rs.getString("weight")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table_1.setModel(modelo);
    }
}

