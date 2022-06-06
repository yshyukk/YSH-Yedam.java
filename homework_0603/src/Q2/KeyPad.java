package Q2;

public interface KeyPad {
//필드
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;

	public abstract void leftUpButton();

	public abstract void leftDownButton();

	public abstract void rightUpButton();

	public abstract void rightDownButton();

	public abstract void changeMode();

}
