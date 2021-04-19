package com.ghost.site_downloads.resources;

import com.ghost.site_downloads.converter.LinkCoverters.LinkConverter;
import com.ghost.site_downloads.converter.categoryConverters.CategoryConverter;
import com.ghost.site_downloads.dto.LinkDTO.LinkDTO;
import com.ghost.site_downloads.dto.categoryDTO.CategoryDTO;
import com.ghost.site_downloads.dto.categoryDTO.CategoryWSubCatDTO;
import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.models.Link;
import com.ghost.site_downloads.services.CategoryService;
import com.ghost.site_downloads.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/link")
public class LinkResource {

    @Autowired
    private LinkService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LinkDTO> findById(@PathVariable Integer id) {
        Link obj = service.findById(id);
        LinkDTO dto = LinkConverter.entityToDTO(obj);

        return ResponseEntity.ok().body(dto);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Category> findById(@PathVariable Integer id) {
//        Category obj = service.findById(id);
//
//        return ResponseEntity.ok().body(obj);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert(@RequestBody LinkDTO obj){
        Link link = LinkConverter.dtoToEntity(obj);
        link = service.insert(link);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getLink_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody LinkDTO obj ,@PathVariable Integer id){
        Link link = LinkConverter.dtoToEntity(obj);
        link.setLink_id(id);
        link = service.update(link);

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
    public ResponseEntity<List<LinkDTO>> findAllDTO() {
        List<Link> list = service.findAll();
        List<LinkDTO> linkDTO  = LinkConverter.entityToDTOList(list);

        return ResponseEntity.ok().body(linkDTO);
    }
}
