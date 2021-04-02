#!/usr/bin/env bash

SLICK=libs/lib/slick.jar
LWJGL_UTIL=libs/lib/lwjgl_util.jar
LWJGL=libs/lib/lwjgl.jar
JINPUT=libs/lib/jinput.jar
LIBS=${SLICK}:${LWJGL_UTIL}:${LWJGL}:${JINPUT}
NATIVE=libs
EXECUTABLE_JAR=build/jar/Pong-1.0.jar

java -cp ${EXECUTABLE_JAR}:${LIBS} -Djava.library.path=${NATIVE} pong.game.Pong
