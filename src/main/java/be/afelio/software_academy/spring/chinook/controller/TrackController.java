package be.afelio.software_academy.spring.chinook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import be.afelio.software_academy.spring.chinook.dto.ReponseDto;
import be.afelio.software_academy.spring.chinook.dto.ResponseDtoStatus;
import be.afelio.software_academy.spring.chinook.dto.TrackDto;
import be.afelio.software_academy.spring.chinook.persistence.ApplicationRepository;

@Controller
@RequestMapping(value = "Track")

public class TrackController {

	@Autowired
	ApplicationRepository repository;

	@GetMapping(value = "album/{Title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReponseDto<List<TrackDto>>> findAllTrackAlbumTitleDtoWithMapping(
			@PathVariable("Title") String title) {

		ReponseDto<List<TrackDto>> dto = null;
		try {
			List<TrackDto> track = repository.findAllTrackByAlbumTitleDtoWithMapping(title);
			if (track == null) {
				dto = new ReponseDto(ResponseDtoStatus.FAILURE, "track not found");
			} else {
				dto = new ReponseDto(ResponseDtoStatus.SUCCESS, "ok");
				dto.setPayload(track);
			}
		} catch (Exception e) {
			dto = new ReponseDto(ResponseDtoStatus.FAILURE, "unexpected exception");
			e.printStackTrace();
		}

		return ResponseEntity.ok(dto);
	}
}
