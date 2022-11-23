package io.github.rafaelyudji;

import io.github.rafaelyudji.model.entity.Cliente;
import io.github.rafaelyudji.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ClientsApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientsApplication.class, args);
    }
}
