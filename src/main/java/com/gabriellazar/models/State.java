package com.gabriellazar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "states")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class State {

    @Id
    @Column(name = "state_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stateId;
    @Column(name="state_abv")
    private String stateAbv;
    @Column(name = "state_tax")
    private Double stateTax;


}
