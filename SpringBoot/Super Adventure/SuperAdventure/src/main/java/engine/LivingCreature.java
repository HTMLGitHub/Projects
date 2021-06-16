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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 * Base class for all Creatures in Super Adventure
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class LivingCreature
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LivingCreatureSequence")
	@SequenceGenerator(name="LivingCreatureSequence", sequenceName="LIVINGCREATURE_SEQ", allocationSize=1)
	private int id;
	
	@Column(name = "currentHitPoints")
	private int currentHitPoints;
	
	@Column(name = "maximumHitPoints")
	private int maximumHitPoints;

	/**
	 * @param currentHitPoints
	 * @param maximumHitPoints
	 */
	public LivingCreature(int currentHitPoints, int maximumHitPoints)
	{
		this.currentHitPoints = currentHitPoints;
		this.maximumHitPoints = maximumHitPoints;
	}
	
	
}
