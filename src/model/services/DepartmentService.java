/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.util.ArrayList;
import java.util.List;
import model.entities.Department;

/**
 *
 * @author julio
 */
public class DepartmentService {

    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();

        list.add(new Department(1, "Books"));
        list.add(new Department(2, "Computer"));
        list.add(new Department(3, "Electronics"));
        
        return list;
    }
}
