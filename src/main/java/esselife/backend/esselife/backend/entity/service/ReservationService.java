package esselife.backend.esselife.backend.entity.service;

import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));


        existingReservation.setConsultant(updatedReservation.getConsultant());
        existingReservation.setReservationCompleted(updatedReservation.isReservationCompleted());
        existingReservation.setReservationDateTime(updatedReservation.getReservationDateTime());
        existingReservation.setCustomer(updatedReservation.getCustomer());

        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
    }
}