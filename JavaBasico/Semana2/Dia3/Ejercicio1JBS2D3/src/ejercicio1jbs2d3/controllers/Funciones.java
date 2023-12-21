package ejercicio1jbs2d3.controllers;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public class Funciones {

    String url = "jdbc:mysql://localhost:3306/universidad";
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "1234";
    Scanner sc = new Scanner(System.in);
    
    public Funciones() {
    }
    
    public void start() {
        int elecion=3;
        while(elecion!=0){
            System.out.println("Introduce\n0 Salir\n1 Insertar datos \n2 Mostrar");
            elecion=sc.nextInt();
            switch(elecion){
                case 0:
                    break;
                case 1:
                    crear();
                    break;
                case 2:
                    selectAll();
                    System.out.println("Introduce cualquier numero para salir excepto 0");
                    elecion=sc.nextInt();
                    break;
            }
        }
    }

    public void crear() {
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            String sqlInsert = "insert into estudiantes (nombre,edad,calificacion) values(?,?,?)";
            PreparedStatement st = con.prepareStatement(sqlInsert);
            System.out.println("Introduce el nombre");
            String nombre = sc.next();
            System.out.println("Introduce la edad");
            int edad = sc.nextInt();
            System.out.println("Introduce la calificacion");
            double calificacion = sc.nextDouble();
            st.setString(1, nombre);
            st.setInt(2, edad);
            st.setDouble(3, calificacion);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAll() {
        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,password);
            ResultSet result;
            String sql="select * from estudiantes";
            PreparedStatement st=con.prepareStatement(sql);
            result=st.executeQuery();
            while(result.next()){
                int id=result.getInt("id");
                String nombre=result.getString("nombre");
                int edad=result.getInt("edad");
                double calificacion=result.getDouble("calificacion");
                System.out.println("ID "+id+" Nombre "+nombre+" Edad "+edad+" Calificacion "+calificacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
