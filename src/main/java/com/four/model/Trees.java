/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Tree
 * Author:   Administrator
 * Date:     2018/5/16 16:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/5/16
 * @since 1.0.0
 */
public class Trees implements Serializable {

    private static final long serialVersionUID = 292218231584391737L;
    private Integer id;
    private String text;
    private Integer pid;
    private String url;
    private String iconCls ;
//    private List<Tree> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

//    public List<Tree> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<Tree> children) {
//        this.children = children;
//}
//
//    @Override
//    public String toString() {
//        return "Tree{" +
//                "id=" + id +
//                ", text='" + text + '\'' +
//                ", pid=" + pid +
//                ", url='" + url + '\'' +
//                ", iconCls='" + iconCls + '\'' +
//                ", children=" + children +
//                '}';
//    }


    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", url='" + url + '\'' +
                ", iconCls='" + iconCls + '\'' +
                '}';
    }
}



