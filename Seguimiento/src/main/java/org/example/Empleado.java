package org.example;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre,String documento, int edad, float salarioBase,CategoriaEmpleado categoria,float descuentoSalud,float descuentoPension){
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        if (descuentoSalud < 0 || descuentoSalud > 100 || descuentoPension < 0 || descuentoPension > 100) {
            throw new IllegalArgumentException("Los porcentajes de descuento deben estar entre 0 y 100");
        }

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }
    public float calcularBonificacionCategoria() {
        float porcentaje = 0;
        switch (this.categoria) {
            case JUNIOR:
                porcentaje = 0.05f;
                break;
            case SEMI_SENIOR:
                porcentaje = 0.10f;
                break;
            case SENIOR:
                porcentaje = 0.15f;
                break;
        }
        return this.salarioBase * porcentaje;
    }
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Categoría: " + categoria);
    }
    public abstract ResumenPago generarResumenPago();

    public abstract float calcularSalarioBruto();

    protected float calcularDescuentos() {
        float bruto = calcularSalarioBruto();
        float salud = bruto * (this.descuentoSalud / 100);
        float pension = bruto * (this.descuentoPension / 100);
        return salud + pension;
    }

    protected float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public Object getDocumento() {
        return this.documento;
    }
}

