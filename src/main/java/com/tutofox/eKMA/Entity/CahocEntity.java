package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thoigian")
public class CahocEntity {

    @Id
    @GeneratedValue
    @Column(name = "cahocID")
    private int cahocID;

    @Column(name = "dateStudy")
    private Date dateStudy;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

}
