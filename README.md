# PBO (Toko HandPhone Cindy-Vadella-Zefanya)

Nama Kelompok :
- Cindy                          (1957051002) : Membuat 2 class java kodingan pemrograman, ERD, dan Class diagram.
- Vadella Nikita Ayumi           (1917051054) : Membuat 4 class java kodingan pemrograman.
- Zefanya Jhon Poltak Panggabean (1917051070) : Membuat 2 class java kodingan pemrograman, Penjelasan jalannya program aplikasi & fungsi simbol yang digunakan.

## Penjelasan Proses Jalannya Program :
Pada Program Aplikasi yang telah kami rancang ini adalah tentang “Toko Pembelian HandPhone”. Dimana nanti user (kasir toko) akan menginput formulir data diri para pengunjung toko HandPhone setelah si pengunjung tersebut sudah mendapatkan HP yang diinginkannya. 
Dan lalu untuk sebagai adanya bukti transaksi pembayaran tersebut, maka digunakanlah aplikasi ini yang memudahkan traksaksi toko HandPhone ini berjalan dengan baik dan tanpa adanya kecurangan antara si kasir toko maupun si pembeli.
Pada tools Tunai, lihat layar monitor yang disebelah kiri. Kemudian diharapkan user memasukkan ID Pembeli terlebih dahulu untuk menghindari terjadi kekeliruan identitas para pembeli HP. 
Lalu memasukkan Nama pembeli secara lengkap, Alamat si pembeli secara detail, dan Tanggal Pembelian HP dengan benar. 
Lalu dibawahnya memasukkan Jenis HP Yang Dibeli (merek/nama HP) dan Masukkan Harga HP Yang Dibeli dengan benar.
Lalu jika sudah di isi data si pembeli tersebut silahkan di cek kembali data tersebut dengan teliti, lalu klik tombol Tambahkan Data Pembeli. 
Maka akan muncul data informasi secara lengkap dari si pembeli HP di layar monitor sebelah kanan. 
Dan dibawahnya pun tampil Jenis HP dan Harga HP yang dibeli si pembeli. Namun jika terjadi ketidaksesuaian data informasi pembeli, bisa pilih menu Muat Ulang Tabel Data Pembeli di sebelah kiri monitor. 
Dan kalau ingin menghapus data informasi yang sudah diisi tersebut bisa pilih Hapus Formulir, maka nanti akan secara keseluruhan terhapus.
Berikutnya ada tools Kredit bagi yang ingin membayar pembelian HP tersebut dengan mengansur secara rutin dengantenggang waktu yang ditentukan. 
Lalu pada Menu Bar diatasnya terdapat File untuk Close dari aplikasi, ada Pembelian untuk Delete, ada juga Help untuk About (tentang aplikasi toko HandPhone ini). 
Dan yang terakhir juga ada DB Status di pojokan kanan atas aplikasi untuk sebagai tampilan status tentang DataBase yang sedang digunakan.

### Penjelasan Simbol pada "JavaFx Scene Builder" yang kami gunakan pada aplikasi kami:
-	AnchorPane : tempat bagian dimana untuk ditambahkannya label-label dan tombol-tombol lainnya.
-	MenuBar : tampilan beberapa menu utama yang biasanya sudah langsung tampil secara jelas setelah membuka aplikasi yang dijalankan.
-	Menu : berisi menu pilihan-pilihan setelah MenuBar.
-	MenuItem : memberikan item teks setelah Menu.
-	TabPane : hamper sama seperti AnchorPane, namun TabPane lebih berbentuk seperti Table untuk berpindah dari satu lapisan ke lapisan lain (lapisan yang dimasuk ialah 1 kolom table).
-	Tab : tampilan teks dalam TabPane yang di dalam tab ini nantinya akan menjadi tempat fitur-fitur lainnya juga dalam aplikasi.
-	TextField : untuk memasukkan teks pada table kolom yang biasanya digunakan untuk inputan data pada aplikasi.
-	DataPicker : untuk menampilkan kalender waktu hari, bulan, dan tahun.
-	Button : tombol yang nantinya ketika di klik akan mengeluarkan suatu proses/berjalannya program aplikasi pada tujuan tertentu.
-	Label : pemberian label/teks utama yang ditampilkan pada layar monitor aplikasi.
-	TableView : untuk melihat beberapa tampilan table yang akan digunakan untuk penginputan pada aplikasi.
-	TableColumn : Tabel berbentuk kolom secara terpisah untuk inputan teks.

