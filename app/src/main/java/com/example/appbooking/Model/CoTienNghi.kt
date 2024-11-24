package com.example.appbooking.Model

class CoTienNghi {
    var ma_tien_nghi: Int = 0
    var ma_loai_phong: Int = 0
    constructor(){}
    constructor(ma_loai_phong: Int, ma_tien_nghi: Int) {
        this.ma_loai_phong = ma_loai_phong
        this.ma_tien_nghi = ma_tien_nghi
    }

    override fun toString(): String {
        return "CoTienNghi(ma_tien_nghi=$ma_tien_nghi, ma_loai_phong=$ma_loai_phong)"
    }

}