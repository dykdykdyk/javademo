package test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr =new int[]{8,2,1,0,3};
        int[] index =new int[]{2,0,3,2,4,0,1,3,2,3,3};
        String tel ="";
        for(int i :index){
        	tel+=arr[i];
        }
        int b =4 ,a, c;
        for(int i=0;i<10;i++){ 
        	b=22 | 1;//  ��   ���� ת���ɶ����ƣ�ֻҪ��һ��Ϊ1  ��Ϊ1   
        }            // 0001 0110 
        			 // 0000 0001           // 0001 0111
         a=22 & 1;   // ��   ����   ֻ��������Ϊ1   ��Ϊ1 
         c=22^1;     //  ������� ��ͬ���Ϊ0����ͬ���Ϊ1
         c =~23;      // ��   0Ϊ1  1Ϊ0   00010111  11101000 ��λΪ1 Խ���˳ɸ���      00010111 +1 
         			//����������ݵĴ洢��ʽ�������Ĳ�����ʽ���ڵ�   �����Ĳ����� ȡ�� �ټ�1 
        System.out.println("��ϵ��ʽ: "+ b);                
	}

}
