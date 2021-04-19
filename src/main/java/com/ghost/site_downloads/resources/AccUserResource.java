package com.ghost.site_downloads.resources;

import com.ghost.site_downloads.converter.categoryConverters.CategoryBasicWAccUserConverter;
import com.ghost.site_downloads.converter.categoryConverters.CategoryConverter;
import com.ghost.site_downloads.dto.categoryDTO.CategoryBasicWAccUserDTO;
import com.ghost.site_downloads.dto.categoryDTO.CategoryDTO;
import com.ghost.site_downloads.dto.categoryDTO.CategoryWSubCatDTO;
import com.ghost.site_downloads.models.AccUser;
import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.services.AccUserService;
import com.ghost.site_downloads.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class AccUserResource {

    @Autowired
    private AccUserService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccUser> findById(@PathVariable Integer id) {
        AccUser obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Category> findById(@PathVariable Integer id) {
//        Category obj = service.findById(id);
//
//        return ResponseEntity.ok().body(obj);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert(@RequestBody AccUser obj){
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getUser_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody AccUser obj ,@PathVariable Integer id){
        obj.setUser_id(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<Category>> findAll() {
//        List<Category> list = service.findAll();
//
//        return ResponseEntity.ok().body(list);
//    }

//    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccUser>> findAllDTO() {
        List<AccUser> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }
}
