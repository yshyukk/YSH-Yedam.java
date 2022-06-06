package com.yedam.java.ch0902;

public class Product {
	// 필드
	RemoteControl field = new RemoteControl() {
		// 필드
		String message = "스마트TV";

		// 메서드
		void print() {
			System.out.println("제품 종류 : " + message);
		}

		@Override
		public void turnOn() {
			print();
			System.out.println("전원을 켭니다.");

		}

		@Override
		public void turnOff() {
			print();
			System.out.println("전원을 끕니다.");

		}

	};

	// 생성자

	// 메서드
	RemoteControl method1() {
		int volume = 0;	// <--- final의 성격을 가짐.

		RemoteControl var = new RemoteControl() {
			// 필드
			String message = "Audio";

			// 메서드
			void print() {
				System.out.println("제품 종류 : " + message);
			}

			@Override
			public void turnOn() {
				print();
				System.out.println("전원을 켭니다.");
				System.out.println("현재 볼륨 : " + volume);
			}

			@Override
			public void turnOff() {
				print();
				System.out.println("전원을 끕니다.");

			}

		};

		var.turnOn();
		var.turnOff();
		return var;
	}

	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}

}
