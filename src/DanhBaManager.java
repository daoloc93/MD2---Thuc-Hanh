import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

public class DanhBaManager {
    Scanner sc = new Scanner(System.in);
    public static String PATH = ConfigReadAndWriteFile.PATH;
    public static List<DanhBa> listDanhBa = new ConfigReadAndWriteFile<DanhBa>().readFromFile(PATH);


    public List<DanhBa> findAll() {
        new ConfigReadAndWriteFile<DanhBa>().writeToFile(PATH, listDanhBa);
        return listDanhBa;
    }

    public void save(DanhBa danhBa) {
        listDanhBa.add(danhBa);
    }

    public void add() {
        System.out.println("======== THÊM MỚI DANH BẠ ========");
        int id = (listDanhBa.size() > 0) ? (listDanhBa.size() + 1) : 1;
        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();
        System.out.print("Nhập email: ");
        String email = sc.nextLine();
        System.out.print("Nhập facebook: ");
        String facebook = sc.nextLine();

        DanhBa danhBa = new DanhBa(id, hoTen, sdt, diaChi, email, facebook);
        save(danhBa);
        findAll();

        System.out.println("THÊM MỚI DANH SÁCH THÀNH CÔNG!");
        backToMenu();
    }

    public void edit() {
        System.out.println("Nhập vào id bạn muốn sửa: ");
        String sdt = sc.nextLine();
        boolean flag = false;
        sc.nextLine();
        for (int i = 0; i < listDanhBa.size(); i++) {
            if (sdt.equals(listDanhBa.get(i).getSdt())) {
                flag = true;

                System.out.println("======== CẬP NHẬT DANH BẠ ========");
                System.out.print("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhập số điện thoại (10 số): ");
                String sdtMoi = sc.nextLine();
                boolean checkSDTMoi = Pattern.matches("[0-9_-]{10,10}", sdtMoi);
                if (!checkSDTMoi) {
                    System.out.println("Nhâp sai định dạng số điện thoại, thử lại:");
                    edit();
                }
                System.out.print("Nhập địa chỉ: ");
                String diaChi = sc.nextLine();
                System.out.print("Nhập email (định dạnh @gmail.com): ");
                String email = sc.nextLine();
                if (!email.endsWith("@gmail.com")) {
                    System.out.println("Nhập sai định dạng, thử lại");
                    edit();
                }
                System.out.print("Nhập facebook: ");
                String facebook = sc.nextLine();

                DanhBa danhBa = new DanhBa(listDanhBa.get(i).getId(), hoTen, sdtMoi, diaChi, email, facebook);
                listDanhBa.set(i, danhBa);
                findAll();
                System.out.println("CẬP NHÂT DANH BẠ THÀNH CÔNG!");
            }
        }
        if (flag == false) {
            System.out.println("id cần tìm không có trong danh sách");
        }

        backToMenu();
    }

    public void delete() {
        System.out.println("======== XÓA DANH BẠ ========");
        System.out.print("Nhập vào số điện thoại cần xóa: ");
        String sdt = sc.nextLine();
        boolean flag = false;

        for (int i = 0; i < listDanhBa.size(); i++) {
            flag = true;
            if (listDanhBa.get(i).getSdt().equals(sdt)) {
                listDanhBa.remove(listDanhBa.get(i));
                System.out.println("XÓA DANH BẠ THÀNH CÔNG!");
            }
        }
        if (flag == false) {
            System.out.println("id vừa nhập không có trong danh bạ.");
        }
        backToMenu();
    }

    public void findByName() {
        System.out.print("Nhập vào tên bạn muốn tìm: ");
        String name = sc.nextLine();
        int count = 0;
        ArrayList<DanhBa> tenTimDuoc = new ArrayList<>();

        for (int i = 0; i < listDanhBa.size(); i++) {
            if (name.equalsIgnoreCase(listDanhBa.get(i).getHoTen())) {
                count++;
                tenTimDuoc.add(listDanhBa.get(i));
            }
        }
        System.out.println("Tìm được " + count + "id có tên " + name + ":");
        for (DanhBa element : tenTimDuoc) {
            System.out.println(element);
        }
        backToMenu();
        ;
    }

    public void backToMenu() {
        System.out.println("Nhấn 1 để trở lại MENU");
        int no1 = sc.nextInt();
        switch (no1) {
            case 1:
                new Main();
        }
    }
}
