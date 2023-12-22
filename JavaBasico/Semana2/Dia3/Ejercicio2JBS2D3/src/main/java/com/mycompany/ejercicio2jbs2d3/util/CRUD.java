package com.mycompany.ejercicio2jbs2d3.util;

import com.mycompany.ejercicio2jbs2d3.controllers.PersistenceController;
import com.mycompany.ejercicio2jbs2d3.models.Platillos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public class CRUD {

    static PersistenceController controller = new PersistenceController();
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        int elecion = 6;
        while (elecion != 0) {
            System.out.println("Introduce\n0 Para salir\n1 Crear\n2 Editar\n3 Borrar\n4 Buscar\n5 Mostrar todos los platos");
            if (sc.hasNextInt()) {
                elecion = sc.nextInt();
                if (elecion <= 5 && elecion >= 0) {
                    switch (elecion) {
                        case 0:
                            sc.close();
                            break;
                        case 1:
                            create();
                            break;
                        case 2:
                            edit();
                            break;
                        case 3:
                            delete();
                            break;
                        case 4:
                            find();
                            break;
                        case 5:
                            findAll();
                            break;
                    }
                } else {
                    System.out.println("Error debes introducir un numero del 0 al 5");
                }
            } else {
                System.out.println("Error debe introducir un numero");
                sc.next();
            }
        }
    }

    public static void create() {
        System.out.println("Introduce el nombre del platillo");
        String platillo = sc.next();
        System.out.println("Introduce el origen de la receta ejemplo Italiana");
        String receta = sc.next();
        System.out.println("Introduce el precio");
        double precio = sc.nextDouble();
        Platillos plato = new Platillos(0, platillo, receta, precio);
        controller.createPlatillo(plato);
    }

    public static void edit() {
        System.out.println("Inreoduce el ID del platillo que quieres editar");
        int id = sc.nextInt();
        Platillos plato = controller.verPlato(id);
        int elecion = 4;
        while (elecion != 0) {
            System.out.println("Introduce\n0 Para salir\n1 Para editar nombre\n2 Para editar receta\n3 Para editar precio");
            elecion = sc.nextInt();
            switch (elecion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduce el nuevo nombre del platillo");
                    String platillo = sc.next();
                    plato.setNombre(platillo);
                    break;
                case 2:
                    System.out.println("Introduce el nuevo origen de la receta ejemplo Italiana");
                    String receta = sc.next();
                    plato.setReceta(receta);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo precio");
                    double precio = sc.nextDouble();
                    plato.setPrecio(precio);
                    break;
            }
        }
        controller.editPlatillo(plato);
    }

    public static void delete() {
        System.out.println("Introduce el ID del platillo que quieres eliminar");
        int id = sc.nextInt();
        controller.deletePlatillo(id);
    }

    public static void find() {
        System.out.println("Introduce el ID del platillo que quieres ver");
        int id = sc.nextInt();
        System.out.println(controller.verPlato(id).toString());
    }

    public static void findAll() {
        ArrayList<Platillos> platos = controller.verPlatos();
        for (Platillos data : platos) {
            System.out.println(data);
        }
    }

}
