package org.example.rpl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@Builder
@Table(name = "Player")
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    public enum PlayerStatus {
        IN_STARTING_LINEUP, // в стартовом составе
        ON_BENCH,          // на замене
        INJURED,           // травмирован
        ACTIVE             // активный игрок
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Rating cannot be null")
    private int rating;

    @Column(nullable = false)
    @NotNull(message = "Position cannot be null")
    private String position;

    @Column(nullable = false)
    @NotNull(message = "Age cannot be null")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Status cannot be null")
    private PlayerStatus status;
}
