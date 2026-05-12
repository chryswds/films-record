package ie.films.Service;

import ie.films.Model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    public List<Category> getCategories();
}
