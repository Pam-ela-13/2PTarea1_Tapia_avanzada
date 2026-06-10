package tarea.funcional.actividad4;

import java.util.List;
import java.util.function.Function;

public class ComposicionCadenas {

    public static void main(String[] args) {
        List<String> nombres = List.of(
                "  juan perez  ",
                "  MARIA GONZALEZ  ",
                "  carlos rodriguez  ",
                "  ANA MARTINEZ  "
        );

        Function<String, String> trim = String::trim;
        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> capitalize = s -> {
            if (s.isEmpty()) {
                return s;
            }
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        };
        Function<String, String> prefijoSrSra = s -> "Sr./Sra. " + s;

        System.out.println("=== ORDEN 1 (trim -> minusculas -> capitalizar -> prefijo) ===");
        Function<String, String> pipeline1 = trim
                .andThen(toLowerCase)
                .andThen(capitalize)
                .andThen(prefijoSrSra);

        nombres.forEach(nombre -> System.out.println(pipeline1.apply(nombre)));

        System.out.println("\n=== ORDEN 2 (trim -> minusculas -> prefijo -> capitalizar) ===");
        Function<String, String> pipeline2 = trim
                .andThen(toLowerCase)
                .andThen(prefijoSrSra)
                .andThen(capitalize);

        nombres.forEach(nombre -> System.out.println(pipeline2.apply(nombre)));

        System.out.println("\n=== ORDEN 3 (Usando compose - orden inverso) ===");
        Function<String, String> pipeline3 = prefijoSrSra
                .compose(capitalize)
                .compose(toLowerCase)
                .compose(trim);

        nombres.forEach(nombre -> System.out.println(pipeline3.apply(nombre)));

        System.out.println("\n=== EXPLICACION DEL CAMBIO ===");
        System.out.println("Orden 1: capitaliza el nombre antes de agregar el prefijo.");
        System.out.println("Orden 2: agrega el prefijo antes de capitalizar; por eso el nombre queda en minusculas.");
        System.out.println("Orden 3: produce un resultado equivalente al Orden 1 usando compose().");
    }
}
