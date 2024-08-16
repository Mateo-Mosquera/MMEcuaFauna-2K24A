package MMBusinessLogic;

import MMDataAccess.MMDTO.MMHormigaDTO;
import MMDataAccess.MMDAO.MMHormigaDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MMHormigaBL {
    private MMHormigaDAO hormigaDAO;

    public MMHormigaBL(Connection connection) {
        this.hormigaDAO = new MMHormigaDAO(connection);
    }

    public void addHormiga(MMHormigaDTO hormiga) throws SQLException {
        hormigaDAO.create(hormiga);
    }

    public List<MMHormigaDTO> getAllHormigas() throws SQLException {
        return hormigaDAO.readAll();
    }

    public void updateHormiga(MMHormigaDTO hormiga) throws SQLException {
        hormigaDAO.update(hormiga);
    }

    public void deleteHormiga(int id) throws SQLException {
        hormigaDAO.delete(id);
    }
    
    // Método simulado para obtener nombres de hormigas
    public List<String> getHormigaNames() {
        List<String> hormigas = new ArrayList<>();
        hormigas.add("Hormiga 1");
        hormigas.add("Hormiga 2");
        hormigas.add("Hormiga 3");
        // Agrega más nombres según sea necesario
        return hormigas;
    }
}
