public class TestSplit {
    public static void main(String[] args) {
        //String url = "<a href=\"https://vnexpress.net/so-hoa/video-nguoi-phu-nu-an-va-truoc-xe-bon-gay-tranh-cai-tuan-qua-3952088.html\"><img width=130 height=100 src=\"https://i-sohoa.vnecdn.net/2019/07/13/anva220190713190653-1563020322-2551-1563020659_180x108.gif\" ></a></br>Va quệt với xe bồn, người phụ nữ trung niên đã vác xe đạp chạy theo rồi nằm dưới bánh xe với mục đích ăn vạ.";
        String url = "<a href=\"https://vnexpress.net/so-hoa/ky-su-phan-mem-trom-du-lieu-tu-my-chuyen-ve-trung-quoc-3952135.html\"><img width=130 height=100 src=\"https://i-sohoa.vnecdn.net/2019/07/13/5390085071119wlstradesecrets6p-7896-7077-1563030968_180x108.jpg\" ></a></br>Một kỹ sư bị truy nã và đối mặt với 10 năm tù sau khi đánh cắp dữ liệu của công ty đầu máy Mỹ rồi tuồn sang Trung Quốc.";
        String link = url.substring(url.indexOf("src=\"")+5,url.lastIndexOf("\" >"));
        //System.out.println(link.substring(5,link.length()));
        System.out.println(link);
        String content = url.substring(url.lastIndexOf("</br>")+5,url.lastIndexOf("."));
        System.out.println(content);


    }
}
