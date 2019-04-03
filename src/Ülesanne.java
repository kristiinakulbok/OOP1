public class Ülesanne {

    private String ülesanne;
    private boolean tähtis;

    public Ülesanne(String ülesanne, boolean tähtis) {
        this.ülesanne = ülesanne;
        this.tähtis = tähtis;
    }

    public Ülesanne(String ülesanne) {
        this.ülesanne = ülesanne;
    }

    public String getÜlesanne() {
        return ülesanne;
    }

    public void setÜlesanne(String ülesanne) {
        this.ülesanne = ülesanne;
    }

    public boolean isTähtis() {
        return tähtis;
    }

    public void setTähtis(boolean tähtis) {
        this.tähtis = tähtis;
    }

    public String toString() {
        return ülesanne;
    }
}
