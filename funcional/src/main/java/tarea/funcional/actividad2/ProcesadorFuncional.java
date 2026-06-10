package tarea.funcional.actividad2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

record Producto(String nombre, double precio) {}

public class ProcesadorFuncional {

    // Predicate<Producto> evalua una condicion; Function<Producto, String> transforma el producto.
    public List<String> procesar(
            List<Producto> productos,
            Predicate<Producto> filtro,
            Function<Producto, String> transformador) {

        List<String> resultado = new ArrayList<>();

        for (Producto p : productos) {
            if (filtro.test(p)) {
                resultado.add(transformador.apply(p));
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        ProcesadorFuncional proc = new ProcesadorFuncional();
        List<Producto> lista = List.of(
                new Producto("Laptop", 1200),
                new Producto("Mouse", 25),
                new Producto("Monitor", 350)
        );

        // Predicate filtra productos caros y Function transforma el producto a su nombre en mayusculas.
        List<String> caros = proc.procesar(
                lista,
                p -> p.precio() > 100,
                p -> p.nombre().toUpperCase()
        );
        System.out.println(caros);

        // Method reference: Producto::nombre equivale a p -> p.nombre().
        List<String> nombres = proc.procesar(
                lista,
                p -> p.precio() > 0,
                Producto::nombre
        );
        System.out.println("Nombres con method reference: " + nombres);

        List<String> preciosFormateados = proc.procesar(
                lista,
                p -> p.precio() > 100,
                p -> String.format("$%.2f", p.precio())
        );
        System.out.println("Precios: " + preciosFormateados);
    }
}
