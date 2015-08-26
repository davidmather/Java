public class QuickSort{
	public static void main(String args[]){
		int[] x={547,23,523,2378,243,7855,14,23,310};
		System.out.println("Unsorted List:");
		display(x);
		quickSort(x,0,x.length-1);
	}
	public static void quickSort(int x[], int lb, int ub){
		int j=0;
		if(lb>=ub)
			return;
		j = partition(x, lb, ub);
		System.out.println("After partitioning array from index"+(lb+1)+" to "+(ub+1)+":");
		display(x);
		quickSort(x,lb,j-1);
		quickSort(x,j+1,ub);
	}
	public static int partition(int x[], int lb, int ub){
		int a, down, temp, up;
		a=x[lb];
		up=ub;
		down=lb;
		while(down<up){
			while(x[down]<=a && down<up)
				down++;
			while(x[up]>a)
				up--;
			if(down<up){
				temp=x[down];
				x[down]=x[up];
				x[up]=temp;
			}
		}
		x[lb]=x[up];
		x[up]=a;
		return up;
	}
	public static void display(int x[]){
		for(int i=0; i<x.length; i++)
			System.out.print(x[i]+"");
			System.out.println("\n");
	}
}