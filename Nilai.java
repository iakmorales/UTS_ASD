public class Nilai {
    private Mahasiswa mahasiswa;
    private Matakuliah matakuliah;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;
    double nilaiAkhir;

    public Nilai(Mahasiswa mahasiswa, Matakuliah matakuliah, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.mahasiswa = mahasiswa;
        this.matakuliah = matakuliah;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.3) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4);
    }

    public void tampilNilai() {
        System.out.printf("%-12s | %-15s | Nilai Akhir: %.1f\n", 
            mahasiswa.getNama(), matakuliah.getNamaMK(), hitungNilaiAkhir());
    }
    
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    static void urutkanNilaiAkhir(Nilai[] nilai){
        for (int i = 0; i < nilai.length-1; i++) {
            for (int j = 1; j < nilai.length-i; j++) {
                if (nilai[j].hitungNilaiAkhir() > nilai[j-1].hitungNilaiAkhir()) {
                    Nilai temp = nilai[j];
                    nilai[j] = nilai[j-1];
                    nilai[j-1] = temp;                   
                }
            }
        }
    }
}
