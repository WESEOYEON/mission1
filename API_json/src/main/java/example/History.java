package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class History {
	
  public static void saveHist(double myLnt, double myLat) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        String url = "jdbc:mariadb://localhost/mission1";
        String dbUserId = "root";
        String dbPassword = "zerobase";

        try {
        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);
            String sql = " insert into History ( X좌표, Y좌표 ,조회일자 ) " +
                    " values( ? , ? , now() ); ";
 
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,myLnt );
            preparedStatement.setDouble(2, myLat);

            int affected = preparedStatement.executeUpdate();
            if (affected>0){
            } else {
                System.out.println("저장 실패");
            }
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

  public static List<wifiInfo> selectHist(){
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
          		+ " FROM history  "
          		+ " ORDER BY num desc "
          		;
          
          preparedStatement = connection.prepareStatement(sql);
          rs = preparedStatement.executeQuery();
          
          while (rs.next()) {
          	String num = rs.getString("num");
          	Double x = rs.getDouble("X좌표");
          	Double y = rs.getDouble("Y좌표");
          	String time = rs.getString("조회일자");
          	

          	wifiInfo wifi = new wifiInfo(num, x, y, time);
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

  public static void delete(String num) {
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
          String sql = " delete from history "
        		  + " where num = ? ";

          preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1, num);

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
      }
  }
}
