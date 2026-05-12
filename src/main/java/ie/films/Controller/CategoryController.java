package ie.films.Controller;

import brave.Response;
import ie.films.Controller.Request.CategoryRequest;
import ie.films.Controller.Response.CategoryResponse;
import ie.films.Mapper.CategoryMapper;
import ie.films.Model.Category;
import ie.films.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/films/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;





    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest request) {
        Category category = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





}
