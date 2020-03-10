FROM java-netcat
VOLUME /tmp
EXPOSE 8081
# (前面一个是打包的jar的名字，后面一个是在容器中使用的名字，这个要和最后的-jar 后面的jar包的名字一致)
ADD eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
RUN sh -c 'touch /eureka-server.jar'
ENV JAVA_OPTS=""
#Djava.security.egd  这个是用来防止springboot项目tomcat启动慢的问题（具体可搜索：随机数数与熵池策略）
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /eureka-server.jar" ]