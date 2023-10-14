package esselife.backend.esselife.backend.entity.service;

import org.springframework.stereotype.Service;
import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));

        existingReservation.setConsultant(updatedReservation.getConsultant());
        existingReservation.setReservationCompleted(updatedReservation.isReservationCompleted());
        existingReservation.setReservationDate(updatedReservation.getReservationDate());
        existingReservation.setReservationTime(updatedReservation.getReservationTime());
        existingReservation.setCustomer(updatedReservation.getCustomer());

        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}