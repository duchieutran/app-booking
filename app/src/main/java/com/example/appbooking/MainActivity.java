package com.example.appbooking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbooking.Activities.SignUpActivity;
import com.example.appbooking.Database.MySQLite;
import com.example.appbooking.page.Admin.HomeAdminActivity;
import com.example.appbooking.page.DashboardActivity;
import com.example.booking.Model.TaiKhoan;

import org.mindrot.jbcrypt.BCrypt;

public class MainActivity extends AppCompatActivity {

    EditText edtTenDangNhap, edtMatKhau;
    Button btnDangNhap;
    TextView txvDangKy;
    MySQLite db;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        txvDangKy = findViewById(R.id.txvDangKy);
        db = new MySQLite(MainActivity.this, db.DATABASE_NAME, null, 1);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenDangNhap = edtTenDangNhap.getText().toString().trim();
                String matKhau = edtMatKhau.getText().toString().trim();

                boolean isValid = true;
                // Kiểm tra nếu tên đăng nhập trống
                if (tenDangNhap.isEmpty()) {
                    edtTenDangNhap.setError("Vui lòng điền đầy đủ tên đăng nhập!");
                    isValid = false;
                } else {
                    edtTenDangNhap.setError(null);
                }
                // Kiểm tra nếu mật khẩu trống
                if (matKhau.isEmpty()) {
                    edtMatKhau.setError("Vui lòng điền đầy đủ mật khẩu!");
                    isValid = false;
                } else {
                    edtMatKhau.setError(null);
                }
                // Thực hiện đăng nhập nếu đã điền đầy đủ thông tin
                if (isValid) {
                    // Kiểm tra tài khoản và mật khẩu trong SharedPreferences
                    String storedUsername = sharedPreferences.getString("username", "");
                    String storedPassword = sharedPreferences.getString("password", "");

                    if (tenDangNhap.equals(storedUsername) && checkPassword(matKhau, storedPassword)) {
                        // Kiểm tra vai trò người dùng
                        TaiKhoan taiKhoan = new TaiKhoan();
                        taiKhoan.setUsername(tenDangNhap);
                        taiKhoan.setPassword(matKhau);
                        taiKhoan.setRole(1);  // Ví dụ: role 1 là người dùng bình thường

                        // Chuyển đến trang DashboardActivity
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        intent.putExtra("taiKhoan", taiKhoan);
                        startActivity(intent);
                        finish();
                    } else {
                        // Kiểm tra trong CSDL nếu không tìm thấy trong SharedPreferences
                        TaiKhoan taiKhoan = db.kiemTraDangNhap(tenDangNhap, matKhau);
                        if (taiKhoan.getId() >= 0) {
                            // Tài khoản hợp lệ, chuyển sang trang tương ứng
                            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                            intent.putExtra("taiKhoan", taiKhoan);
                            startActivity(intent);
                            finish();
                        } else {
                            // Nếu tài khoản hoặc mật khẩu không đúng, hiển thị lỗi
                            edtTenDangNhap.setError("Tài khoản hoặc mật khẩu không đúng!");
                            edtMatKhau.setError("Tài khoản hoặc mật khẩu không đúng!");
                        }
                    }
                }
            }
        });

        // Sự kiện đăng ký
        txvDangKy.setOnClickListener(v -> {
            Intent intentDangKy = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intentDangKy);
        });
    }

    // Hàm kiểm tra mật khẩu (so sánh mật khẩu nhập vào với mật khẩu đã mã hóa trong SharedPreferences)
    private boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }
}
