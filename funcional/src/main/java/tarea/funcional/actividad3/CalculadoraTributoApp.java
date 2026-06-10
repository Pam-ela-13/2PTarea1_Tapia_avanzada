package tarea.funcional.actividad3;

import java.util.List;

@FunctionalInterface
interface CalculadoraTributo {
    double calcularImpuesto(double monto, double tasa);

    default void mostrarResultado(double monto, double tasa) {
        System.out.printf(
                "Monto: %.2f, Tasa: %.2f%%, Impuesto: %.2f%n",
                monto,
                tasa * 100,
                calcularImpuesto(monto, tasa)
        );
    }
}

record Factura(String concepto, double monto) {}

public class CalculadoraTributoApp {

    public static void main(String[] args) {
        CalculadoraTributo iva = (monto, tasa) -> monto * 0.15;
        CalculadoraTributo retencion = (monto, tasa) -> monto * 0.02;
        CalculadoraTributo impuestoVariable = (monto, tasa) -> monto * tasa;

        List<Factura> facturas = List.of(
                new Factura("Venta producto A", 1000),
                new Factura("Servicio consultoria", 2500),
                new Factura("Venta producto B", 750),
                new Factura("Mantenimiento", 1200),
                new Factura("Capacitacion", 3000)
        );

        System.out.println("=== CALCULO DE IMPUESTOS ===\n");

        System.out.println("--- IVA 15% ---");
        facturas.forEach(f -> iva.mostrarResultado(f.monto(), 0.15));

        System.out.println("\n--- Retencion fuente 2% ---");
        facturas.forEach(f -> retencion.mostrarResultado(f.monto(), 0.02));

        System.out.println("\n--- Impuesto variable (8% personalizado) ---");
        facturas.forEach(f -> impuestoVariable.mostrarResultado(f.monto(), 0.08));

        System.out.println("\n--- Impuesto variable con diferentes tasas ---");
        facturas.forEach(f -> {
            double tasa = switch (f.concepto()) {
                case "Venta producto A", "Venta producto B" -> 0.10;
                case "Servicio consultoria" -> 0.21;
                default -> 0.05;
            };

            System.out.printf(
                    "%s: %.2f x %.0f%% = %.2f%n",
                    f.concepto(),
                    f.monto(),
                    tasa * 100,
                    impuestoVariable.calcularImpuesto(f.monto(), tasa)
            );
        });
    }
}
