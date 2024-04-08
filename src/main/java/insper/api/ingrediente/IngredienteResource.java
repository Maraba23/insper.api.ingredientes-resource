package insper.api.ingrediente;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import insper.api.ingrediente.IngredienteIn;
import insper.api.ingrediente.IngredienteOut;

@RestController
public class IngredienteResource implements IngredienteController {

    @Autowired
    private IngredientesService ingredienteService;

    @Override
    public ResponseEntity<IngredienteOut> create(IngredienteIn in) {
        // parser
        Ingrediente ingrediente = IngredientesParser.to(in);
        // insert using service
        ingrediente = ingredienteService.create(ingrediente);
        // return
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ingrediente.id())
                .toUri())
            .body(IngredientesParser.to(ingrediente));
    }

    @Override
    public ResponseEntity<IngredienteOut> read(String idIngrediente, String nomeIngrediente, String descricaoIngrediente) {
        final IngredienteOut ingrediente = IngredienteOut.builder()
            .id(idIngrediente)
            .name(nomeIngrediente)
            .descricao(descricaoIngrediente)
            .build();
        return ResponseEntity.ok(ingrediente);
    }

    @Override
    public ResponseEntity<IngredienteOut> update(String id, IngredienteIn in) {
        // parser
        Ingrediente ingrediente = IngredientesParser.to(in);
        // insert using service
        ingrediente = ingredienteService.create(ingrediente);
        // return
        return ResponseEntity.ok(IngredientesParser.to(ingrediente));
    }
    
}