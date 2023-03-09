package br.com.projetoam.hospital.repository;

import br.com.projetoam.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByEspecialidades_Nome(String nome);
}
