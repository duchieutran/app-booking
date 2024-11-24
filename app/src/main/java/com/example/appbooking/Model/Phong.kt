package com.example.appbooking.Model

import java.io.Serializable

class Phong : Serializable {
    var maPhong: Int = 0
    var viTri: String? = null
    var maLoaiPhong: Int = 0

    constructor()

    constructor(maPhong: Int, viTri: String?, maLoaiPhong: Int) {
        this.maPhong = maPhong
        this.viTri = viTri
        this.maLoaiPhong = maLoaiPhong
    }

    override fun toString(): String {
        return "Phong{" +
                "maPhong=" + maPhong +
                ", viTri='" + viTri + '\'' +
                ", maLoaiPhong=" + maLoaiPhong +
                '}'
    }
}