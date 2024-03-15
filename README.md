# How to start the app in Docker containers

**Important!** Please make sure to install Docker Desktop application in order to be able to use `docker` and `docker-compose` commands.

### Compiling `travel-journal-api`
* run command `mvn clean install` or `mvn clean package` to create the jar file (from /travel-journal-api folder).


## Build the docker images:
<hr/>

* Run command
  `docker-compose build --build-arg DB_HOST=host_name_or_ip_of_host --build-arg DB_PWD=password_for_postgress_db`

This command will download and build the images necessary.

## Start the containers:
<hr/>

* Run command
  `docker-compose up`

This command will start the containers. Depending on the host, the UI can be accessed using the name or ip of the host, on port 5173<br/>
ex: `http://localhost:5173`, `http://13.73.187.21:5173/`

Note: If you run the containers locally and try to connect to the DB on the Endava virtual machine on Azure, be sure to be connected to VPN