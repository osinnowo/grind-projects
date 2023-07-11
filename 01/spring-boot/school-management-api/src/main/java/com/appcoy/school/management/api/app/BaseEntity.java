package com.appcoy.school.management.api.app;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity<T> {
    @Id
    private Long id;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private Boolean isDeleted;
    private Boolean isSoftDeleted;
    private Boolean isModified;

    @PrePersist
    public void prePersist() { }

    @PreUpdate
    public void preUpdate() { }
}
