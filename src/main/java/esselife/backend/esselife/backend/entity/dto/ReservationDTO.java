package esselife.backend.esselife.backend.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private String customerName;
    private String consultantName;
    private boolean reservationCompleted;
    private LocalDateTime reservationDateTime;
}