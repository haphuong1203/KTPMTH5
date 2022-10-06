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




}
