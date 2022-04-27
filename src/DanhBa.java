public class DanhBa {
    int id;
    String hoTen;
    String sdt;
    String diaChi;
    String email;
    String facebook;

    public DanhBa() {
    }

    public DanhBa(int id, String hoTen, String sdt, String diaChi, String email, String facebook) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.facebook = facebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", sdt=" + sdt +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
