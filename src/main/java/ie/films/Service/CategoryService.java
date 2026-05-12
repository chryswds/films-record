package ie.films.Service;

import ie.films.Model.Category;

import java.util.List;


public interface CategoryService {

    public List<Category> getCategories();
    Category addCategory(Category category);
}
