package com.ajhw.tickets;


import com.ajhw.annotations.NullableWarning;
import com.ajhw.annotations.NullableWarningProcessor;
import com.ajhw.utils.StadiumSector;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class Ticket {

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


    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
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

    private String nullSafe(Object o) {
        return o == null ? "null" : o.toString();
    }



}
