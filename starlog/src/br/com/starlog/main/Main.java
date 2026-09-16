package br.com.starlog.main;

import java.util.HashSet;
import java.util.Set;

import br.com.starlog.exception.CapacidadeExcedidaException;
import br.com.starlog.model.BaseLancamento;
import br.com.starlog.model.Carga;
import br.com.starlog.model.ModuloCarga;

public class Main {
    public static void main(String[] args){
        Set<Carga> manifesto = new HashSet<>();

        Carga c1 = new Carga("ORB-101-SP", "CRIOGENICA", 2.5, 450);
        Carga c2 = new Carga("ORB-102-RJ", "PADRAO", 8, 120);
        Carga c3 = new Carga("ORB-103-MG", "CRIOGENICA", 12, 850);
        Carga c4 = new Carga("ORB-104-PR", "BIOLOGICA", 15, 300);

        System.out.println(c1);
        System.out.println(c4);

        ModuloCarga modulo  = new ModuloCarga("MOD-ALFA-01", 3);

        BaseLancamento base = new BaseLancamento();

        base.cadastrarModulo(modulo);
        System.out.println("Modulo" + modulo.getCodigoModulo() + " cadastrado na base com capacidade de "+ modulo.getCapacidadeMaxima() + " cargas");

        try {
            modulo.carregarCarga(c1);
            System.out.println("Carga ORB-101-SP carregada no modulo com sucesso");
            modulo.carregarCarga(c2);
            System.out.println("Carga ORB-102-RJ carregada no modulo com sucesso");
            modulo.carregarCarga(c3);
            System.out.println("Carga ORB-103-MG carregada no modulo com sucesso");
            modulo.carregarCarga(c4);
            System.out.println("Carga ORB-104-PR carregada no modulo com sucesso");
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        
        }
        
        System.out.println(base.buscarModulo("MOD-ALFA-01"));

        System.out.println(modulo.calcularSeguroTotal());

        System.out.println(modulo.contarCargasPorCateoria("CRIOGENICA"));

        System.out.println(modulo.calcularSeguroCargasPesadas("CRIOGENICA", 5));


        Carga clone = new Carga("ORB-101-SP", "CRIOGENICA", 9, 990);
        
        manifesto.add(c1);
        manifesto.add(clone);
        manifesto.add(c2);

        System.out.println(manifesto.size());

        try{
            Carga nula = new Carga("", "PADRAO", 1, 50);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }





    }
}
