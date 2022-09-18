public class pattern1 {
    public static void main(String args[]) {
        int k = 1, p = 1;
        System.out.println("⭐⭐⭐ Stating Program ⭐⭐⭐");
        int n = 6, m = 5;
        for(int i=1;i<=4;i++){
            for(int j=1;j<=5;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=5;j++){
                if(i == 1 || j == 5 || i == 4 || j == 1){
                System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=4;i>=1;i--){ 
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=5;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2 == 0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
                
            }
            System.out.println();
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=5;i++){
            for(int j=1;j<6-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<6;j++){
                System.out.print("*");
                
            }
            
            System.out.println();
            
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=n-i;j++ ){
                System.out.print(" ");

            }
            
            for(int j=1;j<=i;j++){
                //System.out.print(" ");
                System.out.print(i+" ");
            }
            System.out.println();
            
        }

        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        for(int i=1;i<=5;i++){
            for(int j=i;j<5;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=1;j<=i-1;j++){
                System.out.print(j+1);
            }
           // for(int j=i;j<5;j++){
             //   System.out.print(" ");
            //}

            System.out.println();
        }
        


    }

}
