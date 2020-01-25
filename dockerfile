FROM devopsedu/webapp:latest
RUN apt-get update
COPY src ./html
RUN chown -R www-data:www-data html
EXPOSE 80
