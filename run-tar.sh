
./gradlew clean distTar
tar -xf ./build/distributions/spring-poc-1.0-SNAPSHOT.tar --directory ./build/distributions

APP_HOME="./build/distributions/spring-poc-1.0-SNAPSHOT/lib"
MAVEN_HOME="~/.m2"

CLASSPATH="${APP_HOME}/spring-poc-1.0-SNAPSHOT.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/car-parts-custom-1.0-SNAPSHOT.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/spring-context-5.3.13.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/spring-aop-5.3.13.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/spring-beans-5.3.13.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/spring-expression-5.3.13.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/spring-core-5.3.13.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/log4j-slf4j-impl-2.16.0.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/slf4j-api-1.7.32.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/log4j-core-2.16.0.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/javax.inject-1.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/spring-jcl-5.3.13.jar"
CLASSPATH="${CLASSPATH}:${APP_HOME}/log4j-api-2.16.0.jar"
CLASSPATH="${CLASSPATH}:${MAVEN_HOME}/repository/com/tesseractus/car-parts/1.0-SNAPSHOT/car-parts-1.0-SNAPSHOT.jar"

"${JAVA_HOME}/bin/java" -classpath ${CLASSPATH} com.amazon.Main
