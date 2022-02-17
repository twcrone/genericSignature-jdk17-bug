#!/usr/bin/env bash

if [[ ! -d "out" ]]; then
  mkdir out
fi

javac src/Tester.java -d out

java -javaagent:/Users/tcrone/work/training/asmcf17/app/build/libs/app-all.jar -cp ./out --add-opens=java.base/java.lang=ALL-UNNAMED Tester