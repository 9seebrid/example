import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestMain extends JFrame{
	private JPanel mainPanel = new JPanel(new GridLayout(17, 0));
	private JLabel idlabel = new JLabel("??????? ??? ??? ?");
	private JTextField idText = new JTextField();
	private JLabel pwlabel = new JLabel("??????? ??? ???? ?");
	private JTextField pwText = new JTextField();
	private JLabel pwchecklabel = new JLabel("??????? ??? ???? ?? ?");
	private JTextField pwCheckText = new JTextField();
	private JLabel namelabel = new JLabel("??????? ??? ?? ?");
	private JTextField nameText = new JTextField();
	private JLabel birthYearlabel = new JLabel("??????? ??? ?? ?? ?");
	private JTextField birthYearText = new JTextField();
	private JLabel birthMonthlabel = new JLabel("??????? ??? ?? ? ?");
	private JTextField birthMonthText = new JTextField();
	private JLabel birthDaylabel = new JLabel("??????? ??? ?? ?? ?");
	private JTextField birthDayText = new JTextField();
	private JLabel phoneNumberlabel = new JLabel("??????? ??? ??? ?? ?");
	private JTextField phoneNumberText = new JTextField();
	private JButton signUpbtn = new JButton("????? ??? ?? ?? ?? ?? ?? ?? ??!");
	private TestMain owner = this;

	public TestMain() {
		super("???");

		this.mainPanel.add(idlabel);
		this.mainPanel.add(idText);
		this.mainPanel.add(pwlabel);
		this.mainPanel.add(pwText);
		this.mainPanel.add(pwchecklabel);
		this.mainPanel.add(pwCheckText);
		this.mainPanel.add(namelabel);
		this.mainPanel.add(nameText);
		this.mainPanel.add(birthYearlabel);
		this.mainPanel.add(birthYearText);
		this.mainPanel.add(birthMonthlabel);
		this.mainPanel.add(birthMonthText);
		this.mainPanel.add(birthDaylabel);
		this.mainPanel.add(birthDayText);
		this.mainPanel.add(phoneNumberlabel);
		this.mainPanel.add(phoneNumberText);
		this.mainPanel.add(signUpbtn);

		this.setContentPane(mainPanel);
		this.setSize(500,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//???? ??? ???? ???? ????? ? ??
		signUpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpDialog signup = new SignUpDialog(owner);

				signup.setVisible(true);

				//?? ??? ???? ??? ?? ?? ???? ???? ?? membershipProgress? ??
				if(signup.memberCheck()) {
					idText.setText(signup.getIdText());
					pwText.setText(signup.getPwText());
					pwCheckText.setText(signup.getPwCheckText());
					nameText.setText(signup.getNameText());
					birthYearText.setText(signup.getBirthYearText());
					birthMonthText.setText(signup.getBirthMonthContent());
					birthDayText.setText(signup.getBirthDayText());
					phoneNumberText.setText(signup.getPhoneNumberText());
				}
			}
		});


	}

	public static void main(String[] args) {
		new TestMain();
	}
}