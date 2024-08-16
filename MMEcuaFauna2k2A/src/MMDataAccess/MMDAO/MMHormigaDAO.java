package MMDataAccess.MMDAO;

import MMDataAccess.MMDTO.MMHormigaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MMHormigaDAO {
    private Connection connection;

    public MMHormigaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(MMHormigaDTO hormiga) throws SQLException {
        String sql = "INSERT INTO MMHormiga (TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, hormiga.getMmTipoHormiga());
            pstmt.setString(2, hormiga.getMmSexo());
            pstmt.setString(3, hormiga.getMmProvincia());
            pstmt.setString(4, hormiga.getMmGenoAlimento());
            pstmt.setString(5, hormiga.getMmIngestaNativa());
            pstmt.setString(6, hormiga.getMmEstado());
            pstmt.executeUpdate();
        }
    }

    public List<MMHormigaDTO> readAll() throws SQLException {
        List<MMHormigaDTO> hormigas = new ArrayList<>();
        String sql = "SELECT * FROM MMHormiga";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MMHormigaDTO hormiga = new MMHormigaDTO(
                        rs.getString("TipoHormiga"),
                        rs.getString("Sexo"),
                        rs.getString("Provincia"),
                        rs.getString("GenoAlimento"),
                        rs.getString("IngestaNativa"),
                        rs.getString("Estado")
                );
                hormigas.add(hormiga);
            }
        }
        return hormigas;
    }

    public void update(MMHormigaDTO hormiga) throws SQLException {
        String sql = "UPDATE MMHormiga SET TipoHormiga = ?, Sexo = ?, Provincia = ?, GenoAlimento = ?, IngestaNativa = ?, Estado = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, hormiga.getMmTipoHormiga());
            pstmt.setString(2, hormiga.getMmSexo());
            pstmt.setString(3, hormiga.getMmProvincia());
            pstmt.setString(4, hormiga.getMmGenoAlimento());
            pstmt.setString(5, hormiga.getMmIngestaNativa());
            pstmt.setString(6, hormiga.getMmEstado());
            //pstmt.setInt(7, hormiga.getMmId());  // Suponiendo que tienes un campo id
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM MMHormiga WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
