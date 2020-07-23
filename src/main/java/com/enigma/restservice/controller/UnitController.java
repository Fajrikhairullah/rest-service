package com.enigma.restservice.controller;

import com.enigma.restservice.entities.Unit;
import com.enigma.restservice.models.PageableList;
import com.enigma.restservice.models.ResponseMessage;
import com.enigma.restservice.models.UnitModel;
import com.enigma.restservice.services.UnitService;

import java.lang.reflect.Type;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/units")
@RestController
@Validated
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping
    public ResponseMessage add(@RequestBody @Valid UnitModel model) {
        Unit entity = unitService.save(new Unit(model.getName(), model.getDescription()));
//        Unit entity = unitService.save(new Unit(model.getName(), model.getDescription()));


        ModelMapper modelMaper = new ModelMapper();
        UnitModel data = modelMaper.map(entity, UnitModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage edit(@PathVariable Integer id, @RequestBody @Valid UnitModel model) {

        ModelMapper modelMaper = new ModelMapper();
        model.setId(id);
        Unit entity = unitService.findById(id);
        modelMaper.map(model, entity);

        entity = unitService.save(entity);

        UnitModel data = modelMaper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);

    }

    @DeleteMapping("/{id}")
    public ResponseMessage<UnitModel> removeById(@PathVariable Integer id
    ) {
        Unit entity = unitService.removeById(id);

        ModelMapper modelMaper = new ModelMapper();
        UnitModel model = modelMaper.map(entity, UnitModel.class);

        return ResponseMessage.success(model);

    }

    @GetMapping("/{id}")
    public ResponseMessage<UnitModel> findById(@PathVariable Integer id) {
        Unit entity = unitService.findById(id);

        ModelMapper modelMaper = new ModelMapper();
        UnitModel model = modelMaper.map(entity, UnitModel.class);
        return ResponseMessage.success(model);

    }

    @GetMapping()
    public ResponseMessage findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "ASC") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        Unit entity = new Unit(name,description);
//        Unit entity = new Unit(name);
        Sort.Direction direction = Sort.Direction
                //                .valueOf(sort.toUpperCase());
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Unit> pageUnits = unitService.findAll(entity, page, size, direction);
        List<Unit> units = pageUnits.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<UnitModel>>() {
        }.getType();
        List<UnitModel> unitModels = modelMapper.map(units, type);

        PageableList<UnitModel> data = new PageableList(unitModels, pageUnits.getNumber(), pageUnits.getSize(),
                pageUnits.getTotalElements());
        return ResponseMessage.success(data);
    }

}
