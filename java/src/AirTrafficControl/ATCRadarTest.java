package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ATCRadarTest {
    private ATCRadar r = new ATCRadar(15L);

    public ATCRadarTest() {
    }

    private void assertTrue(final Boolean cond) {
        return;
    }

    private void test() {
        r.move();
    }

    public static void main() {
        new ATCRadarTest().test();
    }

    public String toString() {
        return "ATCRadarTest{" + "r := " + Utils.toString(r) + "}";
    }
}
