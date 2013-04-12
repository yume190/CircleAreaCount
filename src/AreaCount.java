
public class AreaCount {
	//總格子量 = len * wid
	private int scope[][];
	//左右格子數
	private int len;
	//上下格子數
	private int wid;
	//格子長和寬的單位
	private double scale;
	
	//the bound of the circle (up down left right)
	//圓的邊界 (上下左右)
	private int upBound;
	private int downBound;
	private int leftBound;
	private int rightBound;
	
	AreaCount(int length,int width,double scale){
		this.scale = scale;
		len = (int)(length/this.scale);
		wid = (int)(width/this.scale);
		this.scope = new int[len][wid];
	}
	/**
	 * 清空全部格子資料
	 */
	public void flush(){
		this.scope = new int[len][wid];
	}
	
	public void addCircle(double xx,double yy,double rad){
		double centerX = xx / scale;
		double centerY = yy / scale;
		double radius = rad / scale;
		
		setBound(centerX,centerY,radius);
		
		
		
		
		
	}
	
	private void setBound(double centerX,double centerY,double radius){
		setUpBound(centerX,centerY,radius);
		setDownBound(centerX,centerY,radius);
		setLeftBound(centerX,centerY,radius);
		setRightBound(centerX,centerY,radius);
	}
	
	private void setUpBound(double centerX,double centerY,double radius){
		if ((int)(Math.floor(centerY + radius)) > wid)
			upBound = wid - 1;
		else
			upBound = (int)(Math.floor(centerY));
	}

	private void setDownBound(double centerX,double centerY,double radius){
		if ((int)(Math.floor(centerY - radius)) < 0)
			downBound = 0;
		else
			downBound= (int)(Math.floor(centerY));
	}
	
	private void setLeftBound(double centerX,double centerY,double radius){
		if ((int)(Math.floor(centerX - radius)) < 0)
			leftBound = 0;
		else
			leftBound= (int)(Math.floor(centerX));
	}
	
	private void setRightBound(double centerX,double centerY,double radius){
		if ((int)(Math.floor(centerX + radius)) > len)
			rightBound = len - 1;
		else
			rightBound = (int)(Math.floor(centerX));
	}
	
	public Point getLU(double xx, double yy){
		return new Point(xx*scale,yy*(scale+1));
	}
	
	public Point getLD(double xx, double yy){
		return new Point(xx*scale,yy*scale);
	}
	
	public Point getRU(double xx, double yy){
		return new Point(xx*(scale+1),yy*(scale+1));
	}
	
	public Point getRD(double xx, double yy){
		return new Point(xx*(scale+1),yy*scale);
	}
	
	
	
	private class Point{
		
		private double x;
		private double y;
		
		Point(double xx, double yy){
			x = xx;
			y = yy;
		}
		
		public double getX(){
			return x;
		}
		
		public double getY(){
			return y;
		}
		
	}
}
