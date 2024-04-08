package insper.api.ingrediente;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientesRepository extends CrudRepository<IngredientesModel, String> {

    Optional<IngredientesModel> findByName(String nome);
    
}
