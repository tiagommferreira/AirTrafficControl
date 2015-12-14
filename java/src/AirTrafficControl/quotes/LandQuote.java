package AirTrafficControl.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class LandQuote {
    private static int hc = 0;
    private static LandQuote instance = null;

    public LandQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static LandQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new LandQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof LandQuote;
    }

    public String toString() {
        return "<Land>";
    }
}
