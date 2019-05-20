package app.principal;

import factura.Pedido;
import producto.dao.ProductDAOImp;
import tienda.control.GestionTienda;

public class MainApp {

    public static void main(String[] args) {

        GestionTienda gestionTienda = new GestionTienda();
        gestionTienda.iniciar();
       
    }

}
