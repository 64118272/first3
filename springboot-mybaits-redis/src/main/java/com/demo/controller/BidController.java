package com.demo.controller;

import com.demo.model.po.Bid;
import com.demo.model.po.qc.BidQc;
import com.demo.mapper.BidMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bid")
public class BidController {
    static Logger logger = LoggerFactory.getLogger(BidController.class);

    @Autowired
    BidMapper bidMapper;

    @GetMapping("/{id}")
    public Bid getBidById(@PathVariable("id") Integer id) {
        Bid bid = bidMapper.getBidById(id);

        logger.info(bid.toString());

        return bid;
    }

    @GetMapping("/title")
    public List<Bid> getBidByTitle(String title) {
        return bidMapper.getBidByTitle(title);
    }

    @GetMapping("/add")
    public Bid insertBid(Bid bid) {
        bidMapper.insertBid(bid);

        return bid;
    }

    @GetMapping("/count")
    public int getcount() {
        return bidMapper.getCount();
    }

    @GetMapping("/sum/amount")
    public double getAmountSum(String title) {
        return bidMapper.getAmountSum(title);
    }

    @GetMapping("/qc")
    public List<Bid> getBidByQc(BidQc qc) {
        return bidMapper.getBidByQc(qc);
    }

    @GetMapping("/map")
    public List<Bid> getBidByMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("title", "黄惊水");
        map.put("amount", "100.88");

        return bidMapper.getBidByMap(map);
    }

    @GetMapping("/like/title")
    public List<Bid> getBidByTitle1(String title) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);

        return bidMapper.getBidLikeTitle(map);
    }

    @GetMapping("/update")
    public Bid updateBid(Bid bid) {

        bidMapper.dynamicUpdate(bid);

        return bid;
    }

    @GetMapping("/in")
    public List<Bid> getBidByIn(Integer id1, Integer id2, Integer id3) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(id1);
        list.add(id2);
        list.add(id3);
        map.put("in_qc", list);

        return bidMapper.getBidByIn(map);
    }

    @GetMapping("/insertBatch")
    public int insertBatch() {
        Map<String, Object> map = new HashMap<>();
        List<Bid> pList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Bid tmp = new Bid();
            tmp.setAmount(i + 1.1);
            tmp.setUserId(i % 10);
            tmp.setTitle("交学费" + i);
            pList.add(tmp);
        }

        map.put("pList", pList);

        return bidMapper.insertBatch(map);
    }

    @GetMapping("/user/{id}")
    public Bid getUserByBidRM(@PathVariable("id") Integer id){
        return bidMapper.getUserByBid(id);
    }

    @GetMapping("/userAndBills")
    public Bid getuserAndBillsByBidId(Integer id){
        return bidMapper.getuserAndBillsByBidId(id);
    }
}

