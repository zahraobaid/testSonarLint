package be.afelio.software_academy.spring.chinook.dto;

import be.afelio.software_academy.spring.chinook.persistence.entities.AlbumEntity;
import be.afelio.software_academy.spring.chinook.persistence.entities.GenreEntity;

public class TrackDto {

	private String name;
	private  String artist;
	private String mediatype;
	private String genre;
	
	
	public TrackDto() {
	}


	public TrackDto(String name, String artist, String mediatype, String genre) {
		super();
		this.name = name;
		this.artist = artist;
		this.mediatype = mediatype;
		this.genre = genre;
	}


	public String getName() {
		return name;
	}


	public String getArtist() {
		return artist;
	}


	public String getMediatype() {
		return mediatype;
	}


	public String getGenre() {
		return genre;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public void setMediatype(String mediatype) {
		this.mediatype = mediatype;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((mediatype == null) ? 0 : mediatype.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackDto other = (TrackDto) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (mediatype == null) {
			if (other.mediatype != null)
				return false;
		} else if (!mediatype.equals(other.mediatype))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TrackDto [name=" + name + ", artist=" + artist + ", mediatype=" + mediatype + ", genre=" + genre + "]";
	}

	
}