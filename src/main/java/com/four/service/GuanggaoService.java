package com.four.service;


import com.alibaba.fastjson.JSONObject;
import com.four.model.GuangGao;

import java.util.List;

public interface GuanggaoService {
	/**
	 * 广告查询展示
	 * @return
	 */


	/**
	 * 删除广告
	 * @param guangGao
	 */
	void deleteGuangGao(String guangGao);

	/**
	 * 回显
	 * @param guangGao
	 */

	GuangGao queryGuangGaoById(GuangGao guangGao);

	/**
	 * 修改保存的方法
	 * @param guangGao
	 */
	void updateGuangGaoById(GuangGao guangGao);

	/**
	 * 广告的保存方法
	 * @param guangGao
	 */

	void saveGuangGaoByModel(GuangGao guangGao);

	JSONObject queryGuangGao(Integer offset, Integer limit);

	List<GuangGao> queryGuangGaoQianTai();


	List<GuangGao> guangGaoManager();

}
