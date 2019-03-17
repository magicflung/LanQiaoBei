package template;
public class DFS 
{
	private int[] arr;
	private int[] book;
	public int[] rang;
	private int end;
	
	public DFS(int len, int[] rang) 
	{
		this.arr = new int[len];
		this.book = new int[rang.length];
		this.rang = rang;
		this.end = len;
	}
	//���������ĸ���
	public static int sum = 0;
	
	public void dfs(int step)
	{
		if(step == this.end)
		{
			if(checkIsCorrect())
			{
				sum++;
			}
			return;
		}
		
		for (int i = 0; i < rang.length; i++) 
		{
			if(this.book[i] == 0)
			{
				this.arr[step] = this.rang[i];
				this.book[i] = 1;
				dfs(step + 1);
				this.book[i] = 0;
			}
		}
		return;
		
	}
	/**
	 * �ж�����
	 * @return
	 */
	public boolean checkIsCorrect() 
	{
		return true;
	}
	
	/**
	 * ʹ�ô˳���ע������:Ҫ�޸������ط�
	 * (1)len��ֵ��Ҫ��ȡ�ĸ���
	 * (2)rang��Χ�����ֵ
	 * (3)�ж���������checkIsCorrect()
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int len = 5; //Ҫȡ�ĸ���������9����ȡ5��������len=5;
		int[] rang = {1,2,3,4,5,6,7,8,9}; //���ֵķ�Χ�������1-9��������Ϊ{1,2,3,4,5,6,7,8,9}		
		DFS main = new DFS(len, rang);
		main.dfs(0);
		System.out.println(sum);
	}
}
