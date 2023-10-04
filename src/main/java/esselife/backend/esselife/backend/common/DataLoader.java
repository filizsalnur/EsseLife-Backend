package esselife.backend.esselife.backend.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import esselife.backend.esselife.backend.entity.Customer;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.CustomerRepository;
import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public DataLoader(ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Müşterileri oluştur
        Customer customer1 = new Customer("Müşteri 1");
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Müşteri 2");
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Müşteri 3");
        customerRepository.save(customer3);

        // Rezervasyonları oluştur ve müşterilere bağla
        Reservation reservation1 = new Reservation(customer1.getName(), Consultant.CONSULTANT_A, true, LocalDateTime.now().plusDays(13), customer1);
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation(customer1.getName(), Consultant.CONSULTANT_B, true, LocalDateTime.now().plusDays(2), customer1);
        reservationRepository.save(reservation2);

        Reservation reservation3 = new Reservation(customer2.getName(), Consultant.CONSULTANT_C, true, LocalDateTime.now().plusDays(3), customer2);
        reservationRepository.save(reservation3);

        Reservation reservation4 = new Reservation(customer2.getName(), Consultant.CONSULTANT_A, true, LocalDateTime.now().plusDays(4), customer2);
        reservationRepository.save(reservation4);

        Reservation reservation5 = new Reservation(customer3.getName(), Consultant.CONSULTANT_B, true, LocalDateTime.now().plusDays(5), customer3);
        reservationRepository.save(reservation5);

        Reservation reservation6 = new Reservation(customer3.getName(), Consultant.CONSULTANT_C, true, LocalDateTime.now().plusDays(6), customer3);
        reservationRepository.save(reservation6);
    }
}