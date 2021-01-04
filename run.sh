#!/bin/bash
javac @build.txt
jar cvf TextAdventure.jar manifest.txt TextAdventure/
