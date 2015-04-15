# diodfr/play-adherants
#
# VERSION               0.0.1

FROM google/debian:wheezy
MAINTAINER Didier BROCA <didier.broca@libertysurf.fr>

ENV PLAY_VERSION 2.2.2
ENV PATH $PATH:/opt/play-$PLAY_VERSION

RUN apt-get update -y && apt-get upgrade -y && apt-get install -y unzip openjdk-7-jdk git maven && apt-get clean 
RUN update-java-alternatives -s java-1.7.0-openjdk-amd64
ADD http://downloads.typesafe.com/play/$PLAY_VERSION/play-$PLAY_VERSION.zip /tmp/play-$PLAY_VERSION.zip
RUN (cd /opt && unzip /tmp/play-$PLAY_VERSION.zip && rm -f /tmp/play-$PLAY_VERSION.zip)
