import java.util.Date;

/**
 * 
 */

/**
 * @author tejas nitore
 *
 */
public class CityPeriod {

	private int CITY_ID;
	private String NAME;
	private Date START_DATE;
	private Date END_DATE;
	private int PRIORITY;
	
	public int getCITY_ID() {
		return CITY_ID;
	}
	
	public void setCITY_ID(int cITY_ID) {
		CITY_ID = cITY_ID;
	}
	
	public String getNAME() {
		return NAME;
	}
	
	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public Date getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}

	public int getPRIORITY() {
		return PRIORITY;
	}

	public void setPRIORITY(int pRIORITY) {
		PRIORITY = pRIORITY;
	}
	
	
}
