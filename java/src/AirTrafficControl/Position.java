package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Position {
    public Number x;
    public Number y;

    public Position(final Number cordX, final Number cordY) {
        cg_init_Position_1(cordX, cordY);
    }

    public Position() {
    }

    public void cg_init_Position_1(final Number cordX, final Number cordY) {
        x = cordX;
        y = cordY;

        return;
    }

    public String toString() {
        return "Position{" + "x := " + Utils.toString(x) + ", y := " +
        Utils.toString(y) + "}";
    }
}
