/**
 * 
 */
package superAdventure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JPanel;

/**
 * @author bak12
 *
 */

public class GamePanel extends JPanel implements ActionListener
{

	private static final long serialVersionUID = -4848601770054290101L;
	
	private static final int SCREEN_WIDTH = 735;
	private static final int SCREEN_HEIGHT = 690;
	
	
		
	
	GamePanel()
	{
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(new Color(212,208,200));
		this.setFocusable(true);
				
		
		
		
	}
	
	public class MyKeyAdapter extends KeyAdapter
	{
		
	}


	public void actionPerformed(ActionEvent e)
	{
		
	
	}
}


