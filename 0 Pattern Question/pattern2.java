public class pattern2 {
    public static void main(String args[]) {
        int n = 4;
        System.out.println("*********Butterfly pattern************");
        
        for(int i=1;i<=n;i++){
           
           for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            int spaces = 2*(n-i);
            for(int j=1; j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
          //  for(int j=5;j>i;j--){
              //  System.out.print("*");
            //}
            //for(int j=0;j<1;j++)
           // {
             //   System.out.print(" ");
           // }
            System.out.println();
        
        }

        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
            System.out.print("*");
            }
            int spaces = 2 * (n-i);
            for(int j=1; j<=spaces; j++) {
            System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
            System.out.print("*");
            }
            System.out.println();

        
        }

        System.out.println("************** Diamond pattern*****************");
        //upperpart
        for(int i=1;i<=4;i++){
            //spaces
            for(int j=1;j<=4-i;j++)
            {
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=2*i-1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        //lowerpart
        for(int i=4;i>=1;i--){
            for(int j=1;j<=4-i;j++){
                //spaces
                System.out.print(" ");
            }
            //star
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
           
            System.out.println();
        }
            
    
         
        System.out.println("************** Print half Pyramid *****************");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5-i;j++)
            {
                //spaces
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                //print numbers
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println("************** Print Inverted half Pyramid *****************");
        for(int i=1;i<=5;i++){
            for(int j=1;j<i;j++)
            {
                //spaces
                System.out.print(" ");
            }
            for(int j=0;j<=5-i;j++){
                //print numbers
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println("************** Print Hollow Rhombus *****************");
        for(int j=1;j<=4;j++)
            {
                //intial space
                System.out.print(" ");
            }
        for(int i=1;i<=5;i++){
            //first part
            System.out.print("*");
        }
        
        System.out.println();
        //second part
        for(int i=1;i<=3;i++){
            for(int j=1;j<=4-i;j++)
            {
                //intial space
                System.out.print(" ");
            }
            //star
            for(int j=1;j<=1;j++){
                System.out.print("*");
            }
            for(int j=1;j<=3;j++){
                //spaces
                System.out.print(" ");
            }
            for(int j=1;j<=1;j++){
                //again star
                System.out.print("*");
            }
            System.out.println();

        }
        for(int i=1;i<=5;i++){
            //first part
            System.out.print("*");
        }



    }   
    
}
