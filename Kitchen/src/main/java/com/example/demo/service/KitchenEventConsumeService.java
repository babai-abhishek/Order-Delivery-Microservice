package com.example.demo.service;

import com.example.demo.entity.Hamburger;
import com.example.demo.entity.Orders;
import com.example.demo.entity.type.OrderStatusType;
import com.example.demo.repository.HamburgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KitchenEventConsumeService {

    @Autowired
    HamburgerRepository hamburgerRepository;

    public void addHamburger(Hamburger hams)
    {
        for(int i=0;i<hams.getQuantity();i++)
        {
            Hamburger hamburger=new Hamburger();
            hamburger.setHamburgerType(hams.getHamburgerType());
            hamburgerRepository.save(hamburger);
        }
    }


    public synchronized boolean process(Orders order) {

        List<Hamburger> hamburgers= order.getHamburgerList();
        List<Hamburger> candidatesHamburger=new ArrayList<>();

        for(Hamburger ham:hamburgers)
        {
            List<Hamburger> hamburgerList= hamburgerRepository.findByHamburgerTypeIs(ham.getHamburgerType());

            if(hamburgerList!=null&&hamburgerList.size()>=ham.getQuantity())
            {

                int i=0;
                for(Hamburger hamburger:hamburgerList) {
                    ++i;
                    candidatesHamburger.add(hamburger);
                    if(i==ham.getQuantity())
                        break;

                }
            }
            else {

                order.setOrderStatus(OrderStatusType.ABORTED);
                order.setStatusDescription(ham.getHamburgerType().getDescription()+" finished, only "+hamburgerList.size()+" in the fridge");
                return false;
            }
        }
        order.setOrderStatus(OrderStatusType.COOKING);
        order.setStatusDescription("Order in cooking");
        for(Hamburger hamburger:candidatesHamburger)
        {
            hamburgerRepository.deleteById(hamburger.get_id());
        }

        return true;
    }
}
