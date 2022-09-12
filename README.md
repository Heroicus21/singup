# Proyecto Signup

### Requisitos.

* Docker
* Maven 

## Ejecusion de Signup

### Primero se devera correr un mvn install en la raiz de proyecto para generar el .jar
     mvn install
### Desde una terminal y situado en la raiz del proyecto ejecutar el siguiente comando

     docker build -t src-dev/demo1 .

Este comando lo que ara sera copiar la ultima version generada del proyecto a travez de mvn .jar

### Luego de ejecutar el comando del Build ejecutar la siguiente linea
para ejecutar el proyecto en su container, esto  

    docker-compose up

Despues de ejecutar esta linea de comando el projecto
se desplegara en "localhost:8080".

