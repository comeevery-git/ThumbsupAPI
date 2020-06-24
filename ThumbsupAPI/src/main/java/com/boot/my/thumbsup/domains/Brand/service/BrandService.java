package com.boot.my.thumbsup.domains.Brand.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class BrandService{
	private static String BRAND_LIST_URL = "https://store.musinsa.com/app/contents/brandshop";

	@PostConstruct
	public void getKoreaCovidDatas() throws IOException {

        Document doc = Jsoup.connect(BRAND_LIST_URL).get();
        
        //파싱
        Elements contents = doc.select("div.brand_name_container");
        
        for(Element el : contents.select("div.brand_name_container ul li dl dt")) {    //

            System.out.println("ENG@@@@@@@@@@@@@@@" +el.text());

        }
        
        for(Element el : contents.select("div.brand_name_container ul li dl dd")) {    //

            System.out.println("KOR#############"+el.text());

        }
        //System.out.println("BRAND SERVICE DOC ::::: " +doc);

  }
}
