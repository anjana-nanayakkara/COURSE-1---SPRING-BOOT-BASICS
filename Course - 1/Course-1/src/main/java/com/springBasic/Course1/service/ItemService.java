package com.springBasic.Course1.service;

import com.springBasic.Course1.dto.request.ItemSaveRequestDTO;
import com.springBasic.Course1.dto.responce.ItemGetResponceDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponceDTO> getItemByNameAndStatus(String itemName);
}
