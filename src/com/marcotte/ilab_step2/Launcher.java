package com.marcotte.ilab_step2;

import java.awt.*;
import javax.swing.*;

public class Launcher
{

	public static void main(String[] args)
	{
		// launch the application
		ApplicationFrame app = new ApplicationFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setTitle("Messages");
		app.setPreferredSize(new Dimension(300,300));
		app.pack();
		app.setLocationRelativeTo(null);
		app.setVisible(true);

	}

}
