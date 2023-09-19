package esselife.backend.esselife.backend.entity.service;

import esselife.backend.esselife.backend.entity.Reservation;
import esselife.backend.esselife.backend.entity.enums.Consultant;
import esselife.backend.esselife.backend.entity.repository.ReservationRepository;
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
        Reservation existingReservation = getReservationById(id);

        existingReservation.setCustomerName(updatedReservation.getCustomerName());
        existingReservation.setReservationDateTime(updatedReservation.getReservationDateTime());
        existingReservation.setConsultant(updatedReservation.getConsultant());
        existingReservation.setReservationCompleted(updatedReservation.isReservationCompleted());

        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
    }
}