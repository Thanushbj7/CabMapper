package assissgments;

import java.util.List;

import javax.swing.tree.RowMapper;

@Repository
	public class CabBookingRepositeryImpl implements ICabBookingRepositery {
		
		private JdbcTemplate jdbcTemplate;
		
		@Autowired
		public CabBookingRepositeryImpl(JdbcTemplate jdbcTemplate) {
			super();
			this.jdbcTemplate = jdbcTemplate;
		}
		

		@Override
		public void addCab(Cab cab) {
			String sql=DBQueries.INSERTQUERY;
			Object[] cabArray= {
				cab.getPickup(),cab.getDrop(),cab.getCost(),cab.getTypeOfVehicle(),cab.getCabNumber(),
			};
			jdbcTemplate.update(DBQueries.INSERTQUERY,cabArray);
			
		}

		@Override
		public void updateCab(double cost, Integer cabNumber) {
			String sql=DBQueries.UPDATEQUERY;
			jdbcTemplate.update(sql,cost,cabNumber);
			
		}

		@Override
		public void deleteCab(Integer cabNumber) {
			jdbcTemplate.update(DBQueries.DELETEQUERY,cabNumber)
			
		}

		@Override
		public List<Cab> findAll() {
			RowMapper<Cab> mapper=new CabMapper();
			List<Cab> cab=
					jdbcTemplate.query(DBQueries.SELECTQUERY,mapper);
			return cab;
		}

		@Override
		public List<Cab> findByCabType(String typeOfVehicle) {
			List<Cab> cab=jdbcTemplate.query(DBQueries.SELECTBYTYPE,
					(rs,rowNum)->{
					Cab cab=new Cab();
					cab.setPickup(rs.getString("pickup"));
					cab.setDrop(rs.getString("drop"));
					cab.setCost(rs.getDouble("cost"));
					cab.setTypeOfVehicle(rs.getInt("type_of_vehicle"));
					cab.setCabNumber(rs.getString("cab_number"));
					
					Integer cabNumber=rs.getInt("cab_number");
					cab.setCabNumber(cabNumber);
					return cab;
				
			},typeOfVehicle); 
			return cab;
		}

		@Override
		public List<Cab> findByPickupLocation(String pickup) {
			List<Cab> cab=jdbcTemplate.query(DBQueries.SELECTBYPICKUP,new RowMapper<Cab>() {

				@Override
				public Cab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cab cab=new Cab();
					cab.setPickup(rs.getString("pickup"));
					cab.setDrop(rs.getString("drop"));
					cab.setCost(rs.getDouble("cost"));
					cab.setTypeOfVehicle(rs.getInt("type_of_vehicle"));
					cab.setCabNumber(rs.getString("cab_number"));
					
					Integer cabNumber=rs.getInt("cab_number");
					cab.setCabNumber(cabNumber);
					return cab;
				}
				
			},pickup); 
			return cab;
		}

		@Override
		public List<Cab> findByDropLocation(String drop) {
			List<Cab> cab=jdbcTemplate.query(DBQueries.SELECTBYDROPLOCATION,new RowMapper<Cab>() {

				@Override
				public Cab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cab cab=new Cab();
					cab.setPickup(rs.getString("pickup"));
					cab.setDrop(rs.getString("drop"));
					cab.setCost(rs.getDouble("cost"));
					cab.setTypeOfVehicle(rs.getInt("type_of_vehicle"));
					cab.setCabNumber(rs.getString("cab_number"));
					
					Integer cabNumber=rs.getInt("cab_number");
					cab.setCabNumber(cabNumber);
					return cab;
				}
				
			},drop); 
			return cab;
		}

		@Override
		public List<Cab> findByPrice(double cost) {
			List<Cab> cab=jdbcTemplate.query(DBQueries.SELECTBYCOST,new RowMapper<Cab>() {

				@Override
				public Cab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cab cab=new Cab();
					cab.setPickup(rs.getString("pickup"));
					cab.setDrop(rs.getString("drop"));
					cab.setCost(rs.getDouble("cost"));
					cab.setTypeOfVehicle(rs.getInt("type_of_vehicle"));
					cab.setCabNumber(rs.getString("cab_number"));
					
					Integer cabNumber=rs.getInt("cab_number");
					cab.setCabNumber(cabNumber);
					return cab;
				}
				
			},cost); 
			return cab;
		}

		@Override
		public Cab findByCabNumber(Integer cabNumber) {
			List<Cab> cab=jdbcTemplate.query(DBQueries.SELECTBYCABNUMBER,new RowMapper<Cab>() {

				@Override
				public Cab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cab cab=new Cab();
					cab.setPickup(rs.getString("pickup"));
					cab.setDrop(rs.getString("drop"));
					cab.setCost(rs.getDouble("cost"));
					cab.setTypeOfVehicle(rs.getInt("type_of_vehicle"));
					cab.setCabNumber(rs.getString("cab_number"));
					
					
					cab.setCabNumber(cabNumber);
					return cab;
				}
				
			},cabNumber); 
			return cab;
		}

}
