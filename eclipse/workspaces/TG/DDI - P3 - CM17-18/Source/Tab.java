import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tab extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tab frame = new Tab();
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
	public Tab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 665, 339);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(60, 62, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 59, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(277, 58, 89, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("New label");
		label.setBounds(60, 106, 46, 14);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 103, 86, 20);
		panel.add(textField_1);
		
		JButton button = new JButton("New button");
		button.setBounds(277, 102, 89, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(60, 159, 46, 14);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 156, 86, 20);
		panel.add(textField_2);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(277, 155, 89, 23);
		panel.add(button_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(60, 207, 46, 14);
		panel.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(146, 204, 86, 20);
		panel.add(textField_3);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(277, 203, 89, 23);
		panel.add(button_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(60, 262, 46, 14);
		panel.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(146, 259, 86, 20);
		panel.add(textField_4);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(277, 258, 89, 23);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
