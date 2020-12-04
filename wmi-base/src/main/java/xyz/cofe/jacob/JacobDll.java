package xyz.cofe.jacob;

import com.jacob.com.LibraryLoader;
import xyz.cofe.io.fn.IOFun;

import java.io.*;
import java.net.URL;
import java.util.logging.Logger;

public class JacobDll {
    private static volatile boolean inited = false;
    private static final String x64dllName = "jacob-1.20-x64.dll";
    private static final String x86dllName = "jacob-1.20-x86.dll";
    private static final Logger logger = Logger.getLogger(JacobDll.class.getName());
    private static void copy( URL from, File target ) throws IOException {
        try (
            InputStream sfrom = from.openStream();
            OutputStream sto = new FileOutputStream(target)
        ){
            IOFun.copy(sfrom,sto);
            sto.flush();
        }
    }

    synchronized public static void init(){
        if( inited )return;
        String tmpdirPath = System.getProperty("java.io.tmpdir");
        if( tmpdirPath==null ){
            throw new Error("can't read sys property: java.io.tmpdir");
        }

        File tmpdir = new File(tmpdirPath);
        if( !tmpdir.isDirectory() ){
            throw new Error("java.io.tmpdir(=$tmpdir) is not directory");
        }

        File x64dll = new File(tmpdir,x64dllName);
        if( !x64dll.exists() ){
            String res = "/jacob-dll/"+x64dllName;
            URL x64dllUrl = JacobDll.class.getResource(res);
            if( x64dllUrl==null ){
                throw new Error("resource "+res+" not found");
            }

            try{
                copy(x64dllUrl, x64dll);
            } catch( IOException e ) {
                throw new IOError(e);
            }

            logger.info("copied "+x64dllUrl+" to "+x64dll);
        }

        File x86dll = new File(tmpdir,x86dllName);
        if( !x86dll.exists() ){
            String res = "/jacob-dll/"+x86dllName;
            URL x86dllUrl = JacobDll.class.getResource(res);
            if( x86dllUrl==null ){
                throw new Error("resource $res not found");
            }

            try{
                copy(x86dllUrl, x86dll);
            } catch( IOException e ) {
                throw new IOError(e);
            }

            logger.info("copied "+res+" to "+x86dll);
        }

        String arch = System.getProperty("os.arch");
        if( arch==null ){
            throw new Error("can't read sys property: os.arch");
        }

        boolean isX64 = arch.contains("64");
        if( isX64 ){
            System.setProperty(LibraryLoader.JACOB_DLL_PATH,
                x64dll.toString());
        }else{
            System.setProperty(LibraryLoader.JACOB_DLL_PATH,
                x86dll.toString());
        }

        inited = true;
    }
}
