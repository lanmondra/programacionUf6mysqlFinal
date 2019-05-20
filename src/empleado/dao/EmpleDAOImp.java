package empleado.dao;

import app.conection.conectionBD;
import com.mysql.jdbc.Statement;
import empleado.dominio.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import producto.dao.ProductDAOImp;
import producto.dominio.Producto;

public class EmpleDAOImp implements EmpleDao {

    //
    List<Empleado> empleados;

    public List<Empleado> leerEmple() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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

            int employeeCode = 0;
            String employeeName = null;
            String employeeLastName = null;
            String employeePassword = null;

            try {

                while (result.next()) {
                    employeeCode = result.getInt("e_codigo");
                    employeeName = result.getString("e_nombre");
                    employeeLastName = result.getString("e_apellidos");
                    employeePassword = result.getString("e_password");

                    empleList.add(new Empleado(employeeCode, employeeName, employeeLastName, employeePassword));
                }
            } catch (SQLException ex) {
                System.err.println("no se ha conectado con la base de datos");
            }

        }

        setEmpleados(empleados);
        System.out.println(this.toString());

    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void actualizarPassword(Empleado empleado, String passwordEmple) {

        List<Empleado> empleList = new ArrayList<Empleado>();
        empleList.add(empleado);

        for (int i = 0; i < empleList.size(); i++) {
            if (empleList.get(i).getCodigo() == empleado.getCodigo()) {
                empleList.get(i).setPassword(passwordEmple);
            }


        }
        this.escribirEnDB(empleado, passwordEmple);
        //this.escribirEnArchivo();
    }

    public void escribirEnDB(Empleado empleado, String emplePassword) {

        String query;
        Statement statement = null;
        ResultSet result = null;

        try {
            query = "UPDATE empleados SET e_password = \""
                    + empleado.getPassword() + "\" WHERE e_codigo = "
                    + empleado.getCodigo() + ";";
            Connection connect = conectionBD.conectar();
            statement = (Statement) connect.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            System.err.println("problemas con la base de datos.");
        }
//        finally {
//            this.empleados = (new EmpleDAOImp()).getEmpleados();
//        }

    }

   // @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> leerEmpleados() {
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
