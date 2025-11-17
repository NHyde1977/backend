package br.senac.rj.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author reinaldo.jose
 * Entidade que representa a tabela produtor.
 */
@Entity
@Table(name = "produtor")
@Data
public class Produtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtorId;

    @Column(length = 80, nullable = false)
    private String nome;
    
    @Id
    @Column(length = 80, nullable = false)
    private String email;
    
    @Column(length = 64, nullable = false)
    private String senha;
}
