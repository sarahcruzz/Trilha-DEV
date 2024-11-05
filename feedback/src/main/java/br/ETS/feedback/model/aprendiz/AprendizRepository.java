package br.ETS.feedback.model.aprendiz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AprendizRepository extends JpaRepository<Aprendiz, Integer> {
    Page<Aprendiz> findAllByAtivoTrue(Pageable pageable);
}
