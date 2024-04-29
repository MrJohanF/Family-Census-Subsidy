import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de familias:");
        int numeroFamilias = scanner.nextInt();

        double[] totalAgua = new double[numeroFamilias];
        double[] totalLuz = new double[numeroFamilias];
        double[] totalGas = new double[numeroFamilias];

        for (int i = 0; i < numeroFamilias; i++) {
            System.out.println("Familia " + (i + 1) + ":");
            System.out.println("Ingrese el valor del consumo de agua:");
            double agua = scanner.nextDouble();
            System.out.println("Ingrese el valor del consumo de luz:");
            double luz = scanner.nextDouble();
            System.out.println("Ingrese el valor del consumo de gas:");
            double gas = scanner.nextDouble();
            System.out.println("Ingrese el estrato (1, 2, 3 o más):");
            int estrato = scanner.nextInt();

            // Calcular descuentos según el estrato
            double descuentoAgua = calcularDescuento(agua, estrato);
            double descuentoLuz = calcularDescuento(luz, estrato);
            double descuentoGas = calcularDescuento(gas, estrato);

            totalAgua[i] = agua - descuentoAgua;
            totalLuz[i] = luz - descuentoLuz;
            totalGas[i] = gas - descuentoGas;
        }

        // Sumar totales de cada servicio
        double sumaTotalAgua = 0;
        double sumaTotalLuz = 0;
        double sumaTotalGas = 0;
        for (int i = 0; i < numeroFamilias; i++) {
            sumaTotalAgua += totalAgua[i];
            sumaTotalLuz += totalLuz[i];
            sumaTotalGas += totalGas[i];
        }

        // Mostrar totales
        System.out.println("Total a pagar por servicio:");
        System.out.println("Agua: $" + sumaTotalAgua);
        System.out.println("Luz: $" + sumaTotalLuz);
        System.out.println("Gas: $" + sumaTotalGas);

        scanner.close();
    }

    public static double calcularDescuento(double monto, int estrato) {
        if (estrato == 1) {
            return monto * 0.20;
        } else if (estrato == 2) {
            return monto * 0.15;
        } else {
            return monto * 0.09;
        }


    }
}