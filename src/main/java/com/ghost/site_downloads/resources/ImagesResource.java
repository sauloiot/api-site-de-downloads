package com.ghost.site_downloads.resources;

import com.ghost.site_downloads.converter.categoryConverters.CategoryConverter;
import com.ghost.site_downloads.converter.imagesConverters.ImageCategoryConverter;
import com.ghost.site_downloads.converter.imagesConverters.ImageItemConverter;
import com.ghost.site_downloads.converter.imagesConverters.ImageSubCategoryConverter;
import com.ghost.site_downloads.converter.itemConverters.ItemFullConverter;
import com.ghost.site_downloads.converter.itemConverters.ItemFullWDetailConverter;
import com.ghost.site_downloads.converter.itemConverters.ItemWLinksConverter;
import com.ghost.site_downloads.dto.ImagesDTO.ImagesCategoryDTO;
import com.ghost.site_downloads.dto.ImagesDTO.ImagesItemDTO;
import com.ghost.site_downloads.dto.ImagesDTO.ImagesSubCategoryDTO;
import com.ghost.site_downloads.dto.categoryDTO.CategoryWSubCatDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemFullDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemFullWDetailDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemWLinksDTO;
import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.models.Images;
import com.ghost.site_downloads.models.Item;
import com.ghost.site_downloads.services.ImagesService;
import com.ghost.site_downloads.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/images")
public class ImagesResource {

    @Autowired
    private ImagesService service;

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<ImagesCategoryDTO> findById(@PathVariable Integer id) {
        Images obj = service.findById(id);
        ImagesCategoryDTO dto = ImageCategoryConverter.entityToDTO(obj);

        return ResponseEntity.ok().body(dto);
    }

//    POST AND PUT FOR CATEGORY
    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertCategory(@RequestBody ImagesCategoryDTO obj) {
        Images images = ImageCategoryConverter.dtoToEntity(obj);
        images = service.insertCategory(images);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(images.getImage_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCategory(@RequestBody ImagesCategoryDTO obj ,@PathVariable Integer id){
        Images images = ImageCategoryConverter.dtoToEntity(obj);
        images.setImage_id(id);

        service.updateCategory(images);

        return ResponseEntity.noContent().build();

    }


    //    POST AND PUT FOR SUBCATEGORY
    @RequestMapping(value = "/subcategories", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertSubCategory(@RequestBody ImagesSubCategoryDTO obj) {
        Images images = ImageSubCategoryConverter.dtoToEntity(obj);
        images = service.insertSubCategory(images);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(images.getImage_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/subcategories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSubCategory(@RequestBody ImagesSubCategoryDTO obj ,@PathVariable Integer id){
        Images images = ImageSubCategoryConverter.dtoToEntity(obj);
        images.setImage_id(id);

        service.updateSubCategory(images);

        return ResponseEntity.noContent().build();

    }

    //    POST AND PUT FOR ITEM
    @RequestMapping(value = "/item", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertItem(@RequestBody ImagesItemDTO obj) {
        Images images = ImageItemConverter.dtoToEntity(obj);
        images = service.insertItem(images);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(images.getImage_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateItem(@RequestBody ImagesItemDTO obj ,@PathVariable Integer id){
        Images images = ImageItemConverter.dtoToEntity(obj);
        images.setImage_id(id);

        service.updateItem(images);

        return ResponseEntity.noContent().build();

    }



    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
