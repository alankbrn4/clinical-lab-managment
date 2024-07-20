FROM tomcat:9.0
COPY target/cliniclab-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
