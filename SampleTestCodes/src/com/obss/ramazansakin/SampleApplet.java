package com.obss.ramazansakin;

import javax.swing.JApplet;
import java.awt.Graphics;

public class SampleApplet extends JApplet{

	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		super.paint(g);
		g.drawString("Merhaba BilgisayarKavramlari.com",10,10);
	}
}