package com.enigma.restservice.services.impl;

import com.enigma.restservice.entities.Item;
import com.enigma.restservice.exceptions.EntityNotFoundException;
import com.enigma.restservice.repositories.ItemRepository;
import com.enigma.restservice.services.ItemService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ItemServiceImpl extends CommonServiceImpl<Item, Integer> implements ItemService {

    @Autowired
    private ItemRepository repository;

//    @Autowired
//    private List<Item> entities;
//
//    @PostConstruct
//    public void init() {
//        add(new Item("Beras"));
//        add(new Item("Gula Pasir"));
//        add(new Item("Mie Goreng"));
//        add(new Item("Kopi"));
//        add(new Item("Minyak"));
//    }
//
//    public int nextId() {
//        int i = 1;
//        for (Item entity : entities) {
//            if (entity.getId() != 1) {
//                break;
//            }
//            i++;
//
//        }
//        return i;
//    }
//    @Override
//    public Item add(Item entity) {
//        entity.setId(nextId());
//        entity.setCreateDate(LocalDateTime.now());
//        entity.setModifyDate(LocalDateTime.now());
//        entities.add(entity);
//        
//        Collections.sort(entities, (Item o1, Item o2)-> Integer.compare(o1.getId(), o2.getId()));
//
//        return entity;
//    }
    @Override
    public Item save(Item entity) {
//        Item currentEntity = findById(entity.getId());
//        if(currentEntity == null){
//            throw new ApplicationException(1, "Entity not found");
//            
//        }
//        currentEntity.setName(entity.getName());
//        currentEntity.setModifyDate(LocalDateTime.now());
//        Item item = findById(entity.getId());
//        item.setName(entity.getName());
//        item.setCreateDate(LocalDateTime.now());
//        item.setModifyDate(LocalDateTime.now());

        return repository.save(entity);
    }

    @Override
    public Item removeById(Integer id) {
        Item entity = findById(id);
        repository.delete(entity);
//        Iterator<Item> iterator = entities.iterator();
//        while (iterator.hasNext()) {
//            Item item = iterator.next();
//            if (item.getId().equals(id)) {
//                iterator.remove();
//                return item;
//            }
//        }
        return entity;
    }

    @Override
    public Item findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
//        for (Item item : entities) {
//            if (item.getId().equals(id)) {
//                return item;
//            }
//        }

    }

    @Override
    public Page<Item> findAll(Item entity, int page, int size, Sort.Direction direction) {
        Sort s = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));

    }

//    @Override
//    public List<Item> findByNameLike(String name, boolean ignoreCase) {
//        if(!name.isEmpty()){
//            return ignoreCase ? 
//                    repository.findByNameContaining(name):
//                    repository.findByNameLike(name);
//        }else{
//        return findAll();
//        }
//
//    }

    @Override
    protected JpaRepository<Item, Integer> getRepository() {
        return repository;
    }

}
