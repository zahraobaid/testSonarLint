package be.afelio.software_academy.spring.chinook.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Artist")
@Table(name = "Artist")
public class ArtistEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artistid")
	private Integer id;

	@Column(name = "Name")
	private String name;
	
	@OneToMany(mappedBy="artist")
	private List<AlbumEntity> albums;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@OneToMany
//	@JoinColumn(name = "ArtistId")
//	private AlbumEntity album;

}
