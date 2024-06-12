package com.example.Task1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tracktime", schema = "public")
public class TrackTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "execution_time")
    private long executionTime;
    @ManyToOne
    @JoinColumn(name = "method_id", referencedColumnName = "id")
    private Method method;

    public TrackTime(Method method, long executionTime) {
        this.method = method;
        this.executionTime = executionTime;
    }
}
