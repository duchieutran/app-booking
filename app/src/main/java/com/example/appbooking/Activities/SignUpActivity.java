package com.example.appbooking.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appbooking.R;
import org.mindrot.jbcrypt.BCrypt;

public class SignUpActivity extends AppCompatActivity {
    EditText edtTenDangNhap, edtMatKhau, edtNhapLaiMatKhau, edtEmail, edtSDT;
    Button btnDangKy;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtNhapLaiMatKhau = findViewById(R.id.edtNhapLaiMatKhau);
        edtEmail = findViewById(R.id.edtEmail);
        edtSDT = findViewById(R.id.edtSDT);
        btnDangKy = findViewById(R.id.btnDangKy);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Lấy thông tin tài khoản người dùng
                    String username = edtTenDangNhap.getText().toString().trim();
                    String password = edtMatKhau.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String sdt = edtSDT.getText().toString().trim();

                    // Mã hóa mật khẩu và lưu vào SharedPreferences
                    saveAccount(username, password, email, sdt);

                    // Hiển thị thông báo đăng ký thành công
                    showSuccessDialog();
                }
            }
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;
        String matKhau = edtMatKhau.getText().toString().trim();
        String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString().trim();

        if (matKhau.isEmpty()) {
            edtMatKhau.setError("Vui lòng nhập mật khẩu!");
            isValid = false;
        } else if (matKhau.length() < 6) {
            edtMatKhau.setError("Mật khẩu phải có ít nhất 6 ký tự!");
            isValid = false;
        }

        if (nhapLaiMatKhau.isEmpty()) {
            edtNhapLaiMatKhau.setError("Vui lòng nhập lại mật khẩu!");
            isValid = false;
        } else if (!nhapLaiMatKhau.equals(matKhau)) {
            edtNhapLaiMatKhau.setError("Mật khẩu không khớp!");
            isValid = false;
        }

        // Kiểm tra email và số điện thoại
        String email = edtEmail.getText().toString().trim();
        String sdt = edtSDT.getText().toString().trim();

        if (email.isEmpty()) {
            edtEmail.setError("Vui lòng nhập email!");
            isValid = false;
        }

        if (sdt.isEmpty()) {
            edtSDT.setError("Vui lòng nhập số điện thoại!");
            isValid = false;
        }

        return isValid;
    }

    // Lưu tài khoản vào SharedPreferences
    private void saveAccount(String username, String password, String email, String sdt) {
        String hashedPassword = hashPassword(password);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", hashedPassword);
        editor.putString("email", email);
        editor.putString("sdt", sdt);
        editor.apply();  // Lưu thông tin vào SharedPreferences
    }

    // Mã hóa mật khẩu sử dụng BCrypt
    private String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    // Hiển thị hộp thoại đăng ký thành công và chuyển sang màn hình bổ sung thông tin cá nhân
    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setTitle("Đăng ký thành công!")
                .setMessage("Bạn đã đăng ký tài khoản thành công! Hãy bổ sung thông tin cá nhân!")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Sau khi nhấn OK, chuyển đến màn hình bổ sung thông tin cá nhân
                    Intent intent = new Intent(SignUpActivity.this, AddInfoUserActivity.class);
                    startActivity(intent);
                    finish();  // Đóng màn hình đăng ký
                })
                .setCancelable(false)
                .show();
    }
}
