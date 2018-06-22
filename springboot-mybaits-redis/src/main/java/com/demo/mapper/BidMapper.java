package com.demo.mapper;

import com.demo.model.po.Bid;
import com.demo.model.po.qc.BidQc;

import java.util.List;
import java.util.Map;

public interface BidMapper {
    public Bid getBidById(Integer id);

    public List<Bid> getBidByTitle(String title);

    public int insertBid(Bid bid);

    public int getCount();

    public double getAmountSum(String title);

    public List<Bid> getBidByQc(BidQc bidQc);

    public List<Bid> getBidByMap(Map map);

    public List<Bid> getBidLikeTitle(Map map);

    public int dynamicUpdate(Bid bid);

    public List<Bid> getBidByIn(Map map);

    public int insertBatch(Map map);

    public Bid getUserByBid(Integer id);

    public Bid getuserAndBillsByBidId(Integer id);
}
