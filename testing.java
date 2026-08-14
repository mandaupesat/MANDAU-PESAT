package Matkul;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class Testing extends JFrame implements ActionListener {
	private static final Font mainFont = new Font("Arial", Font.PLAIN, 24);
	static JFrame Frame;
	static JTextField l, result;
	static JLabel title;
	String s0, s1, s2;
	

	Testing()
	{
		s0 = s1 = s2 = "";
	}

	public static void main(String args[])
	{
		
		// create a frame
		Frame = new JFrame("Calculator GUI");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		Testing c = new Testing();

		// create label
		title = new JLabel();
		title.setText("Calcutalor GUI");
		title.setFont(mainFont);

		result = new JTextField(16);
		result.setEditable(false);
		l = new JTextField(16);
		l.setEditable(false);
		l.setBorder(null);
		l.setOpaque(false);

		JPanel header = new JPanel();
		header.setLayout(new GridLayout(3,1,5,5));
		header.setPreferredSize(new Dimension(350, 100));
		header.setOpaque(false);
		header.add(title);
		header.add(result).setFont(mainFont);
		header.add(l).setFont(mainFont);

		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1, bmin;

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		beq1 = new JButton("=");

		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("CLEAR");
		bmin = new JButton("(-)");

		be = new JButton(".");

		// create a panel menu
		JPanel buttonMenu = new JPanel();
		buttonMenu.setLayout(new GridLayout(4,3,5,5));
		buttonMenu.setOpaque(false);
		buttonMenu.setPreferredSize(new Dimension(350, 200));
		buttonMenu.add(b7).setFont(mainFont);
		buttonMenu.add(b8).setFont(mainFont);
		buttonMenu.add(b9).setFont(mainFont);
		buttonMenu.add(bs).setFont(mainFont);
		buttonMenu.add(b4).setFont(mainFont);
		buttonMenu.add(b5).setFont(mainFont);
		buttonMenu.add(b6).setFont(mainFont);
		buttonMenu.add(bm).setFont(mainFont);
		buttonMenu.add(b1).setFont(mainFont);
		buttonMenu.add(b2).setFont(mainFont);
		buttonMenu.add(b3).setFont(mainFont);
		buttonMenu.add(ba).setFont(mainFont);
		buttonMenu.add(bmin).setFont(mainFont);
		buttonMenu.add(b0).setFont(mainFont);
		buttonMenu.add(be).setFont(mainFont);
		buttonMenu.add(bd).setFont(mainFont);
		
		JPanel buttonAction = new JPanel();
		buttonAction.setLayout(new GridLayout(1,2,5,5));
		buttonAction.setOpaque(false);
		buttonAction.setPreferredSize(new Dimension(350, 50));
		buttonAction.add(beq).setFont(mainFont);
		buttonAction.add(beq1).setFont(mainFont);
		
		Frame.add(header, BorderLayout.NORTH);
		Frame.add(buttonAction, BorderLayout.CENTER);
		Frame.add(buttonMenu, BorderLayout.SOUTH);

		Frame.setSize(400, 500);
		Frame.setFont(mainFont);
		Frame.pack();
		Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Frame.setVisible(true);

		// add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);
		bmin.addActionListener(c);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.' || s.equals("(-)")) {
				if (s.equals("(-)")) {
					if (s0.equals("") && s1.equals("")) {
						s0 =  "-"+s0;
					} else if (!s0.equals("") && s1.equals("") && s2.equals("")) {
						s1 = s;
					} else if (!s0.equals("") && !s1.equals("") && s2.equals("")) {
						s2 = "-"+s2;
					}
				} else {
					if (s1.equals("")) {
						s0 = s0 + s;
					} else {
						s2 = s2 + s;
					}
				}
			l.setText(s0 +" "+ s1 +" " + s2);
		}
		else if (s.charAt(0) == 'C') {
			s0 = s1 = s2 = "";

			l.setText(s0 + s1 + s2);
			result.setText("");
		}
		else if (s.charAt(0) == '=') {

			double te;
			if (s2.equals("0")) {
				result.setText("cannot devide by 0");
			} else {
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/")) 
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));

			l.setText(s0 + " "+ s1 + " " + s2 + " " + "=" + " " + te);
			result.setText(Double.toString(te));

			s0 = Double.toString(te);

			s1 = s2 = "";
			}
		}
		else {
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			else {
				double te;

				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				s0 = Double.toString(te);

				s1 = s;

				s2 = "";
			}

			l.setText(s0 + s1 + s2);
		}
	}
}
