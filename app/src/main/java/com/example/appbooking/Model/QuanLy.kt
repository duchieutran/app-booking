package com.example.appbooking.Model
import java.io.Serializable

class QuanLy : Serializable {
    var maNhanVien: Int
    var maDon: Int
    var isThanhToan: Boolean = false
    var isDuyet: Boolean = false
    var isDatCoc: Boolean = false

    constructor() {
        this.maNhanVien = -1
        this.maDon = -1
    }

    constructor(
        maNhanVien: Int,
        maDon: Int,
        isThanhToan: Boolean,
        isDuyet: Boolean,
        isDatCoc: Boolean
    ) {
        this.maNhanVien = maNhanVien
        this.maDon = maDon
        this.isThanhToan = isThanhToan
        this.isDuyet = isDuyet
        this.isDatCoc = isDatCoc
    }

    override fun toString(): String {
        return "QuanLy{" +
                "maNhanVien=" + maNhanVien +
                ", maDon=" + maDon +
                ", isThanhToan=" + isThanhToan +
                ", isDuyet=" + isDuyet +
                ", isDatCoc=" + isDatCoc +
                '}'
    }
}