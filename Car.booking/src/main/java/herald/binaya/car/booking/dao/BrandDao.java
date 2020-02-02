package herald.binaya.car.booking.dao;

import java.util.List;

import herald.binaya.car.booking.entities.EBrand;

public interface BrandDao {

	public boolean saveBrand(EBrand brand);
	public List<EBrand> getAllBrands();
	public EBrand getBrandById(int id);
}
