package academy.mindswap.pantry_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static academy.mindswap.pantry_management.utils.Messages.CATEGORY1;
import static academy.mindswap.pantry_management.utils.Messages.INGREDIENT_LIST;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = INGREDIENT_LIST)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    @OneToMany(mappedBy = CATEGORY1)
    @JsonIgnore
    private List<Ingredient> ingredientList;
}
