package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-01-19 17:43
 * @LastEditTime: 2023-01-19 17:43
 */
@Slf4j
public class PdfUtil {
    private final static String TEMPLATE_BASE_PATH = "/app/static/template/";//存放文件模板的地址
    private final static String IMG_BASE_PATH = "/app/static/conf/";//存放图片文件的地址（logo图片、机构公章等）
    private final static String FONT_BASE_PATH = "/app/static/conf/";//存放字体资源文件的地址
    private final static String DEFAULT_FONT = "simsun.ttc";//默认字体资源文件（[宋体][simsun.ttc]）
    private final static String ENCODING = "UTF-8";//指定编码
    public final static String PDF_DEMO_IMAGE =  "demo_image.png";//图片名称
    public final static String PDF_DEMO_TEMPLATE =  "demo_pdf.ftl";//模板名称
    public final static String PDF_DEMO_LIST_TEMPLATE = "list_pdf.ftl";//列表模板名称
    //时间格式
    private static String getTime(){
        String pattern = "yyyy-MM-dd-HHmmss-SSS";
        SimpleDateFormat date = new SimpleDateFormat(pattern);
        return date.format(new Date());
    }

    private  static String file ="openworkbook_%1$s.pdf";
    private  static String P = "C:\\Users\\USER\\Desktop\\testworkspace\\";
    private static  int create() throws Exception{
       // 创建一个文档（默认大小A4，边距36, 36, 36, 36）
       Document document = new Document();
       // 设置文档大小
       document.setPageSize(PageSize.A4);
       // 设置边距，单位都是像素，换算大约1厘米=28.33像素
       document.setMargins(50, 50, 50, 50);
       file = String.format(file,getTime());

       // 设置pdf生成的路径
       FileOutputStream fileOutputStream= new FileOutputStream(P+file);
       System.out.println(P+file);
       // 创建writer，通过writer将文档写入磁盘
       PdfWriter writer = PdfWriter.getInstance(document,fileOutputStream);
       // demo
       String title = "阿昇";
       String content = "测试PDF生成";

       // 定义字体
       FontFactoryImp ffi = new FontFactoryImp();
       // 注册全部默认字体目录，windows会自动找fonts文件夹的，返回值为注册到了多少字体
       ffi.registerDirectories();
       // 获取字体，其实不用这么麻烦，后面有简单方法
       Font font = ffi.getFont("宋体", BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12, Font.UNDEFINED, null);

       // 打开文档，只有打开后才能往里面加东西
       document.open();

       // 设置作者
       document.addAuthor("林北");
       // 设置创建者
       document.addCreator("叫小贺");
       // 设置主题
       document.addSubject("测试");
       // 设置标题
       document.addTitle("打油诗");

       // 增加一个段落
       document.add(new Paragraph(title, font));
       document.add(new Paragraph(content, font));
       document.add(new Paragraph("\n\r", font));

       // 创建表格，5列的表格
       PdfPTable table = new PdfPTable(4);
       table.setTotalWidth(PageSize.A4.getWidth()- 100);
       table.setLockedWidth(true);
       // 创建头
       PdfPHeaderCell header = new PdfPHeaderCell();
       header.addElement(new Paragraph(title, font));
       header.setColspan(4);
       table.addCell(header);
       // 添加内容
       table.addCell(new Paragraph("生意兴隆通四海",font));
       table.addCell(new Paragraph("财源广进达三江",font));
       table.addCell(new Paragraph("新春如意多富贵下联",font));
       table.addCell(new Paragraph("佳节平安添吉祥横批",font));

       document.add(table);
       // 关闭文档，才能输出
       document.close();
       writer.close();
        return 1;
   }
    public static void create1() throws Exception {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        file = String.format(file,getTime());
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(P+file));

        String title = "凉州词";
        String content = "黄河远上白云间，一片孤城万仞山。羌笛何须怨杨柳，春风不度玉门关。";
        document.open();

        Font font = new XMLWorkerFontProvider().getFont("宋体");
        for (int i = 0; i <5; i++) {
            document.add(new Paragraph(title, font));
            document.add(new Paragraph(content,font));
            document.add(new Paragraph("\n"));
        }
        document.close();
        writer.close();
    }

    public static int create2() throws Exception {

        // html中字体非常郁闷
        // 1. html中不指定字体，则默认使用英文字体，中文会不显示。
        // 2. html中指定的字体必须是英文名称，如宋体：font-family:SimSun;
        // 3. html中不能指定自定义字体，必须指定itext支持的字体，还好itext支持字体比较多，常见操作系统带的都支持
        // 4. 暂没有找到如何html中支持自定义字体方法，网上都是修改源码实现默认字体中文，也很重要
        file = String.format(file,getTime());
        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<body style='font-size:20px;font-family:SimSun;'>");
        html.append("<table width='19cm'border='1' cellpadding='0' cellspacing='0'>");
        html.append("<tr>");
        html.append("<td colspan='2'>凉州词</td>");
        html.append("</tr>");
        html.append("<tr>");
        html.append("<td>黄河远上白云间，一片孤城万仞山。</td>");
        html.append("<td>羌笛何须怨杨柳，春风不度玉门关。</td>");
        html.append("</tr>");
        html.append("</table>");
        html.append("</body>");
        html.append("</html>");

        InputStream is = new ByteArrayInputStream(html.toString().getBytes());

        OutputStream os = new FileOutputStream(P+file);
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document,os);

        document.open();

        // 将html转pdf
        XMLWorkerHelper.getInstance().parseXHtml(writer,document, is);
        document.close();
        return 1;
    }
    public static void main (String args []){
       try {
        create();
//        create1();
//        create2();
           if(create2() >0){
               System.out.println("                   _ooOoo_\n" +
                       "                  o8888888o\n" +
                       "                  88\" . \"88\n" +
                       "                  (| -_- |)\n" +
                       "                  O\\  =  /O\n" +
                       "               ____/`---'\\____\n" +
                       "             .'  \\\\|     |//  `.\n" +
                       "            /  \\\\|||  :  |||//  \\\n" +
                       "           /  _||||| -:- |||||_  \\\n" +
                       "           |   | \\\\\\  -  /// |   |\n" +
                       "           | \\_|  ''\\---/''  |   |\n" +
                       "           \\  .-\\__  `-`  ___/-. /\n" +
                       "         ___`. .'  /--.--\\  `. . __\n" +
                       "      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
                       "     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                       "     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
                       "======`-.____`-.___\\_____/___.-`____.-'======\n" +
                       "                   `=---='\n" +
                       "           佛祖保佑        永无BUG" );
           }
           Runtime.getRuntime().exec("cmd /c start "+P+file);

       }catch (Exception e){
           System.out.println("error");
       }

   }

}
