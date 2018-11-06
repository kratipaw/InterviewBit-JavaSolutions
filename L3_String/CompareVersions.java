package L3_String;

public class CompareVersions {

	public static void main(String[] args) {

		String A = "0.8";
		String B = "0";
		
		System.out.println(compareVersion(A, B));
	}
	
	private static int compareVersion(String A, String B) {
    
		String arrA[] = A.split("\\.");
		
		String arrB[] = B.split("\\.");
		int i = 0;
		while(i<arrA.length || i<arrB.length){
            if(i<arrA.length && i<arrB.length){
                if(Double.parseDouble(arrA[i]) < Double.parseDouble(arrB[i])){
                    return -1;
                }else if(Double.parseDouble(arrA[i]) > Double.parseDouble(arrB[i])){
                    return 1;
                }
            } else if(i<arrA.length){
                if(Double.parseDouble(arrA[i]) != 0){
                    return 1;
                }
            } else if(i<arrB.length){
                if(Double.parseDouble(arrB[i]) != 0){
                    return -1;
                }
            }
            
            i++;
        }
		return 0;
	
	}

}
