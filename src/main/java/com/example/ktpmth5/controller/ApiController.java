package com.example.ktpmth5.controller;


import com.example.ktpmth5.entity.ChuyenBay;
import com.example.ktpmth5.entity.NhanVien;
import com.example.ktpmth5.repository.ChuyenBayRepository;
import com.example.ktpmth5.repository.MayBayRepository;
import com.example.ktpmth5.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ChuyenBayRepository chuyenBayRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Autowired
    MayBayRepository mayBayRepository;

    //Cau 1
    @RequestMapping(value = "/cau1/{gaden}", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDen(@PathVariable("gaden") String gaDen) {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDen(gaDen);
        if (chuyenBays == null) {
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }

    //Cau 2
    @RequestMapping(value = "/cau2", method = RequestMethod.GET)
    public List<String> mayBayCoTamBayLonHon10000() {
        List<String> mayBays = mayBayRepository.findLoaiMayBayByTamBay();
        if (mayBays == null) {
            ResponseEntity.notFound().build();
        }
        return mayBays;
    }

    //Cau 3
    @RequestMapping(value = "/cau3", method = RequestMethod.GET)
    public List<NhanVien> timNhanVienTheoLuong() {
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByLuong();
        if (nhanViens == null) {
            ResponseEntity.notFound().build();
        }
        return nhanViens;
    }

    //Cau 4
    @RequestMapping(value = "/cau4", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiDoDai() {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByDoDai();
        if (chuyenBays == null) {
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }

    //Cau 5
    @RequestMapping(value = "/cau5", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDenVaGaDi() {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDiVaGaDen();
        if (chuyenBays == null) {
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }

    //Cau 6
    @RequestMapping(value = "/cau6/{gaDi}", method = RequestMethod.GET)
    public String soChuyenBayXuatPhatTuSaiGon(@PathVariable("gaDi") String gaDi) {
        int soChuyenBay = chuyenBayRepository.findChuyenBayByGaDi(gaDi);
        if (soChuyenBay == 0) {
            ResponseEntity.notFound().build();
        }
        return "Có " + soChuyenBay + " chuyến bay xuất phát từ Sài Gòn";
    }

    //Cau 7
    @RequestMapping(value = "/cau7", method = RequestMethod.GET)
    public String soLoaiMayBayBoeing() {
        int soLoaiMayBay = mayBayRepository.findLoaiMayBay();
        if (soLoaiMayBay == 0) {
            ResponseEntity.notFound().build();
        }
        return "Tổng số " + soLoaiMayBay + " máy bay Boeing";
    }

    //Cau 8
    @RequestMapping(value = "/cau8", method = RequestMethod.GET)
    public String tongSoLuongNhanVien() {
        int soLuong = nhanVienRepository.tinhTongLuong();
        if (soLuong == 0) {
            ResponseEntity.notFound().build();
        }
        return "số lương các nhân viên" + soLuong;
    }






}
