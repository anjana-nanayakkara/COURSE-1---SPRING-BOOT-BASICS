package com.springBasic.Course1.service.serviceIMPL;

import com.springBasic.Course1.dto.request.ItemSaveRequestDTO;
import com.springBasic.Course1.dto.responce.ItemGetResponceDTO;
import org.modelmapper.ModelMapper;
import com.springBasic.Course1.entity.Item;
import com.springBasic.Course1.repository.ItemRepo;
import com.springBasic.Course1.service.ItemService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    public ItemRepo itemRepo;

    @Autowired
    public  ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );
//
//        itemRepo.save(item);
//        return null;

        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);

        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemName() + "saved";
        }else{
            throw new DuplicateKeyException("Already added");
        }



    }

    @Override
    public List<ItemGetResponceDTO> getItemByNameAndStatus(String itemName) {
        boolean activeState = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,activeState);
        if (items.size()>0){
            List<ItemGetResponceDTO> itemGetResponceDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponceDTO>>(){}.getType());
            return itemGetResponceDTOS;
        }else {
            throw new RuntimeException("Not Found");
        }

    }
}
