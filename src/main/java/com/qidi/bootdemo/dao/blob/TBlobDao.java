package com.qidi.bootdemo.dao.blob;

import com.qidi.bootdemo.model.blob.TBlob;

import java.util.List;
import java.util.Map;

public interface TBlobDao {

	void insert(TBlob tBlob);
	
	void update(TBlob tBlob);
	
	TBlob getTBlobById(Long id);

    Integer countTBlob(Map<String, Object> params);

    List<TBlob> getTBlobList(Map<String, Object> params);
	
}