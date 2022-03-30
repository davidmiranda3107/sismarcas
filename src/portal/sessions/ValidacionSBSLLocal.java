package portal.sessions;

import javax.ejb.Local;

@Local
public interface ValidacionSBSLLocal {

	public static final Integer VAL_ERROR_NO_DETERMINADO = -1;
	public static final Integer VAL_USUARIO_NO_EXISTE = 0;
	public static final Integer VAL_USUARIO_VALIDO = 1;
	public static final Integer VAL_USUARIO_DEBE_CAMBIAR_CLAVE = 2;
	public static final Integer VAL_ERROR_EN_CLAVE = 3;
	public static final Integer VAL_USUARIO_EXPIRADO = 4;
	public static final Integer VAL_USUARIO_DE_BAJA = 5;
	public static final Integer VAL_USUARIO_NO_TIENE_ACCESO_A_SISTEMA = 6;
	
	public Integer validar(String usuario, String clave);
}
