# diodfr/adherants
#
# VERSION               0.0.1

FROM diodfr/play-adherants
MAINTAINER Didier BROCA <didier.broca@libertysurf.fr>

RUN mkdir /opt/hashFind
RUN (cd /opt/ && git clone https://github.com/diodfr/hashFind.git && cd /opt/hashFind && mvn install && cd /opt && rm -f /opt/hasFind)
RUN mkdir /opt/play_adherants
RUN (cd /opt && git clone https://github.com/diodfr/play_adherants.git)

RUN (cd /opt/play_adherants/ && play stage)

WORKDIR /opt/play_adherants
EXPOSE 9000

ENTRYPOINT /opt/play_adherants/target/universal/stage/bin/play_adherants