package modelo;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {}
    public Producto(int id,String nombre,double precio,int cantidad){
        this.id=id; this.nombre=nombre; this.precio=precio; this.cantidad=cantidad;
    }
    // getters/setters
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNombre(){return nombre;} public void setNombre(String n){this.nombre=n;}
    public double getPrecio(){return precio;} public void setPrecio(double p){this.precio=p;}
    public int getCantidad(){return cantidad;} public void setCantidad(int c){this.cantidad=c;}
    public double getValorTotal(){ return precio * cantidad; }
}
