package org.corporateforce.server.rest;

import java.util.Date;
import java.util.List;

import org.corporateforce.server.dao.HolidaysorgDao;
import org.corporateforce.server.model.Holidaysorg;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Holidaysorg")
public class HolidaysorgRest extends AbstractRest<Holidaysorg, HolidaysorgDao>   {
	
	@RequestMapping(value = "/listByRangeOverlap/{startDate}/{endDate}", method = RequestMethod.GET)
	public @ResponseBody List<Holidaysorg> listByRangeOverlap(
			@PathVariable("startDate") @DateTimeFormat(iso=ISO.DATE) Date startDate, 
			@PathVariable("endDate") @DateTimeFormat(iso=ISO.DATE)  Date endDate
	) throws Exception {
		List<Holidaysorg> entities = null;
		try {
			entities = daoService.listByRangeOverlap(startDate, endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
