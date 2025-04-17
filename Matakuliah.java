public class Matakuliah {
    String kodeMK;
    String namaMK;
    int sks;

    public Matakuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    public void tampilMatakuliah() {
    System.out.println("Kode MK: " + kodeMK + " | Nama: " + namaMK + " | SKS: " + sks);
    }

    public String getKodeMK() {
      return kodeMK;
    }  

    public String getNamaMK() {
      return namaMK;
    }

    public int getSks() {
      return sks;
    }
}
