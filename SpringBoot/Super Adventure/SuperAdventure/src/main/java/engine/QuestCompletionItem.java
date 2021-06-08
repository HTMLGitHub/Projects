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
 *
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class QuestCompletionItem
{
	private Item details;
	private int Quantity;
}
