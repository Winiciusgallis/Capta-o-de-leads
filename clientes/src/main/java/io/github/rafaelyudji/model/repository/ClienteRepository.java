package io.github.rafaelyudji.model.repository;

import io.github.rafaelyudji.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    

}
