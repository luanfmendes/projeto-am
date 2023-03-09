package br.com.projetoam.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "especialidade", sequenceName = "SQ_ESPECIALIDADE", allocationSize = 1)
public class Especialidade {
    @Id
    @GeneratedValue(generator = "especialidade", strategy = GenerationType.SEQUENCE)
    @Column(name = "CD_ESPECIALIDADE")
    private int codigo;

    private String nome;

    private String descricao;
}
