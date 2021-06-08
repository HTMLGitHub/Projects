/**
 * 
 */
package Models;

import Enums.Color;
import Enums.Tokens;

/**
 * @author bak12
 *
 */
public class Property implements Comparable<Property>
{
	private int index;
	private String name;
	private String description;
	
	private int buyingCost;
	private int rentOwed;
	private int costPerBuilding;
	private int housesOwned;
	private int hotelsOwned;
	private int mortgageValue;
		
	private boolean monopoly;
	
	private Color color;
	private Tokens ownedBy;
	
	public Property(Property property)
	{
		if(property.color == Color.White)
		{
			this.description = property.description;
		}
		
		this.index = property.index;
		this.name = property.name;
		this.buyingCost = property.buyingCost;
		this.rentOwed = property.rentOwed;
		this.mortgageValue = property.mortgageValue;
		this.monopoly = property.monopoly;
		this.color = property.color;
		this.ownedBy = property.ownedBy;
	}
	
	/**
	 * @param index
	 * @param name
	 * @param buyingCost
	 * @param rentOwed
	 * @param monopoly
	 * @param color
	 * @param ownedBy
	 */
	public Property(int index, String name, int buyingCost, int rentOwed, boolean monopoly,
			Color color, Tokens ownedBy) {
		this.index = index;
		this.name = name;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = monopoly;
		this.color = color;
		this.ownedBy = ownedBy;
	}
	/**
	 * @param index
	 * @param name
	 * @param description
	 * @param buyingCost
	 * @param rentOwed
	* @param monopoly
	 * @param color
	 * @param ownedBy
	 */
	public Property(int index, String name, String description, int buyingCost, int rentOwed,
			boolean monopoly, Color color, Tokens ownedBy) {
		this.index = index;
		this.name = name;
		this.description = description;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = monopoly;
		this.color = color;
		this.ownedBy = ownedBy;
	}
	/**
	 * @param index
	 * @param name
	 * @param description
	 * @param buyingCost
	 * @param rentOwed
	 * @param costPerBuilding
	 * @param housesOwned
	 * @param hotelsOwned
	 * @param monopoly
	 * @param color
	 * @param ownedBy
	 */
	public Property(int index, String name, String description, int buyingCost, int rentOwed, int costPerBuilding,
			int housesOwned, int hotelsOwned, boolean monopoly, Color color, Tokens ownedBy) {
		this.index = index;
		this.name = name;
		this.description = description;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;
		this.costPerBuilding = costPerBuilding;	//not on all properties
		this.housesOwned = housesOwned;			//not on all properties
		this.hotelsOwned = hotelsOwned;			//not on all properties
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = monopoly;
		this.color = color;
		this.ownedBy = ownedBy;
	}
	
	
	
	public Property(int index, String name, int buyingCost, int rentOwed, int costPerBuilding, int housesOwned, int hotelsOwned, boolean monopoly, Color color, Tokens ownedBy) 
	{
		this.index = index;
		this.name = name;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;
		this.costPerBuilding = costPerBuilding;	
		this.housesOwned = housesOwned;			
		this.hotelsOwned = hotelsOwned;			
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = monopoly;
		this.color = color;
		this.ownedBy = ownedBy;
	}
	public Property(int index, String name, int buyingCost, int rentOwed, int costPerBuilding, Color color) 
	{
		this.index = index;
		this.name = name;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;
		this.costPerBuilding = costPerBuilding;	
		this.housesOwned = 0;			
		this.hotelsOwned = 0;			
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = false;
		this.color = color;
		this.ownedBy = Tokens.Bank;
	}

	public Property(int index, String name, int buyingCost, int rentOwed, Color color) 
	{
		this.index = index;
		this.name = name;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;		
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = false;
		this.color = color;
		this.ownedBy = Tokens.Bank;
	}

	public Property(int index, String name, String description, int buyingCost, int rentOwed, Color color) 
	{
		this.index = index;
		this.name = name;
		this.description = description;
		this.buyingCost = buyingCost;
		this.rentOwed = rentOwed;		
		mortgageValue = setMortgageValue(this.buyingCost);
		this.monopoly = false;
		this.color = color;
		this.ownedBy = Tokens.Bank;
	}

