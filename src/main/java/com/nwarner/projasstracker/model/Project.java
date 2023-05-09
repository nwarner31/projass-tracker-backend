package com.nwarner.projasstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project extends BaseEntity {

    @Column(name = "project_name", nullable = false)
    private String name;
    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "launch_date")
    private LocalDate launchDate;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<UserProject> teamMembers;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Sprint> sprints;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return getId() != null && Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        String toHash = this.getId() + this.name + this.description + this.status;
        return toHash.hashCode();
    }
}
