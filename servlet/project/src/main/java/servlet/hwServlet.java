package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mber.dao.mberDao;
import mber.vo.mberVo;
@WebServlet("/hw/index")
public class hwServlet extends HttpServlet {

	private static final long serialVersionUID = 100002;
	
	private Statement stmt;
	private Connection con;
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://localhost:5432/hw_postgres";
	private static final String user = "hw_postgres";
	private static final String pwd = "hw_postgres#1";
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("postgresql 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("hwhwhw init");
		super.init();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("hwhwhw destroy");
		super.destroy();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		this.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		this.service(req, resp);
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("service1");
//
//		ArrayList<mberVo> memList = new ArrayList<mberVo>();
//		
//		try {
//			connDB();
//			String query = "SELECT * FROM MBER WHERE 1=1;";
//			System.out.println(query);
//			ResultSet rs = stmt.executeQuery(query);
//			
//			while (rs.next()) {
//
//				mberVo vo = new mberVo();
//				String mberSeq = rs.getString("mber_seq");
//				String id = rs.getString("id");
//				String name = rs.getString("name");
//				String birh = rs.getString("birh");
//				String gendCd = rs.getString("gend_cd");
//				String mptel = rs.getString("mptel");
//				String createDate = rs.getString("create_date");
//				
//				vo.setMberSeq(mberSeq);
//				vo.setId(id);
//				vo.setName(name);
//				vo.setBirh(birh);
//				vo.setGendCd(gendCd);
//				vo.setMptel(mptel);
//				vo.setCreateDate(createDate);
//				
//				memList.add(vo);
//			}
//
//			req.setAttribute("mberList", memList);
//			rs.close();
//			stmt.close();
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		req.getRequestDispatcher("/WEB-INF/hw/index.jsp").forward(req, resp);
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service2");

		
		ArrayList<mberVo> memList = new ArrayList<mberVo>();
		mberDao mberDao = new mberDao();
		
		try {
			List<mberVo> list = mberDao.selectDataAll();
			for(int i=0; i<list.size(); i ++) {
				mberVo vo = new mberVo();
				String mberSeq = list.get(i).getMberSeq();
				String id = list.get(i).getId();
				String name = list.get(i).getName();
				String birh = list.get(i).getBirh();
				String gendCd = list.get(i).getGendCd();
				String mptel = list.get(i).getMptel();
				String createDate = list.get(i).getCreateDate();

				vo.setMberSeq(mberSeq);
				vo.setId(id);
				vo.setName(name);
				vo.setBirh(birh);
				vo.setGendCd(gendCd);
				vo.setMptel(mptel);
				vo.setCreateDate(createDate);

				memList.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("mberList", memList);		
		req.getRequestDispatcher("/WEB-INF/hw/index.jsp").forward(req, resp);
	}
	
	
	
}
