
/**
 * Write a description of class MyTester here.
 *
 * @author (Arye Holtzberg)
 * @version (7/5/2020)
 */
import java.io.*;

public class Tester_for_maman13_Aryeh_Holtzberg
{
    public static void main (String[]args){

        System.out.println("\t\t\t******************************************************************\n");
        System.out.println("\t\t\t\t\t     Tester for Maman 13\n");
        System.out.println("\t\t\t\t\t     By- Arye Holtzberg\n");
        System.out.println("\t\t\t******************************************************************\n\n\n");

        System.out.println("\t--------------check a regular situation:------------------");

        String[] arr= {"Paris","rome","Tel-Aviv","London","Berlin","Monaco"};

        Train[] trains=new Train[100];
        for(int i=0;i<100;i++){

            String city=arr[(i*17)%6];
            trains[i]=new Train(city, (i*13)%24, (i*13)%60, i*10, i*2, 100, i);
        }

        RailwayStation rs1=new RailwayStation() ;
        for(int i=0;i<100;i++){
            rs1.addTrain(trains[i]);
        }
        
        //String check3=rs1.toString3();
        //System.out.println(check3);
        
        String check1=rs1.toString();
        boolean result=(check1.equals(CHECK1)||check1.equals(CHECK2));
        System.out.println("\nThe result for regular situation was :\t"+((result)?"Ok": "Not Ok"));
        if (result==false){
            String[] arr1 =check1.split("\n",0);
            String[] arr2 =CHECK1.split("\n",0);
            String[] arr3 =CHECK2.split("\n",0);
            for (int i=0;i<arr1.length;i++){
                if(!((arr1[i].equals(arr2[i]))||(arr1[i].equals(arr3[i])))){
                    System.out.println("\nERROR!\tline-"+i);
                    System.out.println("The result was supposed to be:\t"+arr2[i]);
                    System.out.println("Your result was:              \t"+arr1[i]);
                }
            }
        }

        System.out.println("\n\n\t--------------check the addTrain method:------------------");
        System.out.println("\n-----Check a addTrain out of the range situation:");
        Train tr1=new Train("Oklahoma", 12, 30, 16, 7, 100, 5);
        result =(rs1.addTrain(tr1));
        System.out.println("\nThe result for out of the range situation was :\t"+((!result)?"Ok": "Not Ok"));
        if (result){
            System.out.println("The object was supposed to be full,\nCheck your array maximum.");
        }

        System.out.println("\n-----Check a addTrain same Train situation:");
        int flag=0;
        for(int i=0;i<100;i++){
            result=rs1.addTrain(trains[i]);
            if (result){
                flag=1;
            }  
        }
        result=(flag==0)?true:false;
        System.out.println("\nThe result for addTrain same Train situation was :\t"+((result)?"Ok": "Not Ok"));
        if(!result)
            System.out.println("The train is already in,\nCheck your checking for equals situation.");
        System.out.println("\n-----Check a addTrain null Train situation:");
        Train tr2=null;
        result=rs1.addTrain(tr2);
        System.out.println("\nThe result for addTrain same Train situation was :\t"+((!result)?"Ok": "Not Ok"));
        if (result)
        System.out.println("\nnull object should return false...");
        

        System.out.println("\n\n\t--------------check the removeTrain method:------------------");
        System.out.println("\n-----Check a removeTrain regular situation:");

        flag=0;
        for(int i=0;i<100;i++){
            result=rs1.removeTrain(trains[i]);
            if (!result){
                flag=1;
            }  
        }
        result=(flag==0)?true:false;
        System.out.println("\nThe result for removeTrain regular situation was :\t"+((result)?"Ok": "Not Ok"));

        System.out.println("\n-----Check a removeTrain -train not faund situation:");
        for(int i=0;i<100;i++){
            rs1.addTrain(trains[i]);
        }
        result=rs1.removeTrain(tr1);
        System.out.println("\nThe result for removeTrain -train not faund situation was :\t"+((!result)?"Ok": "Not Ok"));

        System.out.println("\n-----Check a removeTrain -empty station situation:");
        RailwayStation rs2=new RailwayStation() ;
        result=rs2.removeTrain(tr1);
        System.out.println("\nThe result for removeTrain -empty situation was :\t"+((!result)?"Ok": "Not Ok"));
        
        System.out.println("\n-----Check a remove null Train situation:");
        result=rs1.removeTrain(tr2);
        System.out.println("\nThe result for remove null Train situation was :\t"+((!result)?"Ok": "Not Ok"));
        if (result)
        System.out.println("\nnull object should return false...");
        
        
        
        System.out.println("\n\n\t--------------check the firstDepartureToDestination method:------------------");
        System.out.println("\n-----Check a firstDepartureToDestination regular situation:");
        
        Time1 t1=rs1.firstDepartureToDestination("London");
        Time1 t11=new Time1(3,15);
        Time1 t2=rs1.firstDepartureToDestination("Paris");
        Time1 t22=new Time1(0,0);
        Time1 t3=rs1.firstDepartureToDestination("ramat gan");
       
        Time1 t4=rs1.firstDepartureToDestination(null);
        Time1 t44=null;
        
        result=(t1.equals(t11)&&t2.equals(t22));
        System.out.println("\nThe result for firstDepartureToDestination regular situation was :\t"+((result)?"Ok": "Not Ok"));
        
        System.out.println("\n-----Check a firstDepartureToDestination -destination not faund situation:");
        result=(t3==null);
        System.out.println("\nThe result for firstDepartureToDestination -destination not faund situation was :\t"+((result)?"Ok": "Not Ok"));
        
        System.out.println("\n-----Check a firstDepartureToDestination -null destination situation:");
        result=(t4==null);
        System.out.println("\nThe result for firstDepartureToDestination -null destination  situation was :\t"+((result)?"Ok": "Not Ok"));
        
        System.out.println("\n\n\t--------------check the howManyFullTrains method:------------------");
        int num=rs1.howManyFullTrains();
        int num2=rs2.howManyFullTrains();
        System.out.println("\n-----Check a howManyFullTrains regular situation:");
        System.out.println("\nThe result for firstDepartureToDestination regular situation was :\t"+((num==50)?"Ok": "Not Ok"));
        System.out.println("\n-----Check a howManyFullTrains -empty station situation:");
        System.out.println("\nThe result for firstDepartureToDestination empty situation was :\t"+((num2==0)?"Ok": "Not Ok"));
        
        System.out.println("\n\n\t--------------check the mostPopularDestination method:------------------");
        System.out.println("\n-----Check a mostPopularDestination regular situation:");
        
        String pop=rs1.mostPopularDestination();
        System.out.println("\nThe result for firstDepartureToDestination regular situation was :\t"+((pop.equals("Paris"))?"Ok": "Not Ok"));
        System.out.println("\n-----Check a howManyFullTrains -empty station situation:");
        pop=rs2.mostPopularDestination();
        System.out.println("\nThe result for firstDepartureToDestination empty situation was :\t"+((pop==null)?"Ok": "Not Ok"));
        
        
        System.out.println("\n\n\t--------------check the mostExpensiveTicket method:------------------");
        System.out.println("\n-----Check a mostExpensiveTicket regular situation:");
        
        Train exp1=rs1.mostExpensiveTicket();
        Train exp11=new Train(trains[99]);
        Train exp2=rs2.mostExpensiveTicket();
        System.out.println("\nThe result for mostExpensiveTicket regular situation was :\t"+((exp1.equals(exp11))?"Ok": "Not Ok"));
        System.out.println("\n-----Check a mostExpensiveTicket empty situation:");
        System.out.println("\nThe result for mostExpensiveTicket empty situation was :\t"+((exp2==null)?"Ok": "Not Ok"));
       
        
        
        
        System.out.println("\n\n\t--------------check the longestTrain method:------------------");
        System.out.println("\n-----Check a longestTrain regular situation:");
        exp1=rs1.longestTrain();
        
        System.out.println("\nThe result for longestTrain regular situation was :\t"+((exp1.equals(exp11))?"Ok": "Not Ok"));
        exp2=rs2.longestTrain();
        System.out.println("\n-----Check a longestTrain empty situation:");
        System.out.println("\nThe result for longestTrain empty situation was :\t"+((exp2==null)?"Ok": "Not Ok"));
        
        
        
        
        
        
        
        
    }

