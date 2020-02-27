package com.situ.scrm.dictionaries.service;

import java.util.List;

import com.situ.scrm.commons.domain.LayResult;
import com.situ.scrm.dictionaries.domain.Dictionaries;

public interface DictionariesService {

	Integer checkDicValue(String dicValue);

	Long saveDic(Dictionaries dictionaries);

	LayResult findAllDictionaries();

	Dictionaries getDictionariesById(Long parentId);

	Integer doDeleteDict(Long rowId);

	Dictionaries getAllDicById(Long rowId);

	Long updateDic(Dictionaries dictionaries);

	List<Dictionaries> DictionariesList();



}
