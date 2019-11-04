package com.aze.blog.common.Utils;

/**
 * @author ：Aze
 * @description：图片处理
 * @date ：Created in 2019/11/4 14:19
 * @modified By：
 * @version:
 */
public class PathUtil {

    private static String seperator = System.getProperty( "file .separator") ;
    public static String getlmgBasePath() {
        String os = System.getProperty ("os. name");
        String basePath="";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image/";
        }
            else {
                basePath="/home/xiangze/image/";
            }
        basePath  = basePath.replace("/", seperator);
            return basePath;

        }

            public static String getShoplmagePath(long shopld){
                String imagePath = "/upload/item/shop/" + shopld + "/";
                return imagePath.replace("/", seperator);

            }
        }