    private static final  String CHECK1="The trains today are:"+"\n"
        +"Train to Paris departs at 00:00. Train is not full."+"\n"
        +"Train to Monaco departs at 13:13. Train is not full."+"\n"
        +"Train to Berlin departs at 02:26. Train is not full."+"\n"
        +"Train to London departs at 15:39. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 04:52. Train is not full."+"\n"
        +"Train to rome departs at 17:05. Train is not full."+"\n"
        +"Train to Paris departs at 06:18. Train is not full."+"\n"
        +"Train to Monaco departs at 19:31. Train is not full."+"\n"
        +"Train to Berlin departs at 08:44. Train is not full."+"\n"
        +"Train to London departs at 21:57. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 10:10. Train is not full."+"\n"
        +"Train to rome departs at 23:23. Train is not full."+"\n"
        +"Train to Paris departs at 12:36. Train is not full."+"\n"
        +"Train to Monaco departs at 01:49. Train is not full."+"\n"
        +"Train to Berlin departs at 14:02. Train is not full."+"\n"
        +"Train to London departs at 03:15. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 16:28. Train is not full."+"\n"
        +"Train to rome departs at 05:41. Train is not full."+"\n"
        +"Train to Paris departs at 18:54. Train is not full."+"\n"
        +"Train to Monaco departs at 07:07. Train is not full."+"\n"
        +"Train to Berlin departs at 20:20. Train is not full."+"\n"
        +"Train to London departs at 09:33. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 22:46. Train is not full."+"\n"
        +"Train to rome departs at 11:59. Train is not full."+"\n"
        +"Train to Paris departs at 00:12. Train is not full."+"\n"
        +"Train to Monaco departs at 13:25. Train is not full."+"\n"
        +"Train to Berlin departs at 02:38. Train is not full."+"\n"
        +"Train to London departs at 15:51. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 04:04. Train is not full."+"\n"
        +"Train to rome departs at 17:17. Train is not full."+"\n"
        +"Train to Paris departs at 06:30. Train is not full."+"\n"
        +"Train to Monaco departs at 19:43. Train is not full."+"\n"
        +"Train to Berlin departs at 08:56. Train is not full."+"\n"
        +"Train to London departs at 21:09. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 10:22. Train is not full."+"\n"
        +"Train to rome departs at 23:35. Train is not full."+"\n"
        +"Train to Paris departs at 12:48. Train is not full."+"\n"
        +"Train to Monaco departs at 01:01. Train is not full."+"\n"
        +"Train to Berlin departs at 14:14. Train is not full."+"\n"
        +"Train to London departs at 03:27. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 16:40. Train is not full."+"\n"
        +"Train to rome departs at 05:53. Train is not full."+"\n"
        +"Train to Paris departs at 18:06. Train is not full."+"\n"
        +"Train to Monaco departs at 07:19. Train is not full."+"\n"
        +"Train to Berlin departs at 20:32. Train is not full."+"\n"
        +"Train to London departs at 09:45. Train is not full."+"\n"
        +"Train to Tel-Aviv departs at 22:58. Train is not full."+"\n"
        +"Train to rome departs at 11:11. Train is not full."+"\n"
        +"Train to Paris departs at 00:24. Train is not full."+"\n"
        +"Train to Monaco departs at 13:37. Train is not full."+"\n"
        +"Train to Berlin departs at 02:50. Train is full."+"\n"
        +"Train to London departs at 15:03. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 04:16. Train is full."+"\n"
        +"Train to rome departs at 17:29. Train is full."+"\n"
        +"Train to Paris departs at 06:42. Train is full."+"\n"
        +"Train to Monaco departs at 19:55. Train is full."+"\n"
        +"Train to Berlin departs at 08:08. Train is full."+"\n"
        +"Train to London departs at 21:21. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 10:34. Train is full."+"\n"
        +"Train to rome departs at 23:47. Train is full."+"\n"
        +"Train to Paris departs at 12:00. Train is full."+"\n"
        +"Train to Monaco departs at 01:13. Train is full."+"\n"
        +"Train to Berlin departs at 14:26. Train is full."+"\n"
        +"Train to London departs at 03:39. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 16:52. Train is full."+"\n"
        +"Train to rome departs at 05:05. Train is full."+"\n"
        +"Train to Paris departs at 18:18. Train is full."+"\n"
        +"Train to Monaco departs at 07:31. Train is full."+"\n"
        +"Train to Berlin departs at 20:44. Train is full."+"\n"
        +"Train to London departs at 09:57. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 22:10. Train is full."+"\n"
        +"Train to rome departs at 11:23. Train is full."+"\n"
        +"Train to Paris departs at 00:36. Train is full."+"\n"
        +"Train to Monaco departs at 13:49. Train is full."+"\n"
        +"Train to Berlin departs at 02:02. Train is full."+"\n"
        +"Train to London departs at 15:15. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 04:28. Train is full."+"\n"
        +"Train to rome departs at 17:41. Train is full."+"\n"
        +"Train to Paris departs at 06:54. Train is full."+"\n"
        +"Train to Monaco departs at 19:07. Train is full."+"\n"
        +"Train to Berlin departs at 08:20. Train is full."+"\n"
        +"Train to London departs at 21:33. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 10:46. Train is full."+"\n"
        +"Train to rome departs at 23:59. Train is full."+"\n"
        +"Train to Paris departs at 12:12. Train is full."+"\n"
        +"Train to Monaco departs at 01:25. Train is full."+"\n"
        +"Train to Berlin departs at 14:38. Train is full."+"\n"
        +"Train to London departs at 03:51. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 16:04. Train is full."+"\n"
        +"Train to rome departs at 05:17. Train is full."+"\n"
        +"Train to Paris departs at 18:30. Train is full."+"\n"
        +"Train to Monaco departs at 07:43. Train is full."+"\n"
        +"Train to Berlin departs at 20:56. Train is full."+"\n"
        +"Train to London departs at 09:09. Train is full."+"\n"
        +"Train to Tel-Aviv departs at 22:22. Train is full."+"\n"
        +"Train to rome departs at 11:35. Train is full."+"\n"
        +"Train to Paris departs at 00:48. Train is full."+"\n"
        +"Train to Monaco departs at 13:01. Train is full."+"\n"
        +"Train to Berlin departs at 02:14. Train is full."+"\n"
        +"Train to London departs at 15:27. Train is full."+"\n";
        
