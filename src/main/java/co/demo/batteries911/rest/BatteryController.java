package co.demo.batteries911.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.demo.batteries911.domain.Battery;
import co.demo.batteries911.service.BatteryService;
import co.demo.batteries911.util.Constants;
import co.demo.batteries911.util.Response;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/battery")
public class BatteryController {

	@Autowired
	private BatteryService batteryService;

	static Logger log = Logger.getLogger(BatteryController.class.getName());

	@RequestMapping(method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	Response save(@RequestBody Battery battery) {
		Response response = new Response();
		try {
			this.batteryService.save(battery);
			response.setCode(Constants.CODE_SUCCESS);
			response.setMessage(Constants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			log.error("Error: " + e);
			response.setCode(Constants.CODE_ERROR);
			response.setMessage(Constants.MESSAGE_ERROR);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	Response get() {
		Response response = new Response();
		try {
			response.setData(this.batteryService.findAll());
			response.setCode(Constants.CODE_SUCCESS);
			response.setMessage(Constants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			log.error("Error: " + e);
			response.setCode(Constants.CODE_ERROR);
			response.setMessage(Constants.MESSAGE_ERROR);
		}
		return response;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	Response getById(@RequestBody Battery battery) {
		Response response = new Response();
		try {
			response.setData(this.batteryService.findById(battery.getCdBattery()));
			response.setCode(Constants.CODE_SUCCESS);
			response.setMessage(Constants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			log.error("Error: " + e);
			response.setCode(Constants.CODE_ERROR);
			response.setMessage(Constants.MESSAGE_ERROR);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	@ResponseBody
	Response update(@RequestBody Battery battery) {
		Response response = new Response();
		try {
			this.batteryService.update(battery);
			response.setCode(Constants.CODE_SUCCESS);
			response.setMessage(Constants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			log.error("Error: " + e);
			response.setCode(Constants.CODE_ERROR);
			response.setMessage(Constants.MESSAGE_ERROR);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	@ResponseBody
	Response delete(@RequestBody Battery battery) {
		Response response = new Response();
		try {
			this.batteryService.delete(battery);
			response.setCode(Constants.CODE_SUCCESS);
			response.setMessage(Constants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			log.error("Error: " + e);
			response.setCode(Constants.CODE_ERROR);
			response.setMessage(Constants.MESSAGE_ERROR);
		}
		return response;
	}
}
