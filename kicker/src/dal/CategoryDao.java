package dal;

import java.util.List;

import bll.Category;

public interface CategoryDao {
	public Category createCategory(Category newCategory);
	public Category getCategoryById(int CategoryId);
	public boolean updateCategory(Category newCategory);
	public boolean deleteCategory(Category dCategory);
	public boolean deleteCategory(int CategoryId);
	public List<Category> getAll();
}
