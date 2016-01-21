package models;

/**
 *
 * @author VSB
 */
public class Player {

    private String name;
    private int setsPlayed = 0;
    private int setsWon = 0;

    public Player(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addSetsPlayed(int sets) {
        if (sets > 0) {
            setsPlayed = setsPlayed + sets;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addOneSetWin() {
        setsWon = setsWon + 1;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public int getSetsPlayed() {
        return setsPlayed;
    }

}
