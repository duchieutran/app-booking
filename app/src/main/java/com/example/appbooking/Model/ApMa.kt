package com.example.appbooking.Model

import java.io.Serializable
import java.util.Date


class ApMa : Serializable {
    var maDon: Int
    var maUuDai: Int
    var ngayApMa: Date? = null

    constructor() {
        this.maDon = -1
        this.maUuDai = -1
    }

    constructor(maDon: Int, maUuDai: Int, ngayApMa: Date?) {
        this.maDon = maDon
        this.maUuDai = maUuDai
        this.ngayApMa = ngayApMa
    }

    override fun toString(): String {
        return "ApMa{" +
                "maDon=" + maDon +
                ", maUuDai=" + maUuDai +
                ", ngayApMa=" + ngayApMa +
                '}'
    }
}
