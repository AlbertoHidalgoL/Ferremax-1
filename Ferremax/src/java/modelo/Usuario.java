package modelo;

public class Usuario {
    private int id;
    private String usuario;
    private String clave;
    private String rol; // NUEVO

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public String getUsuario(){ return usuario; }
    public void setUsuario(String usuario){ this.usuario=usuario; }

    public String getClave(){ return clave; }
    public void setClave(String clave){ this.clave=clave; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
