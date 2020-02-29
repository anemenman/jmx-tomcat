FROM tomcat:8.5-jre8-alpine

ARG GIT_COMMIT=unspecified
LABEL git_commit=$GIT_COMMIT

ENV STARTUP_SLEEP=5
#\
#    JAVA_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9999 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false"

# Add a tomcat user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh tomcat
WORKDIR /home/tomcat

ADD src/main/docker/entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown tomcat:tomcat entrypoint.sh
RUN mkdir -p /usr/local/tomcat/files /usr/local/tomcat/reports && chown -R tomcat:tomcat /usr/local/tomcat/
USER tomcat

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080 9999 5701/udp

COPY build/libs/*.war /usr/local/tomcat/webapps/jmx.war
