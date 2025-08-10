package com.manoelcampos.produtos;

import java.time.LocalDate;

/**
 * Produto da loja.
 * @author Manoel Campos da Silva Filho
 */
public class Produto {
    private final long id;
    private final String codigoEan;
    private final String descricao;
    private final String marca;
    private final String modelo;
    private final double preco;
    private final LocalDate dataCadastro;
    private final LocalDate dataUltimaAtualizacao;
    private final int estoque;
    private final String categoria;
    private final String urlFoto;

    public Produto(Builder builder) {
        this.id = builder.id;
        this.codigoEan = builder.codigoEan;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.preco = builder.preco;
        this.dataCadastro = builder.dataCadastro;
        this.dataUltimaAtualizacao = builder.dataUltimaAtualizacao;
        this.estoque = builder.estoque;
        this.categoria = builder.categoria;
        this.urlFoto = builder.urlFoto;
    }

    public static class Builder {
        private final String descricao;
        private final String marca;
        private final long id;
        private final double preco;
        private final LocalDate dataCadastro;
        private final String categoria;
        private String modelo;
        private String codigoEan;
        private LocalDate dataUltimaAtualizacao;
        private int estoque = 0; // Valor padrão de estoque
        private String urlFoto;

        public Builder(String descricao, String marca, long id, double preco, String categoria) {
            if (descricao == null || descricao.isEmpty() || marca == null || marca.isEmpty()) {
                throw new IllegalArgumentException("Descrição e marca são obrigatórios");
            }
            if (id <= 0) {
                throw new IllegalArgumentException("ID deve ser maior que zero");
            }
            if (preco < 0) {
                throw new IllegalArgumentException("Preço não pode ser negativo");
            }
            if (categoria == null || categoria.isEmpty()) {
                throw new IllegalArgumentException("Categoria não pode ser nula ou vazia");
            }
            this.descricao = descricao;
            this.marca = marca;
            this.id = id;
            this.preco = preco;
            this.dataCadastro = LocalDate.now();
            this.categoria = categoria;
        }

        public Builder Modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder CodigoEan(String codigoEan) {
            this.codigoEan = codigoEan;
            return this;
        }

        public Builder DataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
            if (dataUltimaAtualizacao != null && dataUltimaAtualizacao.isBefore(dataCadastro)) {
                throw new IllegalArgumentException("Data de última atualização não pode ser anterior à data de cadastro");
            }
            this.dataUltimaAtualizacao = dataUltimaAtualizacao;
            return this;
        }

        public Builder Estoque(int estoque) {
            this.estoque = estoque;
            return this;
        }

        public Builder UrlFoto(String urlFoto) {
            this.urlFoto = urlFoto;
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }
    }

    @Override
    public String toString() {
        return "Produto{id=%d, codigoEan='%s', descricao='%s', marca='%s', modelo='%s', preco=%s, dataCadastro=%s, dataUltimaAtualizacao=%s, estoque=%d, categoria='%s', urlFoto='%s'}".formatted(id, codigoEan, descricao, marca, modelo, preco, dataCadastro, dataUltimaAtualizacao, estoque, categoria, urlFoto);
    }
}
