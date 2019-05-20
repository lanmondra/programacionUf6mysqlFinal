package empleado.control;

import empleado.dao.EmpleDAOImp;

import empleado.dominio.Empleado;
import java.util.List;
import empleado.dao.EmpleDao;

public class ControladorEmpleado implements EmpleDao{

    public List<Empleado> leerEmple() {

        EmpleDao dao = new EmpleDAOImp();
        return dao.leerEmpleados();
    }

    public Empleado getEmpleadoPorCodigo(int codigo) {
        EmpleDao edao = new EmpleDAOImp();
        return edao.getEmpleadoPorCodigo(codigo);
    }

    @Override
    public List<Empleado> leerEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPassword(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escribirEnDB(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

}
