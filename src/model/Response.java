package model;


public class Response {
	int errno;
	String err;
	Object rsm;
	
	public Response(){
		super();
		this.errno = 3;
		this.err = "";
		this.rsm = new Object();
	}
	public Response(int errno,String err,Object rsm){
		super();
		this.errno = errno;
		this.err = err;
		this.rsm = rsm;
	}
	
	public void set_errno(int err){
		this.errno = err;
	}
	public int geErrno(){
		return this.errno;
	}
	public void set_err(String err){
		this.err = err;
	}
	public String getErr(){
		return this.err;
	}
	public void set_rsm(Object err){
		this.rsm = err;
	}
	public Object getRsm(){
		return this.rsm;
	}
}

