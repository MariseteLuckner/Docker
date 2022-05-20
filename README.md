# Projeto spring com docker

![image](https://user-images.githubusercontent.com/42948627/146280938-ec413378-ca08-4f11-968e-77cd7c8338e2.png)


## Pré-requisitos:
- Docker [https://docs.docker.com/install/linux/docker-ce/ubuntu/
- Ubuntu 20.04 [Microsoft Store]
- WSL [https://docs.microsoft.com/pt-br/windows/wsl/install]
- Java 11 [https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html]
- MAVEN [https://maven.apache.org/install.html]
- Lombok [https://projectlombok.org/download] <br><br>
 
- Baixar a imagem do mysql:8.0 <br>
  docker pull mysql:8.0

- Baixar a imagem do phpMyAdmin <br>
  docker pull phpmyadmin

- Iniciar o docker: <br>
  docker-compose up -p

- Encerrar o docker: <br>
  docker-compose down

Utilizado o Swagger para testar a API:
* http://localhost:8080/swagger-ui/index.html#/
