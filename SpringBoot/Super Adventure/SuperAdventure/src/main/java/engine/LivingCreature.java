/**
 * 
 */
package engine;

import javax.persistence.Entity;

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
	private int currentHitPoints;
	private int maximumHitPoints;
}
