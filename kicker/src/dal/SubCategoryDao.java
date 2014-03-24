package dal;

import java.util.List;

import bll.SubCategory;

public interface SubCategoryDao {
	public SubCategory createSubCategory(SubCategory newSubCategory);
	public SubCategory getSubCategoryById(int subCategoryId);
	public boolean updateSubCategory(SubCategory newSubCategory);
	public boolean deleteSubCategory(SubCategory dSubCategory);
	public boolean deleteSubCategory(int subCategoryId);
	public List<SubCategory> getAll();
}
