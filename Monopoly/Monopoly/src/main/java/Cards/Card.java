/**
 * 
 */
package Cards;

import java.util.List;
import java.util.Objects;

import Enums.Tokens;
import Models.Player;

/**
 * @author bak12
 *
 */
public class Card
{
	private Tokens cardOwner;
	private Tokens payTo;
	private String message;
	private int cardIndex;
	private boolean cardChosen;
	private int advanceSpaces;
	private int collectAmount;
	private List<Player> players;
	
	public Card(String message, int cardIndex)
	{
		this.message = message;
		this.cardIndex = cardIndex;
		this.cardChosen = false;
	}
	
	public Card(String message, int cardIndex, int spaces, int collect)
	{
		this.message = message;
		this.cardIndex = cardIndex;
		this.cardChosen = false;
		this.advanceSpaces = spaces;
		this.collectAmount = collect;
	}
	
	public Card(String message, int cardIndex, int spaces, int collect, Tokens player)
	{
		this.message = message;
		this.cardIndex = cardIndex;
		this.cardChosen = false;
		this.advanceSpaces = spaces;
		this.collectAmount = collect;
		this.payTo = player;
	}
	
	public Card(String message, int cardIndex, int spaces, int collect, List<Player>player)
	{
		this.message = message;
		this.cardIndex = cardIndex;
		this.cardChosen = false;
		this.advanceSpaces = spaces;
		this.collectAmount = collect;
		this.players = player;
	}
	
	public Card(List<Card> cards)
	{
		for(Card c: cards)
		{
			this.message = c.message;
			this.cardIndex = c.cardIndex;
			this.cardChosen = false;
			this.advanceSpaces = c.advanceSpaces;
			this.collectAmount = c.collectAmount;
			this.players = c.players;
		}
	}

	public void freePass(Tokens cardOwner, List<Player> player)
	{
		if(this.getMessage().contains("Free"))
		{
			for(Player p: players)
			{
				if(p.getToken().equals(cardOwner))
				{
					p.setCards(p.getCards()+1);
				}
			}
		}
	}

	/**
	 * @return the cardOwner
	 */
	public Tokens getCardOwner()
	{
		return cardOwner;
	}

	/**
	 * @param cardOwner the cardOwner to set
	 */
	public void setCardOwner(Tokens cardOwner)
	{
		this.cardOwner = cardOwner;
	}

	/**
	 * @return the payTo
	 */
	public Tokens getPayTo()
	{
		return payTo;
	}

	/**
	 * @param payTo the payTo to set
	 */
	public void setPayTo(Tokens payTo)
	{
		this.payTo = payTo;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @return the cardIndex
	 */
	public int getCardIndex()
	{
		return cardIndex;
	}

	/**
	 * @param cardIndex the cardIndex to set
	 */
	public void setCardIndex(int cardIndex)
	{
		this.cardIndex = cardIndex;
	}

	/**
	 * @return the cardChosen
	 */
	public boolean isCardChosen()
	{
		return cardChosen;
	}

	/**
	 * @param cardChosen the cardChosen to set
	 */
	public void setCardChosen(boolean cardChosen)
	{
		this.cardChosen = cardChosen;
	}

	/**
	 * @return the advanceSpaces
	 */
	public int getAdvanceSpaces()
	{
		return advanceSpaces;
	}

	/**
	 * @param advanceSpaces the advanceSpaces to set
	 */
	public void setAdvanceSpaces(int advanceSpaces)
	{
		this.advanceSpaces = advanceSpaces;
	}

	/**
	 * @return the payAmount
	 */
	public int getcollectAmount()
	{
		return collectAmount;
	}

	/**
	 * @param collectAmount the collectAmount to set
	 */
	public void setcollectAmount(int collectAmount)
	{
		this.collectAmount = collectAmount;
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers()
	{
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players)
	{
		this.players = players;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(advanceSpaces, cardChosen, cardIndex, cardOwner, message, collectAmount, payTo, players);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof Card)) return false;
		Card other = (Card) obj;
		return advanceSpaces == other.advanceSpaces && cardChosen == other.cardChosen && cardIndex == other.cardIndex
				&& cardOwner == other.cardOwner && Objects.equals(message, other.message)
				&& collectAmount == other.collectAmount && payTo == other.payTo && Objects.equals(players, other.players);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Card [");
		if (cardOwner != null)
		{
			builder.append("cardOwner=");
			builder.append(cardOwner);
			builder.append(", ");
		}
		if (payTo != null)
		{
			builder.append("payTo=");
			builder.append(payTo);
			builder.append(", ");
		}
		if (message != null)
		{
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		builder.append("cardIndex=");
		builder.append(cardIndex);
		builder.append(", cardChosen=");
		builder.append(cardChosen);
		builder.append(", advanceSpaces=");
		builder.append(advanceSpaces);
		builder.append(", payAmount=");
		builder.append(collectAmount);
		builder.append(", ");
		if (players != null)
		{
			builder.append("players=");
			builder.append(players);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
