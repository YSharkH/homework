package homewor.com.firstHomework;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    /**
     * 失物排序方法
     *
     * @param lostArray 待排序的失物数组
     */
    public void sortLost(Lost[] lostArray) {
    int len=lostArray.length;
    for(int i=1;i<len;i++){
        for(int j=0;j<i;j++){
            if(lostArray[j].time>lostArray[j+1].time){
                Lost temp=lostArray[j];
                lostArray[j]=lostArray[j+1];
                lostArray[j+1]=temp;
            }
        }
    }
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     *
     * @param lostArray 失物数组
     * @param keyword   用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost[] selectByKeyword(Lost[] lostArray, String keyword) {
        List<Lost>list=new ArrayList<>();
        Pattern pattern = Pattern.compile(keyword,Pattern.CASE_INSENSITIVE);
        for(int i=0;i<lostArray.length;i++){
            Matcher matcher = pattern.matcher(lostArray[i].introduce);
            if(matcher.find()){
                list.add(lostArray[i]);
            }
        }
        return list.toArray(new Lost[0]);
    }


}

class test {
    public static void main(String[] args) {
        Lost[] lostArray=creat();
        Solution solution=new Solution();
        solution.sortLost(lostArray);
        Scanner s=new Scanner(System.in);
    String key=s.next();
   Lost[]select= solution.selectByKeyword(lostArray,key);
   for(Lost i:select)
       System.out.println("查询物品编号为"+i.id+"    请前往"+i.rPlace+"领取");
    }
    public static Lost[]creat(){
        Lost[] lost = new Lost[3];
        CardLost cardLost = new CardLost();
        cardLost.name = "小明";
        cardLost.id = "001";
        cardLost.CardID = "12345";
        cardLost.courage = "计算机学院";
        cardLost.place = "校门口";
        cardLost.rPlace = "1号失物招领点";
        cardLost.time = 20220715;
        cardLost.description="学生卡";
        cardLost.introduce = new StringBuilder().append(cardLost.CardID).append(cardLost.name).append(cardLost.id).append(cardLost.courage).append((String.valueOf(cardLost.time))).append(cardLost.place).append(cardLost.description).toString();
        lost[0] = cardLost;
        BookLost bookLost=new BookLost();
        bookLost.bookName="老人与海";
        bookLost.description="书";
        bookLost.place="宿舍门口";
        bookLost.rPlace = "2号失物招领点";
        bookLost.price=32.5;
        bookLost.name="unknown";
        bookLost.id="003";
        bookLost.time=20220615;
        bookLost.introduce=bookLost.bookName+bookLost.name+bookLost.time+bookLost.id+bookLost.price+bookLost.place+bookLost.description;
        lost[1]=bookLost;
        Lost lost1=new Lost();
        lost1.name="unknown";
        lost1.description="黑色水瓶";
        lost1.time=20220618;
        lost1.id="002";
        lost1.place="教学楼";
        lost1.rPlace="3号失物招领点";
        lost1.introduce=lost1.id+lost1.name+lost1.place+lost1.time+lost1.description;
        lost[2]=lost1;
    return lost;
    }

}

class Lost {
    String description;//描述
    String name;//失物主人
    long time;//表示时间
    String introduce;
    String place;//捡拾地点
    String id;//失物编号
    String rPlace;//归还地点
}

class CardLost extends Lost {
    String CardID;
    String courage;
}

class BookLost extends Lost {
    String bookName;
    double price;
}