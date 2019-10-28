package be.afelio.software_academy.spring.chinook.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Album")
@Table(name = "Album")
public class AlbumEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "albumid") // album_id
	private Integer id;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "artistid")
	private ArtistEntity artist;

	@OneToMany(mappedBy = "album")
	private List<TrackEntity> trackList;

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public ArtistEntity getArtist() {
		return artist;
	}

	public List<TrackEntity> getTracks() {
		return trackList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(ArtistEntity artist) {
		this.artist = artist;
	}

	

}
