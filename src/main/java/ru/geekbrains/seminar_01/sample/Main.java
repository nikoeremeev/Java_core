package ru.geekbrains.seminar_01.sample;

import ru.geekbrains.seminar_01.regular.Decorator;
import ru.geekbrains.seminar_01.regular.OtherClass;

import java.util.List;

/**
 * https://www.docker.com/products/docker-desktop/
 * https://hub.docker.com/
 * <p>
 * javac -sourcepath ./java  -d out java/ru/geekbrains/lesson1/sample/Main.java
 * <p>
 * java -classpath ./out ru.geekbrains.lesson1.sample.Main
 * <p>
 * javadoc -d docs -sourcepath ./java -cp ./out -subpackages ru
 */

/**
 * FROM bellsoft/liberica-openjdk-alpine:11.0.16
 * COPY ./java ./src
 * RUN mkdir ./out
 * RUN javac -sourcepath ./src -d out src/ru/geekbrains/lesson1/sample/Main.java
 * CMD java -classpath ./out ru.geekbrains.lesson1.sample.Main
 * <p>
 * <p>
 * <p>
 * <p>
 * FROM bellsoft/liberica-openjdk-alpine:11.0.16 as BuildProject
 * WORKDIR /app
 * COPY ./java ./src
 * RUN mkdir ./out
 * RUN javac -sourcepath ./src -d out ./src/ru/geekbrains/lesson1/sample/Main.java
 * <p>
 * FROM scratch as OutputFiles
 * COPY --from=BuildProject /app/out /bin
 * <p>
 * <p>
 * >> docker buildx build --output type=local,dest=. .
 * <p>
 * <p>
 * <p>
 * <p>
 * FROM bellsoft/liberica-openjdk-alpine:11.0.16
 * WORKDIR /app
 * COPY ./bin .
 * CMD java -classpath . ru.geekbrains.lesson1.sample.Main
 * <p>
 * docker build . -t runjavaapp:v1
 * docker run runjavaapp:v1
 */

public class Main {

    public static void main(String[] args) {
        int result = OtherClass.add(2, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(2, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(2, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(2, 3);
        System.out.println(Decorator.decorate(result));
    }

}

