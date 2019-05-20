package producto.control;

import java.util.List;
import producto.dao.ProductDAO;
import producto.dao.ProductDAOImp;

import producto.dominio.Producto;

public class ControladorProducto {

    static public List<Producto> readProductos() {
        ProductDAO pdao = new ProductDAOImp();
        return pdao.readProductos();
    }

}
