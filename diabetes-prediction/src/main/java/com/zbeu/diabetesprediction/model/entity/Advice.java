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
@Table(name = "advices")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

}
