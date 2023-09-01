INSERT INTO place (id_place, place_name, address) VALUES
    (1, 'Salle A', '123 Rue Principale'),
    (2, 'Bureau B', '456 Avenue Secondaire'),
    (3, 'Salle de Conférence', '789 Place Centrale'),
    (4, 'Espace Coworking', '555 Rue des Innovateurs'),
    (5, 'Salle de Réunion', '888 Avenue Collaborative');

INSERT INTO client (id_client, name, phone_number, address, email) VALUES
    (1, 'Alice Johnson', '123-456-7890', '321 Elm Street', 'alice@example.com'),
    (2, 'Bob Smith', '987-654-3210', '456 Oak Avenue', 'bob@example.com'),
    (3, 'Carol Davis', '555-555-5555', '789 Pine Drive', 'carol@example.com'),
    (4, 'David White', '111-222-3333', '123 Maple Lane', 'david@example.com'),
    (5, 'Eve Brown', '999-888-7777', '555 Birch Road', 'eve@example.com');

INSERT INTO rdv (id_appointment, appointment_request, appointment_date, description, id_client, id_place) VALUES
    (1, '2023-09-01 10:00:00', '2023-09-01 10:00:00', 'Réunion hebdomadaire', 1, 1),
    (2, '2023-09-02 15:30:00', '2023-09-02 15:30:00', 'Entretien de recrutement', 2, 3),
    (3, '2023-09-03 14:00:00', '2023-09-03 14:00:00', 'Présentation du projet', 3, 2),
    (4, '2023-09-04 11:45:00', '2023-09-04 11:45:00', 'Consultation juridique', 4, 5),
    (5, '2023-09-05 09:30:00', '2023-09-05 09:30:00', 'Réunion d''équipe', 5, 4);
