package AirTrafficControl.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class BeaconQuote {
    private static int hc = 0;
    private static BeaconQuote instance = null;

    public BeaconQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static BeaconQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new BeaconQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof BeaconQuote;
    }

    public String toString() {
        return "<Beacon>";
    }
}
