package comeon;

public class requestDTO {
//	complete": false,
//	  "lake_id": 1,
//	  "geo_points": [
//	    {1.11, 2.21},
//	    {1.71, 2.51},
//	    {1.17, 2.
	
	private boolean complete;
private Integer lake_id;
	
	private Float[] geo_points;
	
	
	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Integer getLake_id() {
		return lake_id;
	}

	public void setLake_id(Integer lake_id) {
		this.lake_id = lake_id;
	}

	public Float[] getGeo_points() {
		return geo_points;
	}

	public void setGeo_points(Float[] geo_points) {
		this.geo_points = geo_points;
	}
	
}
