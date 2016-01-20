package models;

/**
 *
 * @author VSB
 */
public class Venue {

    String name;

    public void setName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public Venue(String name) {

        setName(name);
    }
}
