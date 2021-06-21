package control;

public class gestionmvt {
	private boolean top, bouttom, left, rigth, middle, conr1, conr2, conr3;

	public gestionmvt(boolean top, boolean bouttom, boolean left, boolean rigth, boolean middle, boolean conr1,
			boolean conr2, boolean conr3) {

		this.top = top;
		this.bouttom = bouttom;
		this.left = left;
		this.rigth = rigth;
		this.middle = middle;
		this.conr1 = conr1;
		this.conr2 = conr2;
		this.conr3 = conr3;
	}


	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isBouttom() {
		return bouttom;
	}

	public void setBouttom(boolean bouttom) {
		this.bouttom = bouttom;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRigth() {
		return rigth;
	}

	public void setRigth(boolean rigth) {
		this.rigth = rigth;
	}

	public boolean isMiddle() {
		return middle;
	}

	public void setMiddle(boolean middle) {
		this.middle = middle;
	}

	public boolean isConr1() {
		return conr1;
	}

	public void setConr1(boolean conr1) {
		this.conr1 = conr1;
	}

	public boolean isConr2() {
		return conr2;
	}

	public void setConr2(boolean conr2) {
		this.conr2 = conr2;
	}

	public boolean isConr3() {
		return conr3;
	}

	public void setConr3(boolean conr3) {
		this.conr3 = conr3;
	}
}
