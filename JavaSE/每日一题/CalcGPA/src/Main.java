import java.util.Scanner;

public class Main{

    // 学分绩点

    // 北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
    // 公式如下： 实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0
    // 75——77 2.7 72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0
    // 1．一门课程的学分绩点=该课绩点*该课学分 2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）。

    public static double calcGPA(int n,int[] credit,int[] socre){
        double gpa = 0.0;
        double gpaSum = 0.0;
        for(int i = 0;i < n;i++){
            if(socre[i] < 60){
                gpa = 0.0;
            }else if(60 <= socre[i] && socre[i] <= 71 ){
                if(60 <= socre[i] && socre[i] <= 63){
                    gpa = 1.0;
                }else if(64 <= socre[i] && socre[i] <= 67){
                    gpa = 1.5;
                }else{
                    gpa = 2.0;
                }
            }else if(72 <= socre[i] && socre[i] <= 81){
                if(72 <= socre[i] && socre[i] <= 74){
                    gpa = 2.3;
                }else if(75 <= socre[i] && socre[i] <= 77){
                    gpa = 2.7;
                }else{
                    gpa = 3.0;
                }
            }else{
                if(82 <= socre[i] && socre[i] <= 84){
                    gpa = 3.3;
                }else if(85 <= socre[i] && socre[i] <= 89){
                    gpa = 3.7;
                }else{
                    gpa = 4.0;
                }
            }
            gpaSum += (gpa * credit[i]);
        }
        int sum = 0;
        for(int i = 0; i < n;i++){
            sum += credit[i];
        }
        return gpaSum/sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf (sc.nextLine());
        int[] credit = new int[n]; //学分
        int[] socre = new int[n]; //成绩
        for(int i = 0; i < n;i++){
            credit[i] = sc.nextInt ();
        }
        for(int i = 0; i < n;i++){
            socre[i] = sc.nextInt ();
        }
        double res = calcGPA(n,credit,socre);
        System.out.printf("%.2f",res);
    }
}