package de.unistuttgart.iste.sqa.pse.sheet11.homework.cleancode;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Optional;
import java.util.Locale;

public class WeekdayComputer {
    private final LocalDate date;

    private final static String[] datePatterns = {
            "yyyy-MM-dd",
            "yyyy-M-d",
            "yy-M-d",
            "yyyy/MM/dd",
            "yyyy/M/d",
            "yy/M/d",
            "yyyy.MM.dd",
            "yyyy.M.d",
            "yy.M.d",
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

    public String getWeekdayString() {
        DayOfWeek dayOfWeek = this.date.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
