/*
* przyklad1 hibernate
* przyklad stosowania createQuery() obiektu Session, czyli szukanie danych*/

package sda.hibernate.przyklad1;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class przyklad1 {

    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Uzytkownik pobranyRekord = (Uzytkownik)session.createQuery("from Uzytkownik WHERE id=:id").setParameter("id",19L).getSingleResult();
        Uzytkownik pobranyRekord2 = session.createQuery("from Uzytkownik WHERE id=:id", Uzytkownik.class).setParameter("id",10L).getSingleResult();

        session.close();
        System.out.println("Pobrano uzytkownika o id=" + pobranyRekord.getId() + ", imie=" + pobranyRekord.getImie() + ", nazwisko=" + pobranyRekord.getNazwisko());
        System.out.println("Pobrano uzytkownika o id=" + pobranyRekord2.getId() + ", imie=" + pobranyRekord2.getImie() + ", nazwisko=" + pobranyRekord2.getNazwisko());
    }
}
