package com.leleplus.common.exception.file;


import com.leleplus.common.exception.BaseException;

/**
 * 文件信息异常类
 *
 * @author witt
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
