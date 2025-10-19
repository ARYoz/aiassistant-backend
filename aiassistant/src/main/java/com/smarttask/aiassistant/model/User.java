package com.smarttask.aiassistant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    /* Projects the user owns */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Project> ownedProjects = new LinkedHashSet<>();

    /* Tasks where the user is the assignee/owner */
    @OneToMany(mappedBy = "owner")
    private Set<Task> tasks = new LinkedHashSet<>();

    /* Comments authored by this user */
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    /* Notifications */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Notification> notifications = new LinkedHashSet<>();

    /* API Keys for AI providers */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserApiKey> apiKeys = new LinkedHashSet<>();
}
