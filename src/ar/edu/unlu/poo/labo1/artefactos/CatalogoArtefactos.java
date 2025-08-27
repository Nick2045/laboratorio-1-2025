package ar.edu.unlu.poo.labo1.artefactos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CatalogoArtefactos {

    Set<Artefacto> artefactos;

    public CatalogoArtefactos() {
        this.artefactos = new HashSet<>();
    }

    public void agregarArtefacto(Artefacto item){
        artefactos.add(item);
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return artefactos;
    }

    public List buscarArtefactosPorTipo(String tipo){
        List<Artefacto> lista = new ArrayList<>();
        for (Artefacto item : artefactos){
            if (item.getTipo().equalsIgnoreCase(tipo)){
                lista.add(item);
            }
        }

        int i, j, longitud = lista.size();
        Artefacto aux;
        for (i = 0; i < longitud-1; i++){
            for  (j = i+1; j < longitud; j++) {
                if(lista.get(i).getPoder() < lista.get(j).getPoder()) {
                    aux = lista.get(i); //Para hacer este de mejor manera puedo usar sort(), collections() o API de Streams.
                    lista.set(i,lista.get(j));
                    lista.set(j, aux);
                }
            }

        }

        return lista;
    }

    public Map<String, Integer> contarArtefactosPorTipo(){
        Map <String, Integer> tabla = new HashMap<>();
        for(Artefacto item : artefactos){
            Integer valor = tabla.putIfAbsent(item.getTipo(),1);
            if (valor != null){
                Integer nuevoValor = tabla.get(item.getTipo());
                tabla.put(item.getTipo(), nuevoValor+1);//Para hacer esto de mejor manera usar el merge() o el computer()
            }
        }
        return tabla;
    }

    public Artefacto obtenerArtefactoMasPoderoso(){
        if (artefactos.isEmpty()){
            return null;
        }

        Artefacto artefacto = null;
        int max = -1;
        for(Artefacto item : artefactos){
            if (item.getPoder() > max){
                artefacto = item;
                max = item.getPoder();
            }
        }
        /*
        Artefacto artefactoMasPoderoso = artefactos.get(0);

        for (int i = 1; i < artefactos.size(); i++) {
            Artefacto artefactoActual = artefactos.get(i);
            if (artefactoActual.getPoder() > artefactoMasPoderoso.getPoder()) {
                artefactoMasPoderoso = artefactoActual;
            }
        }
        return artefactoMasPoderoso;
        * */

        return artefacto;
    }
}
