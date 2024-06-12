package com.example.Task1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "method", schema = "public")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "method_name")
    private String name;
    @OneToMany(mappedBy = "method")
    private List<TrackTime> trackTimeList;

    public Method(String name) {
        this.name = name;
    }
}
