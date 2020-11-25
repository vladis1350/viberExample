#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/testbot-0.0.1-SNAPSHOT.jar \
    autocap@45.128.205.240:/home/autocap/viberBot

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa autocap@45.128.205.240 << EOF
pgrep java | xargs kill -9
nohup java -jar /home/autocap/viberBot/testbot-0.0.1-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'