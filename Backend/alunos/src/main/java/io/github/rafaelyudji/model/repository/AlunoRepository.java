package io.github.rafaelyudji.model.repository;

import io.github.rafaelyudji.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    

}
