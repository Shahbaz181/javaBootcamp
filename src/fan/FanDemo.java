
package fan;

import java.util.ArrayList;
import java.util.Scanner;

public class FanDemo {

    public static void main(String[] args) {
        ArrayList<Fan> fanArrayList = new ArrayList<>();
        int i = 1;
        while (i <= 180) {
            //Creating the fan
            Fan f = new Fan();
            //Adding the fan to warehouse(Fan arraylist)
            fanArrayList.add(f);
            i++;
        }
        System.out.println("No of fans in warehouse : " + fanArrayList.size());
        Scanner sc = new Scanner(System.in);
        boolean outerRunning = true;
        while (outerRunning == true) {
            System.out.println("Enter the fan number to test :");
            int fanSelected = sc.nextInt();
            Fan f1 = fanArrayList.get(fanSelected);
            boolean running = true;
            int overAllCount=0;
            while (running == true) {
                System.out.println("---Fan Controls---");
                System.out.println("1) Switch on the fan.");
                System.out.println("2) Switch of the fan.");
                System.out.println("3) Increase the fan speed.");
                System.out.println("4) Decrease the fan speed.");
                System.out.println("5) To select another fan.");
                System.out.println("6) No of fans in switched on status");
                System.out.println("7) No of fans in switched off status");
                System.out.println("8) Exit");
                int choice = sc.nextInt();
                //1, 2, 3, 4, 5

                switch (choice) {
                    case 1 -> {
                        if (f1.isSwitchedOn() == false) {
                            System.out.println("Starting the fan");
                            overAllCount++;
                            f1.switchOnTheFan();
                        } else {
                            System.out.println("Fan is already running");
                        }
                    }
                    case 2 -> {
                        f1.switchOfTheFan();
                        System.out.println("Fan is switched");
                        overAllCount++;
                    }
                    case 3 -> {
                        f1.increaseSpeed();
                        System.out.println("Fan speed is: " + f1.getSpeed());
                        overAllCount++;
                    }
                    case 4 -> {
                        f1.decreaseSpeed();
                        System.out.println("Fan speed is: " + f1.getSpeed());
                        overAllCount++;
                    }
                    case 5 -> {
                        running = false;
                        //  System.out.println("");
                        overAllCount++;
                    }
                    case 6 -> {
                        int countOfFansOn = 0;
                        for (Fan fan : fanArrayList) {
                            if (fan.isSwitchedOn() == true) {
                                countOfFansOn++;
                            }
                        }
                        overAllCount++;
                        System.out.println("Number of fans in switched on status : " + countOfFansOn);
                    }
                    case 7 -> {
                        int countOfFansOn = 0;
                        for (Fan fan : fanArrayList) {
                            if (fan.isSwitchedOn() == false) {
                                countOfFansOn++;
                            }
                        }
                        overAllCount++;
                        System.out.println("Number of fans in switched off status : " + countOfFansOn);
                    }

                    case 8 -> {
                        outerRunning = false;
                        running = false;
                        System.out.println("The application is closed ");
                    }
                }
                System.out.println("Overall count of tested button " + overAllCount);
            }
        }
    }
}