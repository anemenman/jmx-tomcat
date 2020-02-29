#!/bin/sh

echo "The application will start in ${STARTUP_SLEEP}s..." && sleep ${STARTUP_SLEEP}
exec /usr/local/tomcat/bin/catalina.sh run
