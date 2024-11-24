package com.example.booking.Model

import java.io.Serializable

class TaiKhoan : Serializable {
    var id: Int
    var role: Int
    var username: String? = null
    var password: String? = null
    var email: String? = null
    var address: String? = null
    var sdt: String? = null
    var cccd: String? = null
    var name: String? = null
    var hinh: String? = null

    constructor() {
        this.id = -1
        this.role = -1
    }

    constructor(
        id: Int,
        role: Int,
        username: String?,
        password: String?,
        email: String?,
        address: String?,
        sdt: String?,
        cccd: String?,
        name: String?,
        hinh: String?
    ) {
        this.id = id
        this.role = role
        this.username = username
        this.password = password
        this.email = email
        this.address = address
        this.sdt = sdt
        this.cccd = cccd
        this.name = name
        this.hinh = hinh
    }

    override fun toString(): String {
        return "TaiKhoan{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", sdt='" + sdt + '\'' +
                ", cccd='" + cccd + '\'' +
                ", name='" + name + '\'' +
                ", hinh='" + hinh + '\'' +
                '}'
    }
}


