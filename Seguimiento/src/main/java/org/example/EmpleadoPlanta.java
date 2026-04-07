package org.example;

public class EmpleadoPlanta extends Empleado {
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (horasExtra < 0) {
            throw new IllegalArgumentException("No se permiten horas extra negativas");
        }
        if (valorHoraExtra < 0) {
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo");
        }

        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public float calcularSalarioBruto() {
        // Regla: salario base + bonificación + pago horas extra + auxilio transporte [1]
        float pagoHorasExtra = this.horasExtra * this.valorHoraExtra;
        return this.salarioBase + calcularBonificacionCategoria() + pagoHorasExtra + this.auxilioTransporte;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Muestra datos comunes [4]
        System.out.println("Cargo: " + cargo);
        System.out.println("Horas Extra: " + horasExtra);
        System.out.println("Auxilio de Transporte: " + auxilioTransporte);
        System.out.println("Salario Bruto: " + calcularSalarioBruto());
    }

    @Override
    public ResumenPago generarResumenPago() {
        // Uso obligatorio del record ResumenPago [5]
        return new ResumenPago(
                this.documento,
                this.nombre,
                "Empleado de Planta",
                this.calcularSalarioBruto(),
                this.calcularDescuentos(),
                this.calcularSalarioNeto()
        );
    }
}
