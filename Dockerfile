# mzkrelx/playframework2-dev
#
# VERSION               0.0.1

FROM google/debian:wheezy
MAINTAINER Mizuki Yamanaka <mizuki@relx.jp>

ENV PLAY_VERSION 2.2.2
ENV PATH $PATH:/opt/play-$PLAY_VERSION

RUN apt-get update -y && apt-get upgrade -y && apt-get install -y unzip openjdk-7-jdk git maven && apt-get clean 
ADD http://downloads.typesafe.com/play/$PLAY_VERSION/play-$PLAY_VERSION.zip /tmp/play-$PLAY_VERSION.zip
RUN (cd /opt && unzip /tmp/play-$PLAY_VERSION.zip && rm -f /tmp/play-$PLAY_VERSION.zip)

RUN mkdir /opt/hashFind
RUN (cd /opt/ && git clone https://github.com/diodfr/hashFind.git && cd /opt/hashFind && mvn install && cd /opt && rm -f /opt/hasFind)
RUN mkdir /opt/play_adherants
RUN (cd /opt && git clone https://github.com/diodfr/play_adherants.git)


WORKDIR /opt/play_adherants
EXPOSE 9000 

CMD ["/bin/bash", "play", "compile"]

