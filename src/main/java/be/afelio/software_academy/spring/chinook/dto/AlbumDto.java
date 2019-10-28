package be.afelio.software_academy.spring.chinook.dto;

import java.util.List;

public class AlbumDto {

	private String title;
	private String artist;
	private List<String> genres;

	public AlbumDto() {
	}

	public AlbumDto(String title, String artist, List<String> genres) {
		super();
		this.title = title;
		this.artist = artist;
		this.genres = genres;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		AlbumDto other = (AlbumDto) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title)) {
			return false;}
		return true;
	}

	@Override
	public String toString() {
		return "AlbumDto [title=" + title + ", artist=" + artist + ", genres=" + genres + "]";
	}

	

}