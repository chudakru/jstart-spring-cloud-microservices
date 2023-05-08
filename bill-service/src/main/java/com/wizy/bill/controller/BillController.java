package com.wizy.bill.controller;

import com.wizy.bill.controller.dto.BillRequestDto;
import com.wizy.bill.controller.dto.BillResponseDto;
import com.wizy.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/")
    public Long create(@RequestBody BillRequestDto billRequestDto) {
        return billService.create(billRequestDto.getId(), billRequestDto.getAmount(),
            billRequestDto.getIsDefault(), billRequestDto.getOverdraftEnabled());
    }

    @GetMapping("/{billId}")
    public BillResponseDto getBill(@PathVariable Long billId) {
        return new BillResponseDto(billService.getById(billId));
    }

    @PutMapping("/{billId}")
    public BillResponseDto updateBill(@PathVariable Long billId,
                                      @RequestBody BillRequestDto billRequestDTO) {
        return new BillResponseDto(billService.update(billId, billRequestDTO.getId(),
            billRequestDTO.getAmount(), billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDto deleteBill(@PathVariable Long billId) {
        return new BillResponseDto(billService.delete(billId));
    }
}
