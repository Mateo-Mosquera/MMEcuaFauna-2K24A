package MMDataAccess.MMDTO;

public class MMHormigaDTO {
    private String mmTipoHormiga;
    private String mmSexo;
    private String mmProvincia;
    private String mmGenoAlimento;
    private String mmIngestaNativa;
    private String mmEstado;

    // Constructor
    public MMHormigaDTO(String mmTipoHormiga, String mmSexo, String mmProvincia, String mmGenoAlimento, String mmIngestaNativa, String mmEstado) {
        this.mmTipoHormiga = mmTipoHormiga;
        this.mmSexo = mmSexo;
        this.mmProvincia = mmProvincia;
        this.mmGenoAlimento = mmGenoAlimento;
        this.mmIngestaNativa = mmIngestaNativa;
        this.mmEstado = mmEstado;
    }

    // Getters and Setters
    public String getMmTipoHormiga() { return mmTipoHormiga; }
    public void setMmTipoHormiga(String mmTipoHormiga) { this.mmTipoHormiga = mmTipoHormiga; }
    public String getMmSexo() { return mmSexo; }
    public void setMmSexo(String mmSexo) { this.mmSexo = mmSexo; }
    public String getMmProvincia() { return mmProvincia; }
    public void setMmProvincia(String mmProvincia) { this.mmProvincia = mmProvincia; }
    public String getMmGenoAlimento() { return mmGenoAlimento; }
    public void setMmGenoAlimento(String mmGenoAlimento) { this.mmGenoAlimento = mmGenoAlimento; }
    public String getMmIngestaNativa() { return mmIngestaNativa; }
    public void setMmIngestaNativa(String mmIngestaNativa) { this.mmIngestaNativa = mmIngestaNativa; }
    public String getMmEstado() { return mmEstado; }
    public void setMmEstado(String mmEstado) { this.mmEstado = mmEstado; }
}
