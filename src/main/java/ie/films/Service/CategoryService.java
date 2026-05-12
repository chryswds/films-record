package ie.films.Service;

import ie.films.Model.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public List<Category> getCategories();
    Category addCategory(Category category);
    Category getCategoryById(long id);

}
