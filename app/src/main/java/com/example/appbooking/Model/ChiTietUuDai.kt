package com.example.appbooking.Model

import java.io.Serializable


class ChiTietUuDai : Serializable {
    var id: Int
    var maUuDai: Int
    var hinh: String? = null

    constructor() {
        this.id = -1
        this.maUuDai = -1
    }

    constructor(id: Int, maUuDai: Int, hinh: String?) {
        this.id = id
        this.maUuDai = maUuDai
        this.hinh = hinh
    }

    override fun toString(): String {
        return "ChiTietUuDai{" +
                "id=" + id +
                ", maUuDai=" + maUuDai +
                ", hinh='" + hinh + '\'' +
                '}'
    }
}
