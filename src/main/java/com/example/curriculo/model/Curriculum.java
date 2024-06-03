package com.example.curriculo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonalInfo personalInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToOne(cascade = CascadeType.ALL)
    private Summary summary;

    public void setId(Long id) {
        this.id = id;
    }
}
