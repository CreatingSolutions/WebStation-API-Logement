package webstationapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @Class FLT_FLATS
 * 
 * Two columns :
 * 		- id_flat, a long primary key, auto-incremented value;
 * 		- description, a String field, describes the flat.
 * 
 * To be used to store flats from the complex.
 */

@Entity
@Table(name="FLT_FLATS")
public class Flt_Flat {

	@Id
	@Column(name="ID_FLAT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_flat;
	// Long primary key, auto-incremented value

	@Column(name="DESCRIPTION", length = 150)
	private String description;
	// String field
	
	@Lob
	@Column(name="PHOTO", columnDefinition="BLOB")
	private byte[] photo;
	// BLOB picture of the flat

	public Flt_Flat() {}
	public Flt_Flat(long id_flat, String description, byte[] photo) {
		this.id_flat = id_flat;
		this.description = description;
		this.photo = photo;
	}
}