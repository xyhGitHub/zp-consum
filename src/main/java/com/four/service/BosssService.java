package com.four.service;

import com.four.model.GongSi;
import com.four.model.GongSiBoos;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
public interface BosssService {
    List<GongSiBoos> queryboss(GongSiBoos boss, Integer offset, Integer limit);

    long queryCount(GongSiBoos boss);

    void delboss(Integer id);

    void saveShenhe(GongSi gongsi);

}
