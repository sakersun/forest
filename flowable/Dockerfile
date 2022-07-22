FROM alpine:3.16

RUN apk --no-cache add openjdk17-jre
RUN apk --no-cache add libffi-dev openssl-dev build-base
RUN apk --no-cache add python3 py3-pip
RUN apk --no-cache add fontconfig
RUN apk --no-cache add terminus-font ttf-inconsolata ttf-dejavu font-noto font-noto-cjk ttf-font-awesome font-noto-extra

RUN pip install requests
RUN pip install --upgrade pip setuptools wheel

EXPOSE 8086
WORKDIR /app
ADD ./target/csdigital-flowable.jar /app/
ADD ./script/echo.py /app/script/

ENTRYPOINT [ "java", "-jar", "/app/csdigital-flowable.jar" ]