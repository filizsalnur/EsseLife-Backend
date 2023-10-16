package esselife.backend.esselife.backend.entity.controller;
import esselife.backend.esselife.backend.entity.Customer;
import esselife.backend.esselife.backend.entity.Reservation;

import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;
import esselife.backend.esselife.backend.entity.service.CustomerService;
import esselife.backend.esselife.backend.entity.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;
    private final CustomerService customerService;
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        String customerName = reservation.getCustomerName();
        Customer existingCustomer = customerService.getCustomerByName(customerName);

        if (existingCustomer == null) {
            // Müşteri yoksa yeni müşteri oluştur
            Customer newCustomer = new Customer(customerName);
            customerService.createCustomer(newCustomer);
            reservation.setCustomer(newCustomer);
        } else {
            // Var olan müşteriye bağla
            reservation.setCustomer(existingCustomer);
        }

        Reservation createdReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }
}