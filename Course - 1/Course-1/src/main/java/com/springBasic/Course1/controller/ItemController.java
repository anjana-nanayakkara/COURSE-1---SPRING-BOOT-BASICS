package com.springBasic.Course1.controller;

import com.springBasic.Course1.dto.CustomerDTO;
import com.springBasic.Course1.dto.request.ItemSaveRequestDTO;
import com.springBasic.Course1.dto.responce.ItemGetResponceDTO;
import com.springBasic.Course1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController{
    @Autowired
    public ItemService itemService;

    @PostMapping
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){

        itemService.saveItem(itemSaveRequestDTO);
        return "saved";
    }

    @GetMapping(
            value = "get-by-name",
            params= "name"
    )
    public List<ItemGetResponceDTO> getItemByNameAndStatus(@RequestParam (value = "name") String itemName){
        List<ItemGetResponceDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDTOS;

    }
}
