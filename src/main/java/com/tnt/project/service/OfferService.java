/**
 * 
 */
package com.tnt.project.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tnt.project.vo.Offer;
import com.tnt.project.vo.OfferCost;
import com.tnt.project.vo.OfferRole;

/**
 * @author vcvr
 *
 */
@FeignClient(name="OFFERSERVICE")
public interface OfferService {

    @RequestMapping(method = RequestMethod.GET, value = "/offers/{offerId}")
    public Offer getOffer(@PathVariable("offerId") Integer offerId);
    
    @RequestMapping(method = RequestMethod.GET, value = "/offers/{offerId}/roles")
    List<OfferRole> getRoles(@PathVariable("offerId") Integer offerId);

    @RequestMapping(method = RequestMethod.GET, value = "/offers/{offerId}/costs")
    List<OfferCost> getCosts(@PathVariable("offerId") Integer offerId);
    
}
