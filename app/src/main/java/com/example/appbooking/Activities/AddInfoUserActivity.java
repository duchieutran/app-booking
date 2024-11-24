package com.example.appbooking.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbooking.R;

import java.io.IOException;

public class AddInfoUserActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final String SHARED_PREFS_NAME = "UserPrefs";
    private static final String KEY_AVATAR_URI = "avatar_uri";

    private ImageView imgAvatar;
    private EditText edtUsername, edtPassword, edtEmail, edtPhone;
    private Button btnLuuThayDoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_user);

        // Ánh xạ các View
        imgAvatar = findViewById(R.id.imgAvata);
        edtUsername = findViewById(R.id.edtTenDangNhap);
        edtPassword = findViewById(R.id.edtMatKhau);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtSDT);
        btnLuuThayDoi = findViewById(R.id.btnLuuThayDoi);

        // Tải thông tin người dùng và hiển thị
        loadUserInfo();

        // Khi nhấn vào avatar, mở thư viện để chọn ảnh mới
        imgAvatar.setOnClickListener(v -> openGallery());

        // Khi nhấn "Lưu", lưu thông tin thay đổi
        btnLuuThayDoi.setOnClickListener(v -> saveUserInfo());
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imgAvatar.setImageBitmap(bitmap);
                saveAvatarUri(imageUri.toString());
                Toast.makeText(this, "Avatar đã được cập nhật", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Có lỗi xảy ra khi chọn ảnh", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveAvatarUri(String uri) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_AVATAR_URI, uri);
        editor.apply();
    }

    private void loadUserInfo() {
        // Lấy thông tin từ Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("sdt");

        // Hiển thị thông tin người dùng
        edtUsername.setText(username);
        edtPassword.setText(password); // Hiển thị mật khẩu
        edtEmail.setText(email);
        edtPhone.setText(phone);
    }

    private void saveUserInfo() {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();

        // Lưu thông tin vào SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.apply();

        Toast.makeText(AddInfoUserActivity.this, "Thông tin đã được lưu!", Toast.LENGTH_SHORT).show();
    }
}
