package empleado.control;

import empleado.dao.EmpleDAOImp;
import empleado.dao.EmpleDao;

import empleado.dominio.Empleado;
import java.text.SimpleDateFormat;
import java.util.List;

public class ControladorEmpleado {

   public List<Empleado> leerEmpleados() {
        EmpleDao edao = new EmpleDAOImp();
        return edao.leerEmpleados();
    }

    public Empleado getEmpleadoPorCodigo(int codigo) {
        EmpleDao edao = new EmpleDAOImp();
        return edao.getEmpleadoPorCodigo(codigo);
    }

   public boolean actulizarEmpleado(Empleado empleado){
       EmpleDao edao =new EmpleDAOImp();
       return edao.actualizarEmpleado(empleado);
       
   }
    

}
