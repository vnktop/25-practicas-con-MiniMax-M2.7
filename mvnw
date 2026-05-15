#!/bin/sh
# Maven wrapper using local extraction
MAVEN_HOME="/tmp/apache-maven-3.9.9"
exec "$MAVEN_HOME/bin/mvn" "$@"