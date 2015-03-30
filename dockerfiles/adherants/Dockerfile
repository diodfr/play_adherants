# diodfr/adherants
#
# VERSION               0.0.1

FROM diodfr/playframework2-dev
MAINTAINER Didier BROCA <didier.broca@libertysurf.fr>

RUN mkdir /opt/hashFind
RUN (cd /opt/ && git clone https://github.com/diodfr/hashFind.git && cd /opt/hashFind && mvn install && cd /opt && rm -f /opt/hasFind)
RUN mkdir /opt/play_adherants
RUN (cd /opt && git clone https://github.com/diodfr/play_adherants.git)


WORKDIR /opt/play_adherants
EXPOSE 9000 

CMD play stage

CMD bash