package insper.api.ingrediente;

public class IngredientesParser {

    public static Ingrediente to(IngredienteIn in) {
        return Ingrediente.builder()
            .email(in.email())
            .name(in.name())
            .descricao(in.descricao())
            .build();
    }

    public static IngredienteOut to(Ingrediente ingrediente) {
        return IngredienteOut.builder()
            .id(ingrediente.id())
            .name(ingrediente.name())
            .descricao(ingrediente.descricao())
            .build();
    }
    
}
