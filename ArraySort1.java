/**
	1、找到最大的，放到最后
	2、找到剩下的最大的，放到剩下的最后
	3、找到剩下的最大的，放到剩下的最后
	4、找到剩下的最大的，放到剩下的最后
	...
	n、找到剩下两个最大的放在剩下的最后
*/
public class ArraySort1
{
	public static void main(String[] args){
		int[] array={9,8,7,6,5,4,3,2,1};//8,7,6,5,4,3,2,1,9
		int tempMax=-1;
		int index=0;
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		
	}
}