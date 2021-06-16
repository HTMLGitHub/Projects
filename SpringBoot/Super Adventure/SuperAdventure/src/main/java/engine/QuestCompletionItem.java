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
 *
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class QuestCompletionItem
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QuestCompletionItemSequence")
	@SequenceGenerator(name="QuestCompletionItemSequence", sequenceName="QUESTCOMPLETIONITEM_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="Details")
	private Item details;
	
	@Column(name="Quantity")
	private int Quantity;

	/**
	 * @param details
	 * @param quantity
	 */
	public QuestCompletionItem(Item details, int quantity)
	{
		this.details = details;
		Quantity = quantity;
	}
}
