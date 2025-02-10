package com.example.projectc1023i1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @ManyToOne
    @JoinColumn(name = "sender_id",nullable = false)
    private Users senderId;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Users receiverId;

    private String content;

    @Column(name = "send_at")
    private LocalDateTime sentAt;

    @Column(name = "is_read")
    private Boolean isRead;
}
