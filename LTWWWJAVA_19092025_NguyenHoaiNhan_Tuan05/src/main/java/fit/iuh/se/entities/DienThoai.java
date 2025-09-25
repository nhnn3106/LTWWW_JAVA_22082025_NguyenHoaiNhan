package fit.iuh.se.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dien-thoais")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Setter
@Getter
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int maDT;
    @Column(name = "ten")
    private String tenDT;
    @Column(name = "nam-sx")
    private int namSanXuat;
    @Column(name = "cau-hinh")
    private String cauHinh;


    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "mancc")
    private NhaCungCap nhaCungCap;

    @Column(name = "hinh-anh")
    private String hinhAnh;
}
