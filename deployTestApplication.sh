#!/bin/bash
# Définition des variables
APP_NAME="testApplication"
SRC_DIR="src/main/java"
WEB_DIR="src/main/webapp/WEB-INF"
# placer les jars applicatives dans WEB-INF/lib
LIB_DIR="src/main/webapp/WEB-INF/lib"
BUILD_DIR="build"
TOMCAT_WEBAPPS="/home/balou/S5/apache-tomcat-10.1.60/webapps"
SERVLET_API_JAR="$LIB_DIR/*"

# Nettoyage et création du répertoire temporaire
rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR/WEB-INF/classes
mkdir -p $BUILD_DIR/WEB-INF/lib

# Compilation des fichiers Java en utilisant les jars dans WEB-INF/lib (framework.jar + éventuels ...)
find $SRC_DIR -name "*.java" > sources.txt
javac -parameters -cp "$SERVLET_API_JAR" -d $BUILD_DIR/WEB-INF/classes @sources.txt
rm sources.txt

# Copier les fichiers web (web.xml, JSP, etc.) et les libs
cp -r $WEB_DIR/../* $BUILD_DIR/   # copie des resources web (views, WEB-INF, ...)
cp -r $LIB_DIR/* $BUILD_DIR/WEB-INF/lib/ 2>/dev/null || true

# Générer le fichier .war dans le dossier build
cd $BUILD_DIR || exit
jar -cvf $APP_NAME.war *
cd ..

# Déploiement dans Tomcat
cp -f $BUILD_DIR/$APP_NAME.war $TOMCAT_WEBAPPS/

echo ""