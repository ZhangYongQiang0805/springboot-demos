#基础镜像信息
FROM java:8
#维护者信息
MAINTAINER zyq
#镜像操作指令RUN、COPY、ADD、EXPOSE
ADD springboot-docker-0.0.1-SNAPSHOT.jar /app.jar
#暴露端口
EXPOSE 8080
#容器启动时执行指令
ENTRYPOINT ["/usr/bin/java","-jar","app.jar"]