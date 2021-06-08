/**
 * 
 */
package superAdventure;

import java.awt.event.*;
import javax.swing.*;

import engine.Player;

/**
 * @author bak12
 *
 */
public class GameFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3592564772596667260L;
	
	Player player = new Player(10, 10, 20, 0, 1);
	
	JFrame frame = new JFrame("Super Adventure");
	
	JLabel lbl1 = new JLabel("Hit Points:");	
	JLabel lbl2 = new JLabel("Gold:");
	JLabel lbl3 = new JLabel("Experience:");
	JLabel lbl4 = new JLabel("Level:");
	JLabel lbl5 = new JLabel("Select Action");
	JLabel lblHitPoints = new JLabel("");
	JLabel lblGold = new JLabel("");
	JLabel lblExperience = new JLabel("");
	JLabel lblLevel = new JLabel("");
	
	
	JButton btnNorth = new JButton("North");
	JButton btnSouth = new JButton("South");
	JButton btnEast = new JButton("East");
	JButton btnWest = new JButton("West");
	JButton btnUseWeapon = new JButton("Use");
	JButton btnUsePotion = new JButton("Use");

	GameFrame()
	{
		setComponents();
		
		
		
		frame.add(new GamePanel());
		frame.setTitle("Super Adventure");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private void setComponents()
	{
		lbl1.setSize(60,13);
		lbl1.setLocation(18,20);
						
		lbl2.setSize(32,13);
		lbl2.setLocation(18,46);
				
		lbl3.setSize(70,13);
		lbl3.setLocation(18,74);
		
		lbl4.setSize(36,13);
		lbl4.setLocation(18,100);
		
		lbl5.setSize(100,13);
		lbl5.setLocation(617,531);
		
		lblHitPoints.setLocation(110,19);
		lblGold.setLocation(110,45);
		lblExperience.setLocation(110,73);
		lblLevel.setLocation(110, 99);
		
		
		btnNorth.setSize(75,23);
		btnNorth.setLocation(493,433);
		btnNorth.setActionCommand("North");
		btnNorth.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				lblHitPoints.setText(String.valueOf(player.getCurrentHitPoints()));
				lblGold.setText(String.valueOf(player.getGold()));
				lblExperience.setText(String.valueOf(player.getExperiencePoints()));
				lblLevel.setText(String.valueOf(player.getLevel()));
			}
		});
		
		btnSouth.setSize(75,23);
		btnSouth.setLocation(493,487);
		
		btnEast.setSize(75,23);
		btnEast.setLocation(573,457);
		
		btnWest.setSize(75,23);
		btnWest.setLocation(412,457);
		
		btnUseWeapon.setSize(75,23);
		btnUseWeapon.setLocation(620,559);
		
		btnUsePotion.setSize(75,23);
		btnUsePotion.setLocation(620,593);		
		
		frame.add(lbl1);
		frame.add(lbl2);
		frame.add(lbl3);
		frame.add(lbl4);
		frame.add(lbl5);
		frame.add(lblHitPoints);
		frame.add(lblGold);
		frame.add(lblExperience);
		frame.add(lblLevel);
		
		frame.add(btnNorth);
		frame.add(btnSouth);
		frame.add(btnEast);
		frame.add(btnWest);
		frame.add(btnUseWeapon);
		frame.add(btnUsePotion);
	}
}
