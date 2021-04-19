package com.ghost.site_downloads.services;

import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.models.Link;
import com.ghost.site_downloads.repositories.CategoryRepository;
import com.ghost.site_downloads.repositories.LinkRepository;
import com.ghost.site_downloads.services.exception.DataIntegrityException;
import com.ghost.site_downloads.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public Link findById(Integer link_id){
        Optional<Link> obj = linkRepository.findById(link_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                //Pode se usar .getName no lugar de getSimpleName()
                "+-=Custom Error=-+ Object not found! id: " + link_id + ", Type: " + Category.class.getSimpleName()
        ));
    }

    public Link insert(Link obj){
        obj.setLink_id(null);
        return linkRepository.save(obj);
    }

    public Link update(Link obj){
        findById(obj.getLink_id());
        return linkRepository.save(obj);
    }

    public void deleteById(Integer category_id){
        findById(category_id);
        try {
            linkRepository.deleteById(category_id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("+-=Custom Error=-+ Not is possible delete category with sub-categories");
        }
    }

    public List<Link> findAll(){
        return linkRepository.findAll();
    }

}
