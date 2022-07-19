FROM alpine:latest

RUN apk --update add openjdk17-jre
RUN apk --update add python3 py3-pip
RUN apk --update add fontconfig
RUN apk --update add terminus-font ttf-inconsolata ttf-dejavu font-noto font-noto-cjk ttf-font-awesome font-noto-extra

RUN pip install requests

EXPOSE 8086
WORKDIR /app
ADD ./target/flowable.jar /app/
ADD ./script/echo.py /app/script/

ENTRYPOINT [ "java", "-jar", "/app/flowable.jar" ]