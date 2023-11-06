package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {
    private LocalDate terminationInclusive;
    private long numberOfOccurrences;
    
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
         super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.terminationInclusive = terminationInclusive;
        LocalDate nStart = start.toLocalDate();
        if (frequency.equals(ChronoUnit.DAYS)) {
            numberOfOccurrences = ChronoUnit.DAYS.between(nStart, terminationInclusive) + 1;
        }
        if (frequency.equals(ChronoUnit.WEEKS)) {
            numberOfOccurrences = ChronoUnit.WEEKS.between(nStart, terminationInclusive) + 1;
        }
        if (frequency.equals(ChronoUnit.MONTHS)) {
            numberOfOccurrences = ChronoUnit.MONTHS.between(nStart, terminationInclusive) + 1;
        }

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.numberOfOccurrences = numberOfOccurrences;
        LocalDate nStart = start.toLocalDate();
        if (frequency.equals(ChronoUnit.DAYS)) {
            terminationInclusive = nStart.plusDays(numberOfOccurrences-1);
        }
        if (frequency.equals(ChronoUnit.WEEKS)) {
            terminationInclusive = nStart.plusWeeks(numberOfOccurrences-1);
        }
        if (frequency.equals(ChronoUnit.MONTHS)) {
            terminationInclusive = nStart.plusMonths(numberOfOccurrences-1);
        }
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        return this.terminationInclusive;
    }

    public long getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        return this.numberOfOccurrences;
    }
        
}
