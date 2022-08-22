package com.unifaj.tcc.curriculo.CurriculoWeb.uDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.unifaj.tcc.curriculo.CurriculoWeb.entities.Usuario;
import com.unifaj.tcc.curriculo.CurriculoWeb.jdbc.ConnectionDB;
import com.unifaj.tcc.curriculo.CurriculoWeb.utils.FormatarCPFtoString;
import com.unifaj.tcc.curriculo.CurriculoWeb.utils.StringtoMD5;


public class UsuarioDao {

    private Connection conn;

    public UsuarioDao() {
		conn = ConnectionDB.getConnection();
	}

    public boolean updateUsuario(Usuario u) throws SQLException {
		String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, idade = ?, cpf = ?, id_curso = ?, id_turma = ?, id_cidade = ?, id_estado = ? WHERE usuario.id = ?;";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setString(3, StringtoMD5.convertStringToMd5(u.getSenha()));
		ps.setLong(4, u.getIdade().getTimeInMillis());
		ps.setString(5, FormatarCPFtoString.format(u.getCpf()));
		ps.setInt(7, u.getCurso().getId());
		ps.setInt(8, u.getTurma().getId());
		ps.setInt(9, u.getCidade().getId());
		ps.setInt(10, u.getEstado().getId());
		ps.setInt(11, u.getId());
		
		return ps.executeUpdate() > 0;
	}

    public boolean inserirUsuario(Usuario u) throws SQLException {
		String sql = "INSERT INTO usuario(nome, email, senha, idade, cpf, id_curso, id_turma, id_cidade, id_estado)"
				+ " VALUES(?,?,?,?,?,?,?,?,?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setString(3, StringtoMD5.convertStringToMd5(u.getSenha()));
		ps.setLong(4, u.getIdade().getTimeInMillis());
		ps.setString(5, FormatarCPFtoString.format(u.getCpf()));
		ps.setInt(7, u.getCurso().getId());
		ps.setInt(8, u.getTurma().getId());
		ps.setInt(9, u.getCidade().getId());
		ps.setInt(10, u.getEstado().getId());

		return ps.executeUpdate() > 0;
	};

    public Usuario buscaUsuarioPorEmail(String email) throws SQLException {
		String sql = "	SELECT u.*, c.nome AS nomeCidade, e.nome AS nomeEstado, st.nome AS nomeStatus, cur.nome AS nomeCurso, tur.nome AS nomeTurma FROM usuario AS u " + 
				"INNER JOIN cidade AS c ON c.id = u.id_cidade " + 
				"INNER JOIN estado AS e ON e.id = u.id_estado " + 
				"INNER JOIN status_ AS st ON st.id = u.id_status " + 
				"INNER JOIN curso AS cur ON cur.id = u.id_curso " + 
				"INNER JOIN turma AS tur ON tur.id = u.id_turma " + 
				"WHERE u.email = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();

		Usuario u = null;
		if (rs.next()) {
			u = new Usuario();
			
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(rs.getLong("idade"));   

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(c);
			u.setCpf(rs.getString("cpf"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNome(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNome(rs.getString("nomeTurma"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNome(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNome(rs.getString("nomeEstado"));
		}

		return u;
	}

    public Usuario buscaUsuarioPorCpf(String cpf) throws SQLException {
		String sql = "	SELECT u.*, c.nome AS nomeCidade, e.nome AS nomeEstado, st.nome AS nomeStatus, cur.nome AS nomeCurso, tur.nome AS nomeTurma FROM usuario AS u " + 
				"INNER JOIN cidade AS c ON c.id = u.id_cidade " + 
				"INNER JOIN estado AS e ON e.id = u.id_estado " + 
				"INNER JOIN status_ AS st ON st.id = u.id_status " + 
				"INNER JOIN curso AS cur ON cur.id = u.id_curso " + 
				"INNER JOIN turma AS tur ON tur.id = u.id_turma " + 
				"WHERE u.cpf = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, FormatarCPFtoString.format(cpf));

		ResultSet rs = ps.executeQuery();

		Usuario u = null;
		if (rs.next()) {
			u = new Usuario();
			
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(rs.getLong("idade"));   

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(c);
			u.setCpf(rs.getString("cpf"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNome(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNome(rs.getString("nomeTurma"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNome(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNome(rs.getString("nomeEstado"));
		}

		return u;
	}




    


}
