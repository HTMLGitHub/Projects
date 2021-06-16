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
 *	Base Class for all objects in Super Adventure
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class Item
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ItemSequence")
	@SequenceGenerator(name="ItemSequence", sequenceName="ITEM_SEQ", allocationSize=1)
	private int Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="PluaralName")
	private String PluralName;
}