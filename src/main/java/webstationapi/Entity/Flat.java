package webstationapi.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="FLAT_FLATS")
public class Flat {

	@Id
	@Column(name="ID_FLAT")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id_flat;

	@Column(name="DESCRIPTION", length = 150)
	private String description;
	
	@Column(name="NB_PERSONNES", length = 150)
	private String nbPersonnes;
	
	@Column(name="SDBWC")
	private boolean sdbwc;
	
	@Column(name="PETS")
	private boolean pets;
	
	@Column(name="WIFI")
	private boolean wifi;
	
	@Column(name="ORIENTATION", length = 150)
	private String orientation;

	public Flat() {}
	public Flat(long id_flat, String description, String nbPersonnes, boolean sdbwc, boolean pets, boolean wifi, String orientation) {
		this.id_flat = id_flat;
		this.description = description;
		this.nbPersonnes = nbPersonnes;
		this.sdbwc = sdbwc;
		this.pets = pets;
		this.wifi = wifi;
		this.orientation = orientation;
	}

	public long getId_flat() {
		return id_flat;
	}
	// Long primary key, auto-incremented value

	public void setId_flat(long id_flat) {
		this.id_flat = id_flat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getNbPersonnes() {
		return description;
	}

	public void setNbPersonnes(String nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public boolean getSdbwc() {
		return sdbwc;
	}

	public void setSdbwc(String sdbwc) {
		this.sdbwc = sdbwc;
	}
	
	public boolean getPets() {
		return pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}
	
	public boolean getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
}
