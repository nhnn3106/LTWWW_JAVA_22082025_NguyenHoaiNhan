package fit.iuh.se.daos;

import fit.iuh.se.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    List<NhaCungCap> findAll();

    List<NhaCungCap> findByID(int id);

    List<NhaCungCap> findByName(String name);

    List<NhaCungCap> findByAddress(String address);

    List<NhaCungCap> findByPhone(String phone);
}
