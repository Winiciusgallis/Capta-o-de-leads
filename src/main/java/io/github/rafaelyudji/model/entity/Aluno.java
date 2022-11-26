package io.github.rafaelyudji.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length =  150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length =  12)
    private String telefone;

    @Column(name = "data_cadastro",updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @Column(nullable = false, length =  30)
    private String cidade;

    @Column(nullable = false, length =  30)
    private String estado;

    @Column(nullable = false, length =  150)
    private String curso;

    @Column(nullable = false, length =  30)
    private String codCurso;

    @Column(nullable = false, length =  150)
    private String Email;

    @PrePersist
    public void prePresist(){
        setDataCadastro(LocalDate.now());
    }
}
