package com.nwarner.projasstracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sprint")
public class Sprint extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @ManyToOne
    private Project project;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sprint sprint = (Sprint) o;
        return getId() != null && Objects.equals(getId(), sprint.getId());
    }

    @Override
    public int hashCode() {
        String toHash = this.getId() + title;
        return toHash.hashCode();
    }
}
