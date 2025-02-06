package org.example.game;

public enum Roles {
    SHERIFF("Sheriff", "Serif"),
    VICE("Vice", "Pomocnik"),
    RENEGADE("Renegade", "Odpadlik"),
    OUTLAW("Outlaw","Bandita");

    public static final int SHERIFF_LIFE_BONUS = 1;

    private final String roleName;
    private  final String statsName;

    Roles(String name, String statsName) {
        this.roleName = name;
        this.statsName = statsName;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getStatsName() {
        return statsName;
    }
}
