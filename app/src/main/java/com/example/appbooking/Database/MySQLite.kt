package com.example.appbooking.Database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.booking.Model.TaiKhoan
import com.example.appbooking.R

class MySQLite(context: Context, dbName: String, cursorFactory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, dbName, cursorFactory, version) {

    companion object {
        const val DATABASE_NAME = "Booking.sql"
    }

    init {
        // create table
        createTable("TAI_KHOAN", """
            id INTEGER PRIMARY KEY AUTOINCREMENT, 
            username VARCHAR(255), password VARCHAR(255), 
            name VARCHAR(255), email VARCHAR(255), sdt VARCHAR(255), 
            cccd VARCHAR(255), address VARCHAR(255), role INTEGER, 
            hinh VARCHAR(255)
        """)

        createTable("LOAI_PHONG", """
            ma_loai_phong INTEGER PRIMARY KEY AUTOINCREMENT, 
            ten VARCHAR(255), 
            gia INTEGER, 
            so_nguoi_toi_da INTEGER, 
            mo_ta text
        """)

        createTable("PHONG", """
            ma_phong INTEGER PRIMARY KEY AUTOINCREMENT, 
            vi_tri VARCHAR(255),
            ma_loai_phong integer,
            FOREIGN KEY (ma_loai_phong) REFERENCES LOAI_PHONG(ma_loai_phong)
        """)

        createTable("CHI_TIET_LOAI_PHONG", """
            id INTEGER PRIMARY KEY AUTOINCREMENT, 
            ma_loai_phong INTEGER, 
            hinh VARCHAR(255), 
            FOREIGN KEY (ma_loai_phong) REFERENCES LOAI_PHONG(ma_loai_phong)
        """)

        createTable("TIEN_NGHI", """
            ma_tien_nghi integer primary key autoincrement,
            ten_tien_nghi varchar(255),
            ic_mo_ta varchar(255)
        """)

        createTable("CO_TIEN_NGHI", """
            ma_tien_nghi INTEGER, 
            ma_loai_phong INTEGER, 
            PRIMARY KEY (ma_tien_nghi, ma_loai_phong), 
            FOREIGN KEY (ma_tien_nghi) REFERENCES TIEN_NGHI(ma_tien_nghi), 
            FOREIGN KEY (ma_loai_phong) REFERENCES LOAI_PHONG(ma_loai_phong)
        """)

        createTable("DON", """
            ma_don INTEGER PRIMARY KEY AUTOINCREMENT, 
            check_in DATE, 
            ma_nhan_vien_nhap_phieu INTEGER, 
            ngay_lap_phieu DATE, 
            FOREIGN KEY (ma_nhan_vien_nhap_phieu) REFERENCES TAI_KHOAN(id)
        """)

        createTable("THUE", """
            ma_don INTEGER, 
            ma_phong INTEGER, 
            check_out DATE, 
            PRIMARY KEY (ma_don, ma_phong), 
            FOREIGN KEY (ma_don) REFERENCES DON(ma_don), 
            FOREIGN KEY (ma_phong) REFERENCES PHONG(ma_phong)
        """)

        createTable("HOA_DON", """
            ma_hoa_don INTEGER PRIMARY KEY AUTOINCREMENT, 
            ma_don INTEGER UNIQUE, 
            ngay_thanh_toan DATE, 
            so_tien_thanh_toan INTEGER, 
            FOREIGN KEY (ma_don) REFERENCES DON(ma_don)
        """)

        createTable("CHI_TIET_DANH_GIA", """
            ma_danh_gia INTEGER PRIMARY KEY AUTOINCREMENT, 
            ma_don INTEGER UNIQUE, 
            ngay_danh_gia DATE, 
            danh_gia_chat_luong_phong INTEGER, 
            danh_gia_chat_luong_dich_vu INTEGER, 
            danh_gia_sach_se INTEGER, 
            danh_gia_nhan_vien_phuc_vu INTEGER, 
            danh_gia_tien_nghi INTEGER, 
            mo_ta_chi_tiet VARCHAR, 
            FOREIGN KEY (ma_don) REFERENCES DON(ma_don)
        """)

        createTable("QUAN_LY", """
            ma_nhan_vien INTEGER, 
            ma_don INTEGER, 
            is_thanh_toan BOOLEAN, 
            is_duyet BOOLEAN, 
            is_dat_coc BOOLEAN, 
            PRIMARY KEY (ma_don, ma_nhan_vien), 
            FOREIGN KEY (ma_don) REFERENCES DON(ma_don), 
            FOREIGN KEY (ma_nhan_vien) REFERENCES TAI_KHOAN(id)
        """)

        createTable("UU_DAI", """
            ma_nhan_vien INTEGER, 
            ma_uu_dai INTEGER PRIMARY KEY AUTOINCREMENT, 
            ngay_bat_dau DATE, 
            ngay_het_han DATE, 
            giam DECIMAL(10, 2), 
            dieu_kien_ve_gia INTEGER, 
            ap_dung_cho INTEGER, 
            FOREIGN KEY (ma_nhan_vien) REFERENCES TAI_KHOAN(id)
        """)

        createTable("CHI_TIET_UU_DAI", """
            id INTEGER PRIMARY KEY AUTOINCREMENT, 
            ma_uu_dai INTEGER, 
            hinh VARCHAR(255), 
            FOREIGN KEY (ma_uu_dai) REFERENCES UU_DAI(ma_uu_dai)
        """)

        createTable("AP_MA", """
            ma_don INTEGER, 
            ma_uu_dai INTEGER, 
            ngay_ap_ma DATE, 
            PRIMARY KEY (ma_don, ma_uu_dai), 
            FOREIGN KEY (ma_don) REFERENCES DON(ma_don), 
            FOREIGN KEY (ma_uu_dai) REFERENCES UU_DAI(ma_uu_dai)
        """)

        // insert data
        insertDataTaiKhoan("admin", "123456","Nguyễn Văn A", "quantri@gmail.com", "0123456789", "001204014888", "Hà Nội", "baseline_person_24")
        insertDataTaiKhoan("user1", "123456","Trần Văn B", "nhanvien@gmail.com", "0123456989", "001204015888", "Hà Nội", "baseline_person_24")
        insertDataTaiKhoan("user2", "123456","Trần Văn C", "nhanvien1@gmail.com", "0123456988", "001204015488", "Hà Nội", "baseline_person_24")

        insertDataLoaiPhong("Phòng Standard", 2000000, 3, """
            Loại phòng Vip 1
        """)
        insertDataLoaiPhong("Phòng Superior", 2043000, 3, """
            Loại phòng Vip 2
        """)
        insertDataLoaiPhong("Phòng Deluxe", 7043000, 3, """
            Loại phòng Vip 3
        """)
        insertDataLoaiPhong("Phòng Suite", 10043000, 3, """
            Loại phòng Vip 4
        """)

        insertDataPhong("P101", 1)
        insertDataPhong("P102", 1)
        insertDataPhong("P103", 1)
        insertDataPhong("P201", 2)
        insertDataPhong("P202", 2)
        insertDataPhong("P203", 2)
        insertDataPhong("P301", 3)
        insertDataPhong("P302", 3)
        insertDataPhong("P303", 3)
        insertDataPhong("P401", 4)
        insertDataPhong("P402", 4)
        insertDataPhong("P403", 4)

        insertDataChiTietLoaiPhong(1, "v1_1"); // v1 vip 1
        insertDataChiTietLoaiPhong(1, "v1_2");
        insertDataChiTietLoaiPhong(1, "v1_3");
        insertDataChiTietLoaiPhong(2, "v2_1");
        insertDataChiTietLoaiPhong(2, "v2_2");
        insertDataChiTietLoaiPhong(2, "v2_3");
        insertDataChiTietLoaiPhong(3, "v3_1");
        insertDataChiTietLoaiPhong(3, "v3_2");
        insertDataChiTietLoaiPhong(3, "v3_3");
        insertDataChiTietLoaiPhong(4, "v4_1");
        insertDataChiTietLoaiPhong(4, "v4_2");
        insertDataChiTietLoaiPhong(4, "v4_3");
    }

