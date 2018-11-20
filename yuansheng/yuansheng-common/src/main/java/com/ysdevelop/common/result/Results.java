package com.ysdevelop.common.result;


/**
 * 
 * @author OldHuang
 * 
 * @Package com.ysdevelop.result
 * 
 * @Description: 返回给用户的结果的统一格式,如果失败则调error方法,成功调用success方法
 * 
 * @date 2018年4月2日
 * 
 * @version
 * 
 */
public class Results<T> {
	private int code;
	private String msg;
	// layui 分页需要返回一个总的记录数(总的条目数)
	private long count;
	private T data;
	
	/**
	 *  成功时候的调用
	 * */
	public static  <T> Results<T> success(String msg){
		return new Results<T>(msg);
	}
	
	/**
	 *  成功时候的调用,data设置
	 * */
	public static  <T> Results<T> successData(T data){
		return new Results<T>(data);
	}
	
	/**
	 * 成功时候的调用,data设置
	 * */
	public static <T> Results<T> successPaginationData(T data, Long count) {
		return new Results<T>("操作成功", data, count);
	}
	
	/**
	 *  失败时候的调用
	 * */
	public static  <T> Results<T> error(CodeMsg codeMsg){
		return new Results<T>(codeMsg);
	}
	
	private Results(){
		
	}
	
	private Results(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	private Results(String msg, T data, Long count) {
		this.data = data;
		this.msg = msg;
		this.count = count;
	}
		
	private Results(T data) {
		this.data = data;
	}
	
	private Results(String msg){
		this.msg = msg;
	}
	
	
	private Results(CodeMsg codeMsg){
		if(codeMsg!=null){
			this.code = codeMsg.getCode();
			this.msg = codeMsg.getMsg();
		}
	}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	
	
	
}
