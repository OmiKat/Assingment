FROM eclipse-temurin:21-jre
WORKDIR /app

ENV PORT=8080
EXPOSE 8080

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["sh","-c","java -Dserver.port=${PORT} -jar /app/app.jar"]