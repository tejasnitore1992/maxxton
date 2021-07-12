import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author tejas nitore
 *
 */
public class MaxxtonMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		List<CityPeriod> cityPeriodList = new ArrayList<>();
		CityPeriod CityPeriod1 = new CityPeriod();
		CityPeriod1.setCITY_ID(1);
		CityPeriod1.setNAME("Pune");	
		CityPeriod1.setSTART_DATE(sdf.parse("01-JAN-2021"));
		CityPeriod1.setEND_DATE(sdf.parse("15-JAN-2021"));
		CityPeriod1.setPRIORITY(10);
		cityPeriodList.add(CityPeriod1);
		
		CityPeriod CityPeriod2 = new CityPeriod();
		CityPeriod2.setCITY_ID(2);
		CityPeriod2.setNAME("Mumbai");	
		CityPeriod2.setSTART_DATE(sdf.parse("01-JAN-2021"));
		CityPeriod2.setEND_DATE(sdf.parse("15-FEB-2021"));
		CityPeriod2.setPRIORITY(20);
		cityPeriodList.add(CityPeriod2);
		
		CityPeriod CityPeriod3 = new CityPeriod();
		CityPeriod3.setCITY_ID(3);
		CityPeriod3.setNAME("Delhi");	
		CityPeriod3.setSTART_DATE(sdf.parse("01-MAR-2021"));
		CityPeriod3.setEND_DATE(sdf.parse("15-MAY-2021"));
		CityPeriod3.setPRIORITY(30);
		cityPeriodList.add(CityPeriod3);
		
		CityPeriod CityPeriod4 = new CityPeriod();
		CityPeriod4.setCITY_ID(1);
		CityPeriod4.setNAME("Pune");	
		CityPeriod4.setSTART_DATE(sdf.parse("01-FEB-2021"));
		CityPeriod4.setEND_DATE(sdf.parse("28-FEB-2021"));
		CityPeriod4.setPRIORITY(5);
		cityPeriodList.add(CityPeriod4);
		
		
		System.out.print(" CITY_ID ");
		System.out.print(" NAME ");
		System.out.print("   START_DATE ");
		System.out.print("    END_DATE ");
		System.out.print("     PRIORITY ");
		System.out.println();
		
		
		
		for(CityPeriod cp :getPrioritizedPeriods(cityPeriodList)) {
			System.out.print("   "+cp.getCITY_ID()+" ");
			System.out.print(" 	  "+cp.getNAME()+" ");
			System.out.print("   "+sdf.format(cp.getSTART_DATE())+" ");
			System.out.print("   "+sdf.format(cp.getEND_DATE())+" ");
			System.out.print("    "+cp.getPRIORITY()+" ");
			System.out.println();
		}
		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<CityPeriod> getPrioritizedPeriods(List<CityPeriod> cityPeriods){
		
		LinkedHashMap<Integer,CityPeriod> cityPeriodMap = new LinkedHashMap<>();
		
		for(int i=0;i<cityPeriods.size();i++) {
			CityPeriod cp = cityPeriods.get(i);
			if(cityPeriodMap.containsKey(cp.getCITY_ID())) {
				CityPeriod oldCp = cityPeriodMap.get(cp.getCITY_ID());
				if(oldCp.getSTART_DATE().getTime() > cp.getSTART_DATE().getTime())
					oldCp.setSTART_DATE(cp.getSTART_DATE());
				
				if(oldCp.getEND_DATE().getTime() < cp.getEND_DATE().getTime())
					oldCp.setEND_DATE(cp.getEND_DATE());
				
				oldCp.setPRIORITY(cp.getPRIORITY());
				cityPeriodMap.put(cp.getCITY_ID(), oldCp);
			}else {
				cityPeriodMap.put(cp.getCITY_ID(), cp);
			}
		}
		List<CityPeriod> newCityPeriodList = new ArrayList<>(cityPeriodMap.values());
		
		for(int i=0;i<(newCityPeriodList.size()-1);i++) {
			CityPeriod i_cityPeriod = newCityPeriodList.get(i);
			for(int j=i+1;j<newCityPeriodList.size();j++) {
				CityPeriod j_cityPeriod = newCityPeriodList.get(j);
				
				if(i_cityPeriod.getSTART_DATE().getTime() < j_cityPeriod.getSTART_DATE().getTime()) {
					
					if(i_cityPeriod.getEND_DATE().getTime() > j_cityPeriod.getSTART_DATE().getTime())	{
						j_cityPeriod.setSTART_DATE(i_cityPeriod.getEND_DATE());
						newCityPeriodList.set(j, j_cityPeriod);
					}			
					
				}else if(i_cityPeriod.getSTART_DATE().getTime() > j_cityPeriod.getSTART_DATE().getTime()) {
					if(j_cityPeriod.getEND_DATE().getTime() > i_cityPeriod.getSTART_DATE().getTime())	{
						i_cityPeriod.setSTART_DATE(j_cityPeriod.getEND_DATE());
						
						newCityPeriodList.set(i, j_cityPeriod);
						newCityPeriodList.set(j, i_cityPeriod);
					}
					
				}else if(i_cityPeriod.getSTART_DATE().getTime() == j_cityPeriod.getSTART_DATE().getTime()) {
					
					if(i_cityPeriod.getEND_DATE().getTime() > j_cityPeriod.getEND_DATE().getTime()) {
						
						i_cityPeriod.setSTART_DATE(j_cityPeriod.getEND_DATE());
						
						newCityPeriodList.set(i, j_cityPeriod);
						newCityPeriodList.set(j, i_cityPeriod);
					}else if(j_cityPeriod.getEND_DATE().getTime() > i_cityPeriod.getEND_DATE().getTime()) {
						
						j_cityPeriod.setSTART_DATE(i_cityPeriod.getEND_DATE());
						
						newCityPeriodList.set(j, j_cityPeriod);
					}
				}
				
			}
		}
		
		return newCityPeriodList;
	} 

}
