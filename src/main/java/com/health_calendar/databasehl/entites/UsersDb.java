package com.health_calendar.databasehl.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users_db")
@Builder
public class UsersDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "login", nullable = false, length = Integer.MAX_VALUE)
    private String login;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @OneToMany(mappedBy = "fkUser")
    private Set<Date> dates = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkCreator")
    private Set<GroupCreator> groupCreators = new LinkedHashSet<>();


    @OneToMany(mappedBy = "fkUser")
    private Set<GroupMember> groupMembers = new LinkedHashSet<>();

}