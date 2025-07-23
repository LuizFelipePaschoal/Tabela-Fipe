# 🚗📊 Projeto Tabela FIPE – Consulta de Veículos com Java

Este projeto é um aplicativo de linha de comando em **Java** que permite ao usuário consultar marcas, modelos e valores de **carros, motos e caminhões** diretamente da API pública da [Tabela FIPE](https://deividfortuna.github.io/fipe/). Ele utiliza conceitos modernos de consumo de API REST, manipulação de JSON e boas práticas de programação orientada a objetos.

---

## ✨ Funcionalidades

- ✅ Consulta interativa de **carros**, **motos** e **caminhões**
- ✅ Filtro por nome ou trecho do modelo
- ✅ Exibição de todas as versões por ano
- ✅ Valores de avaliação atualizados pela FIPE
- ✅ Código limpo e estruturado em **camadas**

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Maven** (para gerenciamento de dependências, se desejar expandir)
- **API REST (HTTP GET)** com `java.net.HttpURLConnection`
- **Manipulação de JSON** usando `Gson`
- **Programação funcional** com **Streams**
- Estrutura de pacotes organizada por responsabilidade

---

## 📦 Estrutura do Projeto

```
br.com.alura.TabelaFipe
├── model
│   ├── Dados.java
│   ├── Modelos.java
│   └── Veiculo.java
│
├── service
│   ├── ConsumoApi.java
│   ├── ConverteDados.java
│   └── IConverteDados.java
│
├── principal
│   └── Principal.java
│
└── TabelaFipeApplication.java
```

---

## 🚀 Como Executar

### ✅ Pré-requisitos:

- Java 17 ou superior
- IDE como IntelliJ, Eclipse ou VS Code com extensão Java
- Internet (a aplicação consome dados da API online)

### ▶️ Passos:

1. Clone este repositório ou importe os arquivos no seu projeto:

   ```bash
   git clone https://github.com/seu-usuario/tabela-fipe-java.git
   ```

2. Compile e execute a classe `TabelaFipeApplication` ou `Principal`.

3. Escolha uma opção no menu:

   ```
   ==================***_OPÇÃO_***=====================
   1- Moto
   2- Carro
   3- Caminhão
   ====================================================
   Digite uma das opções para consultar:
   ```

4. Siga as instruções interativas no console para visualizar os dados da FIPE.

---

## 🔍 Exemplo de Uso

```
==================***_OPÇÃO_***=====================
1- Moto
2- Carro
3- Caminhão
====================================================
Digite uma das opções para consultar:
2

INFORME O CÓDIGO DA MARCA PARA CONSULTAR:
25

MODELOS DESSA MARCA:
... (lista de modelos)

DIGITE UM TRECHO DO NOME DO CARRO A SER BUSCADO:
gol

MODELOS FILTRADOS:
Gol 1.0
Gol 1.6
Gol Power...

DIGITE O CÓDIGO DO MODELO:
1234

TODOS OS VEÍCULOS FILTRADOS COM AVALIAÇÕES POR ANO:
2023 - R$ 55.000,00
2022 - R$ 49.000,00
...
```

---

## 📚 Aprendizados e Conceitos Aplicados

- Manipulação de APIs externas (HTTP + JSON)
- Programação orientada a objetos
- Tratamento e filtro de dados usando `Stream API`
- Interfaces, abstrações e boas práticas
- Uso de `record` para representar dados imutáveis

---

## 🙌 Créditos

Este projeto foi inspirado e baseado na proposta educacional da [Alura](https://www.alura.com.br/). O uso da [API da Tabela FIPE](https://deividfortuna.github.io/fipe/) é público e gratuito.

---

## 📜 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para usar, estudar e modificar.

---

## 📞 Contato

Caso tenha dúvidas ou sugestões:

- 💼 [LinkedIn](https://www.linkedin.com/in/luizfelipepaschoal)
- ✉️ luizfelipepaschoalgoncalves@gmail.com

---

> Desenvolvido com 💻 + ☕ + 🚀 por Felipe Paschoal Gonçalves
