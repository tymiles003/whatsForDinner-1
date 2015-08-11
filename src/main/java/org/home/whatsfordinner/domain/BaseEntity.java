package org.home.whatsfordinner.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private Long id;
    private DateTime creationDate;
    private DateTime lastModifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @CreatedDate
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "creation_date")
    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final DateTime creationDate) {
        this.creationDate = creationDate;
    }

    @LastModifiedDate
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "last_modified_date")
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void onCreate() {
        creationDate = DateTime.now();
        lastModifiedDate = DateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        lastModifiedDate = DateTime.now();
    }

}
