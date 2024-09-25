package com.example.ScheduleMate.meta;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "created_timestamp")
    @CreationTimestamp
    private Date createdTimestamp;
    @Column(name = "updated_timestamp")
    private Date updatedTimestamp;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;

    @PreUpdate
    protected void onUpdate(){
        updatedTimestamp=new Date();
    }


}
