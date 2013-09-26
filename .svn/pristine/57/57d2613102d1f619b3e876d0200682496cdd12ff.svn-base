package br.ufrn.controller.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Ponto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {
	
	public static String formatJSON(List<Ponto> pontos) throws ServiceException{
		JSONArray array = new JSONArray();
		JSONObject obj = null;
		
		for (Iterator<Ponto> iterator = pontos.iterator(); iterator.hasNext();) {
			Ponto ponto = iterator.next();
			obj = new JSONObject();
			try {
				obj.put("title", ponto.getDescricao());
				obj.put("lat", ponto.getLatitude());
				obj.put("lng", ponto.getLongitude());
			} catch (JSONException e) {
				throw new ServiceException(e.getMessage());
			}
			array.put(obj);
		}	
		
		
		return array.toString() ;	
		
	}
	
	public static void main(String args[]){
		
	List<Ponto> pontos = new ArrayList<Ponto>();
		
		Ponto p1 = new Ponto("ponto1",1.1,1.2);
		Ponto p2 = new Ponto("ponto2",2.1,2.2);
		pontos.add(p1);
		pontos.add(p2); 
		
		String expected = "[{\"title\":\"ponto1\",\"lng\":1.2,\"lat\":1.1},{\"title\":\"ponto2\",\"lng\":2.2,\"lat\":2.1}]";
		String actual = "";
		try {
			actual = formatJSON(pontos);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Expected: "+expected);
		System.out.println("Actual:   "+actual);
		
		
	}
	

}
