# Connecting to MYSQL using Hashicorp Vault and Spring Boot

# To get started :
You will need the following:

* mysql up and running
* vault up and running

# How to get started with a local running MYSQl and Vault:

- Just run :
    docker-compose up -d
    
    This will start mysql and vault on the same docker network:
    
# MYSQL setup
   For vault to interact with the mysql, you will need to create a user and password
   Run the following commands:
   
   * Enter the mysql container 
    * docker exec -it vault_db_1 mysql -uroot -ppassword
   
   * Create a non root user. This user will be used by vault to create a dynamic user for accessing mysql without having to hardcode any user information in application
       * CREATE USER 'spring'@'localhost' IDENTIFIED BY 'vault';
       * GRANT ALL PRIVILEGES ON *.* TO 'spring' WITH GRANT OPTION;
   
# Vault setup with MYSQL access 

* docker exec -it dev-vault /bin/sh
* export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
* export VAULT_ADDR="http://127.0.0.1:8200"

** Note: The use of 'http' is only for demonstration purposes

* vault secrets enable mysql
* vault write mysql/config/connection connection_url="spring:vault@tcp(dev-mysql:3306)/"
* vault write mysql/roles/readonly sql="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT ON *.* TO '{{name}}'@'%';"
* vault read mysql/creds/readonly

** Note The role created will be used by the application to connect to the mysql db

More information on creating dynamic mysql user in vault can be found here

https://www.vaultproject.io/docs/secrets/mysql/index.html

* We are all set to connect to the database through vault without having to hardcode any user details in application.yml

The above setup is to get these services up locally. This will not be required when you have a running instances of mysql or vault that you need to connect to, as in production or QA. 

Things to keep in mind:
* spring-cloud uses bootstrap.yml.
* Keep a note of the vault token and the mysql role used to access 
  
   
    