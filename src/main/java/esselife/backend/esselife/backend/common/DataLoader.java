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

        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer("Müşteri " + i);
            customerRepository.save(customer);

            // Her müşteri için 2 rezervasyon oluştur
            for (int j = 1; j <= 2; j++) {
                Consultant consultant;
                if (i % 3 == 1) {
                    consultant = Consultant.CONSULTANT_A;
                } else if (i % 3 == 2) {
                    consultant = Consultant.CONSULTANT_B;
                } else {
                    consultant = Consultant.CONSULTANT_C;
                }

                LocalDate reservationDate = LocalDate.now().plusDays(i * 2 + j);
                LocalTime reservationTime = LocalTime.of(8 + i, 0).plusMinutes(j * 15);

                Reservation reservation = new Reservation(
                        customer.getName(),
                        consultant,
                        true,
                        reservationDate,
                        reservationTime,
                        customer
                );
                reservationRepository.save(reservation);
            }


        }

        for (int i = 1; i <= 10; i++) {
            int a = i+4;
            Customer customer = new Customer("Müşteri " + a);
            customerRepository.save(customer);

            // Her müşteri için 2 rezervasyon oluştur
            for (int j = 1; j <= 2; j++) {
                Consultant consultant;
                if (i % 3 == 1) {
                    consultant = Consultant.CONSULTANT_C;
                } else if (i % 3 == 2) {
                    consultant = Consultant.CONSULTANT_A;
                } else {
                    consultant = Consultant.CONSULTANT_B;
                }

                LocalDate reservationDate = LocalDate.now().plusDays(i * 2 + j);
                LocalTime reservationTime = LocalTime.of(8 + a, 0).plusMinutes(j * 15);

                Reservation reservation = new Reservation(
                        customer.getName(),
                        consultant,
                        true,
                        reservationDate,
                        reservationTime,
                        customer
                );
                reservationRepository.save(reservation);
            }


        }
    }
}
