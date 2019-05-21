package producto.control;

import app.conection.conectionBD;

import empleado.dominio.Empleado;
import factura.Pedido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import producto.dao.ProductDAOImp;

import producto.dominio.Producto;
import tienda.vista.VistaProductos;
import util.Color;

public class GestionProductos {

    Empleado empleadoAuten;
    Producto producto;
    List<Producto> losProductos = new ArrayList<Producto>();

    Scanner scan = new Scanner(System.in);

    String archivoPorduc = "src/File/archivoProducto.txt";
    ArrayList<Producto> ProductList = new ArrayList<Producto>();
    private List<Producto> productos = new ArrayList<Producto>();

    public GestionProductos(Empleado empleadoAuten) {
        this.empleadoAuten = empleadoAuten;
    }

    
    public List<Producto> readProductos() {

        List<Producto> productos = new ArrayList<>();

        String query = "SELECT * FROM productos";

        try (
                 var conexion = conectionBD.conectar();  var sentencia = conexion.createStatement();  var resultado = sentencia.executeQuery(query);) {

            // capturar los resultados
            while (resultado.next()) {
                var codigo = resultado.getInt("p_codigo");
                var nombre = resultado.getString("p_nombre");
                var descripcion = resultado.getString("p_descripcion");
                var precio = resultado.getDouble("p_precio");

                productos.add(new Producto(codigo, nombre, descripcion, precio));
                losProductos.add(new Producto(codigo, nombre, descripcion, precio));

            }

        } catch (SQLException e) {
            System.out.println("Error al leer los productos en la base de datos "
                    + this.getClass().getName());
        }

        return productos;

    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> products) {
        this.productos = products;
    }

    private boolean esCodigoValido(int productCode) {

        boolean validProductCode = false;

        for (int i = 0; i < losProductos.size(); i++) {

            if (productCode == losProductos.get(i).getCodigo()) {
                validProductCode = true;
            }
        }

        return validProductCode;
    }

    public void actualizarCodigo() {

        int oldCodigo = 0;
        boolean validNewProductCode = false;
        boolean validFormat = true;

        while (!validNewProductCode) {

            validFormat = true;
            imprimirProductos();
            System.out.print("Entre un codigo de un productos : ");
            String newProductCodeString = scan.nextLine();

            try {
                oldCodigo = Integer.parseInt(newProductCodeString);

            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es un entero. Vuelva a intentarlo de nuevo.\n");
                validFormat = false;
            }

            if (validFormat) {
                if (esCodigoValido(oldCodigo)) {
                    validNewProductCode = true;
                } else {
                    System.err.println("Código del producto inexistente\n");
                }
            }
        }

        boolean cambioCodigoProducto = true;
        while (cambioCodigoProducto) {

            boolean codigoYaExistente = false;
            System.out.println("Entre el nuevo codigo: ");
            int newCod = scan.nextInt();

            for (Producto producto : losProductos) {
                if (newCod == producto.getCodigo()) {
                    codigoYaExistente = true;
                }
            }
            if (!codigoYaExistente) {
                var newProduct = new ProductDAOImp();
                newProduct.actualizarCodigo(oldCodigo, newCod);
                System.out.println(Color.GREEN + "Cambiado exitosamente" + Color.DEFAULT);
                cambioCodigoProducto = false;
            } else {
                System.err.println("El código introducido ya pertenece a otro producto.");
            }
        }
        //para volver a la pantalla de producto
        VistaProductos.opcionDesdeMenuProductos(empleadoAuten);

    }

    public void actualizarNombre() {

        int codigoEntrada = 0;
        boolean validNewProductCode = false;
        boolean validFormat = true;

        while (!validNewProductCode) {

            validFormat = true;
            imprimirProductos();
            System.out.print("Entre un codigo de un productos : ");
            String newProductCodeString = scan.nextLine();

            try {
                codigoEntrada = Integer.parseInt(newProductCodeString);

            } catch (NumberFormatException e) {
                System.err.println("Error - solo se aceptan enteros\n");
                validFormat = false;
            }

            if (validFormat) {
                if (esCodigoValido(codigoEntrada)) {

                    validNewProductCode = true;
                } else {
                    System.err.println("El codigo no existe \n");
                }
            }
        }
        System.out.println("Entre el nuevo nombre ");

        String newName = scan.nextLine();

        var newProduct = new ProductDAOImp();
        newProduct.actualizarNombre(codigoEntrada, newName);
        System.out.println(Color.GREEN + "Nombre cambiado exitosamente" + Color.DEFAULT);

        //para volver a la pantalla de producto
        VistaProductos.opcionDesdeMenuProductos(empleadoAuten);

    }

    public void actualizarPrecio() {

        int codigoEntrada = 0;
        boolean validNewProductCode = false;
        boolean validFormat = true;

        while (!validNewProductCode) {

            validFormat = true;
            imprimirProductos();
            System.out.print("Entre un codigo de un productos : ");
            String newProductCodeString = scan.nextLine();

            try {
                codigoEntrada = Integer.parseInt(newProductCodeString);

            } catch (NumberFormatException e) {
                System.err.println("Error - solo se aceptan enteros\n");
                validFormat = false;
            }

            if (validFormat) {
                if (esCodigoValido(codigoEntrada)) {

                    validNewProductCode = true;
                } else {
                    System.err.println("Código del producto inexistente\n");
                }
            }
        }
        System.out.println("entre el nuevo precio ");
        double nuevoPrecio = 0;
        String newCod = scan.next();
        try {
            nuevoPrecio = Double.parseDouble(newCod);

        } catch (NumberFormatException e) {
            System.err.println("Error - solo se acepta dobles\n");
            validFormat = false;
        }

        var newProduct = new ProductDAOImp();
        newProduct.actualizarPrecio(codigoEntrada, nuevoPrecio);

        System.out.println(Color.GREEN + "Precio cambiado exitosamente" + Color.DEFAULT);

        //para volver a la pantalla de producto
        VistaProductos.opcionDesdeMenuProductos(empleadoAuten);
        Pedido pedido = new Pedido();
        //pedido.leerProductos();

    }

    void imprimirProductos() {

        System.out.println(Color.BLUE + "\n************************************************" + Color.DEFAULT);
        for (Producto producto : losProductos) {
            System.out.printf("Codigo:\t\t%d%nNombre:\t\t%s%nDescripción:\t%s%nPrecio\t\t%.2f%n%n", producto.getCodigo(),
                    producto.getNombre(), producto.getDescripcion(), producto.getPrecio());

        }
        System.out.println(Color.BLUE + "************************************************\n" + Color.DEFAULT);
    }

}
