package insper.api.ingrediente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "ingrediente")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class IngredientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_ingrediente")
    private String id;

    @Column(name = "tx_name")
    private String name;

    @Column(name = "tx_descricao")
    private String descricao;


    public IngredientesModel(Ingrediente o) {
        this.id = o.id();
        this.name = o.name();
        this.descricao = o.descricao();
    }
    
    public Ingrediente to() {
        return Ingrediente.builder()
            .id(id)
            .name(name)
            .descricao(descricao)
            .build();
    }
    
}
