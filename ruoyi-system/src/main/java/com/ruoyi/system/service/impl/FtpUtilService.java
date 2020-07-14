package com.ruoyi.system.service.impl;

import com.ruoyi.system.ftp.FtpConfig;
import com.ruoyi.system.ftp.FtpPool;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by MR.Wu on 2019-07-03.
 */
@Service
public class FtpUtilService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    FtpConfig config;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    FtpPool pool;

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param file 上传到FTP服务器上的文件
     * @return 成功返回文件名，否则返回null
     * @Version2.0
     */
    public String upload(MultipartFile file, int type) throws Exception {
        FTPClient ftpClient = pool.getFTPClient();
        //开始进行文件上传
        String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        InputStream input = file.getInputStream();
        String ftn = "";
        try {
            // 0:商品图片 1:首面页图片  2:企业认证图片  3:个人认证图片
            if(0 == type){
                ftpClient.changeWorkingDirectory("goods");
                ftn = "goods/";
            }else if(1 == type){
                ftpClient.changeWorkingDirectory("index");
                ftn = "index/";
            }

            boolean result = ftpClient.storeFile(fileName, input);//执行文件传输
            if (!result) {//上传失败
                throw new RuntimeException("上传失败");
            }
            fileName = ftn + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {//关闭资源
            input.close();
            logger.info("开始归还连接");
            pool.returnFTPClient(ftpClient);//归还资源
        }
        return fileName;
    }

    /**
     * Description: 从FTP服务器下载文件
     *
     * @param fileName FTP服务器中的文件名
     * @param resp     响应客户的响应体
     * @Version1.0
     */
    public void downLoad(String fileName, HttpServletResponse resp) throws IOException {
        FTPClient ftpClient = pool.getFTPClient();
        resp.setContentType("application/force-download");// 设置强制下载不打开 MIME
        resp.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
        //将文件直接读取到响应体中
        OutputStream out = resp.getOutputStream();
        ftpClient.retrieveFile(config.getWorkDir() + "/" + fileName, out);
        out.flush();
        out.close();
        pool.returnFTPClient(ftpClient);
    }

    /**
     * Description: 从FTP服务器读取图片
     *
     * @param fileName 需要读取的文件名
     * @return 返回文件对应的Entity
     * @Version1.0
     */
    public ResponseEntity show(String fileName) {
        String username = config.getUserName();
        String password = config.getPassWord();
        String host = config.getHost();
        String work = config.getWorkDir();
        //ftp://root:root@192.168.xx.xx/+fileName
        return ResponseEntity.ok(resourceLoader.getResource("ftp://" + username + ":" + password + "@" + host + work + "/" + fileName));
    }
}
