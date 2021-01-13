package App.DB;

import Aok.AokData;

import java.util.List;

public class Score extends AokData {
    String subject;
    int mid;
    int fin;
    int total;
    int rank;
    String id;

    public Score(String subject, int mid, int fin, int total, String id, int rank) {
        this.subject = subject;
        this.mid = mid;
        this.fin = fin;
        this.total = total;
        this.id = id;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getMid() {
        return mid;
    }

    public int getFin() {
        return fin;
    }

    public int getTotal() {
        return total;
    }

    public int getRank() {
        return rank;
    }
}
