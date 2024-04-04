package insper.api.ingrediente;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class IngredientesService {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    public Ingredientes create(Ingrediente in) {
        return ingredientesRepository.save(new IngredientesModel(in)).to();
    }

    public Ingrediente read(@NonNull String id) {
        return ingredientesRepository.findById(id).map(IngredientesModel::to).orElse(null);
    }
    
}
