package fit.iuh.se.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart-item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @OneToOne(mappedBy = "id")
    @JoinColumn(name = "item-id")
    private Item item;
    private int quanity;

}
