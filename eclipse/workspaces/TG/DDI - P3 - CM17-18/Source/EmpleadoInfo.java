import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class EmpleadoInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadoInfo frame = new EmpleadoInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void refreshTable() {
		try {
			//MOSTRAR DATOS DE EMPLEADOS
			String query = "SELECT EID, Nombre, Apellidos, Salario FROM EmpleadoInfo";
			
			PreparedStatement pst = conn.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			rs.close();
			pst.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void fillComboBox() {
		try {
			
			String query = "SELECT * FROM EmpleadoInfo";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBox.addItem(rs.getString("Nombre"));
			}
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadList() {
		try {
			//MOSTRAR DATOS DE EMPLEADOS
			String query = "SELECT EID, Nombre, Apellidos, Salario FROM EmpleadoInfo";
			
			PreparedStatement pst = conn.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			DefaultListModel dlm = new DefaultListModel();
			
			while(rs.next()) {
				dlm.addElement(rs.getString("Nombre"));
			}
			listNombre.setModel(dlm);
			
			rs.close();
			pst.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clock() {
		
		Thread clock = new Thread() {
			public void run () {
				
				try {
					
					
					while(true) {
						Calendar cal = new GregorianCalendar();
						
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						lblReloj.setText("Hora: "+hour+":"+minute+":"+second+" - Fecha: "+day+"/"+(month+1)+"/"+year);
						
						sleep(1000);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		clock.start();
		
		
	}
	
	Connection conn=null;
	private JTextField EIDtextField;
	private JTextField NombreTextField;
	private JTextField ApellidosTextField;
	private JTextField SalarioTextField;
	private JComboBox comboBox;
	private JList listNombre;
	private JTextField textFieldSearch;
	private JComboBox comboBoxSelection;
	private JLabel lblReloj;
	
	
	
	public EmpleadoInfo() {
		setResizable(false);
		conn = sqliteConnection.dbConnector();
		setTitle("Gesti\u00F3n de empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 440);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnNew.setIcon(new ImageIcon(EmpleadoInfo.class.getResource("/img/tick_circle.png")));
		mnFile.add(mnNew);
		
		JMenuItem mntmJavaProyect = new JMenuItem("Java Proyect");
		mnNew.add(mntmJavaProyect);
		
		JMenuItem mntmOpen = new JMenuItem("Open File...");
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenuItem mntmCloseAll = new JMenuItem("Close All");
		mnFile.add(mntmCloseAll);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.setIcon(new ImageIcon(EmpleadoInfo.class.getResource("/img/bomb.png")));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnSource = new JMenu("Source");
		menuBar.add(mnSource);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 145, 277, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String EID = (table.getModel().getValueAt(row, 0)).toString();
					String query="select * from EmpleadoInfo where EID='"+EID+"'";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()){
						EIDtextField.setText(rs.getString("EID"));
						NombreTextField.setText(rs.getString("Nombre"));
						ApellidosTextField.setText(rs.getString("Apellidos"));
						SalarioTextField.setText(rs.getString("Salario"));
			
					}
					
					rs.close();
					pst.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
	
		
		JButton btnCargarDatos = new JButton("CARGAR DATOS");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTable();
				
				
			}
		});
		btnCargarDatos.setBounds(490, 111, 144, 23);
		contentPane.add(btnCargarDatos);
		
		JLabel lblEid = new JLabel("EID:");
		lblEid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEid.setBounds(39, 58, 46, 14);
		contentPane.add(lblEid);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(27, 93, 58, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(10, 130, 75, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblSalario = new JLabel("SALARIO:");
		lblSalario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalario.setBounds(27, 167, 58, 14);
		contentPane.add(lblSalario);
		
		EIDtextField = new JTextField();
		EIDtextField.setBounds(104, 55, 166, 20);
		contentPane.add(EIDtextField);
		EIDtextField.setColumns(10);
		
		NombreTextField = new JTextField();
		NombreTextField.setColumns(10);
		NombreTextField.setBounds(104, 90, 166, 20);
		contentPane.add(NombreTextField);
		
		ApellidosTextField = new JTextField();
		ApellidosTextField.setText("");
		ApellidosTextField.setBounds(104, 127, 166, 20);
		contentPane.add(ApellidosTextField);
		ApellidosTextField.setColumns(10);
		
		SalarioTextField = new JTextField();
		SalarioTextField.setText("");
		SalarioTextField.setColumns(10);
		SalarioTextField.setBounds(104, 164, 166, 20);
		contentPane.add(SalarioTextField);
		
		JButton InsertarBtn = new JButton("INSERTAR");
		InsertarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//EVENTO DE INSERTAR INFORMACI�N EN BASE DE DATOS
				try {
					String query = "INSERT INTO EmpleadoInfo (EID, Nombre, Apellidos, Salario) VALUES (?,?,?,?)";
					
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, EIDtextField.getText());
					pst.setString(2, NombreTextField.getText());
					pst.setString(3, ApellidosTextField.getText());
					pst.setString(4, SalarioTextField.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Empleado insertado perfectamente.");
					pst.close();
					refreshTable();
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		InsertarBtn.setBounds(27, 210, 110, 23);
		contentPane.add(InsertarBtn);
		
		JButton ModificarBtn = new JButton("MODIFICAR");
		ModificarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query ="UPDATE EmpleadoInfo SET "
							+ "Nombre='"+NombreTextField.getText()+"',"
							+ "Apellidos='"+ApellidosTextField.getText()+"',"
							+ "Salario='"+SalarioTextField.getText()+"' WHERE EID = '"+EIDtextField.getText()+"' ";
					
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
	
					refreshTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ModificarBtn.setBounds(27, 272, 110, 23);
		contentPane.add(ModificarBtn);
		
		JButton EliminarBtn = new JButton("ELIMINAR");
		EliminarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int action=JOptionPane.showConfirmDialog(null, "�Deseas eliminar el registro?", "CONFIRMACI�N DE BORRADO", JOptionPane.YES_NO_OPTION);
				
				try {
					
					if(action==0) {
						String query ="DELETE FROM EmpleadoInfo WHERE EID = '"+EIDtextField.getText()+"' ";
						
						PreparedStatement pst = conn.prepareStatement(query);
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
						
						pst.close();
					}
								
					refreshTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		EliminarBtn.setBounds(27, 341, 110, 23);
		contentPane.add(EliminarBtn);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from EmpleadoInfo where Nombre=?";
					PreparedStatement pst;
					pst = conn.prepareStatement(query);
					pst.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()){
						EIDtextField.setText(rs.getString("EID"));
						NombreTextField.setText(rs.getString("Nombre"));
						ApellidosTextField.setText(rs.getString("Apellidos"));
						SalarioTextField.setText(rs.getString("Salario"));
			
					}
					
					rs.close();
					pst.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		comboBox.setBounds(104, 22, 166, 23);
		contentPane.add(comboBox);
		
		listNombre = new JList();
		listNombre.setBounds(164, 213, 106, 156);
		contentPane.add(listNombre);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//EVENTO PARA EL BUSCADOR
				
				
				
				try {
					String selection=(String) comboBoxSelection.getSelectedItem();
					String query="SELECT EID, Nombre, Apellidos, Salario FROM EmpleadoInfo WHERE "+selection+"=?";
					
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, textFieldSearch.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textFieldSearch.setBounds(490, 23, 144, 23);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		comboBoxSelection = new JComboBox();
		comboBoxSelection.setModel(new DefaultComboBoxModel(new String[] {"EID", "Nombre", "Apellidos", "Salario"}));
		comboBoxSelection.setBounds(357, 22, 123, 23);
		contentPane.add(comboBoxSelection);
		
		lblReloj = new JLabel("New label");
		lblReloj.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReloj.setBounds(357, 345, 277, 34);
		contentPane.add(lblReloj);
		
		fillComboBox();
		loadList();
		clock();
	}
}
