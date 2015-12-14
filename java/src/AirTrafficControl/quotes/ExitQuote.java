package AirTrafficControl.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ExitQuote {
    private static int hc = 0;
    private static ExitQuote instance = null;

    public ExitQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static ExitQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new ExitQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof ExitQuote;
    }

    public String toString() {
        return "<Exit>";
    }
}
