FROM debian:buster
LABEL maintainer=dev@dschuldt.de

ADD https://github.com/krallin/tini/releases/download/v0.18.0/tini /tini
ADD build/libs/springboot* app/app.jar
RUN apt update && apt install -y openjdk-10-jre-headless && chmod +x /tini

ENTRYPOINT ["/tini", "--"]
CMD ["java", "-jar", "/app/app.jar", "--server.port=80"]