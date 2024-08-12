package application;




import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===TEST 1: sell findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===TEST 2: sell findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===TEST 3: sell findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmal.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.printf("INSERTED! Novo ID = " + newSeller.getId());

        System.out.println("\n===TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Bruce Wayne");
        sellerDao.update(seller);
        System.out.println("Update feito");

        System.out.println("\n===TEST 6: seller delete ===");
        System.out.println("Id para o teste de 'delete': ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Completo");

        sc.close();

    }
}
