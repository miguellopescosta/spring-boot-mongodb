👋 Hi, I’m @miguellopescosta

👀 I’m interested in ... surfing 🏄 and coding 👨‍💻!
🌱 I’m currently programming with... Java, JavaScript, Spring Boot, Node.JS among many other technologies.
💞️ I’m looking to collaborate on ... good causes!
📫 How to reach me ... miguellopescosta@sapo.pt

# spring-boot-mongodb
Funny assignment with Spring Boot, Spring Data, Spring Web and Google Guava CacheLoader.

After compiling the project, you can run it on Tomcat. I used Tomcat 9.0.54. In order to run on Wildfly, you'll need some adjustments.

If you wish to run the project on Intelli J, please, remove the following dependency from pom.xml.

      <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
      <scope>provided</scope>
      </dependency>

Services:
http://127.0.0.1:8080/quotes50k-1.0.0/allquotes
http://127.0.0.1:8080/quotes50k-1.0.0/allquotesfast
http://localhost:8080/quotes50k-1.0.0/search?id=5eb17ab1b69dc744b4e7af0a&author=Bill Gates
http://127.0.0.1:8080/quotes50k-1.0.0/detailedsearch?id=5eb17ab1b69dc744b4e7af0a&text=Everything&author=Ricky&genre=learning&__v=1
      

