package com.enigma.restservice.controller;


//import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.entities.Transaction;
import com.enigma.restservice.models.PageableList;
import com.enigma.restservice.models.ResponseMessage;
import com.enigma.restservice.models.TransactionModel;
import com.enigma.restservice.models.TypeEnum;
import com.enigma.restservice.services.TransactionService;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
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

@RequestMapping("/trans")
@RestController
@Validated
public class TransactionController {
    
//    @Autowired
//    private EntityService<Transaction, Integer> service;

    @Autowired
    private TransactionService transService;

    @PostMapping
    public ResponseMessage<TransactionModel> add(@RequestBody @Valid TransactionModel model) {
        Transaction entity = transService.save(new Transaction(model.getAmount(), model.getTypeEnum(), model.getDescription()));

        ModelMapper modelMaper = new ModelMapper();
        TransactionModel data = modelMaper.map(entity, TransactionModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionModel> edit(@PathVariable Integer id, @RequestBody @Valid TransactionModel model) {

        ModelMapper modelMaper = new ModelMapper();
        model.setId(id);
        Transaction entity = transService.findById(id);
        modelMaper.map(model, entity);

        entity = transService.save(entity);

        TransactionModel data = modelMaper.map(entity, TransactionModel.class);
        return ResponseMessage.success(data);

    }

    @DeleteMapping("/{id}")
    public ResponseMessage<TransactionModel> removeById(@PathVariable Integer id
    ) {
        Transaction entity = transService.removeById(id);

        ModelMapper modelMaper = new ModelMapper();
        TransactionModel model = modelMaper.map(entity, TransactionModel.class);

        return ResponseMessage.success(model);

    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionModel> findById(@PathVariable Integer id) {
        Transaction entity = transService.findById(id);

        ModelMapper modelMaper = new ModelMapper();
        TransactionModel model = modelMaper.map(entity, TransactionModel.class);
        return ResponseMessage.success(model);

    }

    @GetMapping()
    public ResponseMessage findAll(
            @RequestParam(required = false) long amount,
            @RequestParam(required = false) TypeEnum typeEnum,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "ASC") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        
        Transaction entity = new Transaction(amount,typeEnum,description);
        Sort.Direction direction = Sort.Direction
                //                .valueOf(sort.toUpperCase());
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Transaction> pageTrans = transService.findAll(entity, page, size, direction);
        List<Transaction> trans = pageTrans.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<TransactionModel>>() {
        }.getType();
        List<TransactionModel> transModels = modelMapper.map(trans, type);
        
        PageableList<TransactionModel> data = new PageableList(transModels, pageTrans.getNumber(), pageTrans.getSize(),
                pageTrans.getTotalElements());
        return ResponseMessage.success(data);
    }
    
    @GetMapping("/summary")
    public ResponseMessage<List<TransactionSummary>> summary(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer date
    ) {
        List<TransactionSummary> data = transService.transactionSummary(
                        year != null ? Year.of(year) : Year.now(),
                        month != null ? Month.of(month) : null,
                        date != null ? date : null);

        System.out.println(data);
        return ResponseMessage.success(data);

    }

}
    

