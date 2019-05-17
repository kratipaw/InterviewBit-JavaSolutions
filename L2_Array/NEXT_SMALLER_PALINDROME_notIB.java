public class NEXT_SMALLER_PALINDROME_notIB {

	public static void main(String[] args) {

		int arr[] = {1, 7, 3, 5};
		
		System.out.println("Original number : ");
		
		printAarray(arr);
		
		System.out.println("Next smaller Palindrome just greater than given number is ");

		nextPalindrome(arr);
		
	}
	
	private static void printAarray(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	
		System.out.println();
	}

	private static void nextPalindrome(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return;
		
		if(isAllNine(arr))
		{
			int out[] = new int[n+1];
			out[0] = 1;
			for (int i = 1; i < out.length-1; i++) {
				out[i] = 0;
			}
			out[out.length-1] = 1;
			
			printAarray(out);
		}
		
		else 
		{
			nextPalindromeUtil(arr);
			printAarray(arr);
		}
		
	}
	
	private static boolean isAllNine(int arr[]) {
		
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			if(arr[i] != 9)
				return false;
		}
		
		return true;
	}
	
	private static void nextPalindromeUtil(int arr[]) {
		
		int n = arr.length;

		int mid = n / 2;
		
		int i = mid-1;
		
		int j = 0;
		
		if(n % 2 == 0)
			j = mid;
		else
			j = mid + 1;
		
		while(i >= 0 && j < n && arr[i] == arr[j]) {
			i--;
			j++;
		}
		
		boolean flag = false;
		
		//if boundary crossed OR if left side digit is smaller than corresponding right side then
		//in that case increment the mid element and carry towards left and copy left side
		//to right side or else 
		if(i < 0 || j >= n || arr[i] < arr[j])
			flag = true;
		
		if(!flag) {
			copyLeftToRight(arr, i, j);
			return;
		}
			
		int carry = 1 ;
		
		i = mid - 1;
		
		j = (n % 2 == 0) ? mid : mid + 1;
		
		//If odd number of digits
		if(n % 2 != 0) {
			
			arr[mid] = arr[mid] + 1;
			carry = arr[mid] / 10;
			arr[mid] = arr[mid] % 10;
			
		}
		
		while (i >= 0)  
        { 
            arr[i] = arr[i] + carry; 
            carry = arr[i] / 10; 
            arr[i] %= 10; 
            arr[j] = arr[i];// copy mirror to right 
            i--; 
            j++; 
        }
		
	}
	
	private static void copyLeftToRight(int arr[], int i, int j) {
		
		int n = arr.length;
		
		while(i >= 0 && j < n) {
			
			arr[j] = arr[i];
			
			i--;
			j++;
		}
		
		
	}
}
