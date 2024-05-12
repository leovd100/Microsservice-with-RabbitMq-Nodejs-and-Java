package com.github.leovd100.message.service.applicationLayer.components;

import com.github.leovd100.message.service.domainLayer.dto.LeadDto;
import com.github.leovd100.message.service.domainLayer.entities.Lead;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperComponent {


    public Lead toLead(LeadDto leadDto){
        Lead lead = new Lead();
        ModelMapper modelMapper = new ModelMapper().registerModule(new RecordModule());
        modelMapper.map(leadDto, lead);
        return lead;
    }


}
