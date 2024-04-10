package insper.api.ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class IngredientesService {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    public Ingrediente create(Ingrediente in) {
        return ingredientesRepository.save(new IngredientesModel(in)).to();
    }

    public Ingrediente read(@NonNull String id) {
        return ingredientesRepository.findById(id).map(IngredientesModel::to).orElse(null);
    }

    public List<IngredienteOut> readAll() {
        List<IngredienteOut> ingredientes = new ArrayList<>();
        ingredientesRepository.findAll().forEach(
            ingrediente->ingredientes.add(IngredientesParser.to(ingrediente.to())));
        return ingredientes;
    }

    public Ingrediente update(@NonNull String id, Ingrediente in) {
        return ingredientesRepository.save(new IngredientesModel(in)).to();
    }

    public Ingrediente delete(@NonNull String id) {
        Ingrediente ingrediente = read(id);
        ingredientesRepository.deleteById(id);
        return ingrediente;
    }
    
}
