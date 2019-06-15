package com.dt.D.DC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class DataCommSv {

	@Autowired
	private DataCommDao dataCommDao;

	@Autowired
	private DCCRDao DCCRDao;
	@Autowired
	private HttpServletRequest request;	
	private String sessionmid;
	private String sessionnickname;	
	private String grade1;
	private String sessionteam;
	private String grade2;
	private ModelAndView mav;

	public ModelAndView excute(int type, DataComm dataComm) {
		/*
		 //여기세션은 나중에. 
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		*/
		switch (type) {
		case 1:
			dataCommList(dataComm);
			break;
		case 2:
			dataInsertform(dataComm);
			break;
		//
		// case 3:
		// dataInsert(dataComm);
		// break;

		case 4:
			dataDetail(dataComm);
			break;
		case 5:
			dataUpdateform(dataComm);
			break;
		case 6:
			dataUpdate(dataComm);
			break;
		case 7:
			dataDelete(dataComm);
		default:

		}
		return mav;
	}

	public ModelAndView excute(int type, Comment comment,
			MultipartHttpServletRequest mRequest) {
		switch (type) {
		case 1:
			dataCommentInsert(comment);
			break;
		case 2:
			dataCommentUpdate(comment);
			break;
		case 3:
			dataCommentDelete(comment);
			break;
		default:
			break;

		}
		return mav;
	}

	public ModelAndView excute(int type, DataComm dataComm,
			MultipartHttpServletRequest mRequest) {
		switch (type) {
		case 1:
			dataAddAfter(dataComm, mRequest);
			break;
		default:
			break;
		}
		return mav;
	}

	private void dataCommList(DataComm dataComm) {
		mav = new ModelAndView();
		mav.setViewName("my/myFileUpload");
		List<DataComm> dataCommList = dataCommDao.dataCommList(dataComm);
		mav.addObject("dataCommList", dataCommList_HTML(dataCommList));

	}

	private String dataCommList_HTML(List<DataComm> dataCommList) {
		System.out.println(dataCommList.get(0).getD_Code());
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr><td>제목</td><td>작성자</td><td>파일명</td><td>등록일</td></tr>");
		for (DataComm dataComm : dataCommList) {
			// sb.append("<tr><td>" + dataComm.getD_Code() + "</td>");
			sb.append("<tr><td><a href='/dataDetail?d_Code="
					+ dataComm.getD_Code() + "'>" + dataComm.getD_Title()
					+ "</a></td>");
			// sb.append("<td><a href='/dataDetail?d_Code="
			// + dataComm.getD_Title() + "'>" + "</a></td>");
			sb.append("<td>" + dataComm.getM_Email() + "</td>");
			sb.append("<td>" + dataComm.getD_Data() + "</td>");
			sb.append("<td>" + dataComm.getD_Since() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("<a href='/dataInsertform'><input type='button' value='파일 업로드'></a>");
		return sb.toString();
	}

	private void dataDetail(DataComm dataComm) {
		// dataCommDao.dataCommSelect(dataComm);
		mav = new ModelAndView();
		mav.setViewName("my/myFileDetail");
		DataComm dataDetail = dataCommDao.dataDetail_View(dataComm);
		System.out.println("detail" + dataDetail.getD_Code());
		mav.addObject("dataDetail", dataDetail_HTML(dataDetail));

	}

	private String dataDetail_HTML(DataComm dataDetail) {
		StringBuffer sb = new StringBuffer();
		System.out.println("detail" + dataDetail.getD_Code());
		sb.append("제목 : " + dataDetail.getD_Title() + "<br/>");
		sb.append("작성자 : " + dataDetail.getM_Email() + "<br/>");
		sb.append("등록일 : " + dataDetail.getD_Since() + "<br/>");
		sb.append("파일명 : <a href='/dataDownload?d_Path="
				+ dataDetail.getD_Path() + "'>" + dataDetail.getD_Data()
				+ "</a><br/>");
		sb.append("내용 : " + dataDetail.getD_Content() + "<br/>");
		sb.append("상태 : " + dataDetail.getC_Class() + "</br>");
		sb.append("루트 : " + dataDetail.getD_Path() + "</br>");
		sb.append("<a href='/dataUpdateform?d_Code=" + dataDetail.getD_Code()
				+ "'><input type='button' value='수정'></a><br/>");
		sb.append("<input type='hidden' name='d_Code' value='"
				+ dataDetail.getD_Code() + "'/></br>");

		return sb.toString();
	}

	private void dataInsertform(DataComm dataComm) {
		mav = new ModelAndView();
		mav.setViewName("my/myFileInsert");
		mav.addObject("dataInsert", dataInsert_HTML(dataComm));

	}

	private String dataInsert_HTML(DataComm dataComm) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='dataAddAfter' method='post' enctype='multipart/form-data'>");
		sb.append("");
		sb.append("<div class='form-group'>");
		sb.append("<label for='exampleInputFile'>File input</label>");
		sb.append("<input type='file' name='file1'  id='exampleInputFile'>");
		sb.append("</div>");
		sb.append("제목 : <input type='text' name='d_Title'/></br>");
		sb.append("작성자 : <input type='text' name='m_Email'/></br>");
		sb.append("내용 : <input type='text' name='d_Content'/></br>");
		sb.append("공개설정 : <input type='radio' name='c_Class' value='SP'/>공개"
				+ "<input type='radio' name ='c_Class' value ='NP'/>비공개</br>");
		sb.append("<input type='submit' value='등록'/></form>");

		return sb.toString();
	}

	/*
	 * private void dataInsert(DataComm dataComm) {
	 * dataCommDao.dataInsert(dataComm); dataCommList(dataComm);
	 * 
	 * }
	 */
	private void dataUpdateform(DataComm dataComm) {
		mav = new ModelAndView();
		mav.setViewName("my/myFileUpdate");
		DataComm dataDetail = dataCommDao.dataDetail_View(dataComm);
		mav.addObject("dataUpdate", dataUpdate_HTML(dataDetail));
	}

	private String dataUpdate_HTML(DataComm dataComm) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/dataUpdate' method='post' >");
		sb.append("제목 : <input type='text' name='d_Title' value='"
				+ dataComm.getD_Title() + "'/></br>");
		// sb.append("작성자 : <input type='text' name='m_Email' value='"
		// + dataComm.getM_Email() + "'/></br>");
		// sb.append("등록일 : <input type='text' name='d_Since' value='"
		// + dataComm.getD_Since() + "'/></br>");
		sb.append("내용 : <input type='text' name='d_Content' value='"
				+ dataComm.getD_Content() + "'/></br>");
		sb.append("공개설정 : <input type='radio' name='c_Class' value='SP'/>공개"
				+ "<input type='radio' name ='c_Class' value ='NP'/>비공개</br>");
		sb.append("<form action='dataAddAfter' method='get' enctype='multipart/form-data'>");
		sb.append("");
		sb.append("<div class='form-group'>");
		sb.append("<label for='exampleInputFile'>File input</label>");
		sb.append("<input type='file' name='file1'  id='exampleInputFile'>");
		sb.append("</div>");
		sb.append("파일명 : <input type='text' name='d_Data' value='"
				+ dataComm.getD_Data() + "'/></br>");
		sb.append("<input type='hidden' name='d_Code' value='"
				+ dataComm.getD_Code() + "'/></br>");
		sb.append(("<input type='submit' value='수정'></a><br/>"));
		sb.append("</form>");

		return sb.toString();
	}

	private void dataUpdate(DataComm dataComm) {
		System.out.println("sv" + dataComm.getD_Title());
		mav = new ModelAndView();
		dataCommDao.dataUpdate(dataComm);
		dataDetail(dataComm);
	}

	private void dataDelete(DataComm dataComm) {
		dataCommDao.dataDelete(dataComm);
		mav.setViewName("my/myFileDelete");

	}

	public void dataCommentInsert(Comment comment) {
		dataCommDao.dataCommentInsert(comment);
	}

	public void dataCommentUpdate(Comment comment) {
		dataCommDao.dataCommentUpdate(comment);
	}

	public void dataCommentDelete(Comment comment) {
		dataCommDao.dataCommentDelete(comment);
	}

	private void dataAddAfter(DataComm dataComm,
			MultipartHttpServletRequest mRequest) {
		String path = "/resources/upload/";
		boolean isSuccess = false;
		String uploadPath = "D:/JAVA/Worksapce/sgw/src/main/webapp/resources/upload"
				+ path; // 저장경로요
		File dir = new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {

			String uploadFileName = iter.next();
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			String originalFileName = mFile.getOriginalFilename();
			String saveFileName = originalFileName;
			dataComm.setD_Data(saveFileName);
			if (saveFileName != null && !saveFileName.equals("")) {
				if (new File(uploadPath + saveFileName).exists()) {
					saveFileName = saveFileName + "_"
							+ System.currentTimeMillis(); // 같은
					// 이름이있으면~?currentTimeMillis()를
					// 더해
				}
				try {
					mFile.transferTo(new File(uploadPath + saveFileName));// 저장경로
					// +
					// 파일이름
					isSuccess = true;
					dataComm.setD_Path(path + saveFileName);
					if (dataCommDao.dataAddAfter(dataComm)) {
						List<DataComm> dataCommList = dataCommDao
								.dataCommList(dataComm);
						mav.addObject("dataCommList",
								dataCommList_HTML(dataCommList));
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
					isSuccess = false;
				} catch (IOException e) {
					e.printStackTrace();
					isSuccess = false;
				}
			} // if end
		} // while end
		mav.setViewName("my/myFileUpload");
	}// fileUpload end

	/*
	 * public class FileUpload {
	 * 
	 * public static void fileUpload(MultipartFile fileData, String path, String
	 * fileName) throws IOException { String originalFileName =
	 * fileData.getOriginalFilename(); String contentType =
	 * fileData.getContentType(); long fileSize = fileData.getSize();
	 * 
	 * //System.out.println("file Info"); //System.out.println("fileName " +
	 * fileName); //System.out.println("originalFileName :" + originalFileName);
	 * //System.out.println("contentType :" + contentType);
	 * //System.out.println("fileSize :" + fileSize);
	 * 
	 * InputStream is = null; OutputStream out = null; try { if (fileSize > 0) {
	 * is = fileData.getInputStream(); File realUploadDir = new File(path); if
	 * (!realUploadDir.exists()) { //경로에 폴더가 존재하지 않으면 생성합니다.
	 * realUploadDir.mkdirs(); } out = new FileOutputStream(path +"/"+
	 * fileName); FileCopyUtils.copy(is, out); //InputStream에서 온 파일을
	 * outputStream으로 복사 }else{ new IOException("잘못된 파일을 업로드 하셨습니다."); } } catch
	 * (IOException e) { e.printStackTrace(); new
	 * IOException("파일 업로드에 실패하였습니다."); }finally{ if(out != null){out.close();}
	 * if(is != null){is.close();} } } }
	 */

}
