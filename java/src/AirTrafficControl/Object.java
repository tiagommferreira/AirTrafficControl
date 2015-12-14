package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Object {
    public Position position;
    public Number id;

    public Object() {
    }

    public void setPosition(final Number newX, final Number newY) {
        position.x = newX;
        position.y = newY;
    }

    public String toString() {
        return "Object{" + "position := " + Utils.toString(position) +
        ", id := " + Utils.toString(id) + "}";
    }
}
