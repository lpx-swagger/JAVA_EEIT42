package Generator;
import java.util.Scanner;

public class ReverseKeyInNum {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String s1 = sc.nextLine();
    //     String[] sa1 = new String[10];
    //     int arrlen = s1.length();


    //     if (arrlen < 100) {
    //         for(int i = sa1.length - 1; i >= 0; i--) {
    //             System.out.println(sa1[i]);
    //         }
    //     } else {
    //         System.out.println("Overflow");
    //     }

    // }

    
//     public static void main(String[] args) {
        
//         Scanner sc = new Scanner(System.in);
// //      int[] aaa = {10, 32, 64};
//         int n = sc.nextInt();
//         int[] aaa = new int[n];


//         for (int i = aaa.length - 1; i >= 0; i--) {
//             System.out.println(aaa[i]);
//         }
//     }


// Kevin Chan
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		int inputNum = 0;
		int count = 0;

		for(int i = 0; ;i++) {
			inputNum = sc.nextInt();
			arr[i] = inputNum;

			if(i==arr.length-1) {
				arr = doubleArr(arr);
			}

			if(inputNum==-1) {
				break;
			}
			count++;
		}

		for(int i = count-1; i >= 0; i--) {
			System.out.println(arr[i]);
		}    
	}



	public static int[] doubleArr(int[] arr) {
		int[] newArr = new int[arr.length*2];
		for(int i = 0; i < arr.length ;i++) {
			newArr[i] = arr[i];
		}
		return newArr;

	}
	
	
//Joyce chang Linkedlist
	
	

}

