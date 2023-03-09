package br.com.projetoam.hospital.repository;

import br.com.projetoam.hospital.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
}
