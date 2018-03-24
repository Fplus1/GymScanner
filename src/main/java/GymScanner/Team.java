package GymScanner;

public enum Team {
    MYSTIC,
    VALOR,
    INSTINCT;

    public static int getTeamId(Team team) {
        switch (team){
            case MYSTIC: return 1;
            case VALOR: return 2;
            case INSTINCT: return 3;
            default: return 0;
        }
    }

    public static Team getTeam(byte teamId){
        switch (teamId){
            case 1: return Team.MYSTIC;
            case 2: return Team.VALOR;
            case 3: return Team.INSTINCT;
            default: return null;
        }
    }
}
