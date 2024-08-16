package MMBusinessLogic;

import java.util.List;

import MMDataAccess.MMDAO.MMHormigaDAO;
import MMDataAccess.MMDAO.MMIngestaNativaDAO;
import MMDataAccess.MMDTO.MMHormigaDTO;
import MMDataAccess.MMDTO.MMIngestaNativaDTO;

public class MMHormigaBL {
    
    private MMHormigaDAO hormigaDAO;
    private MMIngestaNativaDAO ingestaNativaDAO;
    
    public MMHormigaBL() {
        this.hormigaDAO = new MMHormigaDAO();
        this.ingestaNativaDAO = new MMIngestaNativaDAO(); // Inicializar ingestaNativaDAO
    }
    
    //Metodo para obtener NombreIngestaNativa 
    public String obtenerNombreIngestaNativa(int idIngestaNativa) throws Exception{
        MMIngestaNativaDTO ingestaNativa = ingestaNativaDAO.mmReadBy(idIngestaNativa);
        return ingestaNativa != null ? ingestaNativa.getNombre().toUpperCase(): "N/A";
    }

    //Metodo para obtener Nombre Sexo 
    public String obtenerSexo(int idHormiga) throws Exception {
        MMHormigaDTO hormiga = hormigaDAO.mmReadBy(idHormiga);
        return hormiga != null ? hormiga.getNombre().toUpperCase() : "N/A";
    }
    
    //Metodo para obtener Nombre GenoAlimento 
    public String obtenerGenoAlimento(int idGenoAlimento) throws Exception {
        MMIngestaNativaDTO genoAlimento = ingestaNativaDAO.mmReadBy(idGenoAlimento);
        return genoAlimento != null ? genoAlimento.getNombre().toUpperCase() : "N/A";
    }

    public String obtenerProvincia(int idHormiga) throws Exception {
        MMHormigaDTO hormiga = hormigaDAO.mmReadBy(idHormiga);
        return hormiga != null ? hormiga.getNombre().toUpperCase() : "N/A";
    }

    public String obtenerTipoHormiga(int idHormiga) throws Exception {
        MMHormigaDTO hormiga = hormigaDAO.mmReadBy(idHormiga);
        return hormiga != null ? hormiga.getTipoHormiga().toUpperCase() : "N/A";
    }    
    


    public boolean crearHormiga(MMHormigaDTO hormiga) throws Exception {
        // Validaciones de negocio antes de crear la hormiga
        if (hormiga.getNombre() == null || hormiga.getNombre().isEmpty()) {
            throw new Exception("El nombre de la hormiga es obligatorio.");
        }
        // Otras validaciones...

        // Llamada al DAO para crear la hormiga
        return hormigaDAO.mmCreate(hormiga);
    }

    public List<MMHormigaDTO> obtenerHormigas() throws Exception {
        // Lógica adicional si es necesario
        return hormigaDAO.mmReadAll();
    }

    public boolean actualizarHormiga(MMHormigaDTO hormiga) throws Exception {
        // Validaciones de negocio antes de actualizar la hormiga
        if (hormiga.getIdHormiga() == null) {
            throw new Exception("El ID de la hormiga es obligatorio para la actualización.");
        }
        // Otras validaciones...

        // Llamada al DAO para actualizar la hormiga
        return hormigaDAO.mmUpdate(hormiga);
    }

    public boolean eliminarHormiga(int idHormiga) throws Exception {
        // Validaciones de negocio antes de eliminar la hormiga
        if (idHormiga <= 0) {
            throw new Exception("ID de hormiga inválido.");
        }
        // Otras validaciones...

        // Llamada al DAO para eliminar (o marcar como eliminada) la hormiga
        return hormigaDAO.mmDelete(idHormiga);
    }

    public MMHormigaDTO obtenerHormigaPorId(int idHormiga) throws Exception {
        // Lógica adicional si es necesario
        return hormigaDAO.mmReadBy(idHormiga);
    }
}
        