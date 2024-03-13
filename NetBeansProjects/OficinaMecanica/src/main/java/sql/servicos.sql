DROP TABLE IF EXISTS ordemservicos;
DROP TABLE IF EXISTS clientes; 
DROP TABLE IF EXISTS servicoreparomotor;
DROP TABLE IF EXISTS servicorevisaosuspensao;
DROP TABLE IF EXISTS servicotrocapneus;
DROP TABLE IF EXISTS servicos;



CREATE TABLE servicos(
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(50) NOT NULL,
    Custo VARCHAR(50),
    Status INT NOT NULL);

CREATE TABLE clientes( 
    Cpf VARCHAR(60) NOT NULL PRIMARY KEY, 
    Telefone VARCHAR(60) NOT NULL, 
    Nome VARCHAR(60) NOT NULL,
    Email VARCHAR(60) NOT NULL,
    PreferenciaContato INT NOT NULL);

CREATE TABLE servicoreparomotor(
    ComponenteReparado INT NOT NULL,
    RestauracaoMotor BOOLEAN NOT NULL,
    AjusteValvula BOOLEAN NOT NULL,
    RelatorioTecnico VARCHAR(100),
    ServicoID INT NOT NULL,
    FOREIGN KEY (ServicoID) REFERENCES servicos(Sequencial));

CREATE TABLE servicorevisaosuspensao(
    TipoSuspensao INT NOT NULL,
    TrocaMola BOOLEAN NOT NULL,
    VazamentoFluido BOOLEAN NOT NULL,
    ServicoID INT NOT NULL,
    FOREIGN KEY (ServicoID) REFERENCES servicos(Sequencial));

CREATE TABLE servicotrocapneus(
    MarcaPneu INT NOT NULL,
    Quantidade INT NOT NULL,
    Balanceamento BOOLEAN NOT NULL,
    Alinhamento BOOLEAN NOT NULL,
    ServicoID INT NOT NULL,
    FOREIGN KEY (ServicoID) REFERENCES servicos(Sequencial));


CREATE TABLE ordemservicos(
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TarefaRealizada INT NOT NULL,
    MetodoPagamento INT NOT NULL,
    ClienteID VARCHAR(60) NOT NULL,
    ServicoID INT NOT NULL,
    FOREIGN KEY (ClienteID) REFERENCES clientes(Cpf),
    FOREIGN KEY (ServicoID) REFERENCES servicos(Sequencial));