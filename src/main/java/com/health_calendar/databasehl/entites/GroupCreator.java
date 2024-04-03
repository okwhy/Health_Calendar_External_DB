package com.health_calendar.databasehl.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "group_creator")
public class GroupCreator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_creator")
    private UsersDb fkCreator;

    @Column(name = "group_name", nullable = false, length = Integer.MAX_VALUE)
    private String groupName;

    @Column(name = "access_key", nullable = false, length = Integer.MAX_VALUE)
    private String accessKey;

    @OneToMany(mappedBy = "fkGroup")
    private Set<GroupMember> groupMembers = new LinkedHashSet<>();
}