package assissgments;

public class Mapper {
	public class CabMapper implements RowMapper<Cab>{
		@Override
			public Cab mapRow(ResultSet rs,int rowNum)throws SQLException{
				String pickup=rs.getString("pickup");
				String drop=rs.getString("drop");
				String typeOfVehicle=rs.getString("type_of_vehicle");
				Integer cabNumber=rs.getInt("cab_number");
				double cost=rs.getDouble("cost");
				
				Cab cab=new Cab();
				cab.setPickup(pickup);
				cab.setDrop(drop);
				cab.setCost(cost);
				cab.setTypeOfVehicle(typeOfVehicle);
				cab.setCabNumber(cabNumber);
				return cab;
			}

		}
}
