package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class AirplaneTest {
    private Airplane a = new Airplane(1L, 1L, 1L, new Position(5L, 5L));

    public AirplaneTest() {
    }

    private void assertTrue(final Boolean cond) {
        return;
    }

    private void testMove() {
        a.move();

        Boolean andResult_34 = false;

        if (Utils.equals(a.position.x, 5L)) {
            if (Utils.equals(a.position.y, 6L)) {
                andResult_34 = true;
            }
        }

        assertTrue(andResult_34);

        a.move();

        Boolean andResult_35 = false;

        if (Utils.equals(a.position.x, 5L)) {
            if (Utils.equals(a.position.y, 7L)) {
                andResult_35 = true;
            }
        }

        assertTrue(andResult_35);
    }

    private void testRotate() {
        a.rotate("CW");
        assertTrue(Utils.equals(a.getDirection(), 2L));
        a.rotate("CCW");
        a.rotate("CCW");
        assertTrue(Utils.equals(a.getDirection(), 8L));
    }

    private void testMoveWithRotate() {
        a.rotate("CW");
        a.move();

        Boolean andResult_36 = false;

        if (Utils.equals(a.getDirection(), 2L)) {
            Boolean andResult_37 = false;

            if (Utils.equals(a.position.x, 6L)) {
                if (Utils.equals(a.position.y, 6L)) {
                    andResult_37 = true;
                }
            }

            if (andResult_37) {
                andResult_36 = true;
            }
        }

        assertTrue(andResult_36);

        a.rotate("CW");
        a.rotate("CW");
        a.move();

        Boolean andResult_38 = false;

        if (Utils.equals(a.getDirection(), 4L)) {
            Boolean andResult_39 = false;

            if (Utils.equals(a.position.x, 7L)) {
                if (Utils.equals(a.position.y, 5L)) {
                    andResult_39 = true;
                }
            }

            if (andResult_39) {
                andResult_38 = true;
            }
        }

        assertTrue(andResult_38);

        a.rotate("CW");
        a.rotate("CW");
        a.rotate("CW");
        a.move();

        Boolean andResult_40 = false;

        if (Utils.equals(a.getDirection(), 7L)) {
            Boolean andResult_41 = false;

            if (Utils.equals(a.position.x, 6L)) {
                if (Utils.equals(a.position.y, 5L)) {
                    andResult_41 = true;
                }
            }

            if (andResult_41) {
                andResult_40 = true;
            }
        }

        assertTrue(andResult_40);

        a.move();

        Boolean andResult_42 = false;

        if (Utils.equals(a.getDirection(), 7L)) {
            Boolean andResult_43 = false;

            if (Utils.equals(a.position.x, 5L)) {
                if (Utils.equals(a.position.y, 5L)) {
                    andResult_43 = true;
                }
            }

            if (andResult_43) {
                andResult_42 = true;
            }
        }

        assertTrue(andResult_42);
    }

    private void testLand() {
        a.setObjective(AirTrafficControl.quotes.LandQuote.getInstance(), 0L);
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        assertTrue(Utils.equals(a.getDirection(), 5L));
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        assertTrue(Utils.equals(a.getDirection(), 1L));
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        a.move();
        assertTrue(!(SetUtil.inSet(a, ATCRadar.radar)));
    }

    public static void main() {
        new AirplaneTest().testMove();
        new AirplaneTest().testRotate();
        new AirplaneTest().testMoveWithRotate();
        new AirplaneTest().testLand();
    }

    public String toString() {
        return "AirplaneTest{" + "a := " + Utils.toString(a) + "}";
    }
}
