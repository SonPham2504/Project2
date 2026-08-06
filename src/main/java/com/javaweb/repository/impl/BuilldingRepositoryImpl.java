package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuilldingRepositoryImpl implements BuildingRepository{
	private static final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER01;databaseName=estatebasic;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASS = "123456";

	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
		StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
		if(name != null && name.equals("")) {
			sql.append("and b.name like '%" + name + "%' ");
		}
		if(districtId != null) {
			sql.append("and b.districtid = " + districtId + " ");
		}
    	List<BuildingEntity> result = new ArrayList<>();
    	try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
    			Statement stmt = con.createStatement();
    			ResultSet rSet = stmt.executeQuery(sql.toString());){
    		while(rSet.next()) {
    			BuildingEntity buildingEntity = new BuildingEntity();
    			buildingEntity.setName(rSet.getString("name"));
    			buildingEntity.setStreet(rSet.getString("street"));
    			buildingEntity.setWard(rSet.getString("ward"));
    			buildingEntity.setNumberOfBasement(rSet.getInt("numberofbasement"));
    			result.add(buildingEntity);
    		}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected db faled...");
		}
    	return result;
	}
}



















































