package engine;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 *	Class for the Player's Quests
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class PlayerQuest
{
	private Quest Details;
	private boolean IsCompleted;
	
	public PlayerQuest(Quest details)
	{
		this.Details = details;
		this.IsCompleted = false;
	}
}
