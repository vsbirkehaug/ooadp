package data_classes;

import java.util.Arrays;

/**
 * Created by VSB on 17/11/2015.
 */
public class SingleSet extends Set {
    public SingleSet(String id, Player homePlayer1, Player awayPlayer1) {
        super(id, new Player[]{homePlayer1}, new Player[]{awayPlayer1});
    }
}
