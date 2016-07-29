package com.zg.service.sh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zg.dao.IBookDao;
import com.zg.dao.ISortDao;
import com.zg.po.Book;
import com.zg.po.Sort;
import com.zg.service.ISortService;
import com.zg.vo.SortTree;
import com.zg.vo.Tree;

public class SortServiceImpl implements ISortService {
	private ISortDao sortDao;
	private IBookDao bookDao;

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setSortDao(ISortDao sortDao) {
		this.sortDao = sortDao;
	}

	public void deleteSort(int id) {
		// TODO Auto-generated method stub

	}

	public List findSorts() {
		List<Sort> list = sortDao.findSorts();
		List<SortTree> sorts = new ArrayList<SortTree>();
		for(Sort sort:list){
			String code=sort.getCode()+"";
			if(code.matches("^[0-9]{2}0{4}$")){
				SortTree sortTree=new SortTree(sort);
				sorts.add(sortTree);
				//找第一层下面的子树
				findSubSortTree(list,sortTree,1);
			}
		}
		return sorts;
	}
	protected void findSubSortTree(List<Sort> list,SortTree sortTree,int level){
		String code = sortTree.getRoot().getCode()+"";
		String prefix = code.substring(0, 2*level);
		for(Sort sort:list){
			String subCode=sort.getCode()+"";
			if(subCode.matches("^"+prefix+"[0-9]{2}0{"+(2-level)*2+"}$")&&!subCode.equals(code)){
				SortTree subSortTree=new SortTree(sort);
				sortTree.addSubTree(subSortTree);
				//找下一层下面的子树
				if(level<2){
					findSubSortTree(list, subSortTree, level+1);
				}
			}
		}
	}
	
	public List<Sort> findeSubSorts(int code) {
		return sortDao.findSubSorts(code);
	}

	public void saveSort(int id, String name) {
		// TODO Auto-generated method stub

	}

	public void updateSort(int id, String name) {
		// TODO Auto-generated method stub

	}

	

}
