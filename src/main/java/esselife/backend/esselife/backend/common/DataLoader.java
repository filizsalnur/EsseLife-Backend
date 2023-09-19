package esselife.backend.esselife.backend.common;

import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final ReservationRepository reservationRepository;

    @Autowired
    public DataLoader(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSampleReservations();
    }

    private void loadSampleReservations() {
        Reservation reservation1 = new Reservation();
        reservation1.setCustomerName("Müşteri 1");
        reservation1.setReservationDateTime(LocalDateTime.now().plusDays(1));
        reservation1.setConsultant(Consultant.CONSULTANT_A);
        reservation1.setReservationCompleted(false);
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setCustomerName("Müşteri 2");
        reservation2.setReservationDateTime(LocalDateTime.now().plusDays(2));
        reservation2.setConsultant(Consultant.CONSULTANT_B);
        reservation2.setReservationCompleted(true);
        reservationRepository.save(reservation2);

        Reservation reservation3 = new Reservation();
        reservation3.setCustomerName("Müşteri 3");
        reservation3.setReservationDateTime(LocalDateTime.now().plusDays(3));
        reservation3.setConsultant(Consultant.CONSULTANT_C);
        reservation3.setReservationCompleted(false);
        reservationRepository.save(reservation3);
    }
}