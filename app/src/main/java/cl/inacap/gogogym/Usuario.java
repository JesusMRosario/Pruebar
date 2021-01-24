package cl.inacap.gogogym;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private String nombre;
    private String correo;
    private String contrasena;
    private int altura;
    private int peso;
    private int sexo;
    private String pais;
    private int cuenta;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasena, int altura, int peso, int sexo, String pais, int cuenta) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.pais = pais;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.correo);
        dest.writeString(this.contrasena);
        dest.writeInt(this.altura);
        dest.writeInt(this.peso);
        dest.writeInt(this.sexo);
        dest.writeString(this.pais);
        dest.writeInt(this.cuenta);
    }

    protected Usuario(Parcel in) {
        this.nombre = in.readString();
        this.correo = in.readString();
        this.contrasena = in.readString();
        this.altura = in.readInt();
        this.peso = in.readInt();
        this.sexo = in.readInt();
        this.pais = in.readString();
        this.cuenta = in.readInt();
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
