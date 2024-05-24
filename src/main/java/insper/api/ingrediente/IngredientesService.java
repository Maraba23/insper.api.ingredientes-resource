package insper.api.ingrediente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import lombok.NonNull;

@Service
public class IngredientesService {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @CircuitBreaker(name = "ingredientesService", fallbackMethod = "fallbackCreate")
    @Cacheable("Ingredientes")
    public Ingrediente create(Ingrediente in) {
        return ingredientesRepository.save(new IngredientesModel(in)).to();
    }

    @CircuitBreaker(name = "ingredientesService", fallbackMethod = "fallbackRead")
    @Cacheable("Ingredientes")
    public Ingrediente read(@NonNull String id) {
        return ingredientesRepository.findById(id).map(IngredientesModel::to).orElse(null);
    }

    @CircuitBreaker(name = "ingredientesService", fallbackMethod = "fallbackReadAll")
    public List<IngredienteOut> readAll() {
        List<IngredienteOut> ingredientes = new ArrayList<>();
        ingredientesRepository.findAll().forEach(
            ingrediente -> ingredientes.add(IngredientesParser.to(ingrediente.to())));
        return ingredientes;
    }

    @CircuitBreaker(name = "ingredientesService", fallbackMethod = "fallbackUpdate")
    @Cacheable("Ingredientes")
    public Ingrediente update(@NonNull String id, Ingrediente in) {
        return ingredientesRepository.save(new IngredientesModel(in)).to();
    }

    @CircuitBreaker(name = "ingredientesService", fallbackMethod = "fallbackDelete")
    @Cacheable("Ingredientes")
    public Ingrediente delete(@NonNull String id) {
        Ingrediente ingrediente = read(id);
        ingredientesRepository.deleteById(id);
        return ingrediente;
    }

    // Métodos de fallback
    public Ingrediente fallbackCreate(Ingrediente in, Throwable t) {
        // Lógica de fallback para create
        System.out.println("Fallback create method triggered: " + t.getMessage());
        return new Ingrediente("fallback", "Fallback ingredient due to error: " + t.getMessage());
    }

    public Ingrediente fallbackRead(@NonNull String id, Throwable t) {
        // Lógica de fallback para read
        System.out.println("Fallback read method triggered: " + t.getMessage());
        return new Ingrediente("fallback", "Fallback ingredient due to error: " + t.getMessage());
    }

    public List<IngredienteOut> fallbackReadAll(Throwable t) {
        // Lógica de fallback para readAll
        System.out.println("Fallback readAll method triggered: " + t.getMessage());
        List<IngredienteOut> fallbackList = new ArrayList<>();
        fallbackList.add(new IngredienteOut("fallback", "Fallback ingredient due to error: " + t.getMessage()));
        return fallbackList;
    }

    public Ingrediente fallbackUpdate(@NonNull String id, Ingrediente in, Throwable t) {
        // Lógica de fallback para update
        System.out.println("Fallback update method triggered: " + t.getMessage());
        return new Ingrediente("fallback", "Fallback ingredient due to error: " + t.getMessage());
    }

    public Ingrediente fallbackDelete(@NonNull String id, Throwable t) {
        // Lógica de fallback para delete
        System.out.println("Fallback delete method triggered: " + t.getMessage());
        return new Ingrediente("fallback", "Fallback ingredient due to error: " + t.getMessage());
    }
}
