/*
 * przyklad2 hibernate
 * przyklad stosowania createNativeQuery() do pobierania danych*/

package sda.hibernate.przyklad2;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class przyklad2 {
    public static void main(String[] arg) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        //Uzytkownik pobranyRekord = (Uzytkownik)session.createNativeQuery("SELECT * FROM Uzytkownik WHERE id=:id").setParameter("id",10L).getSingleResult();
        Uzytkownik pobranyRekord2 = session.createNativeQuery("SELECT * FROM Uzytkownik WHERE id=:id",Uzytkownik.class).setParameter("id",10L).getSingleResult();
        session.close();
        //System.out.println("Pobrano uzytkownika o id=" + pobranyRekord.getId() + ", imie=" + pobranyRekord.getImie() + ", nazwisko=" + pobranyRekord.getNazwisko());
        System.out.println("Pobrano uzytkownika o id=" + pobranyRekord2.getId() + ", imie=" + pobranyRekord2.getImie() + ", nazwisko=" + pobranyRekord2.getNazwisko());

    }
}
