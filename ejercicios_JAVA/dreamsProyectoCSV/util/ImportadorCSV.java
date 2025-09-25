package util;

import db.ConexionDB;
import model.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImportadorCSV {
    public static void importarProductos(String rutaCSV) {
        String sql = "INSERT INTO productos (nombre, precio, categoria, stock) VALUES (?, ?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV));
             Connection conn = ConexionDB.conectar()) {

            String linea;
            br.readLine(); // Saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, datos[0]);
                    stmt.setDouble(2, Double.parseDouble(datos[1]));
                    stmt.setString(3, datos[2]);
                    stmt.setInt(4, Integer.parseInt(datos[3]));
                    stmt.executeUpdate();
                }
            }

            System.out.println("Productos importados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //cargar productos desde PostgreSQL
    public static List<Producto> cargarProductosDesdeBD() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT nombre, precio, categoria, stock FROM productos";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String categoria = rs.getString("categoria");
                int stock = rs.getInt("stock");

                Producto producto = new Producto(nombre, precio, categoria, stock);
                lista.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}

