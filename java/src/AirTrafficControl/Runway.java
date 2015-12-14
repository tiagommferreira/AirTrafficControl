package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Runway extends Object {
    public Number entryDir;

    public Runway(final Position position1, final Number e) {
        cg_init_Runway_1(position1, e);
    }

    public Runway() {
    }

    public void cg_init_Runway_1(final Position position1, final Number e) {
        position = position1;
        entryDir = e;

        return;
    }

    public String toString() {
        return "Runway{" + "entryDir := " + Utils.toString(entryDir) + "}";
    }
}
