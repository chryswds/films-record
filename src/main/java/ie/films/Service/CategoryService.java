package ie.films.Service;

import ie.films.Model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> getCategories();
    Category addCategory(Category category);
    Category getCategoryById(long id);
    void deleteCategoryById(long id);


}
