package nl.novi.breedsoft.service;

import nl.novi.breedsoft.dto.waitingListItemDtos.WaitingListItemOutputDto;
import nl.novi.breedsoft.exception.RecordNotFoundException;
import nl.novi.breedsoft.model.management.Person;
import nl.novi.breedsoft.model.management.WaitingListItem;
import nl.novi.breedsoft.repository.WaitingListItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WaitingListItemService {

    private final WaitingListItemRepository waitingListItemRepository;

    public WaitingListItemService(WaitingListItemRepository waitingListItemRepository) {
        this.waitingListItemRepository = waitingListItemRepository;
    }

    //GET all waiting list items from the database
    public List <WaitingListItemOutputDto> getAllWaitingListItems(){
        List<WaitingListItem> waitingListItemsList = waitingListItemRepository.findAll();
        return transferWaitingListItemListToDtoList(waitingListItemsList);
    }

    //GET a waiting list item by person ID
    public List <WaitingListItemOutputDto> getWaitingListItemByPersonID(Long id){
        List <WaitingListItem> waitingListItemList = waitingListItemRepository.findAll();
        List <WaitingListItem> foundWaitingListItem = new ArrayList<>();
        for(WaitingListItem waitingListItem : waitingListItemList){
            Person person = waitingListItem.getPerson();
            if(person.getId().equals(id)){
                foundWaitingListItem = person.getWaitingListItems();
            }
        }
        if(foundWaitingListItem.isEmpty()){
            throw new RecordNotFoundException("No waiting list item found for this person");
        }
        return transferWaitingListItemListToDtoList(foundWaitingListItem);
    }

    //DTO helper classes
    public List<WaitingListItemOutputDto> transferWaitingListItemListToDtoList(List<WaitingListItem> waitingListItems){
        List<WaitingListItemOutputDto> waitingListItemOutputDtoList = new ArrayList<>();

        for(WaitingListItem waitingListItem : waitingListItems){
            WaitingListItemOutputDto dto = transferWaitingListItemToOutputDto(waitingListItem);
            waitingListItemOutputDtoList.add(dto);
        }
        return waitingListItemOutputDtoList;
    }

    public WaitingListItemOutputDto transferWaitingListItemToOutputDto(WaitingListItem waitingListItem){

        WaitingListItemOutputDto waitingListItemOutputDto = new WaitingListItemOutputDto();
        waitingListItemOutputDto.setId(waitingListItem.getId());
        waitingListItemOutputDto.setNumberOnList(waitingListItem.getNumberOnList());
        waitingListItemOutputDto.setSex(waitingListItem.getSex());
        waitingListItemOutputDto.setBreed(waitingListItem.getBreed());
        waitingListItemOutputDto.setPerson(waitingListItem.getPerson());
        waitingListItemOutputDto.setKindOfHair(waitingListItem.getKindOfHair());

        return waitingListItemOutputDto;
    }
}
