package be.afelio.software_academy.spring.chinook.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.afelio.software_academy.spring.chinook.dto.AlbumDto;
import be.afelio.software_academy.spring.chinook.dto.TrackDto;
import be.afelio.software_academy.spring.chinook.exceptions.AlbumNotFoundException;
import be.afelio.software_academy.spring.chinook.persistence.entities.AlbumEntity;
import be.afelio.software_academy.spring.chinook.persistence.entities.TrackEntity;
import be.afelio.software_academy.spring.chinook.persistence.repository.AlbumRepository;
import be.afelio.software_academy.spring.chinook.persistence.repository.TrackRepository;

@Component
public class ApplicationRepository {

	@Autowired
	AlbumRepository albumRepository;

	@Autowired
	TrackRepository trackRepository;

	public List<AlbumDto> findAllAlbumDtoWithMapping() {
		List<AlbumEntity> albumList = albumRepository.findAll();
		List<AlbumDto> listAlbum = new ArrayList<AlbumDto>();

		for (AlbumEntity album : albumList) {

			listAlbum.add(createAlbumDto(album));
		}
		return listAlbum;
	}

	public List<AlbumDto> findAllAlbumByArtistNameDtoWithMapping(String artistName) {
		List<AlbumEntity> albumList = albumRepository.findAllAlbumByArtistName(artistName);
		List<AlbumDto> listAlbum = new ArrayList<AlbumDto>();

		for (AlbumEntity album : albumList) {

			listAlbum.add(createAlbumDto(album));
		}
		return listAlbum;
	}

	public List<AlbumDto> findAllAlbumByGenreNameDtoWithMapping(String genreName) {
		List<AlbumEntity> albumList = albumRepository.findAllAlbumByTrackListGenreName(genreName);
		List<AlbumDto> listAlbum = new ArrayList<AlbumDto>();

		for (AlbumEntity album : albumList) {

			listAlbum.add(createAlbumDto(album));
		}
		return listAlbum;
	}

	private AlbumDto createAlbumDto(AlbumEntity albumEntity) {
		List<String> genres = new ArrayList<String>();

		for (TrackEntity track : albumEntity.getTracks()) {
			if (!genres.contains(track.getGenre().getName())) {
				genres.add(track.getGenre().getName());
			}
		}

		return new AlbumDto(albumEntity.getTitle(), albumEntity.getArtist().getName(), genres);

	}

	public List<TrackDto> findAllTrackByAlbumTitleDtoWithMapping(String title) {
		List<TrackEntity> trackList = trackRepository.findAllTrackByAlbumTitle(title);
		List<TrackDto> listTrack = new ArrayList<TrackDto>();

		for (TrackEntity tracks : trackList) {

			listTrack.add(createTrackDto(tracks));
		}
		return listTrack;
	}

	private TrackDto createTrackDto(TrackEntity tracks) {
		return new TrackDto(tracks.getName(), tracks.getAlbum().getArtist().getName(), tracks.getMedia().getName(),
				tracks.getGenre().getName());
	}

	public void deleteAlbum(int id) {
		AlbumEntity album = albumRepository.findOneById(id);
		if (album == null) {
			throw new AlbumNotFoundException();
		}
		albumRepository.delete(album);
	}

}
