package com.unifaj.tcc.curriculo.CurriculoWeb.mBeans;

import java.sql.SQLException;
import java.util.List;

import com.unifaj.tcc.curriculo.CurriculoWeb.entities.Usuario;
import com.unifaj.tcc.curriculo.CurriculoWeb.subEntities.ClasseGenerica;
import com.unifaj.tcc.curriculo.CurriculoWeb.uDao.ClasseGenericaDao;
import com.unifaj.tcc.curriculo.CurriculoWeb.uDao.UsuarioDao;

public class CadastroUsuarioMBean {

    // classe usada para buscar classes responsaveis por foreign key
	ClasseGenericaDao classeGenericaDao;
	List<ClasseGenerica> cursos;
	List<ClasseGenerica> turmas;
	List<ClasseGenerica> estados;
	List<ClasseGenerica> cidades;

    // usuario a ser salvo no banco
	Usuario usuario;
	UsuarioDao usuarioDao;

    public CadastroUsuarioMBean() throws SQLException {
		classeGenericaDao = new ClasseGenericaDao();
		usuario = new Usuario();
		usuarioDao = new UsuarioDao();
		cursos = classeGenericaDao.buscaCurso();
		estados = classeGenericaDao.buscaEstado();
	}

    public void buscaTurma() throws SQLException {
		turmas = classeGenericaDao.buscaTurma(usuario.getCurso().getId());
	}

	public void buscaCidade() throws SQLException {
		cidades = classeGenericaDao.buscaCidade(usuario.getEstado().getId());
	}

	public List<ClasseGenerica> getCidades() {
		return cidades;
	}

	public void setCidades(List<ClasseGenerica> cidades) {
		this.cidades = cidades;
	}

	public List<ClasseGenerica> getEstados() {
		return estados;
	}

	public void setEstados(List<ClasseGenerica> estados) {
		this.estados = estados;
	}

	public List<ClasseGenerica> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<ClasseGenerica> turmas) {
		this.turmas = turmas;
	}

	public List<ClasseGenerica> getCursos() {
		return cursos;
	}

	public void setCursos(List<ClasseGenerica> cursos) {
		this.cursos = cursos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    
}
