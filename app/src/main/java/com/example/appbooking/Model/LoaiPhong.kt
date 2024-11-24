package com.example.appbooking.Model

import java.io.Serializable

class LoaiPhong : Serializable {
    var maLoaiPhong: Int = 0
    var ten: String? = null
    var gia: Int = 0
    var soNguoiToiDa: Int = 0
    var moTa: String? = null

    constructor()

    constructor(maLoaiPhong: Int, ten: String?, gia: Int, soNguoiToiDa: Int, moTa: String?) {
        this.maLoaiPhong = maLoaiPhong
        this.ten = ten
        this.gia = gia
        this.soNguoiToiDa = soNguoiToiDa
        this.moTa = moTa
    }

    override fun toString(): String {
        return "LoaiPhong{" +
                "maLoaiPhong=" + maLoaiPhong +
                ", ten='" + ten + '\'' +
                ", gia=" + gia +
                ", soNguoiToiDa=" + soNguoiToiDa +
                ", moTa='" + moTa + '\'' +
                '}'
    }
}
//            ma_loai_phong INTEGER PRIMARY KEY AUTOINCREMENT,
//            ten VARCHAR(255),
//            gia INTEGER,
//            so_nguoi_toi_da INTEGER,
//            mo_ta VARCHAR(255)