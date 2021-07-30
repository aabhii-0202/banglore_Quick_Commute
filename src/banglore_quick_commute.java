import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class banglore_quick_commute {

    public int source;
    static int[] intermediatearr;
    public static String[] names={"No where",
            "RNSIT","Kengeri","JP Nagar","Bansankari","BTM Lake","Bannerghatta Main rd","Electronic City",
            "Gopalan Arcade Mall","Majestic","Yeswantpur", "Rajaji Nagar","MG Road","Airport","Orion Mall",
            "Cubbon Park","Koramangla","Indira Nagar","Marathalli","K.R Market","White Field"
    };
    public static float[][] costMatrix= new float[names.length][names.length];

    public void printmenu(){
        for (int i=1;i<20;i++) {
            System.out.println((i)+". "+names[i]);
        }
    }

    public void getinput(){
        System.out.println("Welcome to Banglore Quick Commute:\nThese are the places from which you can choose your source:");
        printmenu();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the source :");
        source=sc.nextInt();
        System.out.println("Do you want any intermediate stop? y or n");
        String s= sc.next();
        if(s.equals("y")){
            System.out.println("Enter the number of intermediate stops you can repeat the places if you want to visit them again");
            int n= sc.nextInt();
            if(n>0) {
                intermediatearr = new int[n+1];
                for (int h = 0; h < n; h++) {
                    System.out.println("Enter "+(h+1)+"th intermediate point ");
                    intermediatearr[h] = sc.nextInt();
                }
            }else intermediatearr =new int[1];
        }else{
            intermediatearr =new int[1];
        }
        System.out.println("Enter the destination :");
        intermediatearr[intermediatearr.length-1] = sc.nextInt();


    }

    public void preparefile() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\abhis\\Desktop\\Abhi\\Prog\\Java Project\\banglore_Quick_Commute\\costMatrix.txt");
        int i;
        StringBuilder s1= new StringBuilder();
        while ((i=fr.read()) != -1)
            s1.append((char) i);

        StringTokenizer st = new StringTokenizer(s1.toString()," ");

        for(i=0;i<=20;i++){
            for (int j = 0; j <= 20; j++) {
             costMatrix[i][j]=Float.parseFloat(st.nextToken());
            }
        }
//        printMatrix();

    }

    public void printMatrix(){
        for(int i=0;i<20;i++){
            for (int j = 0; j < 20; j++) {
                System.out.print(costMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        banglore_quick_commute bc= new banglore_quick_commute();
        bc.preparefile();
        bc.getinput();
        findShortestDistance obj = new findShortestDistance();
        for (int dest : intermediatearr) {
            obj.find(bc.source, dest);
            System.out.println(names[bc.source]+" --> "+names[dest]+" distance = "+costMatrix[bc.source][dest]);

            bc.source=dest;
        }
    }

}
