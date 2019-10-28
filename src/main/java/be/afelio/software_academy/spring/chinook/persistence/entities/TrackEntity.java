package be.afelio.software_academy.spring.chinook.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Track")
@Table(name = "Track")

public class TrackEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trackid")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "genreid")
	private GenreEntity genre;

	@ManyToOne
	@JoinColumn(name = "albumid")
	private AlbumEntity album;
	
	@ManyToOne
	@JoinColumn(name = "mediatypeid")
	private MediaTypeEntity media;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public GenreEntity getGenre() {
		return genre;
	}

	public AlbumEntity getAlbum() {
		return album;
	}

	public MediaTypeEntity getMedia() {
		return media;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}

	public void setMedia(MediaTypeEntity media) {
		this.media = media;
	}
	
	}
