package fit.iuh.se.entities;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "mobiles")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private int maDT;
    @Column(name = "name")
    private String tenDT;
    @Column(name = "year")
    private int namSX;
    @Column(name = "cau_hinh")
    private String cauHinh;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private NhaCungCap nhaCungCap;

    @Column(name = "hinh_anh")
    private String hinhAnh;
}
