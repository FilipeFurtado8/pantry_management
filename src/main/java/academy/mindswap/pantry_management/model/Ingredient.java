package academy.mindswap.pantry_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static academy.mindswap.pantry_management.utils.Messages.USER1;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "user")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;


    @ManyToOne
    private Category category;

    @ManyToOne
    @JsonIgnore
    private User user;
}
