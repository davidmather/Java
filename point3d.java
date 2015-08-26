import java.awt.*;
public class point3d extends Point {
	public int z;
	public point3d(int x,int y,int z){
		super(x,y);
		this.z=z;
	}
	public void move(int x, int y, int z){
		this.z=z;
		super.move(x, y);
	}
	public void translate(int x, int y, int z){
		this.z+=z;
		super.translate(x, y);
	}
}
