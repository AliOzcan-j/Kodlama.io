package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionControllers {
	
	private PositionService positionService;
	
	@Autowired
	public PositionControllers(PositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@RequestMapping("/getall")
	public List<Position> getAll(){
		return this.positionService.getAll();
	}
	
}
