package com.example.appbooking.Model

import java.io.Serializable
import java.sql.Date


class ChiTietDanhGia : Serializable {
    var maDanhGia: Int
    var maDon: Int
    var danhGiaChatLuongPhong: Int = 0
    var danhGiaChatLuongDichVu: Int = 0
    var danhGiaSachSe: Int = 0
    var danhGiaNhanVienPhucVu: Int = 0
    var danhGiaTienNghi: Int = 0
    var moTaChiTiet: String? = null
    var ngayDanhGia: Date? = null

    constructor() {
        this.maDanhGia = -1
        this.maDon = -1
    }

    constructor(
        maDanhGia: Int, maDon: Int, ngayDanhGia: Date?, danhGiaChatLuongPhong: Int,
        danhGiaChatLuongDichVu: Int, danhGiaSachSe: Int, danhGiaNhanVienPhucVu: Int,
        danhGiaTienNghi: Int, moTaChiTiet: String?
    ) {
        this.maDanhGia = maDanhGia
        this.maDon = maDon
        this.ngayDanhGia = ngayDanhGia
        this.danhGiaChatLuongPhong = danhGiaChatLuongPhong
        this.danhGiaChatLuongDichVu = danhGiaChatLuongDichVu
        this.danhGiaSachSe = danhGiaSachSe
        this.danhGiaNhanVienPhucVu = danhGiaNhanVienPhucVu
        this.danhGiaTienNghi = danhGiaTienNghi
        this.moTaChiTiet = moTaChiTiet
    }

    override fun toString(): String {
        return "ChiTietDanhGia{" +
                "maDanhGia=" + maDanhGia +
                ", maDon=" + maDon +
                ", ngayDanhGia=" + ngayDanhGia +
                ", danhGiaChatLuongPhong=" + danhGiaChatLuongPhong +
                ", danhGiaChatLuongDichVu=" + danhGiaChatLuongDichVu +
                ", danhGiaSachSe=" + danhGiaSachSe +
                ", danhGiaNhanVienPhucVu=" + danhGiaNhanVienPhucVu +
                ", danhGiaTienNghi=" + danhGiaTienNghi +
                ", moTaChiTiet='" + moTaChiTiet + '\'' +
                '}'
    }
}
