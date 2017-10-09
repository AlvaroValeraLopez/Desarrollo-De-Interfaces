import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Listas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listas frame = new Listas();
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
	public Listas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"REPUBLICA CATALANA", "ESPA\u00D1A"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(1);
		list.setBounds(300, 11, 274, 289);
		contentPane.add(list);
		
		JButton btnLoadData = new JButton("LOAD DATA");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evento que introduce datos en el JList
				DefaultListModel dlm = new DefaultListModel();
				dlm.add(0, "Markus Cruck");
				dlm.add(1, "Alvarito Figura");
				dlm.add(2, "Manolo Bot");
				list.setModel(dlm);
				
			}
		});
		btnLoadData.setBounds(48, 128, 131, 23);
		contentPane.add(btnLoadData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(220, 245, 55, 38);
		contentPane.add(lblNewLabel);
		
		JSlider slider = new JSlider();
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				lblNewLabel.setText(String.valueOf(slider.getValue()));
				
			}
		});
		slider.setBounds(10, 251, 200, 26);
		contentPane.add(slider);
		
		JLabel lblTemperaturaHabitacin = new JLabel("Temperatura habitaci\u00F3n");
		lblTemperaturaHabitacin.setBounds(48, 176, 141, 14);
		contentPane.add(lblTemperaturaHabitacin);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(134, 201, 29, 23);
		contentPane.add(spinner);
		
		
		
		
	}
}
