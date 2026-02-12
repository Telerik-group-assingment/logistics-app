package logisticsapp;

import logisticsapp.core.LogisticsEngineImpl;

public class Startup {
    public static void main(String[] args) {

        printBanner();
        LogisticsEngineImpl engine = new LogisticsEngineImpl();
        engine.start();
    }

    private static final String BANNER = """
================================================================================
                              LOGISTICS APP
================================================================================

   [ StartLocation ] ------------------------------------------------------> [ EndLocation ]

          ________________________________
         |                                |____
         |        DELIVERY TRUCK          |___ \\____
         |________________________________|___/____/
           O        O        O        O         O   O

   ---------------------------------------------------------------------------
                       Highway open • Deliveries moving • ETA calculated

================================================================================
Type HELP to see available commands
================================================================================
""";

    private static void printBanner() {
        System.out.println(BANNER);
    }
}
