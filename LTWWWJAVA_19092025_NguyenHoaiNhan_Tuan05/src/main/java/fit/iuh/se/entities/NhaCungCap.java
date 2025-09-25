package fit.iuh.se.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "nha-cung-caps")
@Data
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int maNCC;
    @Column(name = "ten")
    private String tenNhaCC;
    @Column(name = "dia-chi")
    private String diaChi;
    @Column(name = "sdt")
    private String soDienThoai;


    @OneToMany(mappedBy = "nhaCungCap")
    @ToString.Exclude
    private Set<DienThoai> dienThoais;
}
