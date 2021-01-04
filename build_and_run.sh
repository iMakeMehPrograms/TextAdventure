#!/bin/bash
rm TextAdventure.jar
find . -name '*.class' -exec rm {} \;
javac @build.txt
jar --create --verbose --manifest=Manifest.txt --file=TextAdventure.jar TextAdventure/
java -jar TextAdventure.jar 