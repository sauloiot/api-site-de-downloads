package com.ghost.site_downloads.services;

import com.ghost.site_downloads.models.SubCategory;
import com.ghost.site_downloads.repositories.SubCategoryRepository;
import com.ghost.site_downloads.services.exception.DataIntegrityException;
import com.ghost.site_downloads.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory findById(Integer subCategory_id){
        Optional<SubCategory> obj = subCategoryRepository.findById(subCategory_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                //Pode se usar .getName no lugar de getSimpleName()
                "+-=Custom Error=-+ Object not found! id: " + subCategory_id + ", Type: " + SubCategory.class.getSimpleName()
        ));
    }

    public SubCategory insert(SubCategory obj){
        obj.setSub_category_id(null);
        return subCategoryRepository.save(obj);
    }

    public SubCategory update(SubCategory obj){
        findById(obj.getSub_category_id());
        return subCategoryRepository.save(obj);
    }

    public void deleteById(Integer category_id){
        findById(category_id);
        try {
            subCategoryRepository.deleteById(category_id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("+-=Custom Error=-+ Not is possible delete subCategory with itens");
        }
    }

    public List<SubCategory> findAll(){
        return subCategoryRepository.findAll();
    }

}
