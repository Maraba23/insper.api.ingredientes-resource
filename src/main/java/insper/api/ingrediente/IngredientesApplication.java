package insper.api.ingrediente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication
public class IngredientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngredientesApplication.class, args);
    }
    
}
