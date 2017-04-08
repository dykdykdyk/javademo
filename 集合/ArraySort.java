/**
	冒泡排序:
			判断，根据需要交换相邻两个数据，length-1次
			判断，根据需要交换相邻两个数据，length-1次
			判断，根据需要交换相邻两个数据，length-1次
			...
			length-1
*/
public class ArraySort
{
	public static void main(String[] args){
		int[] array={4,5,4,3,9,8,7,5,4,2,6,9,8,77,55,11,22,88,33};//1,2,3,4,5,6,7,8,9
		int a=1,b=2;
		//从小到大排序-自然顺序
		for(int k=0;k<array.length-1;k++){//代码块执行array.length次
			for(int i=0;i<array.length-1;i++){
				if(array[i]>array[i+1]){//交换
					array[i]=array[i]+array[i+1];
					array[i+1]=array[i]-array[i+1];
					array[i]=array[i]-array[i+1];
				}
			}
		}
		//输出
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();



		//从大到小--倒序
		for(int k=0;k<array.length-1;k++){//代码块执行array.length次
			for(int i=0;i<array.length-1;i++){
				if(array[i]<array[i+1]){//交换	1 2
					array[i]=array[i]+array[i+1];
					array[i+1]=array[i]-array[i+1];
					array[i]=array[i]-array[i+1];
				}
			}
		}

		//输出
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
}