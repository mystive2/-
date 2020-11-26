import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;


public class CUS {

	private JFrame frame;
	int k=0;
	ImageIcon icon[]=new ImageIcon[300];
	private JTextField textField;
	private JTextField textField_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CUS window = new CUS();
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
	public CUS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		customer customer = new customer();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 960);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		icon[0]=new ImageIcon(this.getClass().getResource("/develop.jpg"));
		icon[1]=new ImageIcon(this.getClass().getResource("/bear.jpg"));
		icon[2]=new ImageIcon(this.getClass().getResource("/menu1.jpg"));
		icon[3]=new ImageIcon(this.getClass().getResource("/menu2.jpg"));
		icon[4]=new ImageIcon(this.getClass().getResource("/menu3.jpg"));
		icon[5]=new ImageIcon(this.getClass().getResource("/menu4.jpg"));
		icon[6]=new ImageIcon(this.getClass().getResource("/menu5.jpg"));
		
		icon[101]=new ImageIcon(this.getClass().getResource("/huhu.gif"));
		icon[102]=new ImageIcon(this.getClass().getResource("/pic3.gif"));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(517, 0, 747, 495);
		String[][] data=customer.getCustomers();
		String[] headers = new String[] {"이름","개월수","성별"};
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 494, 1268, 426);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 32));
		textArea.setText("                    \uC774\uBBF8\uC9C0 \uC124\uBA85\uCE78");
		textArea.setBounds(0, 0, 1268, 240);
		panel_4.add(textArea);
		panel_4.setVisible(false);
		
		JTable table = new JTable(data,headers);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_2.setLayout(null);
		table.setRowHeight(30);
		table.setFont(new Font ("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 56, 763, 633);
		panel_2.add(scrollPane);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(517, 0, 747, 495);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("d");
		lblNewLabel_5.setBounds(158, 47, 509, 372);
		
		panel_3.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(icon[102]);
		
		
		
		JButton btnNewButton_7 = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton_7.setBounds(12, 10, 97, 23);
		panel_2.add(btnNewButton_7);
		panel_3.setVisible(false);
		panel_2.setVisible(false); 
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(517, 0, 747, 495);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0AC\uC9C4");
		lblNewLabel_2.setBounds(35, 25, 321, 250);
		lblNewLabel_2.setIcon(icon[101]);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(489, 58, 140, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(489, 116, 140, 29);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		panel_1.setVisible(false);
		
		JComboBox comboBox = new JComboBox(new String[] {"남자","여자"});
		comboBox.setBounds(489, 172, 140, 29);
		panel_1.add(comboBox);
		
		JButton btnNewButton_5 = new JButton("\uC800\uC7A5\uD558\uAE30");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nametxt=textField.getText();
				String birthtxt=textField_1.getText();
				String gendertxt=comboBox.getSelectedItem().toString();
				System.out.println(textField.getText());
				System.out.println(textField_1.getText());
				System.out.println(gendertxt);
				//customer.createCustomer(textField, textField_1, gender);
				customer.createCustomer(nametxt, birthtxt, gendertxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved succesfully");
				panel_1.setVisible(false);
				
			}
		});
		btnNewButton_5.setBounds(562, 403, 140, 36);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984 :");
		lblNewLabel_3.setFont(new Font("휴먼모음T", Font.BOLD, 25));
		lblNewLabel_3.setBounds(408, 51, 67, 36);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C :");
		lblNewLabel_4.setFont(new Font("휴먼모음T", Font.BOLD, 25));
		lblNewLabel_4.setBounds(368, 113, 119, 29);
		panel_1.add(lblNewLabel_4);
		
		JLabel label = new JLabel("\uC131\uBCC4 :");
		label.setFont(new Font("휴먼모음T", Font.BOLD, 25));
		label.setBounds(408, 165, 67, 36);
		panel_1.add(label);
		
		
		
		
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 960);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 518, 100);
		btnNewButton.setIcon(icon[2]);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] data=customer.getCustomers();
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		
		
		
		JButton btnNewButton_6 = new JButton("\uD560\uC218\uC5C6\uC74C");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				k-=1;
			}
		});
		btnNewButton_6.setBounds(218, 269, 249, 91);
		panel_4.add(btnNewButton_6);
		
		JButton button = new JButton("\uD560\uC218\uC788\uC74C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				k+=1;
			}
		});
		button.setBounds(667, 269, 249, 91);
		panel_4.add(button);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 99, 518, 100);
		btnNewButton_1.setIcon(icon[3]);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(icon[4]);
		btnNewButton_2.setBounds(0, 198, 518, 100);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//k= DB로부터 birth값 넘겨 받고 오늘날짜에서 birth값 빼고 30으로 나누기..
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_4.setVisible(true);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(icon[5]);
		btnNewButton_3.setBounds(0, 297, 518, 100);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setIcon(icon[6]);
		btnNewButton_4.setBounds(0, 397, 518, 100);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 494, 1268, 426);
		lblNewLabel.setIcon(icon[0]);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(519, 0, 749, 497);
		lblNewLabel_1.setIcon(icon[1]);
		panel.add(lblNewLabel_1);
		
		
		
		
		
		
	}
	
}
