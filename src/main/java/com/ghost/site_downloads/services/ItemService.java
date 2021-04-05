package com.ghost.site_downloads.services;

import com.ghost.site_downloads.models.Item;
import com.ghost.site_downloads.models.SubCategory;
import com.ghost.site_downloads.repositories.ItemRepository;
import com.ghost.site_downloads.repositories.SubCategoryRepository;
import com.ghost.site_downloads.services.exception.DataIntegrityException;
import com.ghost.site_downloads.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item findById(Integer item_id){
        Optional<Item> obj = itemRepository.findById(item_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                //Pode se usar .getName no lugar de getSimpleName()
                "+-=Custom Error=-+ Object not found! id: " + item_id + ", Type: " + Item.class.getSimpleName()
        ));
    }

    public Item insert(Item obj){
        obj.setItem_id(null);
        return itemRepository.save(obj);
    }

    public Item update(Item obj){
        findById(obj.getItem_id());
        return itemRepository.save(obj);
    }

    public void deleteById(Integer category_id){
        findById(category_id);
        try {
            itemRepository.deleteById(category_id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("+-=Custom Error=-+ Not is possible delete this item");
        }
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

}
