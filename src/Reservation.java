import java.util.Scanner;

public class Reservation {
    /*
     * TASK:
     * Bir tatil rezervasyon programı yazınız.
     *
     * 1. Adım : Kullanıcıya otel, uçak bileti ve tur seçeneklerini göster.
     * 2. Adım : Hangi hizmeti seçmek istediğini sor ve kaç gün/kişilik olduğunu belirtmesini iste.
     * 3. Adım : Başka bir hizmet eklemek isteyip istemediğini sor.
     *           İstemiyorsa toplam fiyatı göster.
     *           İstiyorsa başka bir hizmet seçtir.
     * 4. Adım : Her seçimde, hizmetin fiyatını toplam tutara ekle.
     * 5. Adım : Rezervasyon bittiğinde toplam tutarı ve seçilen hizmetlerin özetini göster.
     */
    Scanner scanner = new Scanner(System.in);

    public void selectService(User user) {


        boolean endSession = false;
        do {

            showServiceMenu();
            int secim;
            try {
                secim = scanner.nextInt();
                switch (secim) {
                    case 1:
                        addHotelService(user);
                        break;
                    case 2:
                        addFlightService(user);
                        break;
                    case 3:
                        addTourService(user);
                        break;
                    case 4:
                        printOutUserReservation(user);
                        break;
                    case 5:
                        endSession=true;
                        break;
                    default:
                        System.out.println("Tekrar seçim yapın!");
                        break;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //İlk rezervasyondan sonra yeni rezervasyon sorusu kontrolü
            if(user.getResevationTotalCounter()>0) {
                System.out.println("Yeni bir rezervasyon eklemek ister misiniz? (E/H)");
                if (!scanner.next().substring(0, 1).equalsIgnoreCase("E"))
                    break;
            }
        } while (!endSession);
        endUserRezervation(user);
    }

    private void printOutUserReservation(User user) {

        System.out.println("Kullanıcı adı = " + user.getUserName());
        System.out.println("Kullanıcı adı = " + user.getUserId());
        System.out.println("Toplam rezervasyon tutarı = " + user.getReservationCost());
        System.out.println("Toplam rezervasyon Sayısı = " + user.getResevationTotalCounter());
        System.out.println("Uçuş rezervasyon bilgisi = " + user.getFligtReservation());
        System.out.println("Uçuş rezervasyon bilgisi = " + user.getTourReservation());
        System.out.println("Uçuş rezervasyon bilgisi = " + user.getHotelReservation());
    }


    private void addHotelService(User user){
        System.out.println("Otel Rezervasyonunun kişi başı günlük ücreti 500TL dir.");
        user.setHotelReservation(1);
        user.setTotalResevationCounter(1);
        System.out.print("Kaç günlük rezervasyon istediğinizi girin: ");
        int numberOfDays = scanner.nextInt();
        System.out.print("Kaç kişilik rezervasyon yapmak istersiniz:  ");
        int numberOfPeople = scanner.nextInt();
        double hotelPrice = numberOfPeople * numberOfDays * 500.0;
        user.setReservationCost(hotelPrice);
        System.out.println("Kayıt yapıldı. Otel rezervasyon ücreti: "+ hotelPrice + "  TL");

    }

    private void addFlightService(User user) {
        System.out.println("Uçuş Rezervasyonunun kişi başı  ücreti 1200TL dir.");
        user.setFligtReservation(1);
        user.setTotalResevationCounter(1);

        System.out.print("Kaç kişilik bilet rezerve etmek istersiniz? ");
        int numberOfPeople = scanner.nextInt();
        double flightPrice = numberOfPeople * 1200.0;
        user.setReservationCost(flightPrice);
    }

    private void addTourService(User user){
        System.out.println("Tur Rezervasyonunun kişi başı günlük ücreti 2000TL dir.");
        user.setTourReservation(1);
        user.setTotalResevationCounter(1);
        System.out.println("Kaç kişilik rezervasyon yapmak istersiniz? ");
        int numberOfPeople = scanner.nextInt();
        double tourPrice = numberOfPeople * 2000.0;
        user.setReservationCost(tourPrice);
    }

    public void showServiceMenu() {
        System.out.println("---------------Hizmet Seçenekleri:---");
        System.out.println("------------1. Otel Rezervasyonu Yap ");
        System.out.println("------------2. Uçak Bileti Rezervasyonu Yap");
        System.out.println("------------3. Tur Rezervasyonu Yap ");
        System.out.println("------------4. Rezervasyon Bilgilerini Listele ");
        System.out.println("------------5. ÇIKIŞ ");
        System.out.print("Lütfen bir hizmet seçin (1-4): ");
    }
    private void endUserRezervation(User user) {
        System.out.println("Sayın " + user.getUserName() + " Yeni bir rezervasyon işleminde tekrar görüşmek dileğiyle" +
                "\n***********HOŞÇAKALIN***********\n");

    }

}
