package com.ghost.site_downloads.services;

import com.ghost.site_downloads.models.Images;
import com.ghost.site_downloads.models.Item;
import com.ghost.site_downloads.repositories.ImagesRepository;
import com.ghost.site_downloads.repositories.ItemRepository;
import com.ghost.site_downloads.services.exception.DataIntegrityException;
import com.ghost.site_downloads.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    public Images findById(Integer item_id){
        Optional<Images> obj = imagesRepository.findById(item_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                //Pode se usar .getName no lugar de getSimpleName()
                "+-=Custom Error=-+ Object not found! id: " + item_id + ", Type: " + Item.class.getSimpleName()
        ));
    }

    //    POST AND PUT FOR CATEGORY
    public Images insertCategory(Images obj){
        obj.setImage_id(null);
        obj.setSubCategory(null);
        obj.setItem(null);
        return imagesRepository.save(obj);
    }

    public Images updateCategory(Images obj){
        findById(obj.getImage_id());
        obj.setSubCategory(null);
        obj.setItem(null);
        return imagesRepository.save(obj);
    }

    //    POST AND PUT FOR SUBCATEGORY
    public Images insertSubCategory(Images obj){
        obj.setImage_id(null);
        obj.setCategory(null);
        obj.setItem(null);
        return imagesRepository.save(obj);
    }

    public Images updateSubCategory(Images obj){
        findById(obj.getImage_id());
        obj.setCategory(null);
        obj.setItem(null);
        return imagesRepository.save(obj);
    }

    //    POST AND PUT FOR SUBCATEGORY
    public Images insertItem(Images obj){
        obj.setImage_id(null);
        obj.setCategory(null);
        obj.setSubCategory(null);
        return imagesRepository.save(obj);
    }

    public Images updateItem(Images obj){
        findById(obj.getImage_id());
        obj.setCategory(null);
        obj.setSubCategory(null);
        return imagesRepository.save(obj);
    }

    public void deleteById(Integer images_id){
        findById(images_id);
        try {
            imagesRepository.deleteById(images_id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("+-=Custom Error=-+ Not is possible delete this item");
        }
    }

    public List<Images> findAll(){
        return imagesRepository.findAll();
    }

}
