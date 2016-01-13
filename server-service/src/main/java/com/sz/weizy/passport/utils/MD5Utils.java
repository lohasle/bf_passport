package com.sz.weizy.passport.utils;

import com.sz.weizy.passport.utils.security.DESCoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by lohas on 2015/1/31.
 */
public class MD5Utils {
    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    /**
     * MD5普通加密
     *
     * @param rawPass 明文
     * @return
     */
    public final static String encode(String rawPass) {
        return encode(rawPass, null);
    }

    /**
     * * MD5盐值加密
     *
     * @param rawPass 明文
     * @param salt    盐值
     * @return
     */
    public final static String encode(String rawPass, Object salt) {
        String saltedPass = mergePasswordAndSalt(rawPass, salt);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
            return new String(encode(digest));
        } catch (Exception e) {
            return rawPass;
        }
    }

    /**
     * 签名参数
     *
     * @param userId
     * @param token
     * @param json
     * @return
     */
    public static final String signParams(String userId, String token, String json, String appSecret) throws Exception {

        //前置处理  改为大写
        userId = userId == null ? "" : userId.toUpperCase();
        token = token == null ? "" : token.toUpperCase();
        json = json == null ? "" : json.toUpperCase();

        byte[] jsonBytes = json.getBytes("utf-8");
        Arrays.sort(jsonBytes);
        json = new String(jsonBytes, "utf-8");

        // 签名的key
        String signKey = userId + "-" + token;

        // 使用appSecret 对signKey 进行加密
        try {

            // 对 signKey 和 json 的拼接进行des
            byte[] jm_byte = DESCoder.desCrypto((signKey+json).getBytes("utf-8"), appSecret);

            // 进行md5
            String md5value = new String(MD5Utils.encode(jm_byte));

            // base64 编码
            String result = com.sz.weizy.passport.utils.dz.Base64.encodeBytes(md5value.getBytes("utf-8"));
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("参数签名错误");
            throw new Exception("参数签名错误");
        }
    }

    /**
     * 拼接密码与盐值
     *
     * @param password
     * @param salt
     * @return 密码{盐值}
     */
    private static String mergePasswordAndSalt(String password, Object salt) {
        if (salt == null || "".equals(salt.toString().trim())) {
            return password;
        }
        return password + "[" + salt.toString() + "]";
    }

    /**
     * encode
     *
     * @param bytes
     * @return
     */
    private static char[] encode(byte[] bytes) {
        char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
                'f'};
        int nBytes = bytes.length;
        char[] result = new char[2 * nBytes];
        int j = 0;
        for (int i = 0; i < nBytes; i++) {
            // Char for top 4 bits
            result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];

            // Bottom 4
            result[j++] = HEX[(0x0F & bytes[i])];
        }
        return result;
    }

    public static String get() {
        return "";
    }

    /**
     * Test
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 21232f297a57a5a743894a0e4a801fc3
        /*Random random = new Random();
        System.out.println(MD5Utils.encode("admin"));
        //ef4a5e1b7b42a1ee7856339da4e80e24
        System.out.println(MD5Utils.encode("123456","111111"));*/

        String a = "&&&&&0000001111112233334444555556667777788999======AAAAAABCCCDDDDDEEEEEEEEEEEEGGIIIKMMNNOOOPPPRRRSSSSTTTUZ";
    }
}
