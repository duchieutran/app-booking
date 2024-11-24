package com.example.appbooking.Model

class TienNghi {
    var ma_tien_nghi: Int = -1
    var tenTienNghi: String? = null
    var ic_mo_ta: String? = null

    constructor(){
    }
    constructor(ic_mo_ta: String?, tenTienNghi: String?, ma_tien_nghi: Int) {
        this.ic_mo_ta = ic_mo_ta
        this.tenTienNghi = tenTienNghi
        this.ma_tien_nghi = ma_tien_nghi
    }

    override fun toString(): String {
        return "TienNghi(ma_tien_nghi=$ma_tien_nghi, tenTienNghi=$tenTienNghi, ic_mo_ta=$ic_mo_ta)"
    }

}