## Design ER Diagram
    PEMBELI ||..|| TUNAI  : is
    PEMBELI ||--|| KREDIT : is
    PEMBELI ||--|{ DETAIL : has
    
### Penjelasan Simbol pada ERD :
- Entitas : objek atau konsep yang ingin Anda simpan informasinya.
- Arti simbol || adalah One. Jadi kalau ||--|| adalah One To One.
- Arti simbol }| atau |{ adalah Many. Jadi kalau ||--|{ adalah One To Many (dan begitupun sebaliknya).


## Design Class Diagram
    class Pembeli{<<abstract>>}
        Pembeli <|-- Tunai
        Pembeli <|-- Kredit
        Pembeli "1"--o"*" Detail : has
        Pembeli : #IntegerProperty IDpembeli
        Pembeli : #StringProperty nama
        Pembeli : #StringProperty alamat
        Pembeli : +IDpembeliProperty()
        Pembeli : +namaProperty()
        Pembeli : +alamatProperty()
    class Tunai{
        +StringProperty tgl_bayar
        +tgl_bayarProperty()
        }
    class Kredit{
        +StringProperty Kontak
        +kontakProperty()
        }
    class Detail{
        -StringProperty jenisHP
        -DoubleProperty hargaHP
        +setJenisHp(String jenisHp)
        +setHargaHp(double hargaHp)
        +jenisHpProperty()
        +hargaHPProprety()
        }

## Design Class Diagram forJavaFX and DataBase
    class Pembeli{<<abstract>>}
        Pembeli <|-- Tunai
        Pembeli <|-- Kredit
        Pembeli "1"--o"*" Detail : has
        Pembeli --o Tokohpdatamodel : Data Modeling
        Pembeli : #IntegerProperty IDpembeli
        Pembeli : #StringProperty nama
        Pembeli : #StringProperty alamat
        Pembeli : +IDpembeliProperty()
        Pembeli : +namaProperty()
        Pembeli : +alamatProperty()
    class Tunai{
        +StringProperty tgl_bayar
        +tgl_bayarProperty()
        }
    class Kredit{
        +StringProperty Kontak
        +kontakProperty()
        }
    class Detail{
        -StringProperty jenisHP
        -DoubleProperty hargaHP
        +setJenisHp(String jenisHp)
        +setHargaHp(double hargaHp)
        +jenisHpProperty()
        +hargaHPProprety()
        }
    class Tokohpdatamodel{
        +Connection conn
        +addPembeli(Tunai pembeli)
        +addPembeli(Kredit pembeli)
        +getTunaiPembeli()
        +getKredit()
        +getDetail(int idpembeli)
        +nextIDPembeli()
        +nextJenisHP(int idpembeli)
        +addDetail(int IDPembeli, Detail acc)
        }
        FormPembeliController --> Tokohpdatamodel : Data Control
    class FormPembeliController{
        +Initializable
        handleTambahkanButton(ActionEvent event)
        handleTambahkanDataButton(ActionEvent event)
        handleHapusButton(ActionEvent event)
        handleMuatUlangButton(ActionEvent event)
        initialize(URL location, ResourceBundle resources)
        viewDataDetail(int IDPembeli)
        }
        FormPembeli ..> FormPembeliController : Form Control
    class FormPembeli{
        }
        Tokohpdatamodel --> DB : DB Connection
    class DB{
        getConnection()
        getConnection(String driver)
        }
    
### Penjelasan Simbol pada Class Diagram :
Class diagram adalah model statis yang menggambarkan struktur dan deskripsi class serta hubungannya antara class. 
Class diagram mirip ER-Diagram pada perancangan  database, bedanya pada ER-diagram tidak terdapat operasi/methode tapi hanya atribut. 
Class terdiri dari nama kelas, atribut dan operasi/methode.
Atribut dan operation (metode) dapat memiliki salah satu sifat berikut :
- Protected, hanya dapat dipanggil oleh class yang bersangkutan dan  class turunannya. methode diawali dg tanda “#”.
- Private, hanya bisa dipanggil dari dlm kelas itu sendiri.  methode/atribut diawali “-“.
- Public, dapat dipanggil  dari semua objek. methode/atribut diawali tanda “+”.
- Relasi Asosiasi dengan simbol --> ialah, hubungan statis antar class yang punya atribut seperti class lain, ataupun jenis class yang memerlukan informasi mengenai eksistensi class lain.
- Relasi Generalisasi dengan simbol  --|> ialah, hubungan antara kelas induk dengan kelas turunan (inherited). 
- Relasi Aggregation dengan simbol --o ialah, Relasi antarkelas dengan makna semua-bagian (whole-part).
- Relasi Dependency dengan simbol ..> ialah, Relasi antarkelas dengan makna kebergantungan antarkelas.
- Jika terdapat "1" pada salah satu atau kedua ujung relasi, itu artinya "one". 
- Jika terdapat "*" pada salah satu atau kedua ujung relasi, itu artinya "many".
