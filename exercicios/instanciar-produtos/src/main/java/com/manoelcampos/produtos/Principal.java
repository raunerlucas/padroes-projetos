package com.manoelcampos.produtos;

public class Principal {
    public static void main(String[] args) {
        Produto produto = new Produto.ProdutoBuilder("Notebook", "Dell", 1, 3500.00, "Eletrônicos")
                .CodigoEan("1234567890123")
                .Modelo("Inspiron 15")
                .Estoque(10)
                .UrlFoto("http://example.com/notebook.jpg")
                .build();

        System.out.println("Produto criado: " + produto);
    }
}
