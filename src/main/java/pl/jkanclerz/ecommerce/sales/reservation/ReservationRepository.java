package pl.jkanclerz.ecommerce.sales.reservation;

import java.util.HashMap;
import java.util.Optional;

public class ReservationRepository {
    HashMap<String, Reservation> reservations;

    public ReservationRepository() {
        this.reservations = new HashMap<>();
    }

    public Optional<Reservation> load(String reservationId) {
        return Optional.of(reservations.get(reservationId));
    }

    public void add(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }
}
