#!/bin/sh

echo "Running mvn-tester.sh"

cp HelloWorld.java ./hello-world-test/src/main/java/

cd hello-world-test

mvn clean compile test --batch-mode --fail-at-end

mvn surefire-report:report -DshowSuccess=true