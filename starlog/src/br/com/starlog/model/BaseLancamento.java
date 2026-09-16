package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

public class BaseLancamento {
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public BaseLancamento() {
    }

    public Map<String, ModuloCarga> getModulos() {
        return modulos;
    }

    public void cadastrarModulo(ModuloCarga modulo){
        this.modulos.put(modulo.getCodigoModulo(),modulo);
    }

    public ModuloCarga buscarModulo(String codigoModulo){
        return modulos.get(codigoModulo);
    }
}
