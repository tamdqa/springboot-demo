package com.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseRestService {
	protected Logger logger = LogManager.getLogger(this.getClass());
}
