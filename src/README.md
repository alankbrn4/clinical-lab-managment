# Sistema de Gestión de Laboratorio Clínico

Este proyecto implementa un sistema básico de gestión para un laboratorio clínico utilizando Java Servlets y Apache Tomcat.

## Requisitos

- Java Development Kit (JDK) 11 o superior

- Apache Maven 3.6.0 o superior

- Apache Tomcat 9.x

- Visual Studio Code

## Configuración

1. Clonar el repositorio:
    - git clone https://github.com/tu-usuario/clinical-lab-management.git

    - cd clinical-lab-management

2. Compilar el proyecto:

    - mvn clean package

3. Configurar Tomcat en VS Code:

    - Instalar la extensión "Tomcat for Java"

    - En la vista de Tomcat, añadir el servidor Tomcat local

4. Desplegar la aplicación:

- En la vista de Tomcat, hacer clic derecho en el servidor y seleccionar "Deploy war package"

- Seleccionar el archivo WAR generado en la carpeta `target`

## Uso

La API expone los siguientes endpoints:

- GET /patients: Obtiene todos los pacientes

- GET /patients/{id}: Obtiene un paciente específico por ID

- POST /patients: Crea un nuevo paciente

## Pruebas

Para ejecutar las pruebas unitarias:

- mvn test

## Contribución

1. Haz un fork del repositorio

2. Crea una nueva rama (`git checkout -b feature/AmazingFeature`)

3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)

4. Haz push a la rama (`git push origin feature/AmazingFeature`)

5. Abre un Pull Request