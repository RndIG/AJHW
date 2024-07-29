package com.ajhw.tickets;


import com.ajhw.annotations.NullableWarning;
import com.ajhw.annotations.NullableWarningProcessor;
import com.ajhw.utils.Printable;
import com.ajhw.utils.StadiumSector;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class Ticket implements Printable {

    @NullableWarning
    private Integer id;
    private final String venue;
    private final Integer eventCode;
    private Long time;
    private final Boolean onPromo;
    private StadiumSector stadiumSector;
    private final Float allowedWeight;
    private final BigDecimal price;
    private final Long creationTime;


    //Limited ticket constructor as per HW2
    public Ticket( String venue, Integer eventCode, Long time, BigDecimal price) {
        this(null, venue, eventCode, time, null, null, null, price);

    }


    public Ticket(Integer id, String venue, Integer eventCode, Long time, Boolean onPromo, StadiumSector stadiumSector, Float allowedWeight, BigDecimal price) {
        this.id = id;
        this.venue = venue;
        this.eventCode = eventCode;
        this.time = time;
        this.onPromo = onPromo;
        this.stadiumSector = stadiumSector;
        this.allowedWeight = allowedWeight;
        this.price = price;
        this.creationTime = LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC);
        NullableWarningProcessor checker = new NullableWarningProcessor();
        checker.checkFields(this);
    }

    public Ticket() {
        this.id = null;
        this.venue = null;
        this.eventCode = null;
        this.time = null;
        this.onPromo = null;
        this.stadiumSector = null;
        this.allowedWeight = null;
        this.price = null;
        this.creationTime = null;
        NullableWarningProcessor checker = new NullableWarningProcessor();
        checker.checkFields(this);
    }




    public String getVenue() {
        return venue;
    }

    public Integer getEventCode() {
        return eventCode;
    }

    public Long getTime() {
        return time;
    }

    public Boolean isOnPromo() {
        return onPromo;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public Float getAllowedWeight() {
        return allowedWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getCreationTime() {
        return creationTime;
    }



    public void setTime(Long time) {
        this.time = time;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }



    public Integer getId () {
        return this.id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public void shared(Integer phoneNumber){
        System.out.println("shared via phonenumber");
    }
    public void shared(Integer phoneNumber, String email){
        System.out.println("Shared via phonenumber and email");
    }

    @Override
    public String toString() {

        StringBuilder textRepresentation = new StringBuilder();
        textRepresentation.append("Ticket[ID:")
                .append(Objects.toString(this.id, "null"))
                .append(", Venue: ")
                .append(Objects.toString(this.venue, "null"))
                .append(", Event code: ")
                .append(Objects.toString(this.eventCode, "null"))
                .append(", Time of event: ")
                .append(Objects.toString(Instant.ofEpochSecond(this.time).truncatedTo(ChronoUnit.MINUTES), "null"))
                .append(", Promo: ")
                .append(Objects.toString(this.onPromo , "null"))
                .append(", Stadium sector: ")
                .append(Objects.toString(this.stadiumSector, "null"))
                .append(", Allowed carry-on weight: ")
                .append(Objects.toString(this.allowedWeight, "0.00"))
                .append(" kg, Price: ")
                .append(Objects.toString(this.price.setScale(2), "null"))
                .append("$, Ticket creation time: ")
                .append(Objects.toString(Instant.ofEpochSecond(this.creationTime), "null"))
                .append("]");
        return textRepresentation.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket)o;
        return (this.id.equals(other.id)
                && this.venue.equals(other.venue)
                && this.eventCode.equals(other.eventCode)
                && this.time.equals(other.time));
    }

    @Override
    public final int hashCode() {
        int result = 19;
        if (id != null) {
            result = 31 * result + id.hashCode();
        }
        if (venue != null) {
            result = 31 * result + venue.hashCode();
        }
        if (eventCode != null) {
            result = 31 * result + eventCode.hashCode();
        }
        if (time != null) {
            result = 31 * result + time.hashCode();
        }
        return result;
    }

}