    fun querySQL(sql: String) {
        writableDatabase.execSQL(sql)
    }

    fun getDataFromSQL(sql: String): Cursor {
        return readableDatabase.rawQuery(sql, null)
    }

    fun createTable(tableName: String, columns: String) {
        querySQL("CREATE TABLE IF NOT EXISTS $tableName ($columns);")
    }

    fun insertDataTaiKhoan(username: String, password: String, name: String, email: String, sdt: String, cccd: String, address: String, tenAnh: String) {
        val cursor = getDataFromSQL("SELECT COUNT(id) FROM TAI_KHOAN WHERE username = '$username';")
        if (cursor.moveToNext() && cursor.getInt(0) <= 0) {
            val sql = """
            INSERT INTO TAI_KHOAN 
            VALUES (NULL, '$username', '$password', '$name', '$email', '$sdt', '$cccd', '$address', 0, 'android.resource://${R::class.java.`package`.name}/$tenAnh');
        """
            querySQL(sql)
        }
    }

    fun insertDataLoaiPhong(ten: String, gia: Int, soNguoiToiDa: Int, moTa: String) {
        val cursor = getDataFromSQL("SELECT COUNT(*) FROM LOAI_PHONG WHERE ten = '$ten';")
        if (cursor.moveToNext() && cursor.getInt(0) <= 0) {
            val sql = """
            INSERT INTO LOAI_PHONG 
            VALUES (NULL, '$ten', $gia, $soNguoiToiDa, '$moTa');
        """
            querySQL(sql)
        }
    }

