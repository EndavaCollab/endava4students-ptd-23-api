CREATE
DATABASE tjdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE SCHEMA tjsch_module2
    AUTHORIZATION postgres;

CREATE TABLE tjdb.tjsch_module2.users
(
    user_id    SERIAL       NOT NULL PRIMARY KEY,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(256) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL
);

CREATE TABLE tjdb.tjsch_module2.files
(
    file_id      SERIAL       NOT NULL PRIMARY KEY,
    file_name    VARCHAR(256) NOT NULL,
    title        VARCHAR(256) NOT NULL,
    file_content BYTEA        NOT NULL,
    created_date DATE         NOT NULL
);


CREATE TABLE tjdb.tjsch_module2.travel_journal
(
    travel_id       SERIAL       NOT NULL PRIMARY KEY,
    user_id         INT          NOT NULL REFERENCES tjdb.tjsch_module2.users (user_id),
    location        VARCHAR(256) NOT NULL,
    start_date      DATE         NOT NULL,
    end_date        DATE         NOT NULL,
    budget          DOUBLE PRECISION,
    description     TEXT,
    has_cover_photo BOOLEAN,
    file_id         INT REFERENCES tjdb.tjsch_module2.files (file_id)
);

CREATE TABLE tjdb.tjsch_module2.notes
(
    note_id              SERIAL       NOT NULL PRIMARY KEY,
    travel_id            INT          NOT NULL REFERENCES tjdb.tjsch_module2.travel_journal (travel_id),
    destination_name     VARCHAR(256) NOT NULL,
    start_date           DATE         NOT NULL,
    end_date             DATE         NOT NULL,
    note                 TEXT
);

CREATE TABLE tjdb.tjsch_module2.notes_files
(
    file_id INT NOT NULL REFERENCES tjdb.tjsch_module2.files (file_id),
    note_id INT NOT NULL REFERENCES tjdb.tjsch_module2.notes (note_id)
);
ALTER TABLE tjdb.tjsch_module2.notes_files
    ADD PRIMARY KEY (file_id, note_id);


--the changeit password will be changed to the password for the new user
CREATE
USER tjuser WITH PASSWORD 'changeit';

GRANT CONNECT
ON DATABASE tjdb TO tjuser;
ALTER
SCHEMA tjsch_module2 OWNER TO tjuser;
GRANT ALL
ON schema tjsch_module2 TO tjuser;
GRANT ALL
ON ALL TABLES IN SCHEMA tjsch_module2 TO tjuser;
GRANT ALL
ON ALL SEQUENCES IN SCHEMA tjsch_module2 TO tjuser;

INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('baiceaclaudiuadrian@gmail.com', encode(sha256('NanerBag'::bytea), 'hex'), 'Baicea', 'Claudiu Adrian');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('sgaibacristian@gmail.com', encode(sha256('sgaibacristian'::bytea), 'hex'), 'Sgaiba', 'Eugen Cristian');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('coceijanina@yahoo.com', encode(sha256('aninaj-hue'::bytea), 'hex'), 'Cocei', 'Janina Constantina');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('aditudor029@gmail.com', encode(sha256('adrian-tudor'::bytea), 'hex'), 'Tudor', 'Petre-Adrian');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('mihaialex_barascu@yahoo.com', encode(sha256('MihaiBarascu'::bytea), 'hex'), 'Barascu', 'Mihai Alexandru');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('iancovici.teodor.u6e@student.ucv.ro', encode(sha256('IancoviciTeodor1'::bytea), 'hex'), 'Iancovici', 'Teodor-Gabriel');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('anca.ilie29@gmail.com', encode(sha256('anca291'::bytea), 'hex'), 'Ilie', 'Anca-Elena');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('steriusmihnea@yahoo.com', encode(sha256('mihneacrs'::bytea), 'hex'), 'Carastere', 'Mihnea-Andrei');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('alex.mehedinteanu.95@gmail.com', encode(sha256('MehedAlexandru'::bytea), 'hex'), 'Mehedinteanu', 'Ioan-Alexandru');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('fstancu346@gmail.com', encode(sha256('Stancu2001'::bytea), 'hex'), 'Stancu', 'Daniel Florin');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('andrei_alexandru2305@yahoo.com', encode(sha256('D4rky23'::bytea), 'hex'), 'Midus', 'Andrei Alexandru');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('me.abel52@gmail.com', encode(sha256('abel325'::bytea), 'hex'), 'Mehedinteanu', 'Abel-Emanuel');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('monica.iliescu99@gmail.com', encode(sha256('monicailiescu'::bytea), 'hex'), 'Iliescu', 'Monica');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('mikid1997@gmail.com', encode(sha256('MihaiDuta30'::bytea), 'hex'), 'Duta', 'Mihai');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('gabrielionita2002@gmail.com', encode(sha256('Gqbriel02'::bytea), 'hex'), 'Ionita', 'Gabriel');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('claudiaolaru2002@gmail.com', encode(sha256('Claudita8'::bytea), 'hex'), 'Olaru', 'Claudia Florentina');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('birziloiu.mihaialexandru@outlook.com', encode(sha256('Nik00NN'::bytea), 'hex'), 'Birziloiu', 'Mihai-Alexandru');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('simion.dragos.z6r@student.ucv.ro', encode(sha256('0xDRAGOS'::bytea), 'hex'), 'Simion', 'Dragos Ionut');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('axyvisan13@yahoo.com', encode(sha256('Axy13'::bytea), 'hex'), 'Visan', 'Alexandru Daniel');
INSERT INTO tjdb.tjsch_module2.users (email, password, first_name, last_name)
VALUES ('ionicioiu.mihai.y7s@student.ucv.ro', encode(sha256('alexmihai392'::bytea), 'hex'), 'Ionicioiu', 'Mihai-Alexandru');


--SELECT * FROM tjdb.tjsch_module2.users;
--SELECT * FROM tjdb.tjsch_module2.files;
--SELECT * FROM tjdb.tjsch_module2.travel_journal;
--SELECT * FROM tjdb.tjsch_module2.notes;
--SELECT * FROM tjdb.tjsch_module2.notes_files;

-- detelete all data from tables
--DELETE FROM tjdb.tjsch_module2.notes_files;
--DELETE FROM tjdb.tjsch_module2.notes;
--DELETE FROM tjdb.tjsch_module2.travel_journal;
--DELETE FROM tjdb.tjsch_module2.files;
--DELETE FROM tjdb.tjsch_module2.users;

-- delete tables
--DROP TABLE IF EXISTS tjdb.tjsch_module2.notes_files;
--DROP TABLE IF EXISTS tjdb.tjsch_module2.notes;
--DROP TABLE IF EXISTS tjdb.tjsch_module2.travel_journal;
--DROP TABLE IF EXISTS tjdb.tjsch_module2.files;
--DROP TABLE IF EXISTS tjdb.tjsch_module2.users;