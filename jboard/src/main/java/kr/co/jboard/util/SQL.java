package kr.co.jboard.util;

public class SQL {
	
	// Article
	public static final String INSERT_ARTICLE = "INSERT INTO Article SET "
																	+ "type='free',"
																	+ "title=?,"
																	+ "content=?,"
																	+ "writer=?,"
																	+ "regip=?,"
																	+ "wdate=NOW()";
	public static final String SELECT_ARTICLE = "SELECT * FROM Article WHERE ano=?";
	public static final String SELECT_ALL_ARTICLE = "SELECT * FROM Article";
	public static final String UPDATE_ARTICLE = "UPDATE Article SET "
																	+ "title=?,"
																	+ "content=? "
																	+ "WHERE ano=?";
	public static final String DELETE_ARTICLE = "DELETE FROM Article WHERE ano=?";
	
	// User
	public static final String INSERT_USER = "INSERT INTO User SET "
													+ "userid=?,"
													+ "pass=SHA2(?, 256),"
													+ "name=?,"
													+ "nick=?,"
													+ "email=?,"
													+ "hp=?,"
													+ "zip=?,"
													+ "addr1=?,"
													+ "addr2=?,"
													+ "regip=?,"
													+ "regDate=NOW()";
	public static final String SELECT_USER= "";
	public static final String SELECT_USER_WITH_PASS= "SELECT * FROM User WHERE userid=? AND pass=SHA2(?, 256)";
	public static final String SELECT_ALL_USER= "";
	public static final String UPDATE_USER = "";
	public static final String DELETE_USER = "";
	
	// File
	public static final String INSERT_FILE = "";
	public static final String SELECT_FILE = "";
	public static final String SELECT_ALL_FILE= "";
	public static final String UPDATE_FILE = "";
	public static final String DELETE_FILE = "";
	
	// Comment
	public static final String INSERT_COMMENT = "";
	public static final String SELECT_COMMENT = "";
	public static final String SELECT_ALL_COMMENT = "";
	public static final String UPDATE_COMMENT = "";
	public static final String DELETE_COMMENT = "";
	
	// Terms
	public static final String INSERT_TERMS = "";
	public static final String SELECT_TERMS = "";
	public static final String SELECT_ALL_TERMS= "";
	public static final String UPDATE_TERMS = "";
	public static final String DELETE_TERMS = "";

}
