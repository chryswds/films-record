package ie.films.Service;

import ie.films.Model.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    List<Category> getCategories();
    Category addCategory(Category category);
    Optional<Category> getCategoryById(long id);
    void deleteCategoryById(long id);


}
