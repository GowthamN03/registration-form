package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.Box;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtAge;
	private JTextField txtMobileNo;
	private JTextField txtEmail;
	private JTextField txtUserName;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		setBackground(SystemColor.activeCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gowtham\\Downloads\\download.png"));
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 513);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(12, 19, 0, 0);
		contentPane.add(verticalBox);
		
		JLabel lblNewLabel_6 = new JLabel("Name:");
		lblNewLabel_6.setBounds(17, 10, 67, 19);
		lblNewLabel_6.setFont(new Font("Ebrima", Font.BOLD, 14));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(17, 56, 67, 19);
		lblNewLabel_7.setFont(new Font("Ebrima", Font.BOLD, 14));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setBounds(17, 99, 67, 19);
		lblNewLabel_2.setFont(new Font("Ebrima", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setBounds(17, 144, 67, 19);
		lblNewLabel_4.setFont(new Font("Ebrima", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No:");
		lblNewLabel_5.setBounds(17, 187, 85, 19);
		lblNewLabel_5.setFont(new Font("Ebrima", Font.BOLD, 14));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(17, 232, 67, 19);
		lblNewLabel_3.setFont(new Font("Ebrima", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(17, 328, 85, 19);
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("User Name:");
		lblNewLabel_8.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_8.setBounds(17, 282, 85, 14);
		contentPane.add(lblNewLabel_8);
		
		txtName = new JTextField();
		txtName.setBounds(176, 11, 201, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtAddr = new JTextArea();
		txtAddr.setBounds(176, 56, 201, 32);
		contentPane.add(txtAddr);
		
		JRadioButton txtMale = new JRadioButton("Male");
		buttonGroup.add(txtMale);
		txtMale.setBounds(176, 99, 109, 23);
		contentPane.add(txtMale);
		
		JRadioButton txtFemale = new JRadioButton("Female");
		buttonGroup_1.add(txtFemale);
		txtFemale.setBounds(292, 99, 109, 23);
		contentPane.add(txtFemale);
		
		txtAge = new JTextField();
		txtAge.setBounds(176, 145, 109, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setColumns(10);
		txtMobileNo.setBounds(176, 188, 201, 20);
		contentPane.add(txtMobileNo);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(176, 233, 266, 20);
		contentPane.add(txtEmail);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(176, 281, 168, 20);
		contentPane.add(txtUserName);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(176, 329, 168, 20);
		contentPane.add(txtpass);
		
		JButton txtbtnValidate = new JButton("Validate");
		txtbtnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","073259@Gm");
				String query="insert into registration values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, txtName.getText());
				ps.setString(2, txtAddr.getText());
				if(txtMale.isSelected())
					ps.setString(3, txtMale.getText());
				else
					ps.setString(3, txtFemale.getText());
				ps.setInt(4, Integer.parseInt(txtAge.getText()));
				ps.setInt(5, Integer.parseInt(txtMobileNo.getText()));
				ps.setString(6, txtEmail.getText());
				ps.setString(7, txtUserName.getText());
				ps.setString(8, txtpass.getText());
				
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(txtbtnValidate, i+"Record added successfully!");
				ps.close();
				con.close();
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtbtnValidate.setBounds(127, 370, 109, 32);
		contentPane.add(txtbtnValidate);
		
		JButton txtbtnReset = new JButton("Reset");
		txtbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAddr.setText("");
				txtAge.setText("");
				txtMobileNo.setText("");
				txtEmail.setText("");
				txtUserName.setText("");
				txtpass.setText("");
				buttonGroup.clearSelection();
			}
		});
		txtbtnReset.setBounds(268, 370, 109, 32);
		contentPane.add(txtbtnReset);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_2, lblNewLabel_7, lblNewLabel_6, lblNewLabel_4, lblNewLabel_5, lblNewLabel_3, lblNewLabel, lblNewLabel_8, txtName, txtAddr, txtMale, txtFemale, txtAge, txtMobileNo, txtEmail, txtUserName, txtpass, txtbtnValidate, txtbtnReset}));
	}
}
