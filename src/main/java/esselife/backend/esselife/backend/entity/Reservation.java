package esselife.backend.esselife.backend.entity;

import esselife.backend.esselife.backend.entity.enums.Consultant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "customer_name")
        private String customerName;

        @Column(name = "reservation_date_time")
        private LocalDateTime reservationDateTime;

        @Enumerated(EnumType.STRING)
        @Column(name = "consultant")
        private Consultant consultant;

        @Column(name = "reservation_completed")
        private boolean reservationCompleted;

}