package ie.films.Controller;

import ie.films.Controller.Request.CategoryRequest;
import ie.films.Controller.Response.CategoryResponse;
import ie.films.Mapper.CategoryMapper;
import ie.films.Model.Category;
import ie.films.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/films/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;





    @GetMapping()
    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @PostMapping()
    public CategoryResponse addCategory(@RequestBody CategoryRequest request) {
        Category category = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.addCategory(category);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable long id) {
        Category category = categoryService.getCategoryById(id);
        return CategoryMapper.toCategoryResponse(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable long id) {
        categoryService.deleteCategoryById(id);
    }





}
