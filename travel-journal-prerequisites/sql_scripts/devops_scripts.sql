CREATE DATABASE tjdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE SCHEMA tjsch
    AUTHORIZATION postgres;

CREATE TABLE tjdb.tjsch."user" (
	user_id 	SERIAL 		NOT NULL PRIMARY KEY,
	email 		VARCHAR(100) NOT NULL UNIQUE,
	password 	VARCHAR(256) NOT NULL,
	name 		VARCHAR(100) NOT NULL,
	surname 	VARCHAR(100) NOT NULL
);


CREATE TABLE tjdb.tjsch.travel_journal(
	entrance_id SERIAL 		 NOT NULL PRIMARY KEY,
	user_id 	INT 		 NOT NULL REFERENCES tjdb.tjsch."user"(user_id),
	location 	VARCHAR(255) NOT NULL,
	start_date 	DATE 		 NOT NULL,
	end_date 	DATE 		 NOT NULL
);

--the chaneit password will be changed to the password for the new user - put between the apostrophe signs
CREATE USER tjuser WITH PASSWORD changeit;

GRANT CONNECT ON DATABASE tjdb TO tjuser;
ALTER SCHEMA tjsch OWNER TO tjuser;
GRANT ALL ON schema tjsch TO tjuser;
GRANT ALL ON ALL TABLES IN SCHEMA tjsch TO tjuser;
GRANT ALL ON ALL SEQUENCES IN SCHEMA tjsch TO tjuser;

INSERT INTO tjdb.tjsch."user" (email, password, name, surname) VALUES ('test1@test.com', 'f5834e269a78fc0f28010bb56d8851aa9a8aff33b6eaf56d4c9008607be041b9', 'Test', '1');
INSERT INTO tjdb.tjsch."user" (email, password, name, surname) VALUES ('test2@test.com', 'f5834e269a78fc0f28010bb56d8851aa9a8aff33b6eaf56d4c9008607be041b9', 'Test', '2');


--SELECT * FROM tjdb.tjsch."user";
--SELECT * FROM tjdb.tjsch.travel_journal;

-- detelete all data from tables
--DELETE FROM tjdb.tjsch.travel_journal;
--DELETE FROM tjdb.tjsch."user";

-- delete tables
--DROP TABLE IF EXISTS tjdb.tjsch.travel_journal;
--DROP TABLE IF EXISTS tjdb.tjsch."user";