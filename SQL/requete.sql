CREATE TABLE place (
    id_place int PRIMARY KEY,
    place_name VARCHAR(255) NOT NULL,
    address VARCHAR(255)
);

CREATE TABLE client (
    id_client int PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    address VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE rdv (
    id_appointment int PRIMARY KEY,
    appointment_request TIMESTAMP,
    appointment_date TIMESTAMP,
    description TEXT,
    id_client INT REFERENCES client(id_client),
    id_place INT REFERENCES place(id_place)
);
