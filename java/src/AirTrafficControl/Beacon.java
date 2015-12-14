package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Beacon extends Object {
    public Beacon(final Number id1, final Position position1) {
        cg_init_Beacon_1(id1, position1);
    }

    public Beacon() {
    }

    public void cg_init_Beacon_1(final Number id1, final Position position1) {
        id = id1;
        position = position1;

        return;
    }

    public String toString() {
        return "Beacon{}";
    }
}
