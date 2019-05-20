package empleado.dao;

import empleado.dominio.Empleado;
import java.util.List;

public interface EmpleDao {

    List<Empleado> leerEmpleados();  //Read

    Empleado getEmpleadoPorCodigo(int codigo);

    boolean actualizarEmpleado(Empleado empleado); // Update

    void actualizarPassword(Empleado empleado);

    void escribirEnDB(Empleado empleado);
}
