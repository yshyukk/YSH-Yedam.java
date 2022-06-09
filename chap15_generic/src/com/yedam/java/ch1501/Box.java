package com.yedam.java.ch1501;
// Generic 
// Generic은 타입, class명 옆에 <대문자>

public class Box<T,V,K> {
	
	T t;
	V v;
	K k;
	int num;
	public void setT(T t) {
		this.t = t;
	}
	public T getT() { 
		return t;
	}
	public void setV(V v) {
		this.v = v;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getv() { 
		return v;
	}
	public K getk() { 
		return k;
	}
	
}
