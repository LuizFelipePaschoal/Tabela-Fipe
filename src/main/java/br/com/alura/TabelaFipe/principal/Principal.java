package br.com.alura.TabelaFipe.principal;

import br.com.alura.TabelaFipe.model.Dados;
import br.com.alura.TabelaFipe.model.Modelos;
import br.com.alura.TabelaFipe.model.Veiculo;
import br.com.alura.TabelaFipe.service.ConsumoApi;
import br.com.alura.TabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
       private Scanner leitura = new Scanner(System.in);
       private ConsumoApi consumo = new ConsumoApi();
       private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
       private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){
        var menu = """
                ==================***_OPÇÃO_***=====================
                1- Moto
                2- Carro
                3- Caminhão
                ====================================================
                Digite uma das opções para consultar:
                """;
        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr") || opcao.toLowerCase().contains("1")){
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot") || opcao.toLowerCase().contains("2")) {
            endereco = URL_BASE + "motos/marcas";
        } else if (opcao.toLowerCase().contains("caminhao") || opcao.toLowerCase().contains("3")){
            endereco = URL_BASE + "caminhoes/marcas";
        } else {
            System.out.println("OPÇÃO INVALIDA");
            return;
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("""
               ===========================================
                INFORME O CÓDIGO DA MARCA PARA CONSULTAR:
               ===========================================
                """);
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("""
               =======================
                MODELOS DESSA MARCA:
               =======================
               """);
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        if (opcao.toLowerCase().contains("mot")) {
            System.out.println(String.format("""
        ========================================================
        DIGITE UM TRECHO DO NOME DA %S A SER BUSCADO:
        ========================================================
        """, opcao.toUpperCase()));
        }else {
            System.out.println(String.format("""
        ========================================================
         DIGITE UM TRECHO DO NOME DA %S A SER BUSCADO:
        ========================================================
        """, opcao.toUpperCase()));
        }

        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("""
                ===================
                MODELOS FILTRADOS:
                ===================
                """);
        modelosFiltrados.forEach(System.out::println);

        System.out.println("""
                =========================================================================
                DIGITE POR FAVOR O CÓDIGO DO MODELO PARA BUSCAR OS VALORES DE AVALIAÇÃO:
                =========================================================================
                """);
        var codigoModelo = leitura.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }
        System.out.println("""
                =====================================================
                TODOS OS VEICULOS FILTRADOS COM AVALIAÇÕES POR ANO:
                =====================================================
                """);
        veiculos.forEach(System.out::println);
        

    }

}
