# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Docker Commands
docker login
docker build -f Dockerfile -t localproj:0.0.1 . (-f=Docker file name ; -t name:tag ; dot . = current directory)
docker run -d -p 8080:8080 -t localproj:0.0.1 (-d detach process from terminal and let container run in background; -p port of docker image : port of server)

docker image tag localproj:0.0.1 akshayparihar/learning-repo:0.0.1
docker push akshayparihar/learning-repo:0.0.1 (if push is denied, trying doing docker logout and login again)

docker images
docker rmi <IMAGEID>

docker ps -a (shows all containers, even the ones that are stopped)
docker rm <CONTAINERID>