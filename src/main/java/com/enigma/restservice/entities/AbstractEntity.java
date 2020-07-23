package com.enigma.restservice.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_date")
    private LocalDateTime createDate;

    @Column(name = "modified_date")
    private LocalDateTime modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();

    }

    @PreUpdate
    private void preUpdate() {
        modifyDate = LocalDateTime.now();

    }

    @Override
    public String toString() {
        return "AbstractEntity{" + "id=" + id + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }

}
