package com.zg.vo;

import java.util.ArrayList;
import java.util.List;

public  class Tree<T> {

	private T root;
	private List<Tree> subTrees = new ArrayList<Tree>();
	


	public Tree(T root) {
		super();
		this.root = root;
	}

	public Tree() {
		super();
	}

	public T getRoot() {
		return root;
	}

	public void setRoot(T root) {
		this.root = root;
	}



	public List<Tree> getSubTrees() {
		return subTrees;
	}

	public void setSubTrees(List<Tree> subTrees) {
		this.subTrees = subTrees;
	}


	public Tree(T root, List<Tree> subTrees) {
		super();
		this.root = root;
		this.subTrees = subTrees;
	}
	
	public void addSubTree(Tree tree) {
		
		this.subTrees.add(tree);
	}

	public void addSubTreeRoot(T root) {
		
		this.subTrees.add(new Tree(root));
	}
	
   public String toHtml(TreeNodeToHtmlCallback callback){
	   StringBuffer sb=new StringBuffer();
	   toHtml(sb,callback);
	   return sb.toString();
   }
	
	protected void toHtml(StringBuffer sb,TreeNodeToHtmlCallback<T> callback){
		sb.append("<li>");
		if(root!=null)
			sb.append(callback.toHtml(root));
		if(!subTrees.isEmpty()){
			sb.append("<ul>");
			for(Tree subTree :subTrees){
				subTree.toHtml(sb,callback);
			}
			sb.append("</ul>");
		}
		sb.append("</li>");
	}
}
