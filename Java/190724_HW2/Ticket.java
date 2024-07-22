import java.time.Instant;


public record Ticket(
        String id,
        String venue,
        Integer eventCode,
        Long time,
        Boolean isPromo,
        String stadiumSector,
        Float weightLimit,
        Long creationTime

        ) {


    public Ticket {
        if (id == null) id = "N/A";
        if (venue == null) venue = "N/A";
        if (eventCode == null) eventCode = 0;
        if (time == null) time = 0L;
        if (isPromo == null) isPromo = Boolean.FALSE;
        if (stadiumSector == null) stadiumSector = "N/A";
        if (weightLimit == null) weightLimit = 0.00f;
        if (creationTime == null) {
            creationTime = Instant.now().getEpochSecond();
        }
    }

    public  Ticket() {
        this(null, null, null, null, null, null, null, null);

    }

    //Limited ticket
    public Ticket (String venue, Integer eventCode, Long time){
        this(null, venue, eventCode, time, null, null, null,null );
    }

    //All parameters ticket
    public Ticket (String id, String venue,Integer eventCode,Long time, Boolean isPromo,String stadiumSector, Float weightLimit) {
       this(id, venue, eventCode, time,isPromo, stadiumSector, weightLimit, null);
    }
}
