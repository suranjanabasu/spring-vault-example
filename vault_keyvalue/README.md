# Connecting Vault using Spring

# To get Started :
You will need the following:

* vault up and running

# How to get started with a local running MYSQl and Vault:

- Just run :
    docker-compose up -d
    
    This will start vault
    
   
# Vault setup with Key Values

* docker exec -it dev-vault /bin/sh
* export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
* export VAULT_ADDR="http://127.0.0.1:8200"
* vault kv put secret/vault_keyvalue examplekv.username=devuser examplekv.role=dev
* vault kv put secret/vault_keyvalue/prod examplekv.username=produser examplekv.role=prod



The above setup is to get these services up locally. This will not be required when you have a running instances of mysql or vault that you need to connect to, as in production or QA. 

Things to keep in mind:
* spring-cloud uses bootstrap.yml.

  
   
    