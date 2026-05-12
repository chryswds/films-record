package ie.films.Controller;

import ie.films.Model.Category;
import ie.films.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/films/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;



    @GetMapping()
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }



}
