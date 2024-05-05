
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalisanIslemleri {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public CalisanIslemleri() {
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı");
        }

        try {
            con = DriverManager.getConnection(url, Database.kullaniciAdi, Database.parola);
            System.out.println("Bağlantı başarılı.");
        } catch (SQLException e) {
            System.out.println("Bağlantı başarısız.");
        }
    }
    public boolean girisYap(String kullaniciAdi, String parola) {
        String sorgu = "SELECT * FROM adminler WHERE username = ? and password = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, parola);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Calisan> calisanlariGetir() {
        ArrayList<Calisan> cikti = new ArrayList<>();

        try {
            statement = con.createStatement();
            String sorgu = "SELECT * FROM calisanlar";
            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String departman = rs.getString("departman");
                String maas = rs.getString("maas");

                cikti.add(new Calisan(id, ad, soyad, departman, maas));
            }
            return cikti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void calisanEkle(String ad, String soyad, String departman, String maas) {

        String sorgu = "INSERT INTO calisanlar (ad,soyad,departman,maas) VALUES(?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setString(4, maas);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calisanGuncelle(int id, String yeniAd, String yeniSoyad, String yeniDepartman, String yeniMaas) {
        String sorgu = "UPDATE calisanlar SET ad = ? , soyad = ? , departman = ? , maas = ? WHERE id = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, yeniAd);
            preparedStatement.setString(2, yeniSoyad);
            preparedStatement.setString(3, yeniDepartman);
            preparedStatement.setString(4, yeniMaas);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calisanSil(int id) {
        String sorgu = "DELETE FROM calisanlar WHERE id = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
