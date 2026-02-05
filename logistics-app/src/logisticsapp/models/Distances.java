package logisticsapp.models;

import java.util.HashMap;
import java.util.Map;

public final class Distances {

        private static final Map<String, Map<String, Integer>> DISTANCES = new HashMap<>();

        private Distances() {

        }

        // static initializer !
        //„Код, който се изпълнява автоматично,
        //точно веднъж,
        //когато класът се зареди в паметта.“

        //⏰ КОГА точно се изпълнява?
        //
        //НЕ при стартиране на програмата.
        //НЕ при new.
        //
        //А когато класът се използва за първи път.

        //static блокът се изпълнява само веднъж
        //за целия живот на програмата.

        //🏗️ Какво става вътре в JVM (опростено)
        //
        //Когато Java зарежда класа:
        //
        //заделя памет за static полетата
        //
        //инициализира ги
        //
        //изпълнява static блоковете (отгоре надолу)
        //
        //класът е готов

        //Малък пример за усещане

        //public class Test {
        //
        //    static {
        //        System.out.println("STATIC BLOCK");
        //    }
        //
        //    public static void main(String[] args) {
        //        System.out.println("MAIN");
        //    }
        //}

        //Изход:
        //
        //STATIC BLOCK
        //MAIN

        static {
            add("SYD", "MEL", 877);
            add("SYD", "ADL", 1376);
            add("SYD", "ASP", 2762);
            add("SYD", "BRI", 909);
            add("SYD", "DAR", 3935);
            add("SYD", "PER", 4016);

            add("MEL", "ADL", 725);
            add("MEL", "ASP", 2255);
            add("MEL", "BRI", 1765);
            add("MEL", "DAR", 3752);
            add("MEL", "PER", 3509);

            add("ADL", "ASP", 1530);
            add("ADL", "BRI", 1927);
            add("ADL", "DAR", 3027);
            add("ADL", "PER", 2785);

            add("ASP", "BRI", 2993);
            add("ASP", "DAR", 1497);
            add("ASP", "PER", 2481);

            add("BRI", "DAR", 3426);
            add("BRI", "PER", 4311);

            add("DAR", "PER", 4025);
        }

        private static void add(String a, String b, int distance) {
            DISTANCES
                    .computeIfAbsent(a, k -> new HashMap<>())
                    .put(b, distance);

            DISTANCES
                    .computeIfAbsent(b, k -> new HashMap<>())
                    .put(a, distance);
        }

        public static Integer getDistance(String from, String to) {

            if (from.equals(to)) {
                return 0;
            }

            Map<String, Integer> inner = DISTANCES.get(from);

            if (inner == null) {
                return null;  // exception
            }

            return inner.get(to);
        }

    }
