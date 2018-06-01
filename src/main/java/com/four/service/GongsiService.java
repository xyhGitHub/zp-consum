package com.four.service;

import com.four.model.GongSi;
import com.four.model.GongSiBoos;

import java.util.List;

/**
 * Created by Administrator on 2018/5/16.
 */
public interface GongsiService {

    GongSi selectgongsi(Integer comid);

    List<GongSi> querygongsi(GongSi gongsi, Integer offset, Integer limit);

    long queryCount(GongSi gongsi);

    void delgongsi(Integer comid);

    List<GongSiBoos> queryall(Integer id);

    void saveShenhe(GongSi gongsi);

    void updatatongguo(Integer id);

    void editgongshiname(GongSi gongSi);

    void gongsieditphoto(Integer comid, String photo);

    List<GongSi> querysshowbyidzhiwei();

    void savebiaoqian(GongSi gongSi);

    GongSiBoos selectBossById(Integer comid);
}
