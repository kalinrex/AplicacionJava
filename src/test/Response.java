package test;

public enum Response {
	PORDEBAJO(-1), PESOIDEAL(0), SOBREPESO(1);
	private Response(int value) {
		this.value = value;
	}
	
	public int getResponse() {
		return value;
	}
	private int value;
}
