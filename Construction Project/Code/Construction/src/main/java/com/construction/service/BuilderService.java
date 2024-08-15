package com.construction.service;

import com.construction.dtos.BuilderDto;
import com.construction.updateDtos.UpdateBuilderDto;

public interface BuilderService {

	public BuilderDto addNewBuilder(BuilderDto builderDto);

	public BuilderDto updateBuilder(UpdateBuilderDto updateBuilderDto);



}
