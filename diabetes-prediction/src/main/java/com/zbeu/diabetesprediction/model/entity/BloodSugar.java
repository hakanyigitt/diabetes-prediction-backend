package com.zbeu.diabetesprediction.model.entity;

import com.zbeu.diabetesprediction.model.enums.TimeType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author HAKAN YIGIT
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "blood_sugars")
public class BloodSugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private float value;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time_type", nullable = false)
    private TimeType timeType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
