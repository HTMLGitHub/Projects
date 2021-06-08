/**
 * 
 */
package Cards;

import java.util.ArrayList;
import java.util.List;

import Enums.Tokens;

/**
 * @author bak12
 *
 */
public class Community_Chest 
{
	public static List<Card> Cards()
	{
		List<Card> cards = new ArrayList<Card>();
		
			cards.add(new Card("Bank Error In Your Favor/nCollect $200", 0, 0, 200));
			cards.add(new Card("Income Tax Refund/nCollect $20", 1, 0, 20));
			cards.add(new Card("Pay Hospital $100", 2, 0, -100, Tokens.Bank));
			cards.add(new Card("Doctor's Fee Pay $50", 3, 0, -50, Tokens.Bank));
			cards.add(new Card("Advance To Go", 4, 40, 0));																	//TODO SPACES TO GO
			cards.add(new Card("From Sale Of Stock\nYou Get $45", 5, 0, 45));
			cards.add(new Card("Christmas Fund Matures\nCollect $100", 6, 0, 100));
			cards.add(new Card("Life Insurance Matures\nCollect $100", 7, 0, 100));
			
			cards.add(new Card("Grand Opera Opening\nCollect $50 From Every Player\nFor Opening Night Seats", 8, 0, 50));	//TODO
			
			cards.add(new Card("Go To Jail\nGo Directly To Jail\nDo Not Pass Go\nDo Not Collect $200", 9, 10, 0));			//TODO SPACES TO JAIL
			cards.add(new Card("You Are Assessed\nFor Street Repairs", 10, 0, 100)); 										//TODO COST = HOUSES * 40 + HOTEL * 115
			cards.add(new Card("Get Out Of Jail Free\nThis Card May Be Kept Until Needed Or Sold", 11));
			cards.add(new Card("You Inherit $100", 12, 0, 100));
			cards.add(new Card("You Have Won Second Prize\nIn A Beauty Contest\nCollect $10", 13, 0, 10));
			cards.add(new Card("Pay School Tax Of $150", 14, 0, -150, Tokens.Bank));
		
		return cards;
	}
}
