package fit.iuh.se.daos;

import fit.iuh.se.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> findAll();

    List<DienThoai> findBySupplierID(int supplierID);


    List<DienThoai> findBySupplierName(String supplierName);

    List<DienThoai> findBySupplierAddress(String supplierAddress);

    List<DienThoai> findBySupplierPhone(String supplierPhone);

    boolean addDienThoai(DienThoai dienThoai);

    boolean removeDienThoaiByID(int id);
}
