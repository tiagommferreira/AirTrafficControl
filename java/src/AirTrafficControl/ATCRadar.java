package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ATCRadar {
    public static VDMSet radar = SetUtil.set();
    public static Number size = 20L;
    public static Runway runway = new Runway(new Position(11L, 11L), 7L);

    public ATCRadar(final Number s) {
        cg_init_ATCRadar_1(s);
    }

    public ATCRadar() {
    }

    public void cg_init_ATCRadar_1(final Number s) {
        size = s;
        radar = SetUtil.union(Utils.copy(radar),
                SetUtil.set(new Airplane(1L, 3L, 1L, new Position(5L, 5L))));
        //getAirplane(1L)
        //    .setObjective(AirTrafficControl.quotes.LandQuote.getInstance());
        radar = SetUtil.union(Utils.copy(radar),
                SetUtil.set(new Airplane(2L, 3L, 1L, new Position(15L, 5L))));
        //getAirplane(2L)
        //    .setObjective(AirTrafficControl.quotes.LandQuote.getInstance());
        radar = SetUtil.union(Utils.copy(radar),
                SetUtil.set(new Airplane(3L, 5L, 1L, new Position(6L, 15L))));
        //getAirplane(3L)
        //        .setObjective(AirTrafficControl.quotes.LandQuote.getInstance());
        radar = SetUtil.union(Utils.copy(radar),
                SetUtil.set(new Beacon(4L, new Position(9L, 9L))));
        radar = SetUtil.union(Utils.copy(radar), SetUtil.set(runway));
        print();

        return;
    }

    public void addObject(final Object object) {
        radar = SetUtil.union(Utils.copy(radar), SetUtil.set(object));
    }

    public Airplane getAirplane(final Number id) {
        for (Iterator iterator_1 = radar.iterator(); iterator_1.hasNext();) {
            Object object = (Object) iterator_1.next();
            Boolean andResult_1 = false;

            if (object instanceof Airplane) {
                if (Utils.equals(object.id, id)) {
                    andResult_1 = true;
                }
            }

            if (andResult_1) {
                return (Airplane) object;
            }
        }

        return null;
    }

    public static Beacon getBeacon(final Number id) {
        for (Iterator iterator_2 = radar.iterator(); iterator_2.hasNext();) {
            Object object = (Object) iterator_2.next();
            Boolean andResult_2 = false;

            if (object instanceof Beacon) {
                if (Utils.equals(object.id, id)) {
                    andResult_2 = true;
                }
            }

            if (andResult_2) {
                return (Beacon) object;
            }
        }

        return null;
    }

     public Number getNumAirplanes() {
        Number numAirplanes = 0L;

        for (Iterator iterator_2 = radar.iterator(); iterator_2.hasNext();) {
            Object object = (Object) iterator_2.next();

            if (object instanceof Airplane) {
                numAirplanes = numAirplanes.longValue() + 1L;
            }
        }

        return numAirplanes;
    }

     public VDMMap getRadarInfo() {
        VDMMap m1 = MapUtil.map(new Maplet("number of airplanes",
                    getNumAirplanes()));

        return Utils.copy(m1);
    }

    public void checkAirplaneSafety() {
        for (Iterator iterator_3 = radar.iterator(); iterator_3.hasNext();) {
            Object object = (Object) iterator_3.next();

            if (object instanceof Airplane) {
                VDMSet testSet = SetUtil.diff(Utils.copy(radar),
                        SetUtil.set(object));

                for (Iterator iterator_4 = testSet.iterator();
                        iterator_4.hasNext();) {
                    Object airplane = (Object) iterator_4.next();

                    if (airplane instanceof Airplane) {
                        Boolean andResult_3 = false;

                        if (Utils.abs(airplane.position.x.longValue() -
                                    object.position.x.longValue()) < 3L) {
                            if (Utils.abs(airplane.position.y.longValue() -
                                        object.position.y.longValue()) < 3L) {
                                andResult_3 = true;
                            }
                        }

                        if (andResult_3) {
                            Airplane a = (Airplane) object;
                            Airplane b = (Airplane) airplane;
                            Boolean orResult_1 = false;

                            Boolean andResult_4 = false;

                            if (Utils.equals(a.getDirection(), 1L)) {
                                if (Utils.equals(b.getDirection(), 5L)) {
                                    andResult_4 = true;
                                }
                            }

                            if (andResult_4) {
                                orResult_1 = true;
                            } else {
                                Boolean orResult_2 = false;

                                Boolean andResult_5 = false;

                                if (Utils.equals(a.getDirection(), 5L)) {
                                    if (Utils.equals(b.getDirection(), 1L)) {
                                        andResult_5 = true;
                                    }
                                }

                                if (andResult_5) {
                                    orResult_2 = true;
                                } else {
                                    Boolean orResult_3 = false;

                                    Boolean andResult_6 = false;

                                    if (Utils.equals(a.getDirection(), 8L)) {
                                        if (Utils.equals(b.getDirection(), 6L)) {
                                            andResult_6 = true;
                                        }
                                    }

                                    if (andResult_6) {
                                        orResult_3 = true;
                                    } else {
                                        Boolean orResult_4 = false;

                                        Boolean andResult_7 = false;

                                        if (Utils.equals(a.getDirection(), 6L)) {
                                            if (Utils.equals(b.getDirection(),
                                                        8L)) {
                                                andResult_7 = true;
                                            }
                                        }

                                        if (andResult_7) {
                                            orResult_4 = true;
                                        } else {
                                            Boolean orResult_5 = false;

                                            Boolean andResult_8 = false;

                                            if (Utils.equals(a.getDirection(),
                                                        3L)) {
                                                if (Utils.equals(
                                                            b.getDirection(), 7L)) {
                                                    andResult_8 = true;
                                                }
                                            }

                                            if (andResult_8) {
                                                orResult_5 = true;
                                            } else {
                                                Boolean orResult_6 = false;

                                                Boolean andResult_9 = false;

                                                if (Utils.equals(
                                                            a.getDirection(), 7L)) {
                                                    if (Utils.equals(
                                                                b.getDirection(),
                                                                3L)) {
                                                        andResult_9 = true;
                                                    }
                                                }

                                                if (andResult_9) {
                                                    orResult_6 = true;
                                                } else {
                                                    Boolean orResult_7 = false;

                                                    Boolean andResult_10 = false;

                                                    if (Utils.equals(
                                                                a.getDirection(),
                                                                2L)) {
                                                        if (Utils.equals(
                                                                    b.getDirection(),
                                                                    6L)) {
                                                            andResult_10 = true;
                                                        }
                                                    }

                                                    if (andResult_10) {
                                                        orResult_7 = true;
                                                    } else {
                                                        Boolean orResult_8 = false;

                                                        Boolean andResult_11 = false;

                                                        if (Utils.equals(
                                                                    a.getDirection(),
                                                                    6L)) {
                                                            if (Utils.equals(
                                                                        b.getDirection(),
                                                                        2L)) {
                                                                andResult_11 = true;
                                                            }
                                                        }

                                                        if (andResult_11) {
                                                            orResult_8 = true;
                                                        } else {
                                                            Boolean orResult_9 = false;

                                                            Boolean andResult_12 =
                                                                false;

                                                            if (Utils.equals(
                                                                        a.getDirection(),
                                                                        6L)) {
                                                                if (Utils.equals(
                                                                            b.getDirection(),
                                                                            1L)) {
                                                                    andResult_12 = true;
                                                                }
                                                            }

                                                            if (andResult_12) {
                                                                orResult_9 = true;
                                                            } else {
                                                                Boolean andResult_13 =
                                                                    false;

                                                                if (Utils.equals(
                                                                            a.getDirection(),
                                                                            1L)) {
                                                                    if (Utils.equals(
                                                                                b.getDirection(),
                                                                                6L)) {
                                                                        andResult_13 = true;
                                                                    }
                                                                }

                                                                orResult_9 = andResult_13;
                                                            }

                                                            orResult_8 = orResult_9;
                                                        }

                                                        orResult_7 = orResult_8;
                                                    }

                                                    orResult_6 = orResult_7;
                                                }

                                                orResult_5 = orResult_6;
                                            }

                                            orResult_4 = orResult_5;
                                        }

                                        orResult_3 = orResult_4;
                                    }

                                    orResult_2 = orResult_3;
                                }

                                orResult_1 = orResult_2;
                            }

                            if (orResult_1) {
                                IO.print("a rodar");
                                a.rotate("CW");
                            }
                        }
                    }
                }
            }
        }
    }

    public void move() {
        checkAirplaneSafety();

        for (Iterator iterator_5 = radar.iterator(); iterator_5.hasNext();) {
            Object object = (Object) iterator_5.next();

            if (object instanceof Airplane) {
                Airplane a = (Airplane) object;

                if (a.canMove()) {
                    a.move();

                    Boolean andResult_14 = false;

                    if (Utils.equals(a.objective,
                                AirTrafficControl.quotes.LandQuote.getInstance())) {
                        Boolean andResult_15 = false;

                        if (Utils.equals(a.position.x, runway.position.x)) {
                            if (Utils.equals(a.position.y, runway.position.y)) {
                                andResult_15 = true;
                            }
                        }

                        if (andResult_15) {
                            andResult_14 = true;
                        }
                    }

                    if (andResult_14) {
                        radar = SetUtil.diff(Utils.copy(radar), SetUtil.set(a));
                    }

                    Boolean andResult_16 = false;

                    if (Utils.equals(a.objective,
                                AirTrafficControl.quotes.BeaconQuote.getInstance())) {
                        Boolean andResult_17 = false;

                        if (Utils.equals(a.position.x, runway.position.x)) {
                            if (Utils.equals(a.position.y, runway.position.y)) {
                                andResult_17 = true;
                            }
                        }

                        if (andResult_17) {
                            andResult_16 = true;
                        }
                    }

                    if (andResult_16) {
                        a.objective = AirTrafficControl.quotes.HoldQuote.getInstance();
                    }
                } else {
                    radar = SetUtil.diff(Utils.copy(radar), SetUtil.set(a));
                }
            }
        }

        print();
    }

    public void print() {
        Number x = 0L;
        Number y = size;
        Boolean found = false;
        //IO.print("<");

        Boolean whileCond_1 = true;

        while (whileCond_1) {
            whileCond_1 = !(Utils.equals(y, -1L));

            if (!(whileCond_1)) {
                break;
            }

            {
                Boolean whileCond_2 = true;

                while (whileCond_2) {
                    whileCond_2 = !(Utils.equals(x, size.longValue() + 1L));

                    if (!(whileCond_2)) {
                        break;
                    }

                    for (Iterator iterator_6 = radar.iterator();
                            iterator_6.hasNext();) {
                        Object object = (Object) iterator_6.next();
                        Boolean andResult_18 = false;

                        if (Utils.equals(object.position.x, x)) {
                            if (Utils.equals(object.position.y, y)) {
                                andResult_18 = true;
                            }
                        }

                        if (andResult_18) {
                            found = true;

                            if (object instanceof Airplane) {
                                IO.print("A");
                            } else {
                                if (object instanceof Beacon) {
                                    IO.print("B");
                                } else {
                                    IO.print("R");
                                }
                            }
                        }
                    }

                    if (!(Utils.equals(found, true))) {
                        IO.print(" ");
                    }

                    found = false;
                    x = x.longValue() + 1L;
                }

                x = 0L;
                IO.print("\n");
                y = y.doubleValue() - 1L;
            }
        }
    }

    public String toString() {
        return "ATCRadar{" + "radar := " + Utils.toString(radar) +
        ", size := " + Utils.toString(size) + ", runway := " +
        Utils.toString(runway) + "}";
    }
}
