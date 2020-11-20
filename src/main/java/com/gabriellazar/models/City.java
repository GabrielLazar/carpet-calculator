package com.gabriellazar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CITIES")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cityId;
    @Column(name="city_name")
    private String cityName;
    @Column(name="price")
    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name="state_id")
    private State state;
}
