package ejercicio2jas1d1.services;

import ejercicio2jas1d1.models.Inventario;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public class InventoryManagement {

    public InventoryManagement() {
        gestionInventario();
    }

    public void gestionInventario() {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        System.out.println("Enter the product name");
        try {
            inventario.setName(sc.nextLine());
            if (inventario.getName().isBlank()) {
                throw new InventoryExceptions("Error, the product name cannot be empty");
            }
        } catch (InventoryExceptions e) {
            e.printStackTrace();
            System.exit(0);
        }
        try {
            System.out.println("Enter the product price");
            inventario.setPrice(sc.nextDouble());
            if(inventario.getPrice()>1000000){
                throw new InventoryExceptions("Error, the price cannot be more than one million");
            }else if(inventario.getPrice()<0){
                throw new InventoryExceptions("Error, the price cannot be lower than zero");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, you cannot enter a String in price");
            System.exit(0);
        }catch(InventoryExceptions e){
            e.printStackTrace();
            System.exit(0);
        }
        try {
            System.out.println("Enter the product amount");
            inventario.setAmount(sc.nextInt());
            if(inventario.getAmount()>10000){
                throw new InventoryExceptions("Error, the amount cannot be more than ten thousand");
            }else if(inventario.getAmount()<=0){
                throw new InventoryExceptions("Error, the amount cannot be lower or equal to zero");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, you cannot enter a String in amount");
            System.exit(0);
        }catch(InventoryExceptions e){
            e.printStackTrace();
            System.exit(0);
        }
    }

}
