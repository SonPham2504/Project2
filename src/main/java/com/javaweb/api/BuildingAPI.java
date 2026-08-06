package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.CustomException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
    @PostMapping(value = "/api/building/")
    public Object getBuilding(@RequestBody BuildingDTO buildingDTO) {
//    	try {
//    		System.out.println(5/0);
//    		validate(buildingDTO);
//		} catch (FieldRequiredException e) {
//			ErrorResponeDTO errorResponeDTO = new ErrorResponeDTO();
//			errorResponeDTO.setError(e.getMessage());
//			List<String> detaList = new ArrayList<String>();
//			detaList.add("check lai di!");
//			errorResponeDTO.setDetailsList(detaList);
//			return errorResponeDTO;
//		}
    	System.out.println(5/0);
    	return buildingDTO;
    }
    
    public void validate(BuildingDTO buildingDTO) throws FieldRequiredException{
		if(buildingDTO.getName() == null || buildingDTO.getName().equals("")
				|| buildingDTO.getNumberOfBasement() == null) {
			throw new FieldRequiredException("Name or number of basement is null");
		}
	}
    
//    @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//    public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//    	System.out.println("ok");
//    }
    
    @DeleteMapping(value = "/api/building/{id}")
    public void deleteBuilding(@PathVariable Integer id) {
    	System.out.println("Da xoa thanh cong toa nha " + id);
    }
    
    //====================================================================================
    //B9 : MVC
    @GetMapping(value = "/api/building/")
    public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
    		@RequestParam(name = "districtid", required = false) Long district,
    		@RequestParam(name = "typeCode", required = false) List<String> typeCode){
    	List<BuildingDTO> resuBuildingDTOs = buildingService.findAll(name, district);
    	return resuBuildingDTOs;
    }
}














































