package be.afelio.software_academy.spring.chinook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import be.afelio.software_academy.spring.chinook.dto.AlbumDto;
import be.afelio.software_academy.spring.chinook.dto.ReponseDto;
import be.afelio.software_academy.spring.chinook.dto.ResponseDtoStatus;
import be.afelio.software_academy.spring.chinook.exceptions.AlbumNotFoundException;
import be.afelio.software_academy.spring.chinook.persistence.ApplicationRepository;

@Controller
@RequestMapping(value = "Album")
public class AlbumController {
	@Autowired
	ApplicationRepository repository;

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReponseDto<List<AlbumDto>>> findAll() {

		ReponseDto<List<AlbumDto>> dto = null;
		try {
			List<AlbumDto> album = repository.findAllAlbumDtoWithMapping();
			if (album == null) {
				dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.FAILURE, "album not found");
			} else {
				dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.SUCCESS, "ok");
				dto.setPayload(album);
			}
		} catch (Exception e) {
			dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.FAILURE, "unexpected exception");
			e.printStackTrace();
		}

		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "artist/{Name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReponseDto<List<AlbumDto>>> findAllAlbumByArtistNameDtoWithMapping(
			@PathVariable("Name") String Name) {

		ReponseDto<List<AlbumDto>> dto = null;
		try {
			List<AlbumDto> album = repository.findAllAlbumByArtistNameDtoWithMapping(Name);
			if (album == null) {
				dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.FAILURE, "album not found");
			} else {
				dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.SUCCESS, "ok");
				dto.setPayload(album);
			}
		} catch (Exception e) {
			dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.FAILURE, "unexpected exception");
			e.printStackTrace();
		}

		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReponseDto> deleteAlbum(@PathVariable("id") int id) {
		ReponseDto<?> dto = null;

		try {
			repository.deleteAlbum(id);
			dto = new ReponseDto<Object>(ResponseDtoStatus.SUCCESS, "album deleted");
		} catch (AlbumNotFoundException e) {
			dto = new ReponseDto<Object>(ResponseDtoStatus.FAILURE, "album not found");
		} catch (Exception e) {
			dto = new ReponseDto<Object>(ResponseDtoStatus.FAILURE, "unexpected exception");
		}

		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "genre/{Name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReponseDto<List<AlbumDto>>> findAllAlbumByGenreNameDtoWithMapping(
			@PathVariable("Name") String Name) {

		ReponseDto<List<AlbumDto>> dto = null;
		try {
			List<AlbumDto> album = repository.findAllAlbumByGenreNameDtoWithMapping(Name);
			if (album == null) {
				dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.FAILURE, "album not found");
			} else {
				dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.SUCCESS, "ok");
				dto.setPayload(album);
			}
		} catch (Exception e) {
			dto = new ReponseDto<List<AlbumDto>>(ResponseDtoStatus.FAILURE, "unexpected exception");
			e.printStackTrace();
		}

		return ResponseEntity.ok(dto);
	}
}
