#!/bin/bash

echo "Running build-with-maven.sh script"


rm -rf hello-world-test
git clone --quiet https://github.com/junk33/hello-world-test.git

rm -rf hello-world-test/target
cp HelloWorld.java hello-world-test/src/main/java
cd hello-world-test
# --fail-never
# --fail-at-end
mvn clean compile test --quiet --no-transfer-progress --batch-mode --fail-never

mkdir out
echo "Hello World" > out/file1.txt


# java -classpath junit-4.13.2.jar:.:target/classes HelloWorld

