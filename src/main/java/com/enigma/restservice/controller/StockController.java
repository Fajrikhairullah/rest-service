package com.enigma.restservice.controller;

import com.enigma.restservice.dto.StockSummary;
import com.enigma.restservice.entities.Item;
import com.enigma.restservice.entities.Stock;
import com.enigma.restservice.entities.Unit;
import com.enigma.restservice.models.PageableList;
import com.enigma.restservice.models.ResponseMessage;
import com.enigma.restservice.models.StockModel;
import com.enigma.restservice.services.StockService;
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

@RequestMapping("/stocks")
@RestController
@Validated

public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseMessage<StockModel> add(@RequestBody @Valid StockModel model) {
        Stock entity = stockService.save(new Stock(model.getItem(), model.getQty(), model.getUnit()));

        ModelMapper modelMaper = new ModelMapper();
        StockModel data = modelMaper.map(entity, StockModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<StockModel> edit(@PathVariable Integer id, @RequestBody @Valid StockModel model) {

        ModelMapper modelMaper = new ModelMapper();
        model.setId(id);
        Stock entity = stockService.findById(id);
        modelMaper.map(model, entity);

        entity = stockService.save(entity);

        StockModel data = modelMaper.map(entity, StockModel.class);
        return ResponseMessage.success(data);

    }

    @DeleteMapping("/{id}")
    public ResponseMessage<StockModel> removeById(@PathVariable Integer id
    ) {
        Stock entity = stockService.removeById(id);

        ModelMapper modelMaper = new ModelMapper();
        StockModel model = modelMaper.map(entity, StockModel.class);

        return ResponseMessage.success(model);

    }

    @GetMapping("/{id}")
    public ResponseMessage<StockModel> findById(@PathVariable Integer id) {
        Stock entity = stockService.findById(id);

        ModelMapper modelMaper = new ModelMapper();
        StockModel model = modelMaper.map(entity, StockModel.class);
        return ResponseMessage.success(model);

    }

    @GetMapping()
    public ResponseMessage findAll(
            @RequestParam(required = false) Item item,
            @RequestParam(required = false) Integer qty,
            @RequestParam(required = false) Unit unit,
            @RequestParam(defaultValue = "ASC") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }

        Stock entity = new Stock();
        Sort.Direction direction = Sort.Direction
                //                .valueOf(sort.toUpperCase());
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Stock> pageStocks = stockService.findAll(entity, page, size, direction);
        List<Stock> stocks = pageStocks.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<StockModel>>() {
        }.getType();
        List<StockModel> stockModels = modelMapper.map(stocks, type);

        PageableList<StockModel> data = new PageableList(stockModels, pageStocks.getNumber(), pageStocks.getSize(),
                pageStocks.getTotalElements());
        return ResponseMessage.success(data);
    }

    @GetMapping(path = "/summary")
    public ResponseMessage<List<StockSummary>> listSummary() {
        List<StockSummary> stockSummaries = stockService.stockSummary();
        return ResponseMessage.success(stockSummaries);
    }

}
