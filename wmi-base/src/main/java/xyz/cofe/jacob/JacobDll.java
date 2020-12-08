package xyz.cofe.jacob;

import com.jacob.com.LibraryLoader;
import xyz.cofe.io.fn.IOFun;

import java.io.*;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Копирует jacob-xxxx.dll и устанавливает системные переменные чтоб указывали на оные dll
 * <ul>
 *     <li> Переменная <b>xyz.cofe.jacob.skipInit</b> <code>= true</code> - не производит инициализацию
 *     </li>
 *     <li> Переменная <b>jacob.dll.name.x86</b> определена - не производит инициализацию
 *     </li>
 *     <li> Переменная <b>jacob.dll.name.x64</b> определена - не производит инициализацию
 *     </li>
 *     <li>
 *         <b>xyz.cofe.jacob.installDir</b> - указывает на каталог, куда копировать dll
 *     </li>
 * </ul>
 */
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
            sto.close();
        }
    }

    /**
     * Проверяет наличие системных свойств, в зависимости от наличия/значения завершает инициализацию:
     * @return
     * <ul>
     *     <li> Переменная <code>xyz.cofe.jacob.skipInit = true</code> - не производит инициализацию
     *     </li>
     *     <li> Переменная <code>jacob.dll.name.x86</code> определена - не производит инициализацию
     *     </li>
     *     <li> Переменная <code>jacob.dll.name.x64</code> определена - не производит инициализацию
     *     </li>
     * </ul>
     */
    public static boolean skipInit(){
        boolean skipInit = System.getProperty("xyz.cofe.jacob.skipInit","false").equalsIgnoreCase("true");
        if( skipInit )return true;

        String dllName = System.getProperty( "jacob.dll.name" );
        if( dllName!=null && dllName.trim().length()>0 )return true;

        String dllNameX86 = System.getProperty( "jacob.dll.name.x86" );
        if( dllNameX86!=null && dllNameX86.trim().length()>0 )return true;

        String dllNameX64 = System.getProperty( "jacob.dll.name.x64" );
        if( dllNameX64!=null && dllNameX64.trim().length()>0 )return true;

        return false;
    }

    @SuppressWarnings("ConstantConditions")
    synchronized public static void init(){
        if( inited )return;
        if( skipInit() ){
            inited = true;
            return;
        }

        String installDllTo = System.getProperty("xyz.cofe.jacob.installDir");

        String tmpDirPath = System.getProperty("java.io.tmpdir");

        String installDirPath =
            installDllTo!=null && installDllTo.trim().length()>0 ?
                installDllTo :
                tmpDirPath;

        if( installDirPath==null ){
            if( tmpDirPath==null ){
                throw new Error("can't read sys property: java.io.tmpdir");
            }else {
                throw new Error("can't define install dll dir");
            }
        }

        File installDir = new File(installDirPath);
        if( !installDir.isDirectory() ){
            throw new Error(installDir+" is not directory");
        }

        File x64dll = new File(installDir,x64dllName);
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

        File x86dll = new File(installDir,x86dllName);
        if( !x86dll.exists() ){
            String res = "/jacob-dll/"+x86dllName;
            URL x86dllUrl = JacobDll.class.getResource(res);
            if( x86dllUrl==null ){
                throw new Error("resource "+res+" not found");
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
