package com.yedam.java.ch0802;

public class Driver { // Vehicle의 사용관계 !! 서로 관계 없음.
	void drive(Vehicle vehicle) { // <---탈것 호출
		if(vehicle instanceof Bus) { //instanceof로 객체 확인!! 안하면 콘솔창에서 오류.
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}
		
		vehicle.run(); // 운전방법 호출 <-- 운전방법을 run밖에 모름.

	}
}
