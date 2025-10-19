package com.smarttask.aiassistant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "attachments")
public class Attachment extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private User uploader;

    @Column(nullable = false)
    private String storageUrl;   // או path מקומי

    private String fileName;
    private Long sizeBytes;
    private String contentType;
}
