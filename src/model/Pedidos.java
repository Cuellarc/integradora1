package model;
import java.util.Calendar;

public class Pedidos {
    private String nombreComprador;
    private Products[] productos;
    private double precioTotal;
    private String metodoPago;
    private Calendar fechaCompra;

    public Pedidos(String nombreComprador, Products[] productos, double precioTotal, String metodoPago) {
        this.nombreComprador = nombreComprador;
        this.productos = productos;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.fechaCompra = Calendar.getInstance(); // Fecha actual
    }

    // Getters y setters para todos los atributos

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    // Otros métodos que puedas necesitar



    // Getters y setters para todos los atributos

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    // Otros getters y setters para los demás atributos

    // Método para calcular el precio total del pedido sumando el precio de todos los productos
    private void calcularPrecioTotal() {
        precioTotal = 0.0;
        for (Products producto : productos) {
            precioTotal += producto.getPrice();
        }
    }

    // Otros métodos que podrían ser útiles, como agregar productos al pedido, eliminar productos, etc.
}
