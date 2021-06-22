/**
 * 
 */
package engine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 *	Class for all locations in Super Adventure
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Location
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LocationSequence")
	@SequenceGenerator(name="LocationSequence", sequenceName="LOCATION_SEQ", allocationSize=1)
	private int Id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name="ItemRequiredToEnter")
	private Item ItemRequiredToEnter;
	
	@Column(name="QuestAvailableHere")
	private Quest QuestAvailablehere;
	
	@Column(name="MonsterLivingHere")
	private Monster MonsterLivingHere;
	
	@Column(name="LocationToNorth")
	private Location LocationToNorth;
	
	@Column(name="LocationToSouth")
	private Location LocationToSouth;
	
	@Column(name="LocationToEast")
	private Location LocationToEast;
	
	@Column(name="LocationToWest")
	private Location LocationToWest;
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Location(int id, String name, String description)
	{
		this.Id = id;
		this.Name = name;
		this.Description = description;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param itemRequiredToEnter
	 */
	public Location(int id, String name, String description, Item itemRequiredToEnter)
	{
		this(id, name, description);
		ItemRequiredToEnter = itemRequiredToEnter;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param questAvailablehere
	 */
	public Location(int id, String name, String description, Quest questAvailablehere)
	{
		this(id, name, description);
		QuestAvailablehere = questAvailablehere;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param monsterLivingHere
	 */
	public Location(int id, String name, String description, Monster monsterLivingHere)
	{
		this(id, name, description);
		MonsterLivingHere = monsterLivingHere;
	}		
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param itemRequiredToEnter
	 * @param questAvailablehere
	 * @param monsterLivingHere
	 */
	public Location(int id, String name, String description, Item itemRequiredToEnter, Quest questAvailablehere,
			Monster monsterLivingHere)
	{
		this(id, name, description);
		ItemRequiredToEnter = itemRequiredToEnter;
		QuestAvailablehere = questAvailablehere;
		MonsterLivingHere = monsterLivingHere;
	}
}