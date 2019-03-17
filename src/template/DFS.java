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
	//满足条件的个数
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
	 * 判断条件
	 * @return
	 */
	public boolean checkIsCorrect() 
	{
		return true;
	}
	
	/**
	 * 使用此程序注意事项:要修改三个地方
	 * (1)len的值，要获取的个数
	 * (2)rang范围数组的值
	 * (3)判断条件方法checkIsCorrect()
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int len = 5; //要取的个数，比如9个数取5个数，则len=5;
		int[] rang = {1,2,3,4,5,6,7,8,9}; //数字的范围，比如从1-9，则数组为{1,2,3,4,5,6,7,8,9}		
		DFS main = new DFS(len, rang);
		main.dfs(0);
		System.out.println(sum);
	}
}
