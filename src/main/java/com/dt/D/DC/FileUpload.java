package com.dt.D.DC;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.*;

@Service
public class FileUpload {
   public boolean fileUploadAfter(MultipartHttpServletRequest mRequest) {
      boolean isSuccess = false;
      String uploadPath = "/file/"; //저장경로요
      File dir = new File(uploadPath);
      if (!dir.isDirectory()) {
         dir.mkdirs();
      }
      Iterator<String> iter = mRequest.getFileNames();
      while (iter.hasNext()) {
         String uploadFileName = iter.next();
         MultipartFile mFile = mRequest.getFile(uploadFileName);
         String originalFileName = mFile.getOriginalFilename(); //파일이름
         String saveFileName = originalFileName;
         if (saveFileName != null && !saveFileName.equals("")) {
            if (new File(uploadPath + saveFileName).exists()) {
               saveFileName = saveFileName + "_"  
                     + System.currentTimeMillis();  //같은 이름이있으면~?currentTimeMillis()를 더해
            }
            try {
               mFile.transferTo(new File(uploadPath + saveFileName));//저장경로 + 파일이름
               isSuccess = true;
            } catch (IllegalStateException e) {
               e.printStackTrace();
               isSuccess = false;
            } catch (IOException e) {
               e.printStackTrace();
               isSuccess = false;
            }
         } // if end
      } // while end
      
      return isSuccess;
   } // fileUpload end
}