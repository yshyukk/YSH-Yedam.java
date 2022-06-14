package com.yedam.java.map;

public class Student {

	public int sno;
	public String name;

	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

//hashCode가 같다 = 물리적으로 존재하는 위치가 같다.(저장된 위치 확인)
//equals = 내부에 필드가 같은지 (내용까지 확인)
	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}

@Override
public boolean equals(Object obj) {
	if(obj instanceof Student) {
		Student s = (Student) obj;
		return(sno == s.sno) && (name.equals(s.name));
	}
	return false;
}

	
}