	/**
	 * @return the buyingCost
	 */
	public int getBuyingCost() 
	{
		return buyingCost;
	}
	/**
	 * @param buyingCost the buyingCost to set
	 */
	public void setBuyingCost(int buyingCost) 
	{
		this.buyingCost = buyingCost;
	}
	/**
	 * @return the rentOwed
	 */
	public int getRentOwed() {
		return rentOwed;
	}
	/**
	 * @param rentOwed the rentOwed to set
	 */
	public void setRentOwed(int rentOwed) {
		this.rentOwed = rentOwed;
	}
	/**
	 * @return the housesOwned
	 */
	public int getHousesOwned() {
		return housesOwned;
	}
	/**
	 * @param housesOwned the housesOwned to set
	 */
	public void setHousesOwned(int housesOwned) {
		this.housesOwned = housesOwned;
	}
	/**
	 * @return the hotelsOwned
	 */
	public int getHotelsOwned() {
		return hotelsOwned;
	}
	/**
	 * @param hotelsOwned the hotelsOwned to set
	 */
	public void setHotelsOwned(int hotelsOwned) {
		this.hotelsOwned = hotelsOwned;
	}
	/**
	 * @return the monopoly
	 */
	public boolean isMonopoly() {
		return monopoly;
	}
	/**
	 * @param monopoly the monopoly to set
	 */
	public void setMonopoly(boolean monopoly) {
		this.monopoly = monopoly;
	}
	/**
	 * @return the ownedBy
	 */
	public Tokens getOwnedBy() {
		return ownedBy;
	}
	/**
	 * @param ownedBy the ownedBy to set
	 */
	public void setOwnedBy(Tokens ownedBy) {
		this.ownedBy = ownedBy;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the costPerBuilding
	 */
	public int getCostPerBuilding() {
		return costPerBuilding;
	}
	private int setMortgageValue(int buyingCost)
	{
		return buyingCost/2;
	}
	/**
	 * @return the mortgageValue
	 */
	public int getMortgageValue() {
		return mortgageValue;
	}
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buyingCost;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + costPerBuilding;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + hotelsOwned;
		result = prime * result + housesOwned;
		result = prime * result + index;
		result = prime * result + (monopoly ? 1231 : 1237);
		result = prime * result + mortgageValue;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ownedBy == null) ? 0 : ownedBy.hashCode());
		result = prime * result + rentOwed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Property)) {
			return false;
		}
		Property other = (Property) obj;
		if (buyingCost != other.buyingCost) {
			return false;
		}
		if (color != other.color) {
			return false;
		}
		if (costPerBuilding != other.costPerBuilding) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (hotelsOwned != other.hotelsOwned) {
			return false;
		}
		if (housesOwned != other.housesOwned) {
			return false;
		}
		if (index != other.index) {
			return false;
		}
		if (monopoly != other.monopoly) {
			return false;
		}
		if (mortgageValue != other.mortgageValue) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (ownedBy != other.ownedBy) {
			return false;
		}
		if (rentOwed != other.rentOwed) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("Property [index=");
		builder.append(index);
		builder.append(", ");
		
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		builder.append("buyingCost=");
		builder.append(buyingCost);
		
		builder.append(", rentOwed=");
		builder.append(rentOwed);
		
		if(costPerBuilding!=0)
		{
			builder.append(", costPerBuilding=");
			builder.append(costPerBuilding);
			
			if(hotelsOwned!=0)
			{
				builder.append(", housesOwned=");
				builder.append(housesOwned);
			}
			
			if(hotelsOwned!=0)
			{
				builder.append(", hotelsOwned=");
				builder.append(hotelsOwned);
			}
		}
		
		builder.append(", mortgageValue=");
		builder.append(mortgageValue);
		
		builder.append(", monopoly=");
		builder.append(monopoly);
		builder.append(", ");
		
		builder.append("color=");
		builder.append(color);
		builder.append(", ");
		
		builder.append("ownedBy=");
		builder.append(ownedBy);
		
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Property o) 
	{
		return this.index - o.getIndex();
	}

	
}
