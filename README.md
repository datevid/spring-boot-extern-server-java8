# spring-boot-externserver
Despliegue de spring boot en un servidor externo como payara, glassfish, jboss wildfly o tomcat externo.

1. Asegure que la aplicacion genere un .WAR, sino realice el cambio.
2. de la clase @SpringBootApplication, establezca su propia configuración de inicialización. 

Para ello, extienda la clase de SpringBootServletInitializer
```
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
```
Sobreescriba el método configure(), de tal manera que quede de la siguiente manera:

```
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

}
```
Adicione un controlador:
```
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "hola mundo";
    }
}
```

3. Añada un servidor verificar el funcionamiento(El servidor Embebido también debería funcionar)