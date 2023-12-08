package interfaces;


import java.util.ArrayList;

import model.Usuario;

public interface UsuarioInterfaces {
	public 	Usuario validarAcceso(String  usuario, String contraseña);
	public int registrar(Usuario u);
	public ArrayList<Usuario> listarReporteUsuarioXTipo(int codigoTipoUsuario);
}
