/*
 * przyklad3 hibernate
 * przyklad stosowania createNamedQuery() do pobierania danych*/
package sda.hibernate.przyklad3;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class przyklad3 {

    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Uzytkownik pobranyRekord =(Uzytkownik) session.createNamedQuery("uzytkownik.select").setParameter("id", 10L).getSingleResult();
        Uzytkownik pobranyRekord2 = session.createNamedQuery("uzytkownik.select",Uzytkownik.class).setParameter("id", 10L).getSingleResult();

        session.close();
        System.out.println("Pobrano uzytkownika o id=" + pobranyRekord.getId() + ", imie=" + pobranyRekord.getImie() + ", nazwisko=" + pobranyRekord.getNazwisko());
        System.out.println("Pobrano uzytkownika o id=" + pobranyRekord2.getId() + ", imie=" + pobranyRekord2.getImie() + ", nazwisko=" + pobranyRekord2.getNazwisko());

    }
}
