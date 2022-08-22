package com.unifaj.tcc.curriculo.CurriculoWeb.entities;

import java.util.Calendar;

import com.unifaj.tcc.curriculo.CurriculoWeb.subEntities.ClasseGenerica;

public class Usuario {

    public Usuario() {
		curso = new ClasseGenerica();
		turma = new ClasseGenerica();
		cidade = new ClasseGenerica();
		estado = new ClasseGenerica();
		idade = Calendar.getInstance();
	}

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Calendar idade;
	private String cpf;
	private String rg;

	private ClasseGenerica curso;
	private ClasseGenerica turma;
	private ClasseGenerica cidade;
	private ClasseGenerica estado;

	public ClasseGenerica getEstado() {
		return estado;
	}

	public void setEstado(ClasseGenerica estado) {
		this.estado = estado;
	}

	public ClasseGenerica getCidade() {
		return cidade;
	}

	public void setCidade(ClasseGenerica cidade) {
		this.cidade = cidade;
	}

	public ClasseGenerica getCurso() {
		return curso;
	}

	public void setCurso(ClasseGenerica curso) {
		this.curso = curso;
	}

	public ClasseGenerica getTurma() {
		return turma;
	}

	public void setTurma(ClasseGenerica turma) {
		this.turma = turma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getIdade() {
		return idade;
	}

	public void setIdade(Calendar idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}


    
}
