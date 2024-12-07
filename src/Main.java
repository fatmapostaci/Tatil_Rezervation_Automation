import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
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

        ArrayList <User> userList = new ArrayList<>();
        boolean finishSession = false;
        int i=0;
        do{

            userList.add( createUser(i));

            System.out.println("--------- Sayın " + userList.get(i).getUserName().toUpperCase() +" Tatil Rezervasyonuna Hoşgeldiniz!----------");
            Reservation reservation = new Reservation();
            reservation.selectService(userList.get(i));

            //userList.add(userList.get(i));

            System.out.printf("\nKullanıcı adı = %10s" , userList.get(i).getUserName());
            System.out.printf("\nToplam Rezervasyon Tutarı = %10.2f" , userList.get(i).getReservationCost());
            System.out.printf("\nToplam Rezervasyon Sayısı = %10d\n" , userList.get(i).getResevationTotalCounter());


            //Program farklı kullanıcılar için de veri girişi alıp ArrayList içinde tutuyor.
            boolean addNewUser=false;
            System.out.print("\nProgram sonlandırılacak! Farklı bir kullanıcı için Rezervasyon yapmak istermisiniz? (E/H) : ");
            if(scanner.nextLine().substring(0,1).equalsIgnoreCase("E")){
                addNewUser=true;
                i++;
            }
            else{
                finishSession=true;
            }

        }while(!finishSession);

        logOfUserList(userList);
    }

    private static User createUser(int i) {
     //   scanner.nextLine();
        System.out.print("Kullanıcı bilgilerini giriniz...\n İsim Soyisim = ");
        String isimsoyisim= scanner.nextLine();

        return new User(isimsoyisim,(i+100), 0.0 );
    }
    private static void logOfUserList(ArrayList<User> userList){
        for (User user : userList) {
            System.out.printf("\nKullanıcı adı = %10s", user.getUserName());
            System.out.printf("\nToplam Rezervasyon Tutarı = %10.2f", user.getReservationCost());
            System.out.printf("\nToplam Rezervasyon Sayısı = %10d\n", user.getResevationTotalCounter());
        }
    }

}