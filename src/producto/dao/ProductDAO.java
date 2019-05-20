
package producto.dao;

import java.util.List;
import producto.dominio.Producto;


public interface ProductDAO {

    List<Producto> readProductos();  //Read

    void actualizarNombre(int productCode, String productName);
    void actualizarPrecio(int productCode, double productPrice);
    void actualizarCodigo(int productCode, int productNewCode);
    void escribirEnBD(int productCode, Producto product);
  
//    @Override
//    String toString();

}
