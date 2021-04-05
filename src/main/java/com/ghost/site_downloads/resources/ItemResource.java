package com.ghost.site_downloads.resources;

import com.ghost.site_downloads.converter.itemConverters.ItemFullConverter;
import com.ghost.site_downloads.converter.itemConverters.ItemFullWDetailConverter;
import com.ghost.site_downloads.converter.itemConverters.ItemWLinksConverter;
import com.ghost.site_downloads.dto.itemDTO.ItemFullDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemFullWDetailDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemWLinksDTO;
import com.ghost.site_downloads.models.Item;
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
@RequestMapping(value = "/itens")
public class ItemResource {

    @Autowired
    private ItemService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemFullWDetailDTO> findById(@PathVariable Integer id) {
        Item obj = service.findById(id);
        ItemFullWDetailDTO dto = ItemFullWDetailConverter.entityToDTO(obj);

        return ResponseEntity.ok().body(dto);
    }

//    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Item> findById3(@PathVariable Integer id) {
//        Item obj = service.findById(id);
//
//        return ResponseEntity.ok().body(obj);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert2(@RequestBody ItemFullDTO obj) {
        Item item = ItemFullConverter.dtoToEntity(obj);
        Date now = new Date();
        item.setCreated_at(now);
        item = service.insert(item);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getItem_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody Item obj ,@PathVariable Integer id){
//        obj.setItem_id(id);
//        obj = service.update(obj);
//
//        return ResponseEntity.noContent().build();
//
//    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody ItemFullDTO obj ,@PathVariable Integer id){
//        Item item = ItemFullConverter.dtoToEntity(obj);
//        item.setItem_id(id);
//        service.update(item);
//
//        return ResponseEntity.noContent().build();
//
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ItemFullDTO obj ,@PathVariable Integer id){
        var created_at = service.findById(id).getCreated_at();
        Item item = ItemFullConverter.dtoToEntity(obj);
        item.setItem_id(id);
        item.setCreated_at(created_at);
        service.update(item);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemWLinksDTO>> findAllDTO() {
        List<Item> list = service.findAll();
        List<ItemWLinksDTO> dtos = ItemWLinksConverter.entityToDTOList(list);

        return ResponseEntity.ok().body(dtos);
    }
}
