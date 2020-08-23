CREATE TABLE license
(
    license_id        VARCHAR(100) PRIMARY KEY NOT NULL,
    organization_id   TEXT                     NOT NULL,
    license_type      TEXT                     NOT NULL,
    product_name      TEXT                     NOT NULL,
    license_max       INT                      NOT NULL,
    license_allocated INT,
    comment           VARCHAR(1000)
);

COPY license (organization_id, license_id, product_name, license_type, license_max, license_allocated, comment)
    FROM '/license_data.csv'
    DELIMITER ','
    CSV HEADER;


CREATE TABLE organization
(
    organization_id VARCHAR(100) PRIMARY KEY NOT NULL,
    name            TEXT                     NOT NULL,
    contact_name    TEXT                     NOT NULL,
    contact_email   TEXT                     NOT NULL,
    contact_phone   TEXT                     NOT NULL
);

COPY organization (organization_id, contact_email, contact_name, contact_phone, name)
    FROM '/organization_data.csv'
    DELIMITER ','
    CSV HEADER;

CREATE USER licensingservice WITH PASSWORD 'qwerty';

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE license TO licensingservice;

CREATE USER organizationservice WITH PASSWORD 'qwerty';

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE organization TO organizationservice;