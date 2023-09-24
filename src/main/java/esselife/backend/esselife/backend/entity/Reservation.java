package esselife.backend.esselife.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "customer_name") // Müşteri adını burada tutuyoruz
        private String customerName;

        @Enumerated(EnumType.STRING)
        @Column(name = "consultant")
        private Consultant consultant;

        @Column(name = "reservation_completed")
        private boolean reservationCompleted;

        @Column(name="date")
        private LocalDateTime reservationDateTime;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        @JsonBackReference
        private Customer customer;

        public Reservation(Consultant consultant, boolean reservationCompleted, LocalDateTime reservationDateTime, Customer customer) {
                this.consultant = consultant;
                this.reservationCompleted = reservationCompleted;
                this.reservationDateTime = reservationDateTime;
                this.customer = customer;
        }

}