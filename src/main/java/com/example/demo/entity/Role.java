package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Roles")
@AllArgsConstructor
public class Role {
    @Id
    @SequenceGenerator(name = "roles_sequence",sequenceName = "roles_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_sequence")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<User> user = new HashSet<>();

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role( String name) {
        this.name = name;
    }
}
