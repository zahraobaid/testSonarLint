package be.afelio.software_academy.spring.chinook.dto;

public class ArtistDto {
	private String name;

	public ArtistDto() {
	}

	public ArtistDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ArtistDto [name=" + name + "]";
	}
	
}
