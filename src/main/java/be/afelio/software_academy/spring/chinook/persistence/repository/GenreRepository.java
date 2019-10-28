package be.afelio.software_academy.spring.chinook.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.spring.chinook.persistence.entities.GenreEntity;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

	List<GenreEntity> findAll();
}
