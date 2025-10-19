package com.smarttask.aiassistant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "ai_insights")
public class AiInsight extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(columnDefinition = "text", nullable = false)
    private String suggestionText;

    private String source;     // לדוגמה: OPENAI
    private Double confidence; // 0..1
}
