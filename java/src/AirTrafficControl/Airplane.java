package AirTrafficControl;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Airplane extends Object {
    private Number direction;
    private Number speed;
    public java.lang.Object objective = AirTrafficControl.quotes.HoldQuote.getInstance();
    private Number nextDirection;
    private Number beaconId;
    private Number entryBeacon;

    public Airplane(final Number id1, final Number direction1,
        final Number speed1, final Position position1) {
        cg_init_Airplane_1(id1, direction1, speed1, position1);
    }

    public Airplane() {
    }

    public void cg_init_Airplane_1(final Number id1, final Number direction1,
        final Number speed1, final Position position1) {
        id = id1;
        direction = direction1;
        setObjective(AirTrafficControl.quotes.HoldQuote.getInstance(), 4L);
        speed = speed1;
        position = position1;
        entryBeacon = 0L;
        nextDirection = Utils.mod(ATCRadar.runway.entryDir.longValue() + 4L, 8L);

        return;
    }

    public Number getId() {
        return id;
    }

    public Number getDirection() {
        return direction;
    }

    public Number getSpeed() {
        return speed;
    }

    public void setObjective(final java.lang.Object o, final Number i) {
        objective = o;
        beaconId = i;
    }

    public void setObjective(final java.lang.Object o) {
        objective = o;
    }

    public void setDirection(final Number dir) {
        direction = dir;
    }

    public void setSpeed(final Number s) {
        speed = s;
    }

    public void rotate(final String orientation) {
        if (Utils.equals(orientation, "CW")) {
            direction = direction.longValue() + 1L;

            if (Utils.equals(direction, 9L)) {
                direction = 1L;
            }
        } else {
            direction = direction.longValue() - 1L;

            if (Utils.equals(direction, 0L)) {
                direction = 8L;
            }
        }
    }

    public void move() {
        if (Utils.equals(direction, 1L)) {
            super.setPosition(position.x,
                position.y.longValue() + speed.longValue());
        } else {
            if (Utils.equals(direction, 2L)) {
                super.setPosition(position.x.longValue() + speed.longValue(),
                    position.y.longValue() + speed.longValue());
            } else {
                if (Utils.equals(direction, 3L)) {
                    super.setPosition(position.x.longValue() +
                        speed.longValue(), position.y);
                } else {
                    if (Utils.equals(direction, 4L)) {
                        super.setPosition(position.x.longValue() +
                            speed.longValue(),
                            position.y.longValue() - speed.longValue());
                    } else {
                        if (Utils.equals(direction, 5L)) {
                            super.setPosition(position.x,
                                position.y.longValue() - speed.longValue());
                        } else {
                            if (Utils.equals(direction, 6L)) {
                                super.setPosition(position.x.longValue() -
                                    speed.longValue(),
                                    position.y.longValue() - speed.longValue());
                            } else {
                                if (Utils.equals(direction, 7L)) {
                                    super.setPosition(position.x.longValue() -
                                        speed.longValue(), position.y);
                                } else {
                                    if (Utils.equals(direction, 8L)) {
                                        super.setPosition(position.x.longValue() -
                                            speed.longValue(),
                                            position.y.longValue() +
                                            speed.longValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (Utils.equals(objective,
                    AirTrafficControl.quotes.LandQuote.getInstance())) {
            lineUpWithRunway();
        } else {
            if (Utils.equals(objective,
                        AirTrafficControl.quotes.BeaconQuote.getInstance())) {
                goToBeacon();
            } else {
                if (Utils.equals(objective,
                            AirTrafficControl.quotes.ExitQuote.getInstance())) {
                    lineUpExit();
                }
            }
        }
    }

    public void goToBeacon() {
        Beacon b = ATCRadar.getBeacon(beaconId);

        if (Utils.equals(entryBeacon, 0L)) {
            Boolean orResult_11 = false;

            if (Utils.equals(direction, 8L)) {
                orResult_11 = true;
            } else {
                Boolean orResult_12 = false;

                if (Utils.equals(direction, 7L)) {
                    orResult_12 = true;
                } else {
                    orResult_12 = Utils.equals(direction, 6L);
                }

                orResult_11 = orResult_12;
            }

            if (orResult_11) {
                entryBeacon = 3L;
            } else {
                Boolean orResult_13 = false;

                if (Utils.equals(direction, 2L)) {
                    orResult_13 = true;
                } else {
                    Boolean orResult_14 = false;

                    if (Utils.equals(direction, 3L)) {
                        orResult_14 = true;
                    } else {
                        orResult_14 = Utils.equals(direction, 4L);
                    }

                    orResult_13 = orResult_14;
                }

                if (orResult_13) {
                    entryBeacon = 7L;
                } else {
                    if (Utils.equals(direction, 1L)) {
                        entryBeacon = 5L;
                    } else {
                        if (Utils.equals(direction, 5L)) {
                            entryBeacon = 1L;
                        }
                    }
                }
            }

            if (Utils.equals(entryBeacon, 1L)) {
                nextDirection = 5L;
            } else {
                if (Utils.equals(entryBeacon, 3L)) {
                    nextDirection = 7L;
                } else {
                    if (Utils.equals(entryBeacon, 5L)) {
                        nextDirection = 1L;
                    } else {
                        if (Utils.equals(entryBeacon, 7L)) {
                            nextDirection = 3L;
                        }
                    }
                }
            }

            lineUp(entryBeacon, b);
        } else {
            lineUp(entryBeacon, b);
        }
    }

    public void lineUp(final Number entry, final Object o) {
        if (Utils.equals(entry, 5L)) {
            if (!(Utils.equals(direction, nextDirection))) {
                if (o.position.x.longValue() < position.x.longValue()) {
                    rotate("CCW");
                } else {
                    if (o.position.x.longValue() > position.x.longValue()) {
                        rotate("CW");
                    } else {
                        if (Utils.equals(direction, 6L)) {
                            rotate("CCW");
                        } else {
                            rotate("CW");
                        }
                    }
                }
            } else {
                if (Utils.equals(ATCRadar.size.longValue() -
                            position.y.longValue(), speed)) {
                    if (o.position.x.longValue() < position.x.longValue()) {
                        rotate("CCW");
                        nextDirection = Utils.mod(nextDirection.longValue() +
                                6L, 8L);
                    } else {
                        rotate("CW");
                        nextDirection = Utils.mod(nextDirection.longValue() +
                                2L, 8L);
                    }
                } else {
                    if (Utils.equals(position.x.longValue() -
                                o.position.x.longValue(), speed)) {
                        rotate("CCW");
                        nextDirection = Utils.mod(nextDirection.longValue() +
                                6L, 8L);
                    } else {
                        if (Utils.equals(position.x.longValue() -
                                    o.position.x.longValue(), -speed.longValue())) {
                            rotate("CW");
                            nextDirection = Utils.mod(nextDirection.longValue() +
                                    2L, 8L);
                        }
                    }
                }
            }
        } else {
            if (Utils.equals(entry, 1L)) {
                if (!(Utils.equals(direction, nextDirection))) {
                    if (o.position.x.longValue() > position.x.longValue()) {
                        rotate("CCW");
                    } else {
                        if (o.position.x.longValue() < position.x.longValue()) {
                            rotate("CW");
                        } else {
                            if (Utils.equals(direction, 2L)) {
                                rotate("CCW");
                            } else {
                                rotate("CW");
                            }
                        }
                    }
                } else {
                    if (Utils.equals(position.y, speed)) {
                        if (o.position.x.longValue() < position.x.longValue()) {
                            rotate("CW");
                            nextDirection = Utils.mod(nextDirection.longValue() +
                                    2L, 8L);
                        } else {
                            rotate("CCW");
                            nextDirection = Utils.mod(nextDirection.longValue() -
                                    2L, 8L);
                        }
                    } else {
                        if (Utils.equals(o.position.x.longValue() -
                                    position.x.longValue(), speed)) {
                            rotate("CCW");
                            nextDirection = Utils.mod(nextDirection.longValue() -
                                    2L, 8L);
                        } else {
                            if (Utils.equals(o.position.x.longValue() -
                                        position.x.longValue(),
                                        -speed.longValue())) {
                                rotate("CW");
                                nextDirection = Utils.mod(nextDirection.longValue() +
                                        2L, 8L);
                            }
                        }
                    }
                }
            } else {
                if (Utils.equals(entry, 3L)) {
                    if (!(Utils.equals(direction, nextDirection))) {
                        if (o.position.y.longValue() > position.y.longValue()) {
                            rotate("CW");
                        } else {
                            if (o.position.y.longValue() > position.y.longValue()) {
                                rotate("CCW");
                            } else {
                                if (Utils.equals(direction, 2L)) {
                                    rotate("CW");
                                } else {
                                    rotate("CCW");
                                }
                            }
                        }
                    } else {
                        if (Utils.equals(position.x, speed)) {
                            if (o.position.y.longValue() > position.y.longValue()) {
                                rotate("CW");
                                nextDirection = Utils.mod(nextDirection.longValue() +
                                        2L, 8L);
                            } else {
                                rotate("CCW");
                                nextDirection = Utils.mod(nextDirection.longValue() -
                                        2L, 8L);
                            }
                        } else {
                            if (Utils.equals(position.y.longValue() -
                                        o.position.y.longValue(), speed)) {
                                rotate("CCW");
                                nextDirection = Utils.mod(nextDirection.longValue() -
                                        2L, 8L);
                            } else {
                                if (Utils.equals(position.y.longValue() -
                                            o.position.y.longValue(),
                                            -speed.longValue())) {
                                    rotate("CW");
                                    nextDirection = Utils.mod(nextDirection.longValue() +
                                            2L, 8L);
                                }
                            }
                        }
                    }
                } else {
                    if (Utils.equals(entry, 7L)) {
                        if (!(Utils.equals(direction, nextDirection))) {
                            if (o.position.y.longValue() > position.y.longValue()) {
                                rotate("CCW");
                            } else {
                                if (o.position.y.longValue() > position.y.longValue()) {
                                    rotate("CW");
                                } else {
                                    if (Utils.equals(direction, 8L)) {
                                        rotate("CCW");
                                    } else {
                                        rotate("CW");
                                    }
                                }
                            }
                        } else {
                            if (Utils.equals(ATCRadar.size.longValue() -
                                        position.x.longValue(), speed)) {
                                if (o.position.y.longValue() > position.y.longValue()) {
                                    rotate("CCW");
                                    nextDirection = Utils.mod(nextDirection.longValue() -
                                            2L, 8L);
                                } else {
                                    rotate("CW");
                                    nextDirection = Utils.mod(nextDirection.longValue() +
                                            2L, 8L);
                                }
                            } else {
                                if (Utils.equals(position.y.longValue() -
                                            o.position.y.longValue(), speed)) {
                                    rotate("CW");
                                    nextDirection = Utils.mod(nextDirection.longValue() +
                                            2L, 8L);
                                } else {
                                    if (Utils.equals(position.y.longValue() -
                                                o.position.y.longValue(),
                                                -speed.longValue())) {
                                        rotate("CCW");
                                        nextDirection = Utils.mod(nextDirection.longValue() -
                                                2L, 8L);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void lineUpWithRunway() {
        Runway r = ATCRadar.runway;
        lineUp(r.entryDir, r);
    }

    public void lineUpExit() {
        Boolean andResult_27 = false;

        if (!(Utils.equals(direction, 1L))) {
            Boolean andResult_28 = false;

            if (!(Utils.equals(direction, 3L))) {
                Boolean andResult_29 = false;

                if (!(Utils.equals(direction, 5L))) {
                    if (!(Utils.equals(direction, 7L))) {
                        andResult_29 = true;
                    }
                }

                if (andResult_29) {
                    andResult_28 = true;
                }
            }

            if (andResult_28) {
                andResult_27 = true;
            }
        }

        if (andResult_27) {
            rotate("CW");
        }
    }

    public Boolean canMove() {
        if (Utils.equals(direction, 1L)) {
            if ((position.y.longValue() + speed.longValue()) <= ATCRadar.size.longValue()) {
                return true;
            }
        } else {
            if (Utils.equals(direction, 2L)) {
                Boolean andResult_30 = false;

                if ((position.x.longValue() + speed.longValue()) <= ATCRadar.size.longValue()) {
                    if ((position.y.longValue() + speed.longValue()) <= ATCRadar.size.longValue()) {
                        andResult_30 = true;
                    }
                }

                if (andResult_30) {
                    return true;
                }
            } else {
                if (Utils.equals(direction, 3L)) {
                    if ((position.x.longValue() + speed.longValue()) <= ATCRadar.size.longValue()) {
                        return true;
                    }
                } else {
                    if (Utils.equals(direction, 4L)) {
                        Boolean andResult_31 = false;

                        if ((position.x.longValue() + speed.longValue()) <= ATCRadar.size.longValue()) {
                            if ((position.y.longValue() - speed.longValue()) >= 0L) {
                                andResult_31 = true;
                            }
                        }

                        if (andResult_31) {
                            return true;
                        }
                    } else {
                        if (Utils.equals(direction, 5L)) {
                            if ((position.y.longValue() - speed.longValue()) >= 0L) {
                                return true;
                            }
                        } else {
                            if (Utils.equals(direction, 6L)) {
                                Boolean andResult_32 = false;

                                if ((position.x.longValue() -
                                        speed.longValue()) >= 0L) {
                                    if ((position.y.longValue() -
                                            speed.longValue()) >= 0L) {
                                        andResult_32 = true;
                                    }
                                }

                                if (andResult_32) {
                                    return true;
                                }
                            } else {
                                if (Utils.equals(direction, 7L)) {
                                    if ((position.x.longValue() -
                                            speed.longValue()) >= 0L) {
                                        return true;
                                    }
                                } else {
                                    if (Utils.equals(direction, 8L)) {
                                        Boolean andResult_33 = false;

                                        if ((position.x.longValue() -
                                                speed.longValue()) >= 0L) {
                                            if ((position.y.longValue() +
                                                    speed.longValue()) <= ATCRadar.size.longValue()) {
                                                andResult_33 = true;
                                            }
                                        }

                                        if (andResult_33) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public String toString() {
        return "Airplane{" + "direction := " + Utils.toString(direction) +
        ", speed := " + Utils.toString(speed) + ", objective := " +
        Utils.toString(objective) + ", nextDirection := " +
        Utils.toString(nextDirection) + ", beaconId := " +
        Utils.toString(beaconId) + ", entryBeacon := " +
        Utils.toString(entryBeacon) + "}";
    }
}
