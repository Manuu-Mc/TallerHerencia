package org.example;
import java.util.ArrayList;

public class Empresa {
    // Colección obligatoria para almacenar a los empleados [1]
    private ArrayList<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    public void mostrarTodosLosEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados en la empresa.");
            return;
        }
        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("---------------------------");
        }
    }
    public Empleado buscarEmpleadoPorDocumento(String documento) {
        for (Empleado e : empleados) {
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }
    public Empleado obtenerEmpleadoConMayorSalario() {
        if (empleados.isEmpty()) return null;

        Empleado mayor = empleados.get(0);
        for (Empleado e : empleados) {
            if (e.calcularSalarioNeto() > mayor.calcularSalarioNeto()) {
                mayor = e;
            }
        }
        return mayor;
    }
    public float calcularNominaTotal() {
        float total = 0;
        for (Empleado e : empleados) {
            total += e.calcularSalarioNeto();
        }
        return total;
    }
    public void mostrarResumenesDePago() {
        if (empleados.isEmpty()) {
            System.out.println("No hay datos para generar resúmenes.");
            return;
        }
        System.out.println("=== RESÚMENES DE PAGO DE LA EMPRESA ===");
        for (Empleado e : empleados) {
            ResumenPago resumen = e.generarResumenPago();
            System.out.println(resumen);
        }
    }

    public void mostrarEmpleados() {
    }

    public void mostrarResumenesPago() {
    }
}
