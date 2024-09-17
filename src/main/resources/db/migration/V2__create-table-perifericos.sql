CREATE TABLE perifericos (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    computador_id UUID,
    CONSTRAINT fk_computador FOREIGN KEY (computador_id) REFERENCES computadores(id)
);
