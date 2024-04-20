package com.health_calendar.databasehl.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dates")
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Column(name = "day", nullable = false)
    private Integer day;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user", nullable = false)
    private UsersDb fkUser;

    @OneToMany(targetEntity=Note.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="fk_date",referencedColumnName = "id", nullable = false)
            private List<Note> notes = new ArrayList<>();

//    @OneToMany(mappedBy = "fkDate",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Note> notes = new LinkedHashSet<>();


}
