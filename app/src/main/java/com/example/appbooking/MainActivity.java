package com.example.appbooking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.appbooking.Database.MySQLite;
import com.example.appbooking.page.DashboardActivity;
import com.example.booking.Model.TaiKhoan;

public class MainActivity extends AppCompatActivity {
    // khai báo tạm thời
    EditText edtUsername, edtPassword;
    Button btnLogIn;
    MySQLite db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /////////////////////// Test //////////////////////////////////////////////////////////
        db = new MySQLite(MainActivity.this, db.DATABASE_NAME, null, 1);
        String kt = db.isTableExists("ksdfj") ? "t" : "f";
        Toast.makeText(this, kt, Toast.LENGTH_SHORT).show();
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenDangNhap = edtUsername.getText().toString().trim();
                String matKhau = edtPassword.getText().toString().trim();
                if (tenDangNhap.length() > 0 && matKhau.length() > 0) {
                    TaiKhoan taiKhoan = db.kiemTraDangNhap(tenDangNhap, matKhau);
                    String msg = taiKhoan.getRole() == 0 ? "dung" : "sai";
//                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    if (taiKhoan.getId() >= 0 && taiKhoan.getRole() >= 0) {
                        if (taiKhoan.getRole() == 0) {
                            Intent intentQuanTri = new Intent(MainActivity.this, DashboardActivity.class);
                            intentQuanTri.putExtra("taiKhoan", taiKhoan);
                            startActivity(intentQuanTri);
                        }
                        if (taiKhoan.getRole() == 1) {
                            Intent intentDatHang = new Intent(MainActivity.this, DashboardActivity.class);
                            intentDatHang.putExtra("taiKhoan", taiKhoan);
                            startActivity(intentDatHang);
                        }
                    } else Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(MainActivity.this, "Vui lòng nhập tài khoản và mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });


            /////////////////////// Test /////////////////////////////////////////////////////////

    }
}