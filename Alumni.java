import java.util.ArrayList;

public class Alumni {

    public String username;
    public String rank;
    public int scripCount;
    public ArrayList purchases;

    public Alumni(String username, String rank, int scripCount, ArrayList purchases){
        this.username = username;
        this.rank = rank;
        this.scripCount = scripCount;
        this.purchases = purchases;
    }

    public Alumni(String username, String rank, int scripCount){
        this.username = username;
        this.rank = rank;
        this.scripCount = scripCount;
    }

    public String getUsername(){
        return username;
    }

    public int getScripCount(){
        return scripCount;
    }

    public String getRank(){
        return rank;
    }

    public void addScrip(int add){
        scripCount += add;
    }

    public void subtractScrip(int subtract){
        scripCount = scripCount - subtract;
    }

    public void print(){
        System.out.println(rank + " " + username + " || Scrip Count: " + scripCount);

    }


}
