import java.util.Scanner;

public class User {

    private String userName=null;
    private int userId = 0;
    private int resevationTotalCounter=0;
    private double reservationCost=0;
    private int fligtReservation=0;
    private int hotelReservation=0;
    private int tourReservation=0;

    static Scanner scanner =new Scanner(System.in);

    public User(String userName, int userId, double reservationCost) {
        this.userName = userName;
        this.userId = userId;
        this.reservationCost = reservationCost;
    }

    public int getFligtReservation() {
        return fligtReservation;
    }
    public void setHotelReservation(int hotelReservation) {
        this.hotelReservation += hotelReservation;
    }
    public void setFligtReservation(int fligtReservation) {
        this.fligtReservation += fligtReservation;
    }

    public int getHotelReservation() {
        return hotelReservation;
    }

    public int getTourReservation() {
        return tourReservation;
    }

    public void setTourReservation(int tourReservation) {
        this.tourReservation += tourReservation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getResevationTotalCounter() {
        return resevationTotalCounter;
    }

    public void setTotalResevationCounter(int resevationCounter) {
        this.resevationTotalCounter += resevationCounter;
    }

    public double getReservationCost() {
        return reservationCost;
    }

    public void setReservationCost(double reservationCost) {
        this.reservationCost += reservationCost;
    }


}
