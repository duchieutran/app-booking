package com.example.appbooking.Model

import java.io.Serializable
import java.sql.Date


class Thue : Serializable {
    var maDon: Int
    var maPhong: Int
    var checkOut: Date? = null

    constructor() {
        this.maDon = -1
        this.maPhong = -1
    }

    constructor(maDon: Int, maPhong: Int, checkOut: Date?) {
        this.maDon = maDon
        this.maPhong = maPhong
        this.checkOut = checkOut
    }

    override fun toString(): String {
        return "Thue{" +
                "maDon=" + maDon +
                ", maPhong=" + maPhong +
                ", checkOut=" + checkOut +
                '}'
    }
}
