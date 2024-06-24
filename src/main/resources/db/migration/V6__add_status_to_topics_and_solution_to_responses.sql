-- Adiciona a coluna status à tabela topics
ALTER TABLE topics ADD COLUMN status BOOLEAN;

-- Adiciona a coluna solution à tabela responses
ALTER TABLE responses ADD COLUMN solution BOOLEAN;


