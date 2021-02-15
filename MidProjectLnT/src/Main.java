import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<String> vKode = new Vector<String>();
	Vector<String> vNama = new Vector<String>();
	Vector<String> vJenisKelamin = new Vector<String>();
	
	Vector<String> vJabatan = new Vector<String>();
	Vector<String> vManager = new Vector<String>();
	Vector<String> vSupervisor = new Vector<String>();
	Vector<String> vAdmin = new Vector<String>();
	
	Vector<Integer> vGaji = new Vector<Integer>();
	
	public Main() {
	
		int menu = 0;
		
		do {
			System.out.println("==========");
			System.out.println("PT. Mentol");
			System.out.println("==========");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.print(">>");
			try {
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Input harus angka!");
			}
			
		switch (menu) {
		case 1:
			insert();
			break;

		case 2:
			view();
			break;
			
		case 3:
			update();
			break;

		case 4:
			delete();
			break;
			
		case 5:
			System.exit(0);
		}
			
		} while (menu != 5);
		
		
		
	}

	public void delete() {
		
		String nama = "";
		String jenisKelamin = "";
		String jabatan = "";
		String id = "";
		int gajiKaryawan = 0;
		int low = 0;
		int high = 9;
		int left = 65;
		int right = 90;
		int stringLength = 2;
		
		if (vNama.size() == 0) {
			System.out.println();
			System.out.println("No Data");
			System.out.println();
		} else {
			view();
			
			int delete = 0;
			System.out.print("Data ke berapa yang ingin Anda delete : ");
			try {
				delete = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}

            if (vJabatan.get(delete - 1).equals("Manager")) {
                vManager.remove(vManager.size() - 1);
            } else if (vJabatan.get(delete - 1).equals("Supervisor")) {
                vSupervisor.remove(vSupervisor.size() - 1);
            } else if (vJabatan.get(delete - 1).equals("Admin")) {
                vAdmin.remove(vAdmin.size() - 1);
            }
            
            vKode.remove(delete - 1); 
            vNama.remove(delete - 1);
            vJenisKelamin.remove(delete - 1);
            vJabatan.remove(delete - 1);
            vGaji.remove(delete - 1);
		}
		}

	public void update() {
	
		String nama = "";
		String jenisKelamin = "";
		String jabatan = "";
		String id = "";
		int gajiKaryawan = 0;
		int low = 0;
		int high = 9;
		int left = 65;
		int right = 90;
		int stringLength = 2;
		
		if (vNama.size() == 0) {
			System.out.println();
			System.out.println("No Data");
			System.out.println();
		} else {
			view();
			
			int update = 0;
			System.out.print("Data ke berapa yang ingin Anda update : ");
			try {
				update = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
            if(vJabatan.get(update-1).equals("Manager")){
                vManager.remove(vManager.size()-1);
            } else if (vJabatan.get(update-1).equals("Supervisor")){
                vSupervisor.remove(vSupervisor.size()-1);
            } else if (vJabatan.get(update-1).equals("Admin")){
                vAdmin.remove(vAdmin.size()-1);
            }
            
			do {
				System.out.print("Input nama karyawan [>= 3] : ");
				nama = scan.nextLine();
				vNama.set(update-1, nama);
						
				for(int i = 0; i < nama.length();i++){
		             char check = nama.charAt(i);
		             if (!nama.matches("[a-z,A-Z]+")){
		                 do{
		                     System.out.print("Hanya diperbolehkan alphabet : ");
		                     nama = scan.nextLine();
		                 }while(!nama.matches("[a-z,A-Z]+"));
		             } 
		         }
			} while (nama.length() < 3);
					
			do {
				System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
				jenisKelamin = scan.nextLine();
				vJenisKelamin.set(update-1, jenisKelamin);
			} while (!jenisKelamin.equals("Laki-laki") && !jenisKelamin.equals("Perempuan"));
					
			do {
				System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
				jabatan = scan.nextLine();
				vJabatan.set(update-1, jabatan);
			} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
					
			Random rand = new Random();
			int angka1 = rand.nextInt(9-0)+0;
			int angka2 = rand.nextInt(9-0)+0;
			int angka3 = rand.nextInt(9-0)+0;
			int angka4 = rand.nextInt(9-0)+0;
			char huruf1 = (char) (65 + rand.nextInt(26));
	        char huruf2 = (char) (65 + rand.nextInt(26));
			id = "" + huruf1 + huruf2 + "-" + angka1 + angka2 + angka3 + angka4;
					
			System.out.println("Berhasil menambahkan karyawan dengan id " + id);
			System.out.println();
			vKode.set(update-1, id);
					
			int gaji1 = 8000000;
			int gaji2 = 6000000;
			int gaji3 = 4000000;
			
	        if(jabatan.equals("Manager")){
	            vManager.add(jabatan);
	            vGaji.add(gaji1);
	            int cout1 = 0;
	            for(int j = 0; j < vJabatan.size(); j++){
	                if(vManager.size()>=4){
	                    if(vJabatan.get(j).equals("Manager")){
	                        vGaji.set(j, 8800000);
	                        cout1++;
	                        if(cout1 == vManager.size()){
	                            vGaji.set(j-1, 8000000);
	                        }
	                    }
	                }    
	            }
	            
	        } else if (jabatan.equals("Supervisor")){
	            vSupervisor.add(jabatan);
	            vGaji.add(gaji2);
	            int cout2 = 0;
	            for (int j = 0; j < vJabatan.size(); j++) {
	                if(vSupervisor.size()>=4){
	                    if(vJabatan.get(j).equals("Supervisor")){
	                        vGaji.set(j, 6450000);
	                        cout2++;
	                        if(cout2 == vSupervisor.size()){
	                            vGaji.set(j-1, 6000000);
	                        }
	                    }
	                }   
	            }
	         
            } else if (jabatan.equals("Admin")) {
                vAdmin.add(jabatan);
                vGaji.add(gaji3);
                Integer cout2 = 0;
                for (int j = 0; j < vJabatan.size(); j++) {
                    if (vAdmin.size() >= 4) {
                        if (vJabatan.get(j).equals("Admin")) {
                            vGaji.set(j, 4200000);
                            cout2++;
                            if (cout2 == vAdmin.size()) {
                                vGaji.set(j - 1, 4000000);
                            }
                        }
                    }
                }
            }
				vGaji.set(update-1, vGaji.get(vGaji.size()-1));
				}
			}	


	public void view() {
		
		if (vNama.size() == 0) {
			System.out.println();
			System.out.println("No Data");
			System.out.println();
		} else {
			for (int i = 0; i < vNama.size() - 1; i++) {
				for (int j = i + 1; j < vNama.size(); j++) {
					if (vNama.get(i).compareToIgnoreCase(vNama.get(j)) > 0) {
						
						String temp = vKode.get(i);
						vKode.set(i, vKode.get(j));
						vKode.set(j, temp);
						
						temp = vNama.get(i);
						vNama.set(i, vNama.get(j));
						vNama.set(j, temp);
						
						temp = vJenisKelamin.get(i);
						vJenisKelamin.set(i, vJenisKelamin.get(j));
						vJenisKelamin.set(j, temp);
						
						temp = vJabatan.get(i);
						vJabatan.set(i, vJabatan.get(j));
						vJabatan.set(j, temp);
						
						int tempInt = vGaji.get(i);
						vGaji.set(i, vGaji.get(j));
						vGaji.set(j, tempInt);
					}
				}
			}
			String a = "No", b = "Kode Karyawan", c = "Nama Karyawan", d = "Jenis Kelamin", e = "Jabatan", f = "Gaji Karyawan";
			
			System.out.println();
			System.out.println("|----|-----------------|-------------------------|---------------|---------------|---------------|");
			System.out.printf("|%-4s|%-17s|%-25s|%-15s|%-15s|%-15s|\n", a, b, c, d, e, f);
			System.out.println("|----|-----------------|-------------------------|---------------|---------------|---------------|");
			for (int i = 0; i < vNama.size(); i++) {
				System.out.printf("|%-4s|%-17s|%-25s|%-15s|%-15s|%-15s|\n", (i+1), vKode.get(i), vNama.get(i), vJenisKelamin.get(i), vJabatan.get(i), vGaji.get(i));
			}
			System.out.println("|----|-----------------|-------------------------|---------------|---------------|---------------|");
			System.out.println();
		}
	}

	public void insert() {
		
		String nama = "";
		String jenisKelamin = "";
		String jabatan = "";
		String id = "";
		int gajiKaryawan = 0;
		int low = 0;
		int high = 9;
		int left = 65;
		int right = 90;
		int stringLength = 2;
		
		do {
			System.out.print("Input nama karyawan [>= 3] : ");
			nama = scan.nextLine();
			
			for(int i = 0; i < nama.length();i++){
	             char check = nama.charAt(i);
	             if (!nama.matches("[a-z,A-Z]+")){
	                 do{
	                     System.out.print("Hanya diperbolehkan alphabet : ");
	                     nama = scan.nextLine();
	                 }while(!nama.matches("[a-z,A-Z]+"));
	             } 
	         }
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
			jenisKelamin = scan.nextLine();
		} while (!jenisKelamin.equals("Laki-laki") && !jenisKelamin.equals("Perempuan"));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			jabatan = scan.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
		Random rand = new Random();
		int angka1 = rand.nextInt(9-0)+0;
		int angka2 = rand.nextInt(9-0)+0;
		int angka3 = rand.nextInt(9-0)+0;
		int angka4 = rand.nextInt(9-0)+0;
		char huruf1 = (char) (65 + rand.nextInt(26));
        char huruf2 = (char) (65 + rand.nextInt(26));
		id = "" + huruf1 + huruf2 + "-" + angka1 + angka2 + angka3 + angka4;
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + id);
		
		System.out.println("ENTER to return");
		scan.nextLine();
		

		int gaji1 = 8000000;
		int gaji2 = 6000000;
		int gaji3 = 4000000;
        
        if(jabatan.equals("Manager")){
            vManager.add(jabatan);
            vGaji.add(gaji1);
            int cout1 = 0;
            for(int i = 0; i < vJabatan.size(); i++){
                if(vManager.size()>=4){
                    if(vJabatan.get(i).equals("Manager")){
                        vGaji.set(i, 8800000);
                        cout1++;
                        if(cout1 == vManager.size()){
                            vGaji.set(i-1, 8000000);
                        }
                    }
                }    
            }
            
        } else if (jabatan.equals("Supervisor")){
            vSupervisor.add(jabatan);
            vGaji.add(gaji2);
            int cout2 = 0;
            for (int i = 0; i < vJabatan.size(); i++) {
                if(vSupervisor.size()>=4){
                    if(vJabatan.get(i).equals("Supervisor")){
                        vGaji.set(i, 6450000);
                        cout2++;
                        if(cout2 == vSupervisor.size()){
                            vGaji.set(i-1, 6000000);
                        }
                    }
                }   
            }
            
        } else if (jabatan.equals("Admin")){
            vAdmin.add(jabatan);
            vGaji.add(gaji3);
            int cout3 = 0;
            for(int i = 0; i < vJabatan.size(); i++){
                if(vAdmin.size() >= 4){
                    if(vJabatan.get(i).equals("Admin")){
                        vGaji.set(i, 4200000);
                        cout3++;
                        if(cout3 == vAdmin.size()){
                            vGaji.set(i-1, 4000000);
                        }
                    }
                }
            }
        }
		
		vKode.add(id);
		vNama.add(nama);
		vJenisKelamin.add(jenisKelamin);
		vJabatan.add(jabatan);	
	}

	public static void main(String[] args) {
	new Main();

	}

}
