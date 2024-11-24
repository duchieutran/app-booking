package com.example.appbooking.Model

import java.io.Serializable


class ChiTietLoaiPhong : Serializable {
    var id: Int
    var maLoaiPhong: Int
    var hinh: String? = null

    constructor() {
        this.id = -1
        this.maLoaiPhong = -1
    }

    constructor(id: Int, maLoaiPhong: Int, hinh: String?) {
        this.id = id
        this.maLoaiPhong = maLoaiPhong
        this.hinh = hinh
    }

    override fun toString(): String {
        return "ChiTietLoaiPhong{" +
                "id=" + id +
                ", maLoaiPhong=" + maLoaiPhong +
                ", hinh='" + hinh + '\'' +
                '}'
    }
}
