![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# lab504

## Setup
### Requirements
- Java 17
- Maven 3.8+ (for dependency management and project construction)
- MySQL 8.0+  (relational database)

### 1 Clone the Repository
- Clone the project repository to your local machine
```sh
git clone https://github.com/Esteban-Gamboa-01/lab504.git
cd your-clone-repo
```

If you aren't ubicating in the correct directory the following command lines aren't aplicated.

### 2 Configure database credentials
- The project creates a database: dockerlabdb. 
- In `src/main/resources/application.properties` and you have

```properties
# MySQL connection URL
spring.datasource.url=${DB_URL}
# "jdbc:mysql://localhost:3306/dockerlabdb?createDatabaseIfNotExist=true&serverTimezone=UTC"

# Database access credentials
spring.datasource.username=${DB_USER}
# "root"
spring.datasource.password=${DB_PASS}
```

If it is neccesary, change environment variables.

### 3 Container. Network and volume.
- Use the terminal

```properties
# Build the Spring Boot Image
docker build -t docker-lab-crud:1.0.0 .

# Create a Network
docker network create docker-lab-net

# Create a Volume
docker volume create docker-lab-dbdata
```

### 4 Run the MySQL Container and Spring Boot Container
- Use the terminal
- This command line downloads mysql:8.0 of Docker Hub.

```properties
docker run -d --name mydb-lab --network docker-lab-net -v docker-lab-dbdata:/var/lib/mysql -e MYSQL_ROOT_PASSWORD= -e MYSQL_DATABASE=dockerlabdb mysql:8.0
```

- Spring Boot Container is generated with this line command.

```properties
docker run -d --name docker-lab-crud --network docker-lab-net -p 8080:8080 docker-lab-crud:1.0.0
```


### 5 Run the Project in a Browser or Postman
- The Spring Boot application should start and be available at http://localhost:8080.

---


