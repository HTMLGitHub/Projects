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
 *	Base Class for all objects in Super Adventure
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class LootItem {
	private Item Details;
	private int DropPercentage;
	private boolean IsDefaultItem;
}
