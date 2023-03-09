package br.com.projetoam.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "hospital", sequenceName = "SQ_HOSPITAL", allocationSize = 1)
public class Hospital {
    @Id
    @GeneratedValue(generator = "hospital", strategy = GenerationType.SEQUENCE)
    @Column(name = "CD_HOSPITAL")
    private int codigo;
    private String nome;

    private String endereco;

    private String fila;

    private String tempoEspera;

    private String latitude;

    private String longitude;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="T_HOSPITAL_ESPECIALIDADE",
            joinColumns=@JoinColumn(name="CD_HOSPITAL"),
            inverseJoinColumns=@JoinColumn(name="CD_ESPECIALIDADE"))
    private List<Especialidade> especialidades;
}
