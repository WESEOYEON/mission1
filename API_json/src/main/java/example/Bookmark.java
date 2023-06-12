package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bookmark {
		public static void saveBookmark(String name, int nums) {
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet rs = null;
	        String url = "jdbc:mariadb://localhost/mission1";
	        String dbUserId = "root";
	        String dbPassword = "zerobase";

	        try {
	        	connection = DriverManager.getConnection(url,dbUserId, dbPassword);
	            String sql = " insert into bookmark ( 북마크이름, 순서, 등록일자, idx ) " +
	                    " values( ? , ? , now() , null ); ";
	 
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1,name);
	            preparedStatement.setInt(2,nums);

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

		public static List<bookmarkInfo> selectBookmark(){
			  List<bookmarkInfo> bookmarkList = new ArrayList <>();
				
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
		          		+ " FROM bookmark  "
		          		+ " ORDER BY 순서 asc "
		          		;
		          
		          preparedStatement = connection.prepareStatement(sql);
		          rs = preparedStatement.executeQuery();
		          
		          while (rs.next()) {
		          	String name = rs.getString("북마크이름");
		          	int number = rs.getInt("순서");
		          	String regidate = rs.getString("등록일자");
		          	String editdate = rs.getString("수정일자");
		          	int idx = rs.getInt("idx");
		          	String wifiName = rs.getString("와이파이명");
		          	String regiwifiDate = rs.getString("와이파이등록일자");
		          	String wifiNumber = rs.getString("와이파이관리번호");

		          	bookmarkInfo bookmark = new bookmarkInfo(name, number, regidate, editdate,idx,wifiName, regiwifiDate, wifiNumber);
		          	bookmarkList.add(bookmark);
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
				return bookmarkList;
		      }

		public static void delete(String nums) {
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
		          String sql = " delete from bookmark "
		        		  + " where idx = ? ";

		          preparedStatement = connection.prepareStatement(sql);
		          preparedStatement.setString(1, nums);

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

		public static bookmarkInfo selectOne(int nums){
			  bookmarkInfo bookmark = null;
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
		          String sql = " select 북마크이름, 순서 "
		          		+ " from bookmark "
		          		+ " where idx = ? "
		          		;
		          
		          preparedStatement = connection.prepareStatement(sql);
		          preparedStatement.setInt(1,nums);
		          rs = preparedStatement.executeQuery();
		          
		          while (rs.next()) {
		          	String name = rs.getString("북마크이름");
		          	int number = rs.getInt("순서");

		          	bookmark = new bookmarkInfo(name, number);
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
				return bookmark;
		      }

		public static void edit(String newName, int newNums, int idx){
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
		          String sql = " update bookmark "
		          		+ " set 북마크이름 = ? "
		          		+ ", 순서 = ? "
		          		+ ", 수정일자 = now() "
		          		+ " where idx = ?; "
		          		;
		          
		          preparedStatement = connection.prepareStatement(sql);
		          preparedStatement.setString(1,newName);
		          preparedStatement.setInt(2,newNums);
		          preparedStatement.setInt(3,idx);
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

		public static void addBookmark(String wifiName, String bookmarkName, String wifiNumber){
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
		          String sql = " update bookmark "
		          		+ " set 와이파이명 = ? "
		          		+ ", 와이파이등록일자 = now() "
		          		+ ", 와이파이관리번호 = ? "
		          		+ " where 북마크이름 = ?; "
		          		;
		          
		          preparedStatement = connection.prepareStatement(sql);
		          preparedStatement.setString(1,wifiName);
		          preparedStatement.setString(2,wifiNumber);
		          preparedStatement.setString(3,bookmarkName);
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

		public static bookmarkInfo detail(String idx) {
			bookmarkInfo bookmark = null;
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
	            		+ " FROM bookmark "
	            		+ " where idx = ? ; " 
	            		;
	            
	            
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1,idx);

	            rs = preparedStatement.executeQuery();
	            
	            if (rs.next()) {
	            	bookmark = new bookmarkInfo();
	            	bookmark.setName(rs.getString("북마크이름"));
	            	bookmark.setWifiName(rs.getString("와이파이명"));
	            	bookmark.setRegiwifiDate(rs.getString("와이파이등록일자"));	            
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
			return bookmark;
	    }
		
		public static void deleteWifiInfo(String idx){
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
		          String sql = " update bookmark "
		          		+ " set 와이파이명 = null "
		          		+ ", 와이파이등록일자 = null "
		          		+ ", 와이파이관리번호 = null "
		          		+ " where idx = ?; "
		          		;
		          
		          preparedStatement = connection.prepareStatement(sql);
		          preparedStatement.setString(1,idx);
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

}
