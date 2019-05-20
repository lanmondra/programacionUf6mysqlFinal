/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.dao;

import app.conection.conectionBD;
import com.mysql.jdbc.Statement;
import empleado.dominio.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import producto.dominio.Producto;

/**
 *
 * @author miguelmondragon
 */
public class ProductDAOImp implements ProductDAO {

    List<Producto> listaDeProductos;

    public ProductDAOImp() {

        List<Producto> productList = new ArrayList<Producto>();
        String query = "SELECT * FROM productos";
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
            System.err.println("fallo al conectar con la base de datos ");
        } finally {

            int productCode = 0;
            String productName = null;
            String productDescription = null;
            double productPrice = 0.0;

            try {

                while (result.next()) {
                    productCode = result.getInt("p_codigo");
                    productName = result.getString("p_nombre");
                    productDescription = result.getString("p_descripcion");
                    productPrice = result.getDouble("p_precio");

                    productList.add(new Producto(productCode, productName, productDescription, productPrice));
                }
            } catch (SQLException ex) {
                System.err.println("no se puede acceder a la base de datos");
            }

        }

        setListaDeProductos(productList);
        System.out.println(this.toString());

    }

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(List<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    public void actualizarPrecio(int codigo, double precio) {
        Producto productos = new Producto();

        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            if (this.listaDeProductos.get(i).getCodigo() == codigo) {
                productos.setDescripcion(this.listaDeProductos.get(i).getDescripcion());
                productos.setPrecio(precio);
                productos.setNombre(this.listaDeProductos.get(i).getNombre());
                productos.setCodigo(this.listaDeProductos.get(i).getCodigo());
                this.listaDeProductos.set(i, productos);
            }
        }
        escribirEnBD(codigo, productos);

    }

    public void actualizarCodigo(int codigo, int newCodigo) {
        Producto productos = new Producto();

        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            if (this.listaDeProductos.get(i).getCodigo() == codigo) {
                productos.setDescripcion(this.listaDeProductos.get(i).getDescripcion());
                productos.setPrecio(this.listaDeProductos.get(i).getPrecio());
                productos.setNombre(this.listaDeProductos.get(i).getNombre());
                productos.setCodigo(newCodigo);
                this.listaDeProductos.set(i, productos);
            }
        }
        escribirEnBD(codigo, productos);

    }

    public void actualizarNombre(int codigo, String newNombre) {
        Producto productos = new Producto();

        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            if (this.listaDeProductos.get(i).getCodigo() == codigo) {
                productos.setDescripcion(this.listaDeProductos.get(i).getDescripcion());
                productos.setPrecio(this.listaDeProductos.get(i).getPrecio());
                productos.setNombre(newNombre);
                productos.setCodigo(this.listaDeProductos.get(i).getCodigo());
                this.listaDeProductos.set(i, productos);
            }
        }
        escribirEnBD(codigo, productos);

    }

    // @Override
    public void escribirEnBD(int codProd, Producto productoEntrante) {
        String query;
        Statement statement = null;
        ResultSet result = null;

        try {
            query = "UPDATE productos SET "
                    + "p_codigo = " + productoEntrante.getCodigo() + ", "
                    + "p_nombre = " + "\"" + productoEntrante.getNombre() + "\"" + ", "
                    + "p_descripcion = " + "\"" + productoEntrante.getDescripcion() + "\"" + ", "
                    + "p_precio = " + productoEntrante.getPrecio() + " "
                    + "WHERE p_codigo = " + codProd;
            //System.out.println(query);

            Connection connect = conectionBD.conectar();
            statement = (Statement) connect.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            System.err.println("no se puede conectara a las bases de datos");
        }
//        finally {
        this.listaDeProductos = (new ProductDAOImp()).getListaDeProductos();
        //  }
    }

//    public String toString() {
//
//        String productListString = "";
//        for (Producto i : this.listaDeProductos) {
//            productListString
//                    += "[producto]"
//                    + "\n [codigo]\n "
//                    + i.getCodigo()
//                    + "\n [nombre]\n "
//                    + i.getNombre()
//                    + "\n [descripcion]\n "
//                    + i.getDescripcion()
//                    + "\n [precio]\n "
//                    + i.getPrecio()
//                    + "\n";
//        }
//        return productListString;
//    }

    @Override
    public List<Producto> readProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
