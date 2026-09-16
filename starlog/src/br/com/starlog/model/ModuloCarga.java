package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;

import br.com.starlog.exception.CapacidadeExcedidaException;

public class ModuloCarga {
    private String codigoModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    public ModuloCarga(String codigoModulo, int capacidadeMaxima) {
        this.codigoModulo = codigoModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>();
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException{
        if(cargas.size() >= capacidadeMaxima)
        {
            throw new CapacidadeExcedidaException("Modulo " + getCodigoModulo() + " atingiu a capacidade maxima de "+ getCapacidadeMaxima() + " cargas");
        }
        cargas.add(carga);
    }

    public double calcularSeguroTotal(){
        return this.cargas.stream()
        .mapToDouble(Carga::getValorSeguro)
        .sum();
    }

    public long contarCargasPorCateoria(String categoria){
        return this.cargas.stream()
        .filter(t -> categoria != null && categoria.equalsIgnoreCase(t.getCategoria()))
        .count();
    }

    public double calcularSeguroCargasPesadas(String categoria,double pesoMinimo){
        return this.cargas.stream()
        .filter(t -> categoria != null && pesoMinimo < t.getPesoKg() && categoria.equalsIgnoreCase(t.getCategoria()))
        .mapToDouble(Carga::getValorSeguro)
        .sum();
    }
    
}
