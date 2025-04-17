import java.util.Scanner;

public class siakad {
     private static Mahasiswa[] mahasiswas = {
        new Mahasiswa("22001", "Ali Rahman", "Informatika"),
        new Mahasiswa("22002", "Budi Santoso", "Informatika"),
        new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis")
    };

    private static Matakuliah[] matakuliahs = {
        new Matakuliah("MK001", "Struktur Data", 3),
        new Matakuliah("MK002", "Basis Data", 3),
        new Matakuliah("MK003", "Desain Web", 3)
    };

    private static Nilai[] nilais = {
        new Nilai(mahasiswas[0], matakuliahs[0], 80, 85, 90), 
        new Nilai(mahasiswas[0], matakuliahs[1], 60, 75, 70), 
        new Nilai(mahasiswas[1], matakuliahs[0], 75, 70, 80), 
        new Nilai(mahasiswas[2], matakuliahs[1], 85, 90, 95), 
        new Nilai(mahasiswas[2], matakuliahs[2], 80, 90, 65)  
    };

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (pilihan) {
                case 1:
                    tampilkanDaftarMahasiswa();
                    break;
                case 2:
                    tampilkanDaftarMatakuliah();
                    break;
                case 3:
                    tampilkanDataPenilaian();
                    break;
                case 4:
                Nilai.urutkanNilaiAkhir(nilais);
                for (Nilai DATAPENILAIAN : nilais) {
                    DATAPENILAIAN.tampilNilai();
                }
                break;
                case 5:
                    cariMahasiswaByNIM();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Siakad");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== MENU SISTEM AKADEMIK ===");
        System.out.println("1. Tampilkan Daftar Mahasiswa");
        System.out.println("2. Tampilkan Daftar Mata Kuliah");
        System.out.println("3. Tampilkan Data Penilaian");
        System.out.println("4. Urutkan Berdasarkan Nilai Akhir");
        System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("0. Keluar");
    }

    private static void tampilkanDaftarMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        for (Mahasiswa mhs : mahasiswas) {
            mhs.tampilMahasiswa();
        }
    }

    private static void tampilkanDaftarMatakuliah() {
        System.out.println("\nDaftar Mata Kuliah:");
        for (Matakuliah mk : matakuliahs) {
            mk.tampilMatakuliah();
        }
    }

    private static void tampilkanDataPenilaian() {
        System.out.println("\nData Penilaian:");
        for (Nilai nilai : nilais) {
            nilai.tampilNilai();
        }
    }


    private static void cariMahasiswaByNIM() {
        System.out.print("\nMasukkan NIM mahasiswa yang dicari: ");
        String nimCari = scanner.nextLine();
        
        boolean ditemukan = false;
        for (Mahasiswa mhs : mahasiswas) {
            if (mhs.getNIM().equals(nimCari)) {
                System.out.println("\nMahasiswa Ditemukan:");
                mhs.tampilMahasiswa();
                ditemukan = true;
                
                System.out.println("\nDaftar Nilai:");
                boolean adaNilai = false;
                for (Nilai nilai : nilais) {
                    if (nilai.getMahasiswa().getNIM().equals(nimCari)) {
                        nilai.tampilNilai();
                        adaNilai = true;
                    }
                }

                if (!adaNilai) {
                    System.out.println("Mahasiswa ini belum memiliki nilai.");
                }
                break;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }
    }
}
