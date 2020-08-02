package ro.upb.etti.stud.firstproject.Jurnal_package;

public class Jurnal_MyEntries {
    String titleentry;
    String descentry;
    String dateentry;
    String keyentry;

    // Generam constructorii:
    public Jurnal_MyEntries() {
    }
    public Jurnal_MyEntries(String titleentry, String descentry, String dateentry, String keyentry) {
        this.titleentry = titleentry;
        this.descentry = descentry;
        this.dateentry = dateentry;
        this.keyentry = keyentry;
    }

    // Generam get-ere si set-ere
    public String getKeyentry() {
        return keyentry;
    }

    public void setKeyentry(String keyentry) {
        this.keyentry = keyentry;
    }

    public String getTitleentry() {
        return titleentry;
    }

    public void setTitleentry(String titleentry) {
        this.titleentry = titleentry;
    }

    public String getDescentry() {
        return descentry;
    }

    public void setDescentry(String descentry) {
        this.descentry = descentry;
    }

    public String getDateentry() {
        return dateentry;
    }

    public void setDateentry(String dateentry) {
        this.dateentry = dateentry;
    }
}
