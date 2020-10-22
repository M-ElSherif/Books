/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import books.ejb.CategoryService;
import books.entities.Category;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * @author thesh
 */
@Named
@SessionScoped
public class CategoryEditor implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("CategoryEditor");
    private List<Category> _categories;
    private List<Category> _deletedCategories;

    @Inject
    CategoryService _categoryService;

    @PostConstruct
    private void init() {
        _categories = _categoryService.findAll();
        _deletedCategories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return _categories;
    }

    public void setCategories(List<Category> categories) {
        this._categories = categories;
    }

    public String addCategory() {
        _categories.add(new Category());
        return "";
    }

    public String deleteCategory(Category category) {
        if (category.getId() >= 0) {
            _deletedCategories.add(category);
        }
        _categories.remove(category);
        return "";
    }

    public String save() {
//  ***Using a lambda and stream approach***
//        String categories = _categories
//                .stream()
//                .filter(cat -> !cat.getName().isEmpty())
//                .map(cat -> cat.toString())
//                .collect(Collectors.joining(", "));
//        _logger.log(Level.INFO, "Save categories: {0}", categories);
//        return "";

//  ***Using a regular for loop approach***
        for (Category category : _categories) {
            _categoryService.save(category);
        }
        for (Category category : _deletedCategories) {
            _categoryService.delete(category);
        }
        _deletedCategories = new ArrayList<>();
        return "";
    }
}
