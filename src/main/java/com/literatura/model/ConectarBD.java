import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectarBD {
    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:postgresql://localhost:5432/biblioteca"; // Nombre de tu base de datos
        String user = "postgres"; // Tu usuario de PostgreSQL
        String password = "011001"; // Tu contraseña

        // Establecer la conexión
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa.");

            // Crear una sentencia SQL
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM autores"; // Ejemplo de consulta

            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery(sql);

            // Mostrar los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
