package fit.iuh.se.daos;

import fit.iuh.se.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> findAll();

    List<DienThoai> findAllBySupplierName(String supplierName);
}
