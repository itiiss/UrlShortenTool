package com.example.demo.service;
import com.example.demo.Util.UrlTransUtil;
import com.example.demo.dao.UrlRepo;
import com.example.demo.entity.UrlDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class shortUrlService {

    @Autowired
    private UrlRepo urlRepo;

    public String shortToLong(String shortString) {
        long id = UrlTransUtil.toDecimal(shortString);
        Optional<UrlDO> findById = urlRepo.findById(id);
        if(findById.isPresent()){
            return findById.get().getUrl();
        }else {
            return null;
        }
    }

    public String longToShort(String longString) {
        UrlDO prev =  urlRepo.findByLongUrl(longString);
        if(prev == null) {
            UrlDO urlDO = new UrlDO();
            urlDO.setUrl(longString);
            urlDO = urlRepo.save(urlDO);
            return UrlTransUtil.toMixin(urlDO.getId());
        }
        return UrlTransUtil.toMixin(prev.getId());
    }

}
