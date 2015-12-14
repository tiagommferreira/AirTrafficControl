package AirTrafficControl;

import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ATCRadar radar = new ATCRadar(20);

        Scanner in = new Scanner(System.in);
        int num = -1;

        while (num != 4) {
            System.out.println();
            System.out.println("1 - Move");
            System.out.println("2 - Change Airplane Objective");
            System.out.println("3 - Print Radar Information");
            System.out.println("4 - Exit");
            System.out.println("Choose next action: ");

            num = in.nextInt();

            if (num == 1) {
                radar.move();
            } else if (num == 2) {
                listAirplanes();

                int id = in.nextInt();

                System.out.println();
                System.out.println("1 - Hold");
                System.out.println("2 - Land");
                System.out.println("3 - Exit");

                int choice = in.nextInt();

                if (choice == 1) {
                    radar.getAirplane(id).setObjective(AirTrafficControl.quotes.HoldQuote.getInstance());
                } else if (choice == 2) {
                    radar.getAirplane(id).setObjective(AirTrafficControl.quotes.LandQuote.getInstance());
                } else if (choice == 3) {
                    radar.getAirplane(id).setObjective(AirTrafficControl.quotes.ExitQuote.getInstance());
                }
            } else if(num == 3) {
                System.out.println(radar.getRadarInfo());
            }
        }


    }

    private static void listAirplanes() {
        System.out.println();
        int i = 1;
        for (java.lang.Object o : ATCRadar.radar) {
            if (o instanceof Airplane) {
                System.out.println(i + " - Airplane " + ((Airplane) o).getId());
            }

            i++;
        }
    }
}
