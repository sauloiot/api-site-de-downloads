package com.ghost.site_downloads.services;

import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.repositories.CategoryRepository;
import com.ghost.site_downloads.services.exception.DataIntegrityException;
import com.ghost.site_downloads.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer category_id){
        Optional<Category> obj = categoryRepository.findById(category_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                //Pode se usar .getName no lugar de getSimpleName()
                "+-=Custom Error=-+ Object not found! id: " + category_id + ", Type: " + Category.class.getSimpleName()
        ));
    }

    public Category insert(Category obj){
        obj.setCategory_id(null);
        return categoryRepository.save(obj);
    }

    public Category update(Category obj){
        findById(obj.getCategory_id());
        return categoryRepository.save(obj);
    }

    public void deleteById(Integer category_id){
        findById(category_id);
        try {
            categoryRepository.deleteById(category_id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("+-=Custom Error=-+ Not is possible delete category with sub-categories");
        }
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

}
