package com.zg.util;

import org.springframework.dao.DataAccessException;

import com.zg.exception.DaoException;

public class DaoAspect {
	
	public void handleException(Exception e) throws Exception{
		if(e instanceof DataAccessException){
			throw new DaoException(e);
		}else{
			throw e;
		}
	}

}
