package model;

public class Products {
    private String nameProduct;
    private String description;
    private double price;
    private int unitis;
    private String category;
    private int vecesComprado;

    public Products(String nameProduct, String description, double price, int unitis, String category) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.unitis = unitis;
        this.category = category;
        this.vecesComprado = 0; // Inicialmente no ha sido comprado ninguna vez
    }

    // Getters y setters para todos los atributos

    public String getnameProduct() {
        return nameProduct;
    }

    public void setnameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    // Otros getters y setters para los demás atributos

    // Métodos para incrementar/decrementar la cantidad disponible al realizar una venta o añadir stock
    public void vender(int cantidad) {
        if (cantidad <= unitis) {
            unitis -= cantidad;
            vecesComprado += cantidad;
        } else {
            System.out.println("No hay suficiente stock disponible.");
        }
    }

    public void agregarStock(int cantidad) {
        unitis += cantidad;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnitis() {
        return unitis;
    }

    public void setUnitis(int unitis) {
        this.unitis = unitis;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getVecesComprado() {
        return vecesComprado;
    }

    public void setVecesComprado(int vecesComprado) {
        this.vecesComprado = vecesComprado;
    }

    

    // Otros métodos que podrían ser útiles, como calcular ingresos por ventas, etc.
}

