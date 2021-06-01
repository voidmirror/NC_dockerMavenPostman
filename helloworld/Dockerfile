FROM openjdk:8
ENV HW_HOME=/usr/src/app
WORKDIR ${HW_HOME}
COPY . ${HW_HOME}
RUN javac HelloWorld.java
CMD ["java","HelloWorld"]