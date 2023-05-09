package com.nwarner.projasstracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_user")
public class UserProject extends BaseEntity {

    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;
    @Column(name = "role")
    private String role;
    @Column(name = "can_edit")
    private Boolean canEdit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserProject userProject = (UserProject) o;
        return getId() != null && Objects.equals(getId(), userProject.getId());
    }

    @Override
    public int hashCode() {
        String toHash = this.getId() + role;
        return toHash.hashCode();
    }
}