        public static final String CHECK2="The trains today are:"
+"\n"+"Train to Paris departs at 00:00. Train is not full."
+"\n"+"Train to Monaco departs at 13:13. Train is not full."
+"\n"+"Train to Berlin departs at 02:26. Train is not full."
+"\n"+"Train to London departs at 15:39. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 04:52. Train is not full."
+"\n"+"Train to rome departs at 17:05. Train is not full."
+"\n"+"Train to Paris departs at 06:18. Train is not full."
+"\n"+"Train to Monaco departs at 19:31. Train is not full."
+"\n"+"Train to Berlin departs at 08:44. Train is not full."
+"\n"+"Train to London departs at 21:57. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 10:10. Train is not full."
+"\n"+"Train to rome departs at 23:23. Train is not full."
+"\n"+"Train to Paris departs at 12:36. Train is not full."
+"\n"+"Train to Monaco departs at 01:49. Train is not full."
+"\n"+"Train to Berlin departs at 14:02. Train is not full."
+"\n"+"Train to London departs at 03:15. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 16:28. Train is not full."
+"\n"+"Train to rome departs at 05:41. Train is not full."
+"\n"+"Train to Paris departs at 18:54. Train is not full."
+"\n"+"Train to Monaco departs at 07:07. Train is not full."
+"\n"+"Train to Berlin departs at 20:20. Train is not full."
+"\n"+"Train to London departs at 09:33. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 22:46. Train is not full."
+"\n"+"Train to rome departs at 11:59. Train is not full."
+"\n"+"Train to Paris departs at 00:12. Train is not full."
+"\n"+"Train to Monaco departs at 13:25. Train is not full."
+"\n"+"Train to Berlin departs at 02:38. Train is not full."
+"\n"+"Train to London departs at 15:51. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 04:04. Train is not full."
+"\n"+"Train to rome departs at 17:17. Train is not full."
+"\n"+"Train to Paris departs at 06:30. Train is not full."
+"\n"+"Train to Monaco departs at 19:43. Train is not full."
+"\n"+"Train to Berlin departs at 08:56. Train is not full."
+"\n"+"Train to London departs at 21:09. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 10:22. Train is not full."
+"\n"+"Train to rome departs at 23:35. Train is not full."
+"\n"+"Train to Paris departs at 12:48. Train is not full."
+"\n"+"Train to Monaco departs at 01:01. Train is not full."
+"\n"+"Train to Berlin departs at 14:14. Train is not full."
+"\n"+"Train to London departs at 03:27. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 16:40. Train is not full."
+"\n"+"Train to rome departs at 05:53. Train is not full."
+"\n"+"Train to Paris departs at 18:06. Train is not full."
+"\n"+"Train to Monaco departs at 07:19. Train is not full."
+"\n"+"Train to Berlin departs at 20:32. Train is not full."
+"\n"+"Train to London departs at 09:45. Train is not full."
+"\n"+"Train to Tel-Aviv departs at 22:58. Train is not full."
+"\n"+"Train to rome departs at 11:11. Train is not full."
+"\n"+"Train to Paris departs at 00:24. Train is not full."
+"\n"+"Train to Monaco departs at 13:37. Train is not full."
+"\n"+"Train to Berlin departs at 02:50. Train is full."
+"\n"+"Train to London departs at 15:03. Train is full."
+"\n"+"Train to Tel-Aviv departs at 04:16. Train is full."
+"\n"+"Train to rome departs at 17:29. Train is full."
+"\n"+"Train to Paris departs at 06:42. Train is full."
+"\n"+"Train to Monaco departs at 19:55. Train is full."
+"\n"+"Train to Berlin departs at 08:08. Train is full."
+"\n"+"Train to London departs at 21:21. Train is full."
+"\n"+"Train to Tel-Aviv departs at 10:34. Train is full."
+"\n"+"Train to rome departs at 23:47. Train is full."
+"\n"+"Train to Paris departs at 12:00. Train is full."
+"\n"+"Train to Monaco departs at 01:13. Train is full."
+"\n"+"Train to Berlin departs at 14:26. Train is full."
+"\n"+"Train to London departs at 03:39. Train is full."
+"\n"+"Train to Tel-Aviv departs at 16:52. Train is full."
+"\n"+"Train to rome departs at 05:05. Train is full."
+"\n"+"Train to Paris departs at 18:18. Train is full."
+"\n"+"Train to Monaco departs at 07:31. Train is full."
+"\n"+"Train to Berlin departs at 20:44. Train is full."
+"\n"+"Train to London departs at 09:57. Train is full."
+"\n"+"Train to Tel-Aviv departs at 22:10. Train is full."
+"\n"+"Train to rome departs at 11:23. Train is full."
+"\n"+"Train to Paris departs at 00:36. Train is full."
+"\n"+"Train to Monaco departs at 13:49. Train is full."
+"\n"+"Train to Berlin departs at 02:02. Train is full."
+"\n"+"Train to London departs at 15:15. Train is full."
+"\n"+"Train to Tel-Aviv departs at 04:28. Train is full."
+"\n"+"Train to rome departs at 17:41. Train is full."
+"\n"+"Train to Paris departs at 06:54. Train is full."
+"\n"+"Train to Monaco departs at 19:07. Train is full."
+"\n"+"Train to Berlin departs at 08:20. Train is full."
+"\n"+"Train to London departs at 21:33. Train is full."
+"\n"+"Train to Tel-Aviv departs at 10:46. Train is full."
+"\n"+"Train to rome departs at 23:59. Train is full."
+"\n"+"Train to Paris departs at 12:12. Train is full."
+"\n"+"Train to Monaco departs at 01:25. Train is full."
+"\n"+"Train to Berlin departs at 14:38. Train is full."
+"\n"+"Train to London departs at 03:51. Train is full."
+"\n"+"Train to Tel-Aviv departs at 16:04. Train is full."
+"\n"+"Train to rome departs at 05:17. Train is full."
+"\n"+"Train to Paris departs at 18:30. Train is full."
+"\n"+"Train to Monaco departs at 07:43. Train is full."
+"\n"+"Train to Berlin departs at 20:56. Train is full."
+"\n"+"Train to London departs at 09:09. Train is full."
+"\n"+"Train to Tel-Aviv departs at 22:22. Train is full."
+"\n"+"Train to rome departs at 11:35. Train is full."
+"\n"+"Train to Paris departs at 00:48. Train is full."
+"\n"+"Train to Monaco departs at 13:01. Train is full."
+"\n"+"Train to Berlin departs at 02:14. Train is full."
+"\n"+"Train to London departs at 15:27. Train is full.";

}

