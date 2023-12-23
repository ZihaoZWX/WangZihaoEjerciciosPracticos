package ejercicio1jbs2d3.controllers;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public Funciones() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        start(con);
    }

    public void start(Connection con) throws SQLException {
        int elecion = 6;

        while (elecion != 0) {
            System.out.println("Introduce\n0 Salir\n1 Insertar datos \n2 Mostrar\n3 Busqueda avanzada\n4 Editar\n5 Borrar");
            if (sc.hasNextInt()) {
                elecion = sc.nextInt();
                switch (elecion) {
                    case 0:
                        con.close();
                        break;
                    case 1:
                        crear(con);
                        break;
                    case 2:
                        selectAll(con);
                        break;
                    case 3:
                        select(con);
                        break;
                    case 4:
                        editar(con);
                        break;
                    case 5:
                        borrar(con);
                        break;
                }
            } else {
                System.out.println("Debes introducir un numero");
                sc.next();
            }
        }

    }

    public void crear(Connection con) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAll(Connection con) {
        try {
            ResultSet result;
            String sql = "select * from estudiantes";
            PreparedStatement st = con.prepareStatement(sql);
            result = st.executeQuery();
            System.out.println("---------------------------------------------------------");
            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                int edad = result.getInt("edad");
                double calificacion = result.getDouble("calificacion");
                System.out.println("ID " + id + " Nombre " + nombre + " Edad " + edad + " Calificacion " + calificacion);
            }
            System.out.println("---------------------------------------------------------");
            st.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(Connection con) {
        try {
            System.out.println("Introduce el id del estudiante que quieres buscar");
            int id = sc.nextInt();
            String sql = "select * from estudiantes where id=?";
            ResultSet result;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            result = st.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                String nombre = result.getString("nombre");
                int edad = result.getInt("edad");
                double calificacion = result.getDouble("calificacion");
                System.out.println("---------------------------------------------------------");
                System.out.println("ID " + id + " Nombre " + nombre + " Edad " + edad + " Calificacion " + calificacion);
                System.out.println("---------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Connection con) {
        try {
            System.out.println("Introduce el id del estudiante a editar");
            int id = sc.nextInt();
            String sql = "select * from estudiantes where id=?";
            ResultSet result;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            result = st.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                String nombre = result.getString("nombre");
                int edad = result.getInt("edad");
                double calificacion = result.getDouble("calificacion");
                System.out.println("ID " + id + " Nombre " + nombre + " Edad " + edad + " Calificacion " + calificacion);
                int ele = 4;

                while (ele != 0) {
                    System.out.println("Introduce\n0 Para salir\n1 Para editar nombre\n2 Para editar edad\n3 Para editar calificacion");
                    if (sc.hasNextInt()) {
                        ele = sc.nextInt();
                        switch (ele) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Introduce el nombre nuevo");
                                nombre = sc.next();
                                break;
                            case 2:
                                System.out.println("Introduce la edad nueva");
                                edad = sc.nextInt();
                                break;
                            case 3:
                                System.out.println("Introduce la calificacion nueva");
                                calificacion = sc.nextDouble();
                                break;
                        }

                    } else {
                        System.out.println("Debes introducir un numero");
                        sc.next();
                    }
                }
                String sql2 = "update estudiantes set nombre=?,edad=?,calificacion=? where id=?";
                st = con.prepareStatement(sql2);
                st.setString(1, nombre);
                st.setInt(2, edad);
                st.setDouble(3, calificacion);
                st.setInt(4, id);
                st.executeUpdate();
                System.out.println("Filas actualizadas");
            } else {
                System.out.println("No existe ese estudiante");
            }

            st.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrar(Connection con) throws SQLException {
        String sql = "delete from estudiantes where id=?";
        System.out.println("Introduce el id del estudiante que quieras eliminar");
        int id = sc.nextInt();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        st.executeUpdate();
        System.out.println("Datos eliminados con exito");
    }

}
