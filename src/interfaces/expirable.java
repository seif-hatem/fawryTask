package interfaces;

import java.time.LocalDate;

public interface expirable {
    LocalDate getExpiryDate();
    boolean isExpired();
}
