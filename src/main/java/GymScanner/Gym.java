package GymScanner;

public class Gym {
    private String id;
    private String name;
    private Team team;
    private byte slotsAvailible;
    private boolean isPark;
    private String imageUrl;

    public Gym(String id, String name, Team team, byte slotsAvailible, boolean isPark, String imageUrl){
        this.id = id;
        this.name = name;
        this.team = team;
        this.slotsAvailible = slotsAvailible;
        this.isPark = isPark;
        this.imageUrl = imageUrl;
    }

    public String getId(){ return id; }
    public String getName(){ return name; }
    public Team getTeam(){ return team; }
    public byte getSlotsAvailible(){ return slotsAvailible; }
    public boolean getIsPark(){ return isPark; }
    public String getImageUrl(){ return imageUrl; }
}