    fun insertDataPhong(viTri: String, maLoaiPhong: Int) {
        val cursor = getDataFromSQL("SELECT COUNT(*) FROM PHONG WHERE vi_tri = '$viTri';")
        if (cursor.moveToNext() && cursor.getInt(0) <= 0) {
            val sql = """
            INSERT INTO PHONG 
            VALUES (NULL, '$viTri', $maLoaiPhong);
        """
            querySQL(sql)
        }
    }

//    fun insertDataDon(viTri: String, maLoaiPhong: Int) {
//        val cursor = getDataFromSQL("SELECT COUNT(*) FROM DON WHERE ten = '$viTri';")
//        if (cursor.moveToNext() && cursor.getInt(0) <= 0) {
//            val sql = """
//            INSERT INTO DON
//            VALUES (NULL, '$viTri', $maLoaiPhong);
//        """
//            querySQL(sql)
//        }
//    }

    fun insertDataChiTietLoaiPhong(maLoaiPhong: Int, hinh: String){
        val cursor = getDataFromSQL("SELECT COUNT(*) FROM CHI_TIET_LOAI_PHONG WHERE ma_loai_phong = $maLoaiPhong and hinh = '$hinh';")
        if (cursor.moveToNext() && cursor.getInt(0) <= 0) {
            val sql = """
            INSERT INTO CHI_TIET_LOAI_PHONG 
            VALUES (NULL, $maLoaiPhong, 'android.resource://${R::class.java.`package`.name}/$hinh');
        """
            querySQL(sql)
        }
    }

    fun kiemTraDangNhap(tenDangNhap: String, matKhau: String): TaiKhoan {
        val cursor = getDataFromSQL("SELECT * FROM TAI_KHOAN WHERE username = '$tenDangNhap' AND password = '$matKhau'")
        return if (cursor.moveToNext()) {
            TaiKhoan(
                cursor.getInt(0), cursor.getInt(8), cursor.getString(1), cursor.getString(2),
                cursor.getString(4), cursor.getString(7), cursor.getString(5), cursor.getString(6),
                cursor.getString(3), cursor.getString(9)
            )
        } else {
            TaiKhoan()
        }
    }

    fun docDuLieuTaiKhoan(sql: String): ArrayList<TaiKhoan> {
        val listTaiKhoan = ArrayList<TaiKhoan>()
        val cursor = getDataFromSQL(sql)
        while (cursor.moveToNext()) {
            listTaiKhoan.add(
                TaiKhoan(
                cursor.getInt(0), cursor.getInt(8), cursor.getString(1), cursor.getString(2),
                cursor.getString(4), cursor.getString(7), cursor.getString(5), cursor.getString(6),
                cursor.getString(3), cursor.getString(9)
                )
            )
        }
        return listTaiKhoan
    }

    fun isTableExists(tableName: String): Boolean {
        val query = "SELECT name FROM sqlite_master WHERE type='table' AND name=?"
        val cursor = getDataFromSQL(query)
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}
