package sda.hibernate.zadanieKurs;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class ZadanieFilm {

    public static void createQueryFilmById(long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie pobranyRekord = (Movie) session.createQuery("FROM Movie WHERE id = :id").setParameter("id", ID).getSingleResult();
        session.close();
        System.out.println("\nPobrano film o ID: " + pobranyRekord.getId() + " tytuł: " + pobranyRekord.getNazwa_filmu() +
                " rezyser: " + pobranyRekord.getRezyser_filmu() + " rok produkcji: " + pobranyRekord.getRokprodukcji() + "\n");

    }

    public static void createNativeQueryFilmByID(long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie pobranyRekord2 = session.createNativeQuery("SELECT * FROM film WHERE id = :id", Movie.class).setParameter("id", ID).getSingleResult();
        session.close();
        System.out.println("\nFilm pobrany z podanym ID to: " + pobranyRekord2.getId() + ", tytuł: " + pobranyRekord2.getNazwa_filmu() +
                ", gatunek: " + pobranyRekord2.getGatunek_filmu() + ", reżyser: " + pobranyRekord2.getRezyser_filmu()
                + ", rok produkcji: " + pobranyRekord2.getRokprodukcji() + "\n");
    }

    public static void createNamedQueryFilmByID(long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie pobranyRekord3 = session.createNamedQuery("movie.selectById", Movie.class).setParameter("id", ID).getSingleResult();
        session.close();
        System.out.println("\nPobrany film to: " + pobranyRekord3.getId() + ", tytuł: " + pobranyRekord3.getNazwa_filmu() +
                ", gatunek: " + pobranyRekord3.getGatunek_filmu() + ", rezyser: " + pobranyRekord3.getRezyser_filmu() +
                ", rok produkcji: " + pobranyRekord3.getRokprodukcji() + "\n");


    }


    public static void createNamedQueryFilmByName(String nazwaFilmu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie pobranyRekord3 = session.createNamedQuery("movie.selectByName", Movie.class).setParameter("nazwa", nazwaFilmu).getSingleResult();
        session.close();
        System.out.println("\nPobrany film to: " + pobranyRekord3.getId() + ", tytuł: " + pobranyRekord3.getNazwa_filmu() +
                ", gatunek: " + pobranyRekord3.getGatunek_filmu() + ", rezyser: " + pobranyRekord3.getRezyser_filmu() +
                ", rok produkcji: " + pobranyRekord3.getRokprodukcji() + "\n");


    }

    public static void createNamedQueryByGatunek (String gatunekFilmu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie pobranyRekord4 = session.createNamedQuery("movie.selectByGatunek", Movie.class).setParameter("gatunek", gatunekFilmu).getSingleResult();
        session.close();
        System.out.println("\nPobrany film (wg gatunku) to: " + pobranyRekord4.getNazwa_filmu() + ", rok produkcji: " + pobranyRekord4.getRokprodukcji());

    }

}




//Dodać do bazy danych nową tabele „film” z kolumnami:
//        • id -PK
//        • nazwa_filmu -varchar(500)
//        • gatunek_filmu -varchar(200)
//        • rezyser_filmu -varchar(100)
//        • rokprodukcji -int

//        Dodać 5 filmów.
//        Następnie stworzyć 3 metody (tak żeby użyć createQuery(), createNamedQuery(), createdNativeQuery()),
//        które będą pobierały film o konkretnym id i wypisywały wszystkie dane na konsoli.

//        Zadanie 2
//        Dodać do rozwiązania powyżej pobieranie całej listy filmów na 3 sposoby- odpowiednio dla każdego polecenia
//        createQuery(), createNamedQuery(), createdNativeQuery().

//        Zadanie 3
//        Za pomocą createNamedQuery zdefiniować 5 zapytań sql, z których
//        • pierwsze będzie pobierało film według zadanego id
//        • drugie będzie pobierało filmy według zadanej nazwy
//        • trzecie będzie pobierało filmy według zadanego gatunku
//        • czwarte będzie pobierało filmy według zadanego reżysera
//        • piąte będzie pobierało filmy według zadanego roku produkcji

//        Napisać 5 metod wykorzystujących utworzone 5 NamedQuery i zaprezentować działanie z wynikami na konsoli
