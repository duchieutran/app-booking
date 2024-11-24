package com.example.appbooking.Model

import java.io.Serializable
import java.util.Date


class UuDai : Serializable {
    var maNhanVien: Int
    var maUuDai: Int
    var ngayBatDau: Date? = null
    var ngayHetHan: Date? = null
    var giam: Double = 0.0
    var dieuKienVeGia: Int = 0
    var apDungCho: Int = 0

    constructor() {
        this.maNhanVien = -1
        this.maUuDai = -1
    }

    constructor(
        maNhanVien: Int,
        maUuDai: Int,
        ngayBatDau: Date?,
        ngayHetHan: Date?,
        giam: Double,
        dieuKienVeGia: Int,
        apDungCho: Int
    ) {
        this.maNhanVien = maNhanVien
        this.maUuDai = maUuDai
        this.ngayBatDau = ngayBatDau
        this.ngayHetHan = ngayHetHan
        this.giam = giam
        this.dieuKienVeGia = dieuKienVeGia
        this.apDungCho = apDungCho
    }

    override fun toString(): String {
        return "UuDai{" +
                "maNhanVien=" + maNhanVien +
                ", maUuDai=" + maUuDai +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayHetHan=" + ngayHetHan +
                ", giam=" + giam +
                ", dieuKienVeGia=" + dieuKienVeGia +
                ", apDungCho=" + apDungCho +
                '}'
    }
}
