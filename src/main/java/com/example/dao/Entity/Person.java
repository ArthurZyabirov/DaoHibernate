package com.example.dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Person {
    @EmbeddedId
    private PersonId personId;

    @Column(nullable = false)
    private int phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

}
