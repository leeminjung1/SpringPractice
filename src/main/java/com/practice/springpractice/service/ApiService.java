package com.practice.springpractice.service;

import com.practice.springpractice.entity.Domain;
import com.practice.springpractice.entity.User;
import com.practice.springpractice.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final ApiRepository repository;

    public void init(String jsonData) {
        try {
            JSONObject jObj;
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);
            JSONObject parseResponse = (JSONObject) jsonObject.get("response");
            JSONObject parseBody = (JSONObject) parseResponse.get("body");
            JSONArray array = (JSONArray) parseBody.get("items");

            for(int i=0; i<array.size(); i++) {
                jObj = (JSONObject) array.get(i);

                repository.save(Domain.builder()
                        .fshlcNm(jObj.get("fshlcNm").toString())
                        .fshlcType(jObj.get("fshlcType").toString())
                        .rdnmadr(jObj.get("rdnmadr").toString())
                        .lnmadr(jObj.get("lnmadr").toString())
                        .latitude(jObj.get("latitude").toString())
                        .longitude(jObj.get("longitude").toString())
                        .fshlcPhoneNumber(jObj.get("fshlcPhoneNumber").toString())
                        .waterAr(jObj.get("waterAr").toString())
                        .kdfsh(jObj.get("kdfsh").toString())
                        .aceptncCo(jObj.get("aceptncCo").toString())
                        .wtrcFcltyType(jObj.get("wtrcFcltyType").toString())
                        .useCharge(jObj.get("useCharge").toString())
                        .mainPoint(jObj.get("mainPoint").toString())
                        .safentl(jObj.get("safentl").toString())
                        .cvntl(jObj.get("cvntl").toString())
                        .cfrTrrsrt(jObj.get("cfrTrrsrt").toString())
                        .phoneNumber(jObj.get("phoneNumber").toString())
                        .institutionNm(jObj.get("institutionNm").toString())
                        .referenceDate(jObj.get("referenceDate").toString())
                        .insttCode(jObj.get("insttCode").toString())
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
