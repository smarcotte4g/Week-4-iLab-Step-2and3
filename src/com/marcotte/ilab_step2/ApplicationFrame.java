package com.marcotte.ilab_step2;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ApplicationFrame extends JFrame implements ActionListener
{
	// class level references
	JTabbedPane jtpTabbedPane;
	JPanel pnlPart2;
	JPanel pnlPart3;
	JButton cmdGood;
	JButton cmdBad;
	JTextField txfLength;
	JTextField txfWidth;
	JTextField txfResult;
	
	// constructor
	public ApplicationFrame()
	{
		this.setLayout(new BorderLayout());
		
		// create JTabbedPane and two panels(one for Part 2 and one for Part 3)
		jtpTabbedPane = new JTabbedPane();
		pnlPart2 = new JPanel(new FlowLayout());
		pnlPart3 = new JPanel(new GridLayout());
		
		// create good button
		cmdGood = new JButton("Good");
		cmdGood.setMnemonic('G');
		cmdGood.addActionListener(this);
		
		// create bad button
		cmdBad = new JButton("Bad");
		cmdBad.setMnemonic('G');
		cmdBad.addActionListener(this);
		
		// add buttons to the panel
		pnlPart2.add(cmdGood);
		pnlPart2.add(cmdBad);
		
		// set the layout manager
		pnlPart3.setLayout(new GridLayout(4,1));

		// create the first panel for length
		JPanel pnlFirst = new JPanel(new GridLayout(1,2));
		JLabel lblLength = new JLabel("Length: ");
		lblLength.setHorizontalAlignment(JLabel.CENTER);
		txfLength = new JTextField(10);
		txfLength.setHorizontalAlignment(JTextField.CENTER);
		pnlFirst.add(lblLength);
		pnlFirst.add(txfLength);
		pnlPart3.add(pnlFirst);

		// create the second panel for width
		JPanel pnlSecond = new JPanel(new GridLayout(1,2));
		JLabel lblWidth = new JLabel("Width: ");
		lblWidth.setHorizontalAlignment(JLabel.CENTER);
		txfWidth = new JTextField(10);
		txfWidth.setHorizontalAlignment(JTextField.CENTER);
		pnlSecond.add(lblWidth);
		pnlSecond.add(txfWidth);
		pnlPart3.add(pnlSecond);
		
		// create the third panel with the buttons
		JPanel pnlthird = new JPanel(new GridLayout(1,2));
		JButton btnCalculate = new JButton("Calculate");
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}});
		
		btnCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) 
			{
				// get the input
				float length = Float.parseFloat(txfLength.getText());
				float width = Float.parseFloat(txfWidth.getText());
				
				// calculate area
				float area = length * width;
				
				// show output
				DecimalFormat fmt = new DecimalFormat("#,##0.00");
				txfResult.setText(fmt.format(area));
				
			}});
		pnlthird.add(btnCalculate);
		pnlthird.add(btnExit);
		pnlPart3.add(pnlthird);
		
		// create the fourth panel for result
		JPanel pnlfourth = new JPanel(new GridLayout(1,2));
		JLabel lblResult = new JLabel("Result: ");
		lblResult.setHorizontalAlignment(JLabel.CENTER);
		txfResult = new JTextField(10);
		txfResult.setHorizontalAlignment(JTextField.CENTER);
		pnlfourth.add(lblResult);
		pnlfourth.add(txfResult);
		pnlPart3.add(pnlfourth);
		
		// add panels to the JTabbedPane
		jtpTabbedPane.add("DayGUI", pnlPart2);
		jtpTabbedPane.add("OfficeAreaCalculator", pnlPart3);
		
		// add JTabbed to the frame! This is called Layering.
		this.add(jtpTabbedPane);
	}
	
	// behaviors
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		// run code based on the button display
		if(ev.getSource() == cmdGood)
		{
			JOptionPane.showMessageDialog(this, "Today is a good day!");
		}
		else if(ev.getSource() == cmdBad)
		{
			JOptionPane.showMessageDialog(this, "I'm having a bad day today!");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Error. Invaild command button.");
		}

	}

}
