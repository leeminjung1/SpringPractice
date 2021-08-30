package com.practice.springpractice.controller;

import com.practice.springpractice.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
public class APIController {

    private final ApiService apiService;

    @GetMapping("/api")
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();

        String urlStr = "http://api.data.go.kr/openapi/tn_pubr_public_fshlc_api?" +
                "serviceKey=vvI1eRoUVqLd4Xlnz0AGQUplGPvq%2FmVrELb6oju0vbsPHJCSgFZc%2ByrGe4Xt40ES%2FDjAuggE%2FuU%2FEas0NbqPdw%3D%3D" +
                "&pageNo=0" +
                "&numOfRows=5" +
                "&type=json";
        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        String returnLine;

        while((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n\r");
        }

        urlConnection.disconnect();

        apiService.init(result.toString());
        return result.toString();
    }

}
