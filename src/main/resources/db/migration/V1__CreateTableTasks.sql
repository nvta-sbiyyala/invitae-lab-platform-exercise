DROP SCHEMA public CASCADE;
CREATE SCHEMA IF NOT EXISTS gene;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS gene.variant (
    id UUID PRIMARY KEY,
    gene VARCHAR(16) NOT NULL,
    nucleotideChange VARCHAR NOT NULL,
    proteinChange VARCHAR NOT NULL,
    lastEvaluated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
