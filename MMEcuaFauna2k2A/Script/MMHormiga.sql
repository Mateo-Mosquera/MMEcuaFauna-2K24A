--database: ../DataBase/MMHormiguero.sqlite

DROP TABLE IF EXISTS Pais;
DROP TABLE IF EXISTS Region;
DROP TABLE IF EXISTS Provincia;
DROP TABLE IF EXISTS Alimento;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS Hormiga;



-- Tabla País
CREATE TABLE 
Pais (
    PaisId      INTEGER PRIMARY KEY AUTOINCREMENT,
    PaisNombre  TEXT NOT NULL
);

-- Tabla Región
CREATE TABLE Region (
    RegionId        INTEGER PRIMARY KEY AUTOINCREMENT,
    RegionNombre    TEXT NOT NULL,
    PaisId          INTEGER,
    FOREIGN KEY (PaisId) REFERENCES Pais (PaisId)

);

-- Tabla Provincia
CREATE TABLE Provincia (
    ProvinciaId     INTEGER PRIMARY KEY AUTOINCREMENT,
    ProvinciaNombre TEXT NOT NULL,
    RegionId INTEGER,
    FOREIGN KEY (RegionId) REFERENCES Region (RegionId)
);

-- Tabla Alimento
CREATE TABLE Alimento (
    AlimentoId      INTEGER PRIMARY KEY AUTOINCREMENT,
    AlimentoTipo    TEXT NOT NULL,  -- (Carnívoro, Herbívoro, Omnívoro, Insectívoros, X, XX, XY)
    IsGenoAlimento  BOOLEAN
);

-- Tabla Sexo
CREATE TABLE Sexo (
    SexoId      INTEGER PRIMARY KEY AUTOINCREMENT,
    SexoTipo    TEXT NOT NULL  -- (Macho, Hembra, Asexual)
);

-- Tabla Hormiga
CREATE TABLE Hormiga (
    HormigaId       INTEGER PRIMARY KEY AUTOINCREMENT,
    HormigaTipo     TEXT NOT NULL,
    SexoId          INTEGER,
    ProvinciaId     INTEGER,
    GenoAlimentoId  INTEGER,
    IngestaNativaId INTEGER,
    Status TEXT,
    FOREIGN KEY (SexoId) REFERENCES Sexo (SexoId),
    FOREIGN KEY (ProvinciaId) REFERENCES Provincia (ProvinciaId),
    FOREIGN KEY (GenoAlimentoId) REFERENCES Alimento (AlimentoId),
    FOREIGN KEY (IngestaNativaId) REFERENCES Alimento (AlimentoId)
);
