import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
        Scanner sc = new Scanner(System.in);
        DanhBaManager danhBaManager = new DanhBaManager();
        String PATH = ConfigReadAndWriteFile.PATH;
        List<DanhBa> listDanhBa = new ConfigReadAndWriteFile<DanhBa>().readFromFile(PATH);

        DanhBa danhBa1 = new DanhBa(1, "name", "012345", "Hanoi", "email", "facebook");
        DanhBa danhBa2 = new DanhBa(2, "name", "012", "Haiphong", "email1", "facebook1");

        danhBaManager.save(danhBa1);
        danhBaManager.save(danhBa2);

        danhBaManager.findAll();

        System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---" +
                "\nChọn chức năng theo số (để tiếp tục):" +
                "\n1. Xem danh sách" +
                "\n2. Thêm mới" +
                "\n3. Cập nhật" +
                "\n4. Xóa" +
                "\n5. Tìm kiếm" +
                "\n6. Đọc từ file" +
                "\n7. Ghi vào file" +
                "\n8. Thoát" +
                "\nChọn chức năng: ");
        int selection = sc.nextInt();
        switch (selection) {
            case 1:
                System.out.println("======== HIỂN THỊ DANH BẠ ========");
                System.out.println(danhBaManager.findAll());
                danhBaManager.backToMenu();
                break;

            case 2:
                danhBaManager.add();
                break;

            case 3:
                danhBaManager.edit();
                break;

            case 4:
                danhBaManager.delete();
                break;

            case 5:
                danhBaManager.findByName();
                break;

            case 6:
                danhBaManager.findAll();
                System.out.println("ĐỌC TỪ FILE THÀNH CÔNG!");
                new Main();

            case 7:
                System.out.println("GHI VÀO FILE THÀNH CÔNG!");

            case 8:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
