package insper.api.ingrediente;

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

    public IngredienteOut readAll() {
        return IngredienteOut.builder().build();
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
