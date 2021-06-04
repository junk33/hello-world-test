#!/bin/sh

echo "Running mvn-tester.sh"

cp HelloWorld.java ./hello-world-test/src/main/java/

cd hello-world-test

echo "============================================== mvn clean compile test --batch-mode --fail-at-end"
mvn clean compile test --quiet --no-transfer-progress --batch-mode --fail-at-end

echo "============================================== mvn surefire-report:report -DshowSuccess=true"
mvn --quiet --no-transfer-progress surefire-report:report -DshowSuccess=true

ls -lR
