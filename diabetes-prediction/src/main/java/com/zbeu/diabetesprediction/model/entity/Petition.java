package com.zbeu.diabetesprediction.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author HAKAN YIGIT
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "petitions")
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status")
    private boolean status;

}
