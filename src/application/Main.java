package application;


//MANTENDO O GITHUB VERDINHO 


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===TEST 1: sell fndById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===TEST 2: sell fndByDepartment ===");
        Department department = new Department(2, null );
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

    }
}