# Sql scripts

**Important!** Please make sure to run the sql scripts from `scripts_module2.sql` file located on `\travel-journal-prerequisites\sql_scripts\`

# How to start the app in Docker containers

**Important!** Please make sure to install `Docker Desktop` / `Rancher Desktop` application in order to be able to use `docker` and `docker-compose` commands.

## Compiling `travel-journal-api`
* run command `mvn clean install` or `mvn clean package` to create the jar file (from /travel-journal-api folder).

## Running on local
<hr/>

Running the application on local requires to create a run configuration that includes the values for `db_host` and `db_pwd`, necessary to connect to the database.
A run configuration in IntelliJ can be created from the top right corner, near the Run (Play) button. (One will be created automatically on first run, and you can edit that configuration)
When editing the configuration, add the following environment variables:
`db_host=localhost;db_pwd=your_passowrd`
* the password is the password you set for the user `tjuser` following the SQL scripts
* If the `Environment variables` section is not visible, make sure to enable by clicking `Modify options` and checking `Environment variables`

## Running on Docker 
<hr/>

### Build the docker images:

* Run command
`docker-compose build --build-arg DB_HOST=host_name_or_ip_of_host --build-arg DB_PWD=password_for_postgress_db`<br/>
#### Notes:
* When run on the local machine, `DB_HOST` is your local IP. Do not use `localhost` as this would mean the docker container localhost<br/>
* `DB_PWD` is the password you set for the user `tjuser` following the SQL scripts. Example: user: `tjuser`, password: `changeit`

This command will download and build the images necessary. No manual compile step is necessary

### Start the containers:

In order to successfully start the containers, a few extra steps are necessary:
* Depending on the OS, make sure there is a firewall inbound rule to allow connections to port 5432. This is because PostgreSQL is running on localhost and the containers must be allowed to connect to it
* Furthermore, PostgreSQL must be configured to accept the connection:
  * Make sure in `postgresl.conf` you have `listen_addresses = '*'`, so that PostgresQL listens on all addresses
  * Add the following line to `pg_hba.conf` at the `IPv4 local connections` section :
    * host    all             all             0.0.0.0/0       scram-sha-256

#### Notes:
* `postgresl.conf` and `pg_hba.conf` can be typically found in the `data` folder of the postgresql installation folder  
* postgresql service must be restarted after these changes
<hr/>

* Run command
  `docker-compose up`

This command will start the containers. Depending on the host, the UI can be accessed using the name or ip of the host, on port 5173<br/>
ex: `http://localhost:5173`, `http://13.73.187.21:5173/`

<hr/>

### Using Windows Subsystem for Linux 2 (WSL 2)
* Open two Linux terminals in the api project folder
* In the first terminal run `sudo dockerd` to start the docker engine
* In the second terminal run the two commands from the previous section (prefixed by sudo) to build and run the docker images
#### Notes:
* Localhost is valid as the host
* The firewall and PostgreSQL configurations are not required

<hr/>

#### Note:
If you run the containers locally and try to connect to the DB on the Endava virtual machine on Azure, be sure to check the VM Network settings to allow connections from your IP
