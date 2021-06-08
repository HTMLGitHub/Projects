/**
 * 
 */
package Cards;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Enums.Tokens;
import Models.Player;
import Models.Property;

/**
 * @author bak12
 *
 */
public class Chance
{
	static JFrame f;
	
	public static List<Card> Cards()
	{
		List<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card("Advance Token To Nearest Utility\nIf Unowned You May Buy It From Bank.\nIf Owned, Throw Dice And Pay Owner A Total Ten Times The Amount Thrown",0));
		cards.add(new Card("You Have Been Elected Chairman Of The Board\nPay Each Player $50", 1));
		cards.add(new Card("Advance To Illinois Ave.", 2));
		cards.add(new Card("Advance To Go", 3));
		cards.add(new Card("Take A Ride On The Reading\nIf You Pass Go Collect $200", 4));
		cards.add(new Card("Advance Token To Nearest Railroad\nAnd Pay Owner Twice The Rental\nTo Which Is Otherwise Entitled\nIf Railroad Is Unowned, You May Buy It From The Bank ", 5));
		cards.add(new Card("Go Directly To Jail\nDo Not Pass Go\nDo Not Collect $200", 6));
		cards.add(new Card("Make General Repairs On All Your Properties\nFor Each House Pay $25\nFor Each Hotel Pay $100", 7));
		cards.add(new Card("Take A Walk On The Board Walk\nAdvance Token To Board Walk", 8));
		cards.add(new Card("Get Out Of Jail Free\nThis Card May Be Kept Until Needed Or Sold", 9));
		cards.add(new Card("Go Back 3 Spaces", 10));
		cards.add(new Card("Advance To St. Charles Place\nIf You Pass Go, Collect $200", 11));
		cards.add(new Card("Advance Token To Nearest Railroad\nAnd Pay Owner Twice The Rental\nTo Which Is Otherwise Entitled\nIf Railroad Is Unowned, You May Buy It From The Bank ", 12));
		cards.add(new Card("Bank Pays You A Divident Of $50", 13));
		cards.add(new Card("Pay Poor Tax of $15", 14));
		cards.add(new Card("Your Building And Loan Matures\n Collect $150", 15));
		return cards;
	}
	
	public static void ChanceCard(Card card, Player me)
	{
		f = new JFrame();
		JOptionPane.showMessageDialog(f, card.getMessage());	
		
		switch(card.getCardIndex())
		{
		case 0: 
			ChanceCard(me, card.getAdvanceSpaces(), 10, 12, card.getPayTo());
			break;
		case 1:
			ChanceCard(me, card.getcollectAmount(), card.getPlayers());
			break;
		case 5: case 12:
			ChanceCard(me, card.getAdvanceSpaces(), 2, card.getPayTo());
			break;
		case 2: case 3: case 4: case 6: case 8: case 10: case 11: 
			ChanceCard(me, card.getAdvanceSpaces(), false);
			break;
		case 13: case 14: case 15:
			ChanceCard(me, card.getcollectAmount(), true);
			break;
		case 7:
			int cost = 0;
			for(Property p: me.getOwnedProperties())
			{
				cost += p.getHousesOwned()*25+p.getHotelsOwned()*100;
			}
			ChanceCard(me, -cost, true);
			break;
		case 9:
			me.setCards(me.getCards()+1);
			break;
		}
	}
	
	public static void ChanceCard(Player me, int advance, boolean pay)
	{
		if(pay)
		{
			me.setCash(me.getCash()-advance);
		}
		else
		{
			me.setBoardIndex(me.getBoardIndex()+advance);
		}
	}
	
	private static void ChanceCard(Player me, int payAmount, List<Player> enemies)
	{
		for(Player p: enemies)
		{
			if(p.getToken() != me.getToken())
			{
				if(p.getToken().showTaken())
				{
					p.setCash(p.getCash()+ payAmount);
					me.setCash(me.getCash()-payAmount);
				}
				
			}
		}
		
	}

	
	public static void ChanceCard(Player me, int advance, int multiplier, Tokens payTo)
	{
		
	}
	
	public static void ChanceCard(Player me, int advance, int multiplier, int diceRoll, Tokens payTo)
	{
		
	}

	
}