package empleado.dao;

import empleado.dominio.Empleado;
import java.util.List;

public interface EmpleDao {

    List<Empleado> leerEmpleados();  //Read

    Empleado getEmpleadoPorCodigo(int codigo);

    //void actualizarEmpleado(Empleado empleado); // Update
    //  void updatePassword(Empleado empleado, String passwordEmple);
    // void escribirEnDB(Empleado empleado, String employeePassword);
    boolean actualizarEmpleado(Empleado empleado);

}
