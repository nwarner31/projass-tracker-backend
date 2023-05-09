package com.nwarner.projasstracker.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;
    @Lob
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "status", nullable = false)
    private String status;
    @Lob
    @Column(name = "clearance_criteria", columnDefinition = "text")
    private String clearanceCriteria;
    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;
    @ManyToOne
    private Project project;
    @ManyToOne
    private User assignedTo;
    @ManyToOne
    private Sprint sprint;

}
