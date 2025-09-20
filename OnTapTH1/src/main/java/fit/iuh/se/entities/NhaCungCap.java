package fit.iuh.se.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "suppliers")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private int maNCC;

    @Column(name = "name")
    private String tenNCC;

    @Column(name="address")
    private String diaChi;

    @Column(name = "number")
    private String sdt;

    @ToString.Exclude
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private Set<DienThoai> dienThoaiList = new HashSet<>();
}
