package com.example.blog.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> implements Serializable {

    @Column(updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(updatable = false)
    @CreatedBy
    private U createdBy;

    @LastModifiedDate
    private Date lastModifiedAt;

    @LastModifiedBy
    private U lastModifiedBy;
}
