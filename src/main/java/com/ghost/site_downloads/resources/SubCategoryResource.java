package com.ghost.site_downloads.resources;

import com.ghost.site_downloads.converter.subCategoryConverters.SubCategoryBasicConverter;
import com.ghost.site_downloads.converter.subCategoryConverters.SubCategoryConverter;
import com.ghost.site_downloads.converter.subCategoryConverters.SubCategoryFullConverter;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryBasicDTO;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryDTO;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryFullDTO;
import com.ghost.site_downloads.models.SubCategory;
import com.ghost.site_downloads.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/subcategories")
public class SubCategoryResource {

    @Autowired
    private SubCategoryService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubCategoryBasicDTO> findById2(@PathVariable Integer id) {
        SubCategory obj = service.findById(id);
        SubCategoryBasicDTO dto = SubCategoryBasicConverter.entityToDTO(obj);

        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert2(@RequestBody SubCategoryFullDTO obj){
        SubCategory subCategory = SubCategoryFullConverter.dtoToEntity(obj);
        subCategory = service.insert(subCategory);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(subCategory.getSub_category_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody SubCategoryFullDTO obj ,@PathVariable Integer id){
        SubCategory subCategory = SubCategoryFullConverter.dtoToEntity(obj);
        subCategory.setSub_category_id(id);
        subCategory = service.update(subCategory);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SubCategoryDTO>> findAllDTO() {
        List<SubCategory> list = service.findAll();
        List<SubCategoryDTO> listDTO = SubCategoryConverter.entityToDTOList(list);

        return ResponseEntity.ok().body(listDTO);
    }
}
