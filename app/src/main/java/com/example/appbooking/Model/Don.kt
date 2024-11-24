package com.example.appbooking.Model

import java.io.Serializable
import java.sql.Date


class Don : Serializable {
    var maDon: Int
    var maNhanVienNhapPhieu: Int
    var checkIn: Date? = null
    var ngayLapPhieu: Date? = null

    constructor() {
        this.maDon = -1
        this.maNhanVienNhapPhieu = -1
    }

    constructor(maDon: Int, checkIn: Date?, maNhanVienNhapPhieu: Int, ngayLapPhieu: Date?) {
        this.maDon = maDon
        this.checkIn = checkIn
        this.maNhanVienNhapPhieu = maNhanVienNhapPhieu
        this.ngayLapPhieu = ngayLapPhieu
    }

    override fun toString(): String {
        return "Don{" +
                "maDon=" + maDon +
                ", checkIn=" + checkIn +
                ", maNhanVienNhapPhieu=" + maNhanVienNhapPhieu +
                ", ngayLapPhieu=" + ngayLapPhieu +
                '}'
    }
}
