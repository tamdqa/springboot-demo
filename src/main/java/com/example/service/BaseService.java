package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface BaseService {
	Object getData(Map<String, Object> mapParams);
	Object getListData(Map<String, Object> mapParams);
}
