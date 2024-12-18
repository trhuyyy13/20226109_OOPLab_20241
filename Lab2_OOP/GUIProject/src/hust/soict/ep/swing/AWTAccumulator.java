package hust.soict.ep.swing;

import java.awt.*; // Nhập các lớp AWT
import java.awt.event.*; // Nhập các lớp AWT event

public class AWTAccumulator extends Frame {
    private TextField tfInput; // Ô nhập liệu
    private TextField tfOutput; // Ô hiển thị tổng
    private int sum = 0; // Tích lũy giá trị, khởi tạo bằng 0

    // Constructor để thiết lập giao diện và xử lý sự kiện
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); // Lưới 2 hàng, 2 cột

        // Dòng 1: Nhãn và ô nhập liệu
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10); // Tạo TextField với chiều dài 10 ký tự
        add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Lắng nghe sự kiện từ tfInput

        // Dòng 2: Nhãn và ô hiển thị kết quả
        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Không cho phép chỉnh sửa kết quả
        add(tfOutput);

        // Thiết lập cửa sổ
        setTitle("AWT Accumulator");
        setSize(350, 120); // Kích thước cửa sổ
        setVisible(true); // Hiển thị cửa sổ

        // Đóng cửa sổ khi nhấn nút đóng
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); // Giải phóng tài nguyên
                System.exit(0); // Thoát chương trình
            }
        });
    }

    // Điểm khởi chạy chương trình
    public static void main(String[] args) {
        new AWTAccumulator(); // Tạo một thể hiện của AWTAccumulator
    }

    // Lớp lắng nghe sự kiện cho TextField (nội lớp)
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                // Lấy số nguyên từ TextField và cộng vào tổng
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;
                tfInput.setText(""); // Xóa TextField sau khi nhập
                tfOutput.setText(sum + ""); // Cập nhật kết quả trong tfOutput
            } catch (NumberFormatException e) {
                tfOutput.setText("Invalid input!"); // Thông báo khi nhập sai định dạng
            }
        }
    }
}
