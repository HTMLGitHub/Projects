/**
 * 
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Enums.Tokens;

/**
 * @author bak12
 *
 */
public class Player 
{
	private Tokens token;
	
	private int cash;
	private int boardIndex;
	
	private List<Property> ownedProperties;
	private int cards;
	
	public Player(Tokens token)
	{
		this.token = token;
		this.token.setTaken(true);
		this.cash = 1500;
		this.boardIndex = 0;
		this.ownedProperties = new ArrayList<Property>();
		this.cards = 0;		
	}

	/**
	 * @return the token
	 */
	public Tokens getToken() {
		return token;
	}

	/**
	 * @return the cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}

	/**
	 * @return the boardIndex
	 */
	public int getBoardIndex() {
		return boardIndex;
	}

	/**
	 * @param boardIndex the boardIndex to set
	 */
	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}

	/**
	 * @return the ownedProperties
	 */
	public List<Property> getOwnedProperties() {
		return ownedProperties;
	}

	/**
	 * @param ownedProperties the ownedProperties to set
	 */
	public void setOwnedProperties(List<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
	}

	/**
	 * @return the cards
	 */
	public int getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(int cards) {
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardIndex, cards, cash, ownedProperties, token);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) return true;
		if (!(obj instanceof Player)) return false;
		
		Player other = (Player) obj;
		return boardIndex == other.boardIndex && cards == other.cards && cash == other.cash
				&& Objects.equals(ownedProperties, other.ownedProperties) && token == other.token;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Player [");
		if (token != null) 
		{
			builder.append("token=");
			builder.append(token);
			builder.append(", ");
		}
		builder.append("cash=");
		builder.append(cash);
		builder.append(", boardIndex=");
		builder.append(boardIndex);
		builder.append(", ");
		if (ownedProperties != null)
		{
			builder.append("ownedProperties=");
			builder.append(ownedProperties);
			builder.append(", ");
		}
		if(cards>0)
		{
			builder.append("cards=");
			builder.append(cards);
		}
		
		builder.append("]");
		return builder.toString();
	}
	
}
