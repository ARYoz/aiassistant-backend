package com.smarttask.aiassistant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "labels")
public class Lable extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private String color;

    @ManyToMany(mappedBy = "labels")
    private Set<Task> tasks = new LinkedHashSet<>();
}
