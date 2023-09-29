FROM jboss/wildfly:latest
USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
EXPOSE 8080 9990 8787
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug"]