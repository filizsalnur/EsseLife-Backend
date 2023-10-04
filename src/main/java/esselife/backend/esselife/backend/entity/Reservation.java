package esselife.backend.esselife.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate; // LocalDate için import ekleyin
import java.time.LocalTime; // LocalTime için import ekleyin
import java.time.LocalTime; // Ekledik


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

        @Column(name = "reservation_date") // Tarih alanı
        private LocalDate reservationDate;

        @Column(name = "reservation_time") // Saat alanı
        private LocalTime reservationTime;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        @JsonBackReference
        private Customer customer;

        public Reservation(String customerName, Consultant consultant, boolean reservationCompleted, LocalDate reservationDate, LocalTime reservationTime, Customer customer) {
                this.customerName = customerName;
                this.consultant = consultant;
                this.reservationCompleted = reservationCompleted;
                this.reservationDate = reservationDate;
                this.reservationTime = reservationTime;
                this.customer = customer;
        }
}