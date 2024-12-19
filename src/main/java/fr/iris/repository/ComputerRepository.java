package fr.iris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.iris.model.ComputerModel;

public interface ComputerRepository extends JpaRepository<ComputerModel, Long>{

}
