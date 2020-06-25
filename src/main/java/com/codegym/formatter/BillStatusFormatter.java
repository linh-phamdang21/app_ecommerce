package com.codegym.formatter;

import com.codegym.model.BillStatus;
import com.codegym.service.billStatus.BillStatusService;
import com.codegym.service.billStatus.IBillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BillStatusFormatter implements Formatter<BillStatus> {
    @Autowired
    private IBillStatusService billStatusService;

    @Autowired
    public BillStatusFormatter(BillStatusService billStatusService){
        this.billStatusService=billStatusService;
    }

    @Override
    public BillStatus parse(String text, Locale locale) throws ParseException {
        return billStatusService.getById(Long.parseLong(text)).get();
    }

    @Override
    public String print(BillStatus object, Locale locale) {
        return null;
    }
}