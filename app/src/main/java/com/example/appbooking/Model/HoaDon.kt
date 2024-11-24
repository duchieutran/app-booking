package com.example.appbooking.Model

import java.io.Serializable
import java.sql.Date


class HoaDon : Serializable {
    var maHoaDon: Int
    var maDon: Int
    var soTienThanhToan: Int
    var ngayThanhToan: Date? = null

    constructor() {
        this.maHoaDon = -1
        this.maDon = -1
        this.soTienThanhToan = 0
    }

    constructor(maHoaDon: Int, maDon: Int, ngayThanhToan: Date?, soTienThanhToan: Int) {
        this.maHoaDon = maHoaDon
        this.maDon = maDon
        this.ngayThanhToan = ngayThanhToan
        this.soTienThanhToan = soTienThanhToan
    }

    override fun toString(): String {
        return "HoaDon{" +
                "maHoaDon=" + maHoaDon +
                ", maDon=" + maDon +
                ", ngayThanhToan=" + ngayThanhToan +
                ", soTienThanhToan=" + soTienThanhToan +
                '}'
    }
}
