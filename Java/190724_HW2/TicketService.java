import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TicketService {
    private static final String _ID_PATTERN = "^[a-zA-Z0-9]{4}$";
    private static final String _VENUE_PATTERN = ".{1,10}";
    private static final String _EVENTCODE_PATTERN = "\\d{3}";
    private static final String _STADIUMSECTOR_PATTERN = "[ABC]";
    private static final String _ISPROMO_PATTERN ="(?i)\\b(true|false)\\b";
    private static final String _LOCALDATETIME_PATTERN = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
    private static final String _CARRYWEIGHT_PATTERN = "\\d+(\\.\\d{1,2})?";
    private static final String _NO_PATTERN = ".*\n";

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Empty ticket test--");
        Ticket emptyTicket = new Ticket();
        System.out.println(emptyTicket);

        System.out.println("Regular ticket test--");
        String id = dataEntry("Please input ticket id", _ID_PATTERN, scan);
        String venue = dataEntry("Please input venue name (ten characters maximum):", _VENUE_PATTERN, scan);
        String eventCode = dataEntry("Please input event code (3 digit code) :", _EVENTCODE_PATTERN, scan);
        String timeString = dataEntry("Please input time of event (yyyy-mm-dd hh:mm):", _LOCALDATETIME_PATTERN, scan);
        String isPromo = dataEntry("Please check if ticket is on promo:", _ISPROMO_PATTERN, scan);
        String sector = dataEntry("Please input stadium sector(A,B or C):", _STADIUMSECTOR_PATTERN, scan);
        String maximumWeight = dataEntry("Please input maximum carry weight(in kgs with precision up two digits precision):",_CARRYWEIGHT_PATTERN, scan);
        try {
            Long time = stringToTime(timeString);
            Ticket fullTicket = new Ticket(id, venue,Integer.parseInt(eventCode), time, Boolean.parseBoolean(isPromo),sector, Float.parseFloat(maximumWeight));
            System.out.println(fullTicket);
        } catch (DateTimeParseException e) {
            System.out.println("Wrong data format! check if your date is correct!");
        }

        System.out.println("Limited ticket test--");

        String venueLimited = dataEntry("Please input venue name (ten characters maximum):", _VENUE_PATTERN, scan);
        String eventCodeLimited = dataEntry("Please input event code (3 digit code) :", _EVENTCODE_PATTERN, scan);
        String timeStringLimited = dataEntry("Please input time of event (yyyy-mm-dd hh:mm)", _LOCALDATETIME_PATTERN, scan);
        try {
            Long time = stringToTime(timeStringLimited);
            Ticket limitedTicket = new Ticket(venueLimited, Integer.parseInt(eventCodeLimited), time);
            System.out.println(limitedTicket);
        } catch (DateTimeParseException e) {
            System.out.println("Wrong data format! check if your date is correct!");
        }
    }







    static String dataEntry (String message, String pattern, Scanner scan) {
        String entry;
        do {
            System.out.println(message);
            entry = scan.nextLine();
            if (!entry.matches(pattern)) {
                System.out.println("Pattern mismatch, or invalid input. Try again!");
            }
        }while (!entry.matches(pattern));

        return entry;

    }

    static Long stringToTime (String timeInput) throws DateTimeParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(timeInput, formatter);
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }
}
