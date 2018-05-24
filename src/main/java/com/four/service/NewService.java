package com.four.service;

import com.four.model.NewTree;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
public interface NewService {
    List<NewTree> querynews(NewTree newTree, Integer offset, Integer limit);

    Long quentCount(NewTree newTree);

    void delnews(Integer id);
}
