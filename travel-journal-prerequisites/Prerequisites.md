## Prerequisites for Endava for Students program

* [1. Intellij Educational Edition](#intellij)
* [2. OpenJDK 20](#openjdk)
* [3. Maven](#maven)
* [4. Environment Variables](#environment_variables)
* [5. Git](#git)
  * [5.1 Instalation](#git_instalation)
  * [5.2 Set SSH](#git_ssh)
* [6. PostgreSql](#postgresql)
* [7. Postman](#postman)
* [8. Node & NPM](#nodenpm)
* [9. Clone UI project](#cloneui)


<a name="intellij"></a>
# 1. Intellij Educational Edition
IntelliJ IDEA, developed by JetBrains, is an integrated development environment (IDE) for developing computer software written in Java, Kotlin, Groovy, and other JVM-based languages.

Go to <a href="https://www.jetbrains.com/idea/download/?section=windows">Intellij Community Edition</a> and download the latest version for Windows.

![DownloadIntellijEducationalEdition](artefacts/IntellijCommunity/IntellijCommunity_1.PNG)

Proceed with installation:

![IntellijEducationalEditionStep1](artefacts/IntellijCommunity/IntellijCommunity_2.PNG)

![IntellijEducationalEditionStep2](artefacts/IntellijCommunity/IntellijCommunity_3.PNG)

![IntellijEducationalEditionStep3](artefacts/IntellijCommunity/IntellijCommunity_4.PNG)

![IntellijEducationalEditionStep4](artefacts/IntellijCommunity/IntellijCommunity_5.PNG)

![IntellijEducationalEditionStep5](artefacts/IntellijCommunity/IntellijCommunity_6.PNG)

![IntellijEducationalEditionStep6](artefacts/IntellijCommunity/IntellijCommunity_7.PNG)

<a name="openjdk"></a>
# 2. OpenJDK 20

In Intellij create a new Project:

![OpenJDKStep1](artefacts/OpenJDK/OpenJDK_1.PNG)

After inserting the project's name go to SDK filed:

![OpenJDKStep2](artefacts/OpenJDK/OpenJDK_2.PNG)

Click on the arrow and select Download SDK:

![OpenJDKStep3](artefacts/OpenJDK/OpenJDK_3.PNG)

Select OpenJDK 20 (latest version):

![OpenJDKStep4](artefacts/OpenJDK/OpenJDK_4.PNG)

Press create:

![OpenJDKStep5](artefacts/OpenJDK/OpenJDK_5.PNG)

<a name="maven"></a>
# 3. Maven
Maven is a build automation tool used primarily for Java projects.

Go to <a href="https://maven.apache.org/download.cgi">Apache Maven</a> and download the binary zip archive.

![MavenStep1](artefacts/Maven/Maven_1.PNG)

Create a folder named Maven in C:/Program Files/Maven and unzip the downloaded archive there:

![MavenStep2](artefacts/Maven/Maven_2.PNG)

<a name="environment_variables"></a>
# 4. Environment Variables
Environment variables are variables in an operating system that store information used by programs and processes running on the system. They provide a way to pass configuration settings, system information, and other data to applications without hardcoding them into the program's code.

In order to set your environment variables for java and maven press Windows and search for Environment Variables:

![EnvironmentVariablesStep1](artefacts/EnvironmentVariables/Environment_Variables_1.PNG)

![EnvironmentVariablesStep2](artefacts/EnvironmentVariables/Environment_Variables_2.PNG)


To create an environment variable for JDK press New on User variables section:

![EnvironmentVariablesStep3](artefacts/EnvironmentVariables/Environment_Variables_3.PNG)

Variable name should be %JAVA_HOME% and the variable value should be the path to openJdk folder:

![EnvironmentVariablesStep4](artefacts/EnvironmentVariables/Environment_Variables_4.PNG)

![EnvironmentVariablesStep4](artefacts/EnvironmentVariables/Environment_Variables_5.PNG)

![EnvironmentVariablesStep6](artefacts/EnvironmentVariables/Environment_Variables_6.PNG)

![EnvironmentVariablesStep7](artefacts/EnvironmentVariables/Environment_Variables_7.PNG)

Repeat the steps to create MAVEN_HOME:

![EnvironmentVariablesStep8](artefacts/EnvironmentVariables/Environment_Variables_8.PNG)

Then add both variables to Path variable:

![EnvironmentVariablesStep9](artefacts/EnvironmentVariables/Environment_Variables_9.PNG)

![EnvironmentVariablesStep10](artefacts/EnvironmentVariables/Environment_Variables_10.PNG)

![EnvironmentVariablesStep11](artefacts/EnvironmentVariables/Environment_Variables_11.PNG)

<a name="git"></a>
# 5. Git
GIT is a distributed version control system (VCS) used for tracking changes in source code and coordinating work among multiple developers.

<a name="git_instalation"></a>
# 5.1 Instalation
Go to <a href="https://gitforwindows.org/">Apache Maven</a> and download it.

Open the file and follow the next steps:

![GitStep1](artefacts/Git/Installation/Git_Installation_1.PNG)

![GitStep2](artefacts/Git/Installation/Git_Installation_2.PNG)

![GitStep3](artefacts/Git/Installation/Git_Installation_3.PNG)

![GitStep4](artefacts/Git/Installation/Git_Installation_4.PNG)

![GitStep5](artefacts/Git/Installation/Git_Installation_5.PNG)

![GitStep6](artefacts/Git/Installation/Git_Installation_6.PNG)

![GitStep7](artefacts/Git/Installation/Git_Installation_7.PNG)

![GitStep8](artefacts/Git/Installation/Git_Installation_8.PNG)

![GitStep9](artefacts/Git/Installation/Git_Installation_9.PNG)

![GitStep10](artefacts/Git/Installation/Git_Installation_10.PNG)

![GitStep11](artefacts/Git/Installation/Git_Installation_11.PNG)

![GitStep12](artefacts/Git/Installation/Git_Installation_12.PNG)

![GitStep13](artefacts/Git/Installation/Git_Installation_13.PNG)

![GitStep14](artefacts/Git/Installation/Git_Installation_14.PNG)

![GitStep15](artefacts/Git/Installation/Git_Installation_15.PNG)

![GitStep16](artefacts/Git/Installation/Git_Installation_16.PNG)

![GitStep17](artefacts/Git/Installation/Git_Installation_17.PNG)

<a name="git_ssh"></a>
# 5.2 Set SSH
Create an account on <a href="https://github.com/">GitHub</a>. 

SSH (Secure Shell) is one of the authentication protocols used to securely communicate with remote repositories. It provides a secure and encrypted way for developers to access and interact with Git repositories over a network.

In order to set your ssh open GitBash:

![GitSSHStep1](artefacts/Git/SetSSH/Git_SSH_1.PNG)

In GitBash enter the following command:
```
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```
where "your_email@example.com" should be the email on your HitHub account.

![GitSSHStep2](artefacts/Git/SetSSH/Git_SSH_2.PNG)

After this you will be asked to enter the file in which to save the key and the passphrase. For both press enter without entering anything.

![GitSSHStep3](artefacts/Git/SetSSH/Git_SSH_3.PNG)

In C:\Users -> your user -> .ssh you should have now two files:
- id_rsa
- id_rsa.pub

![GitSSHStep4](artefacts/Git/SetSSH/Git_SSH_4.PNG)

Open id_rsa.pub in Notepad++ and copy it's content:

![GitSSHStep5](artefacts/Git/SetSSH/Git_SSH_5.PNG)

Go to your GitHub account in <a href="![img.png](img.png)">SSH and GpPG keys section</a> and press on New SSH key:

![GitSSHStep6](artefacts/Git/SetSSH/Git_SSH_6.PNG)

Give a name to your key and enter the text copied from id_rsa.pub on key field, then press Add SSH key.

![GitSSHStep7](artefacts/Git/SetSSH/Git_SSH_7.PNG)

Now you should have your SSH key set:

![GitSSHStep8](artefacts/Git/SetSSH/Git_SSH_8.PNG)

<a name="postgresql"></a>
# 6. PostgreSql
PostgreSQL is a powerful open-source relational database management system (RDBMS) used for a wide range of applications.

Download <a href="https://www.enterprisedb.com/downloads/postgres-postgresql-downloads">PostgreSql</a> and proceed with installation:

![PostgreSqlStep1](artefacts/PostgreSql/PostgreSql_1.PNG)

![PostgreSqlStep2](artefacts/PostgreSql/PostgreSql_2.PNG)

![PostgreSqlStep3](artefacts/PostgreSql/PostgreSql_3.PNG)

![PostgreSqlStep4](artefacts/PostgreSql/PostgreSql_4.PNG)

Remember the password for database superuser!

![PostgreSqlStep5](artefacts/PostgreSql/PostgreSql_5.PNG)

Do not change the port:

![PostgreSqlStep6](artefacts/PostgreSql/PostgreSql_6.PNG)

![PostgreSqlStep7](artefacts/PostgreSql/PostgreSql_7.PNG)

![PostgreSqlStep8](artefacts/PostgreSql/PostgreSql_8.PNG)

![PostgreSqlStep9](artefacts/PostgreSql/PostgreSql_9.PNG)

![PostgreSqlStep10](artefacts/PostgreSql/PostgreSql_10.PNG)

![PostgreSqlStep11](artefacts/PostgreSql/PostgreSql_11.PNG)

<a name="postman"></a>
# 7. Postman
Postman is used to simplify the process of building, testing, and documenting APIs. It provides a user-friendly interface for making API requests, inspecting responses, and managing API endpoints.

Download <a href="https://www.postman.com/downloads/">Postman</a>:

![PostmanStep1](artefacts/Postman/Postman_1.PNG)

![PostmanStep2](artefacts/Postman/Postman_2.PNG)

![PostmanStep3](artefacts/Postman/Postman_3.PNG)

![PostmanStep4](artefacts/Postman/Postman_4.PNG)

![PostmanStep5](artefacts/Postman/Postman_5.PNG)

<a name="nodenpm"></a>
# 8. Node.js & NPM
Node.js is an open-source, cross-platform runtime environment that allows developers to execute JavaScript code outside a web browser. Node.js enables server-side scripting, allowing developers to run JavaScript on the server and handle various tasks like file system operations, network requests, and database interactions.

NPM (Node Package Manager) is the default package manager for Node.js. It is a command-line tool that allows developers to discover, install, and manage external libraries, frameworks, and tools needed for their Node.js projects.

Download <a href="https://nodejs.org/en">Node.js</a>. Make sure you have downloaded the latest version of NodeJs. It includes the NPM package manager.

![NodeJSStep1](artefacts/NodeJS/NodeJS_1.PNG)

![NodeJSStep2](artefacts/NodeJS/NodeJS_2.PNG)

![NodeJSStep3](artefacts/NodeJS/NodeJS_3.PNG)

Choose the desired path where you want to install Node.js.

![NodeJSStep4](artefacts/NodeJS/NodeJS_4.PNG)


By clicking on the Next button, you will get a custom page setup on the screen. Make sure you choose npm package manager, not the default of Node.js runtime. This way, we can install Node and NPM simultaneously.

![NodeJSStep5](artefacts/NodeJS/NodeJS_5.PNG)

![NodeJSStep6](artefacts/NodeJS/NodeJS_6.PNG)

![NodeJSStep7](artefacts/NodeJS/NodeJS_7.PNG)

Check Node.js and NPM version with “Command Prompt”.

To confirm Node installation, type node -v command.

To confirm NPM installation, type npm -v command.

![NodeJSStep8](artefacts/NodeJS/NodeJS_8.png)

<a name="cloneui"></a>
# 9. Clone UI project

Go to <a href="https://github.com/EndavaCollab/endava4students-ptd-23-ui">UI  project repository</a>.

![CloneUIStep1](artefacts/UIProject/clone1.png)


Click on Code button and copy link from HTTPS tab.


![CloneUIStep2](artefacts/UIProject/clone2.png)


Open Intellij IDEA then click on Pojects tab and then Get from VCS. Enter the copied link into URL input box and select a folder by your choice. Then click clone button.


![CloneUIStep3](artefacts/UIProject/clone3.png)









