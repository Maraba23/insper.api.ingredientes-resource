package insper.api.ingrediente;

public class IngredientesParser {

    public static Ingrediente to(IngredienteIn in) {
        return Ingrediente.builder()
            .name(in.name())
            .descricao(in.descricao())
            .build();
    }

    public static IngredienteOut to(Ingrediente ingrediente) {
        return IngredienteOut.builder()
            .name(ingrediente.name())
            .descricao(ingrediente.descricao())
            .build();
    }

    public static IngredienteOut to(IngredienteOut in) {
        return IngredienteOut.builder()
            .name(in.name())
            .descricao(in.descricao())
            .build();
    }
    
}
