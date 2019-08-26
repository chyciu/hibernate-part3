package sda.hibernate.zadanieKurs;

public class Main {

    public static void main(String[] args) {

       ZadanieFilm.createQueryFilmById(2);
       ZadanieFilm.createNativeQueryFilmByID(3);
       ZadanieFilm.createNamedQueryFilmByID(4);
       ZadanieFilm.createNamedQueryFilmByName("Dobry");
       ZadanieFilm.createNamedQueryByGatunek("kryminal");


    }
}
