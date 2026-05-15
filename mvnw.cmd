@REM Maven wrapper batch script for Windows
@echo off

set MAVEN_PROJECTBASEDIR=%~dp0
set MAVEN_OPTS=-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%

set WRAPPER_JAR=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.jar
set WRAPPER_PROPERTIES=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.properties

if not exist "%WRAPPER_JAR%" (
    echo Downloading Maven Wrapper JAR...
    powershell -Command "Invoke-WebRequest -Uri 'https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.4.0/maven-wrapper-3.4.0.jar' -OutFile '%WRAPPER_JAR%'"
)

if defined JAVA_HOME (
    set JAVA_CMD=%JAVA_HOME%\bin\java
) else (
    set JAVA_CMD=java
)

"%JAVA_CMD%" %MAVEN_OPTS% -jar "%WRAPPER_JAR%" %*