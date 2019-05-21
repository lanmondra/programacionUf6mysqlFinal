package empleado.dao;

import app.conection.conectionBD;
import com.mysql.jdbc.Statement;
import empleado.dominio.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

/**
 *
 * @author miguelmondragon
 */
public class EmpleDAOImp implements EmpleDao{

    private List<Empleado> empleados;

    public EmpleDAOImp() {

        List<Empleado> empleList = new ArrayList<Empleado>();
        String query = "SELECT * FROM empleados";
        Statement statement;
        ResultSet result = null;
        /*
        Statement statement = null;
        ResultSet result = null;
         */

        try {
            Connection connect = conectionBD.conectar();
            statement = (Statement) connect.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("error al leer la base de datos");
        } finally {

            int empleCodigo = 0;
            String empleNombre = null;
            String empleApellido = null;
            String emplePass = null;

            try {

                while (result.next()) {
                    empleCodigo = result.getInt("e_codigo");
                    empleNombre = result.getString("e_nombre");
                    empleApellido = result.getString("e_apellidos");
                    emplePass = result.getString("e_password");

                    empleList.add(new Empleado(empleCodigo, empleNombre, empleApellido, emplePass));
                }
            } catch (SQLException ex) {
                System.err.println("no se ha conectado con la base de datos");
            }

        }

        setEmpleados(empleados);
        System.out.println(this.toString());

    }
     //@Override
    public List<Empleado> leerEmpleados() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     //@Override
    public Empleado getEmpleadoPorCodigo(int codigo) {
        Empleado empleado = null;
        String query = "SELECT * FROM empleados where e_codigo = " + codigo;

        try (
                 var conexion = conectionBD.conectar();  var sentencia = conexion.createStatement();  var resultado = sentencia.executeQuery(query)) {

            resultado.next();
            var code = resultado.getInt("e_codigo");
            var nombre = resultado.getString("e_nombre");
            var apellidos = resultado.getString("e_apellidos");
            var password = resultado.getString("e_password");
            empleado = new Empleado(codigo, nombre, apellidos, password);

        } catch (SQLException e) {
            System.out.println("Error al cargar empleado con el codigo " + codigo);
        }

        return empleado;
    }

     //@Override
    public boolean actualizarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(List<Empleado> emple) {
        this.empleados = emple;
    }

    // @Override
    public void updatePassword(Empleado empleado, String passwordEmple) {
        
        List <Empleado>empleadoList = new ArrayList<>();
        empleadoList.add(empleado);
        
        for (int i = 0; i < empleadoList.size(); i++) {
            if (empleadoList().get(i).getCodigo() == empleado.getCodigo()) {
                empleadoList.get(i).setPassword(passwordEmple);
            }
        }
        this.escribirEnDB(empleado, passwordEmple);
        //this.escribirEnArchivo();
    }

    //@Override
    public void escribirEnDB(Empleado empleado, String emplePassword
    ) {

        String query;
        Statement statement = null;
        ResultSet result = null;

        try {
            query = "UPDATE empleados SET e_password = \""
                    + emplePassword + "\" WHERE e_codigo = "
                    + empleado.getCodigo() + ";";
            Connection connect = conectionBD.conectar();
            statement = (Statement) connect.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            System.err.println("problemas con la base de datos.");
        } finally {
            this.empleados = (new EmpleDAOImp()).getEmpleados();
        }
    }
    
}
