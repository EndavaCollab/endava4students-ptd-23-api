CREATE DATABASE travel_journal
    WITH
    OWNER 			 = postgres
    ENCODING 		 = 'UTF8'
    LC_COLLATE 		 = 'Romanian_Romania.1252'
    LC_CTYPE 		 = 'Romanian_Romania.1252'
    TABLESPACE 		 = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE 	 = False;

CREATE TABLE "user" (
	user_id 	SERIAL 		NOT NULL PRIMARY KEY,
	email 		VARCHAR(100) NOT NULL UNIQUE,
	password 	VARCHAR(256) NOT NULL
);


CREATE TABLE travel_journal(
	entrance_id SERIAL 		 NOT NULL PRIMARY KEY,
	user_id 	INT 		 NOT NULL REFERENCES "user"(user_id),
	location 	VARCHAR(255) NOT NULL,
	start_date 	DATE 		 NOT NULL,
	end_date 	DATE 		 NOT NULL
);

SELECT * FROM "user";

INSERT INTO "user" (email, password) VALUES ('test1@test.com', 'f5834e269a78fc0f28010bb56d8851aa9a8aff33b6eaf56d4c9008607be041b9');
INSERT INTO "user" (email, password) VALUES ('test21@test.com', 'f5834e269a78fc0f28010bb56d8851aa9a8aff33b6eaf56d4c9008607be041b9');

UPDATE "user" SET email = 'test2@test.com' WHERE user_id = 2;

SELECT * FROM travel_journal;

INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (1, 'Rome, Italy', '2024-07-12', '2024-07-18');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (1, 'Milano, Italy', '2024-07-18', '2024-07-22');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (1, 'Venice, Italy', '2024-07-18', '2024-07-22');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Thassos, Greece', '2023-06-01', '2023-06-10');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Cairo, Egypt', '2024-10-21', '2024-10-28');
--INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Sydney, Australia', '2025-02-02', '2023-02-30');--error
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Sydney, Australia', '2025-02-02', '2023-02-28');

INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (1, 'Moscow, Russia', '2023-08-12', '2022-08-23');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (1, 'New Yorl, USA', '2024-07-18', '2024-06-22');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Dubai, United Arabic Emirates', '2024-04-01', '2024-04-01');
INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Tokyo, Japan', '2024-02-28', '2024-02-29');
--INSERT INTO travel_journal (user_id, location, start_date, end_date) VALUES (2, 'Thailand, Bangkok', '2025-02-28', '2025-02-29'); --error

SELECT * FROM travel_journal ORDER BY user_id;
SELECT u.user_id, COUNT(tj.location) FROM travel_journal  AS tj INNER JOIN "user" AS u ON tj.user_id = u.user_id GROUP BY u.user_id;

SELECT * FROM "user";
ALTER TABLE "user" ADD COLUMN name VARCHAR(100);
ALTER TABLE "user" ADD COLUMN surname VARCHAR(100);
UPDATE "user" SET name = 'Test', surname = '1' WHERE user_id = 1 AND email = 'test1@test.com';
UPDATE "user" SET name = 'Test', surname = '2'  WHERE user_id = 2 AND email = 'test2@test.com';

SELECT u.name, u.surname, tj.location, tj.start_date, tj.end_date
		FROM travel_journal AS tj INNER JOIN "user" AS u ON tj.user_id = u.user_id
		WHERE u.user_id = 1;

SELECT u.name, u.surname, u.email, tj.location, tj.start_date, tj.end_date
		FROM travel_journal AS tj INNER JOIN "user" AS u ON tj.user_id = u.user_id
		WHERE u.user_id = 2;

SELECT * FROM travel_journal WHERE end_date < start_date;
UPDATE travel_journal SET end_date = start_date WHERE end_date < start_date;

SELECT * FROM travel_journal WHERE end_date = start_date;
DELETE FROM travel_journal WHERE end_date = start_date;

SELECT * FROM "user";
SELECT * FROM travel_journal;

-- detelete all data from tables
DELETE FROM travel_journal;
DELETE FROM "user";

-- delete tables
DROP TABLE IF EXISTS travel_journal;
DROP TABLE IF EXISTS "user";
