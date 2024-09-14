## Used Docker container original page on Docker hub
https://hub.docker.com/r/ibmcom/db2

## Docker clone command
```docker pull ibmcom/db2```

## Docker container start command with parameters for this example
```docker run -itd --name mydb2 --privileged=true -p 50000:50000 -e LICENSE=accept -e DB2INST1_PASSWORD=db2admin -e DBNAME=db2test -v /root/.xander/docker/db2:/database ibmcom/db2```

## How to test example
- Deploy docker container and start ```Spring boot``` application

