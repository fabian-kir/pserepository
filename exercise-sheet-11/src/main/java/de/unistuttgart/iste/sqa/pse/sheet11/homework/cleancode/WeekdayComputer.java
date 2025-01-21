package de.unistuttgart.iste.sqa.pse.sheet11.homework.cleancode;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


public class WeekdayComputer {
    private final LocalDate date;

    private final static String[] datePatterns = {
            "yyyy-MM-dd",
            "yyyy/MM/dd",
            "yyyy.MM.dd",
    };

    public WeekdayComputer(LocalDate date) {
        this.date = date;
    }

    public static WeekdayComputer fromInputString (String inputString) throws NoValidPatternInInputStringException {
        Optional<LocalDate> date = Optional.empty();

        for (String pattern : datePatterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                // Attempt to parse as LocalDate
                date = Optional.of(LocalDate.parse(inputString, formatter));
                break;

            } catch (DateTimeParseException e) {
                // Format nicht erkannt
            }
        }

        if (date.isPresent()) {
            return new WeekdayComputer(date.get());
        } else {
            throw new NoValidPatternInInputStringException("Could not find a valid Date pattern in the given input String.");
        }
    }

    public String getWeekday() {
        return new DateFormatSymbols().getWeekdays()[this.date.getDay()]; // TODO
    }
}
