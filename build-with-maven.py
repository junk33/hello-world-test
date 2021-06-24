#!/usr/bin/env python3


import os
import sys
from datetime import datetime
from contextlib import redirect_stderr, redirect_stdout
import subprocess

print("Running build-with-maven.py script")


def echoAndRun(cmd):
    print("===================")
    print(cmd)
    os.system(cmd)


echoAndRun("rm -rf hello-world-test")

echoAndRun("git clone --quiet https://github.com/junk33/hello-world-test.git")

echoAndRun("rm -rf hello-world-test/target")
echoAndRun("cp HelloWorld.java hello-world-test/src/main/java")
echoAndRun("cd hello-world-test; mvn clean compile test --quiet --no-transfer-progress --batch-mode --fail-never")


os.makedirs("out", exist_ok=True)

with open("out/report.txt", "w") as fp:
    # datetime object containing current date and time
    now = datetime.now()
    # dd/mm/YY H:M:S
    dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
    fp.write("==============================================\n")
    fp.write("Report generated on " + dt_string + "\n")
    fp.write("==============================================\n")

    resultFile = "hello-world-test/target/surefire-reports/HelloWorldTest.txt"
    if os.path.isfile(resultFile):
        # copy contents
        with open(resultFile) as inFile:
            text = inFile.read()
            fp.write(text)
    else:
        # No report produced
        fp.write("Failed to compile file, could not run any tests\n")
        fp.write("==============================================\n")
        # get the javac output
        print("==============================================\n")
        proc = subprocess.Popen(
            ["javac HelloWorld.java"], stdout=subprocess.PIPE, stderr=subprocess.PIPE, shell=True)
        (out, err) = proc.communicate()
        if out:
            fp.write(out.decode())
        if err:
            fp.write(err.decode())

    now = datetime.now()
    # dd/mm/YY H:M:S
    dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
    fp.write("==============================================\n")
    fp.write("Report ended on " + dt_string + "\n")
    fp.write("==============================================\n")

with open("out/annotations.json", "w") as fp:
    fp.write(
        "{ \"title\": \"title for my annotation\",\n \"message\": \"my message\" }")
