/**
	ð������:
			�жϣ�������Ҫ���������������ݣ�length-1��
			�жϣ�������Ҫ���������������ݣ�length-1��
			�жϣ�������Ҫ���������������ݣ�length-1��
			...
			length-1
*/
public class ArraySort
{
	public static void main(String[] args){
		int[] array={4,5,4,3,9,8,7,5,4,2,6,9,8,77,55,11,22,88,33};//1,2,3,4,5,6,7,8,9
		int a=1,b=2;
		//��С��������-��Ȼ˳��
		for(int k=0;k<array.length-1;k++){//�����ִ��array.length��
			for(int i=0;i<array.length-1;i++){
				if(array[i]>array[i+1]){//����
					array[i]=array[i]+array[i+1];
					array[i+1]=array[i]-array[i+1];
					array[i]=array[i]-array[i+1];
				}
			}
		}
		//���
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();



		//�Ӵ�С--����
		for(int k=0;k<array.length-1;k++){//�����ִ��array.length��
			for(int i=0;i<array.length-1;i++){
				if(array[i]<array[i+1]){//����	1 2
					array[i]=array[i]+array[i+1];
					array[i+1]=array[i]-array[i+1];
					array[i]=array[i]-array[i+1];
				}
			}
		}

		//���
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
}