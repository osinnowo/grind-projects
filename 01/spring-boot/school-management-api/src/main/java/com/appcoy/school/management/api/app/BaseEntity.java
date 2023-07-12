package com.appcoy.school.management.api.app;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_name")
    @SequenceGenerator(name = "sequence_name", sequenceName = "sequence_generator")
    private Long id;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private Boolean isDeleted;
    private Boolean isSoftDeleted;
    private Boolean isModified;

    @PrePersist
    public void prePersist() {
        dateCreated = LocalDate.now();
        dateModified = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        dateModified = LocalDate.now();
    }
}
