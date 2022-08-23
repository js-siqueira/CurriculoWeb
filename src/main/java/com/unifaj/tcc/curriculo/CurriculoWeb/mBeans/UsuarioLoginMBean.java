package com.unifaj.tcc.curriculo.CurriculoWeb.mBeans;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.unifaj.tcc.curriculo.CurriculoWeb.entities.Usuario;
import com.unifaj.tcc.curriculo.CurriculoWeb.uDao.UsuarioDao;
import com.unifaj.tcc.curriculo.CurriculoWeb.utils.StringtoMD5;

public class UsuarioLoginMBean {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private String senha;
    private String email;


    public String fazerLogin() {
        String teste = "login";
		if (teste == "login") {
			try {
				Usuario usuarioLocal = usuarioDao.buscaUsuarioPorEmail(email);
				if (usuarioLocal != null) {
					if (usuarioLocal.getSenha().equals(StringtoMD5.convertStringToMd5(senha))) {
					
							usuario = usuarioLocal;
							return "resume?faces-redirect=true";
						}
					 else {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage("Usuario ou senha incorretos !"));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario n�o encontrado !"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.toString()));
			}
		}
		return null;
	}

    
}
