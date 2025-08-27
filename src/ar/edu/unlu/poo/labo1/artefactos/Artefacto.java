package ar.edu.unlu.poo.labo1.artefactos;

import java.util.Objects;

public class Artefacto {
    private String nombre;
    private int poder;
    private String tipo;

    public Artefacto(String nombre, int poder, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
    }


    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    @Override
    public boolean equals(Object object){
        if (this == object){ //¿Somos el mismo objeto en memoria?
            return true;
        }
        if (object == null || this.getClass() != object.getClass()){ //¿El parameter formal es null o es de otra clase distinta a "this"?
            return false;
        }
        Artefacto artefacto = (Artefacto) object; //Convertimos el objeto y comparamos el campo clave(en este caso es el nombre para saber si son iguales).
        return Objects.equals(nombre, artefacto.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }
}
