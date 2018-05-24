  
package com.four.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.four.model.Tree;
import com.four.model.User;
import com.four.service.IServiceTree;


/**
 * 
 * <pre>项目名称：four_group    
 * 类名称：TreeController    
 * 类描述：    
 * 创建人：孙梦娜  
 * 创建时间：2018年3月12日 下午08:02:08    
 * 修改人：孙梦娜    
 * 修改时间：2018年3月12日 下午08:02:08    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("treeController")
public class TreeController {
	
	@Autowired
	private  IServiceTree servicetree;
	
	
	@RequestMapping("treelist")
	@ResponseBody
	public List<Tree> treelist(){
	 List<Tree> treelist= null;
	try {
		treelist = servicetree.treelist();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return treelist;
	}
	
	@RequestMapping("toTree")
	public String  toTree(String id,HttpServletRequest request){
		request.setAttribute("pid", id);
		return "addtree";
	}
	
	
	@RequestMapping("addTree")
	@ResponseBody
	public String addTree(Tree tree){
		Integer  a =null;
		try {
			
			a = servicetree.insertSelective(tree); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""+a;
		
		
	}
	
	
	@RequestMapping("deleteTrees")
	@ResponseBody
	public String  deleteTrees(Integer  id){
		
		servicetree.deleteByPrimaryKey(id);
		
		return "success";
	}
	
	
	@RequestMapping("toUpdateTree")
	public String toUpdateTree(Integer  id,HttpServletRequest request){
		Tree tree= servicetree.selectByPrimaryKey(id);
		request.setAttribute("tree", tree);
		
		return "updatetree";
	}
	@RequestMapping("updateTree")
	@ResponseBody
	public  String updateTree(Tree tree){
		
		servicetree.updateByPrimaryKey(tree);
		
		
		return "success";
	}
	
	
	@RequestMapping("queryRoleTree")
    @ResponseBody
    public List<Tree> queryRoleTree(int roleId){
 	   List<Tree> listTree = new ArrayList<Tree>();
 	   Tree tre =new Tree();
 	   try {
			List<Tree> list=servicetree.queryRoleTree(roleId);
			listTree = servicetree.selectTreeList(tre);
			for (Tree tree : listTree) {
				for (Tree tree1: list) {
					if(tree.getId()==tree1.getId()){
						tree.setChecked(true);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 	   return listTree;
    }
    
	@RequestMapping("addTreeRoleRelation")
    @ResponseBody
    public String addTreeRoleRelation(String ids,String roleId){
 	   try {
 		  servicetree.addTreeRoleRelation(ids,roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   
		return "success";
 	   
    }
	
/***
 * <pre>getRoleTreeList(不同的人登进来看到不同的页面)   
 * 创建人：孙梦娜  
 * 创建时间：2018年3月20日 下午4:28:13    
 * 修改人:孙梦娜        
 * 修改时间：2018年3月20日 下午4:28:13    
 * 修改备注： 
 * @param request
 * @return</pre>
 */
	 @RequestMapping("getRoleTreeList")
	   	@ResponseBody
	   	public Set<Map<String,Object>> getRoleTreeList(HttpServletRequest request){
	   		
	    	 User user = (User) request.getSession().getAttribute("user");
	    	 
	    	 //获得当前用户
	    	 Set<Map<String,Object>> obj =new HashSet<Map<String,Object>>();
	    	 
	    	 try {
				obj= servicetree.getRoleTreeList(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 
	    	 return obj;
	   	}
	
	
	
	
}
