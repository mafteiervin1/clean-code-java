package victor.training.refactoring;

import lombok.Data;

public class CombineFunctionsIntoTransform {
    public String generateQRCode(String code) {
        return "QR" + code;
    }

    public String getAddress(long eventId) {
        // Call Repo or External Service
        return "Location Details of event " + eventId;
    }
    // ----------- a line -------------

    public String generateTicket(Ticket ticket) {
        String invoice;
        invoice = "Invoice for " + ticket.getCustomerName() + "\n";
        invoice += "QR Code: " + generateQRCode(ticket.getCode()) + "\n";
        invoice += "Address: " + getAddress(ticket.getEventId()) + "\n";
        invoice += "Please arrive 20 minutes before the start of the event\n";
        invoice += "In case of emergency, call 0899898989\n";
        return invoice;
    }
}


// ----- SUPPORTING, DUMMY CODE ------
@Data
class Ticket {
    private final String customerName;
    private final String code;
    private final long eventId;
}