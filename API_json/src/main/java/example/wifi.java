package example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class wifi {
	public static void insertDist (double myLAT, double myLNT) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
		
        
        String url = "jdbc:mariadb://localhost/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        
        try {
        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);
            String sql = " update seoul_wifi "
            		+ " set 거리 = ROUND((6371 * acos ( cos ( radians(126.7728384))* cos(radians(Y좌표)) * cos( radians(X좌표) - radians(37.4931456) )+ sin ( radians(126.7728384) ) * sin( radians(Y좌표)))),4) "
            		;
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, myLNT);
            preparedStatement.setDouble(2, myLAT);
            preparedStatement.setDouble(3, myLNT);
            rs = preparedStatement.executeQuery();
        	}catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                    	preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	
	public static wifiInfo detail(String numbers) {
		wifiInfo wifi = null;
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
		
        
        String url = "jdbc:mariadb://localhost/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        
        
        try {
        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);
            String sql = " select * "
            		+ " FROM seoul_wifi "
            		+ " where 관리번호 = ? ; " 
            		;
            
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,numbers);

            rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
            	wifi = new wifiInfo();
            	wifi.setDist(rs.getString("거리"));
            	wifi.setNumber(rs.getString("관리번호"));
            	wifi.setSigu(rs.getString("자치구"));
            	wifi.setMainADD(rs.getString("와이파이명"));
            	wifi.setAdd1(rs.getString("도로명주소"));
            	wifi.setAdd2(rs.getString("상세주소"));
            	wifi.setFloor(rs.getString("설치위치"));
            	wifi.setType(rs.getString("설치유형"));
            	wifi.setInst(rs.getString("설치기관"));
            	wifi.setService(rs.getString("서비스구분"));
            	wifi.setCmcwr(rs.getString("망종류"));
            	wifi.setYear(rs.getInt("설치년도"));
            	wifi.setInout(rs.getString("실내외구분"));
            	wifi.setEnvironment(rs.getString("WIFI접속환경"));
            	wifi.setLat(rs.getDouble("Y좌표"));
            	wifi.setLnt(rs.getDouble("X좌표"));
            	wifi.setDay(rs.getString("작업일자"));
            }
            
        	}catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                    	preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		return wifi;
    }
	
	public static List<wifiInfo> selectDist (double myLAT, double myLNT) {
		
		List<wifiInfo> wifiList = new ArrayList <>();
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
		
        
        String url = "jdbc:mariadb://localhost/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        
        
        try {
        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);
            String sql =  " select * "
            		+ " FROM seoul_wifi "
            		+ " ORDER BY 거리 ASC "
            		+ " limit 20 ; " ;
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, myLNT);
            preparedStatement.setDouble(2, myLAT);
            preparedStatement.setDouble(3, myLNT);
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	String dist = rs.getString("거리");
            	String number = rs.getString("관리번호");
            	String sigu = rs.getString("자치구");
            	String mainADD = rs.getString("와이파이명");
            	String add1 = rs.getString("도로명주소");
            	String add2 = rs.getString("상세주소");
            	String floor = rs.getString("설치위치");
            	String type = rs.getString("설치유형");
            	String inst = rs.getString("설치기관");
            	String service = rs.getString("서비스구분");
            	String cmcwr = rs.getString("망종류");
            	int year = rs.getInt("설치년도");
            	String inout = rs.getString("실내외구분");
            	String environment = rs.getString("WIFI접속환경");
            	Double lat = rs.getDouble("Y좌표");
            	Double lnt = rs.getDouble("X좌표");
            	String day = rs.getString("작업일자");

            	wifiInfo wifi = new wifiInfo(dist, number, sigu, mainADD,add1,add2, floor,type,inst,service,cmcwr,year,inout, environment,lat,lnt,day);
            	wifiList.add(wifi);
            }
        	}catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                    	preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		return wifiList;
        }

	public static void register (List<wifiInfo> wifiList){
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        String url = "jdbc:mariadb://localhost/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";

        try {
        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);

            String sql = " insert into seoul_wifi ( 거리, 관리번호, 자치구, 와이파이명, 도로명주소, 상세주소, 설치위치, 설치유형, 설치기관, 서비스구분, 망종류, 설치년도, 실내외구분, WIFI접속환경, X좌표, Y좌표, 작업일자 ) " +
                    " values( null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ); ";
        	preparedStatement = connection.prepareStatement(sql);
        	for(wifiInfo wifi : wifiList) {
                preparedStatement.setString(1, wifi.getNumber());
                preparedStatement.setString(2, wifi.getSigu());
                preparedStatement.setString(3, wifi.getMainADD());
                preparedStatement.setString(4, wifi.getAdd1());
                preparedStatement.setString(5, wifi.getAdd2());
                preparedStatement.setString(6, wifi.getFloor());
                preparedStatement.setString(7, wifi.getType());
                preparedStatement.setString(8, wifi.getInst());
                preparedStatement.setString(9, wifi.getService());
                preparedStatement.setString(10, wifi.getCmcwr());
                preparedStatement.setInt(11, wifi.getYear());
                preparedStatement.setString(12, wifi.getInout());
                preparedStatement.setString(13, wifi.getEnvironment());
                preparedStatement.setDouble(14, wifi.getLnt());
                preparedStatement.setDouble(15, wifi.getLat());
                preparedStatement.setString(16, wifi.getDay());
                preparedStatement.addBatch();
                preparedStatement.clearParameters();
            }
        	preparedStatement.executeBatch();
        	preparedStatement.clearParameters();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static void delete(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        String url = "jdbc:mariadb://localhost:3306/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";
        
        try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        try {
            connection = DriverManager.getConnection(url,dbUserId, dbPassword);
            String sql = " delete from seoul_wifi ";

            preparedStatement = connection.prepareStatement(sql);

            int affected = preparedStatement.executeUpdate();
            if (affected>0){
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static int getNums () {
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
		
        
        String url = "jdbc:mariadb://localhost/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        int num = -1;
        try {
        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);
            String sql =  " SELECT COUNT(*) "
            		+ " FROM seoul_wifi ; " ;
            
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            rs.next();
            num  = rs.getInt(1);

        	}catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                    	preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		return num;
        }

}
