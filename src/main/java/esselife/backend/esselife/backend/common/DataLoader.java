package esselife.backend.esselife.backend.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import esselife.backend.esselife.backend.entity.Customer;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.CustomerRepository;
import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;

import java.time.LocalDate;

import java.time.LocalTime;

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
        Reservation reservation1 = new Reservation(customer1.getName(), Consultant.CONSULTANT_A, true, LocalDate.now().plusDays(13), LocalTime.of(14, 0), customer1);
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation(customer1.getName(), Consultant.CONSULTANT_B, true, LocalDate.now().plusDays(2), LocalTime.of(10, 30), customer1);
        reservationRepository.save(reservation2);

        Reservation reservation3 = new Reservation(customer2.getName(), Consultant.CONSULTANT_C, true, LocalDate.now().plusDays(3), LocalTime.of(16, 15), customer2);
        reservationRepository.save(reservation3);

        Reservation reservation4 = new Reservation(customer2.getName(), Consultant.CONSULTANT_A, true, LocalDate.now().plusDays(4), LocalTime.of(11, 45), customer2);
        reservationRepository.save(reservation4);

        Reservation reservation5 = new Reservation(customer3.getName(), Consultant.CONSULTANT_B, true, LocalDate.now().plusDays(5), LocalTime.of(9, 30), customer3);
        reservationRepository.save(reservation5);

        Reservation reservation6 = new Reservation(customer3.getName(), Consultant.CONSULTANT_C, true, LocalDate.now().plusDays(6), LocalTime.of(13, 45), customer3);
        reservationRepository.save(reservation6);

        Reservation reservation7 = new Reservation(customer3.getName(), Consultant.CONSULTANT_A, true, LocalDate.now().plusDays(7), LocalTime.of(15, 0), customer3);
        reservationRepository.save(reservation7);

        Reservation reservation8 = new Reservation(customer3.getName(), Consultant.CONSULTANT_B, true, LocalDate.now().plusDays(7), LocalTime.of(9, 30), customer3);
        reservationRepository.save(reservation8);

        Reservation reservation9 = new Reservation(customer3.getName(), Consultant.CONSULTANT_C, true, LocalDate.now().plusDays(7), LocalTime.of(13, 45), customer3);
        reservationRepository.save(reservation9);
    }
}