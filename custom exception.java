package testing;

import java.util.Arrays;
import java.util.Scanner;

//check the product is present or not
class BikeShowRoom extends RuntimeException {
    String bname;
    double bprice;
    int topSpeed;

    public BikeShowRoom(String str) {
        super(str);
    }

    public BikeShowRoom(String bname, double bprice, int topSpeed) {
        this.bname = bname;
        this.bprice = bprice;
        this.topSpeed = topSpeed;
    }


}

public class CustomException {
    public static void main(String[] args) {
        BikeShowRoom r15 = new BikeShowRoom("R15", 250000, 160);
        BikeShowRoom duke = new BikeShowRoom("Duke", 300000, 250);
        int[] arr1 = new int[3];
        String[] arr2 = new String[5];
        Object[] arr3 = new Object[6];
        //UDA / custom array/Object type
        BikeShowRoom[] bikeShowRoom = new BikeShowRoom[2];
        bikeShowRoom[0] = r15;
        bikeShowRoom[1] = duke;
        System.out.println(Arrays.toString(bikeShowRoom));
        try {
            bookVehicle(bikeShowRoom);
        } catch (BikeShowRoom b) {
//            System.out.println(b.getMessage());
            b.printStackTrace();
        }
        System.out.println("Method end");
    }

    private static void bookVehicle(BikeShowRoom[] bsr) {
        System.out.println("What type of bike u want");
        String userBike = new Scanner(System.in).nextLine();
        for (int i = 0; i < bsr.length; i++) {
            if (bsr[i].bname.equals(userBike)) {
                System.out.println(bsr[i]);
                return;
            }
        }
        throw new BikeShowRoom("Bike Not Available");
    }
}