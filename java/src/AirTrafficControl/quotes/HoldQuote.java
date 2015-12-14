package AirTrafficControl.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class HoldQuote {
    private static int hc = 0;
    private static HoldQuote instance = null;

    public HoldQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static HoldQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new HoldQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof HoldQuote;
    }

    public String toString() {
        return "<Hold>";
    }
}
