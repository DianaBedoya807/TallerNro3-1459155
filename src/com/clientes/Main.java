package com.clientes;

import com.clases.Clientes;
import com.clases.Empresas;
import com.clases.Producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Clientes> clientes = new ArrayList<>();
    static List<Producto> productos = new ArrayList<>();
    static List<Empresas> empresas = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static String opcMenu;

    public static void main(String[] args) {
        String menu =
                "         * 1 Agregar cliente\n" +
                        "         * 2 Editar cliente\n" +
                        "         * 3 Eliminar cliente\n" +
                        "         * 4 Agregar productos\n" +
                        "         * 5 Consultar clientes con documento y tipo de documento \n" +
                        "         * 0 salir de la aplicacion";


        //Uso clico do while() para iniciar menu
        @Deprecated(since = "1.2", forRemoval = true)
        Integer opMenu = new Integer(0);

        /**
         * Segun el concepto de polimorfismo un objeto puede tener multiples formas
         * con la estructura de clase que se entrega por favor implementar el concepto de poliformismo
         */

        do {
            System.out.println(menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                    opcMenu = in.nextLine();
                    agregarCliente();
                    break;
                case "2":
                    opcMenu = in.nextLine();
                    editarCliente();
                    break;
                case "3":
                    opcMenu = in.nextLine();
                    eliminarCliente();
                    break;
                case "4":
                    opcMenu = in.nextLine();
                    agregarProducto();
                    break;
                case "5":
                    mostrarResultado();
                    break;
                case "0":
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();

    }

    public static void agregarCliente() {

        Clientes cliente = new Clientes();
        Clientes cliente1;

        System.out.println("Ingresa el tipo de documento: ");
        String tipoDoc = in.nextLine();

        System.out.println("Ingresa el documento");
        String doc = in.nextLine();

        cliente1 = new Clientes(tipoDoc, doc);

        System.out.println("Ingresa el nombre del cliente: ");
        cliente.setNombre(in.nextLine());

        System.out.println("Ingresa el telefono del cliente: ");
        cliente.setTelefono(in.nextLine());

        System.out.println("Ingresa la direccion del cliente: ");
        cliente.setDireccion(in.nextLine());

        System.out.println("Ingrese el id del producto: ");
        String idProducto = in.next();

        for (Producto producto: productos) {
            if(producto.getIdProducto().equals(idProducto)) {
                cliente.setProductos(productos);
                break;
            }
        }

        empresas.add(cliente1);
        clientes.add(cliente);
    }

    public static void editarCliente() {
        System.out.println("Ingresa el nombre del cliente a editar: ");
        String nombreCliente = in.nextLine();
        boolean clienteEncontrado = false;

        Iterator<Clientes> it = clientes.iterator();
        Clientes cliente;

        while (it.hasNext()) {

            cliente = it.next();

            if (cliente.getNombre().equals(nombreCliente)) {
                clienteEncontrado = true;
                String mensaje = cliente.toString();
                System.out.println("A continuación introduzca nuevos datos para este cliente\n" +
                        mensaje + "\n");

                System.out.println("Ingresa el nombre del cliente: ");
                cliente.setNombre(in.nextLine());

                System.out.println("Ingresa el telefono del cliente: ");
                cliente.setTelefono(in.nextLine());

                System.out.println("Ingresa la direccion del cliente: ");
                cliente.setDireccion(in.nextLine());

                System.out.println("Ingrese el id del producto: ");
                String idProducto = in.next();

                for (Producto producto: productos) {
                    if(producto.getIdProducto().equals(idProducto)) {
                        cliente.setProductos(productos);
                        break;
                    }
                }

                mensaje = cliente.toString();
                System.out.println(mensaje);

            }
        }
        if (clienteEncontrado == false) {
            System.out.println("No se encontró el cliente con ese nombre");
        }
    }

    private static void eliminarCliente() {
        System.out.println("Ingresa el nombre del cliente a eliminar: ");
        String nombreCliente = in.nextLine();
        boolean clienteEncontrado = false;

        Iterator<Clientes> it = clientes.iterator();
        Clientes cliente;

        while (it.hasNext() && clienteEncontrado == false) {

            cliente = it.next();

            if (cliente.getNombre().equals(nombreCliente)) {
                String mensaje = cliente.toString();
                System.out.println("\nSe eliminará el siguiente cliente\n" +
                        mensaje + "\n");

                clientes.remove(cliente);
                clienteEncontrado = true;
            }
        }
        if (clienteEncontrado == false) {
            System.out.println("No se encontró el cliente con ese nombre");
        }
    }

    public static void agregarProducto() {

        Producto producto = new Producto();

        System.out.println("Ingresa el nombre del producto: ");
        producto.setNombre(in.nextLine());

        System.out.println("Ingresa las caracteristicas del producto: ");
        producto.setCarateristicas(in.nextLine());

        System.out.println("Ingresa el id del producto: ");
        producto.setIdProducto(in.nextLine());

        System.out.println("Ingresa las condiciones del producto: ");
        producto.setCondiciones(in.nextLine());

        productos.add(producto);
    }

    //Este metodo es solo para probar que si esten guardando las listas correctamente
    public static void mostrarResultado() {
        System.out.println("Ingrese el Tipo de Documento: ");
        String busquedaTipDoc = in.next();

        System.out.println("Ingrese el Numero de Documento: ");
        String busquedaNumDoc = in.next();

        int indBusqueda = 9999;
        int i = 0;

        for (i = 0; i < clientes.size(); i++) {
            String clienteTipoDoc = empresas.get(i).getTipDoc();
            String clienteNumDoc  = empresas.get(i).getDocumento();

            if (clienteTipoDoc.equals(busquedaTipDoc)){
                if (clienteNumDoc.equals(busquedaNumDoc)){
                    indBusqueda = i;
                }
            }
        }

        if (indBusqueda != 9999){
            System.out.println("El cliente fue encontrado en la siguiente posición:" + indBusqueda);
            System.out.println("El Nombre Cliente: " + clientes.get(indBusqueda).getNombre());
            System.out.println("El Dirrecion Cliente: " + clientes.get(indBusqueda).getDireccion());
            System.out.println("El Teléfono Cliente: " + clientes.get(indBusqueda).getTelefono());

        } else {
            System.out.println("El cliente no existe.");
        }
    }
}
