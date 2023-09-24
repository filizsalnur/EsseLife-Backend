package esselife.backend.esselife.backend.common;

import esselife.backend.esselife.backend.entity.Customer;
import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.CustomerRepository;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        // Veritabanını temizle
        reservationRepository.deleteAll();
        customerRepository.deleteAll();

        // Müşterileri oluştur
        Customer customer1 = new Customer("Müşteri 1");
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Müşteri 2");
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Müşteri 3");
        customerRepository.save(customer3);

        // Rezervasyonları oluştur ve müşterilere bağla
        Reservation reservation1 = new Reservation(Consultant.CONSULTANT_A, true, LocalDateTime.now().plusDays(1), customer1);
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation(Consultant.CONSULTANT_B, true, LocalDateTime.now().plusDays(2), customer2);
        reservationRepository.save(reservation2);

        Reservation reservation3 = new Reservation(Consultant.CONSULTANT_C, true, LocalDateTime.now().plusDays(3), customer3);
        reservationRepository.save(reservation3);

        Reservation reservation4 = new Reservation(Consultant.CONSULTANT_A, true, LocalDateTime.now().plusDays(4), customer1);
        reservationRepository.save(reservation4);

    }
}