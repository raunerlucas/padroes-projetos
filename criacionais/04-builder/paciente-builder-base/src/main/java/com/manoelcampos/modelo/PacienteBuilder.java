package com.manoelcampos.modelo;

public class PacienteBuilder {
    private long id;
    private String nome;
    private char sexo;
    private String cpf;
    private String rg;
    private String orgaoEmissorRg;
    private String cidade;
    private String uf;
    private double peso;
    private double altura;

    public PacienteBuilder id(long id) {
        this.id = id;
        return this;
    }

    public PacienteBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PacienteBuilder sexo(char sexo) {
        this.sexo = sexo;
        return this;
    }

    public PacienteBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PacienteBuilder rg(String rg) {
        this.rg = rg;
        return this;
    }

    public PacienteBuilder orgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
        return this;
    }

    public PacienteBuilder cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public PacienteBuilder uf(String uf) {
        this.uf = uf;
        return this;
    }

    public PacienteBuilder peso(double peso) {
        this.peso = peso;
        return this;
    }

    public PacienteBuilder altura(double altura) {
        this.altura = altura;
        return this;
    }

    public Paciente createPaciente() {
        return new Paciente(id, nome, sexo, cpf, rg, orgaoEmissorRg, cidade, uf, peso, altura);
    }
}