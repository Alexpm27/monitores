package com.example.terminal.utilities;

public class Username {
    private static final String[] NAMES = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
            "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
            "Caritina", "Carlota", "Baltazar"};
    private static final String[] LASTNAMES = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
            "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
            "Grigalva" };
    public static String generateUsername() {
        String fullName = NAMES[(int) (Math.floor(Math.random() * ((NAMES.length - 1) - 0 + 1) + 0))] + " "
                + LASTNAMES[(int) (Math.floor(Math.random() * ((LASTNAMES.length - 1) - 0 + 1) + 0))];

        return fullName;
    }
}
