#!/bin/sh

echo "Running mvn-tester.sh"

cp ../HelloWorld.java ./src/main/java/

mvn clean compile test --batch-mode --fail-at-end

mvn surefire-report:report -DshowSuccess=true